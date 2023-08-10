<%@ include file="/init.jsp"%>
<script type="text/javascript" charset="utf8"
src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript" charset="utf8"
src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" charset="utf8"
src="https://cdn.datatables.net/1.10.16/js/dataTables.jqueryui.min.js"></script>
<link rel="stylesheet" type="text/css"
href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" />
<link rel="stylesheet" type="text/css"
href="https://cdn.datatables.net/1.10.16/css/dataTables.jqueryui.min.css" />
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">

<h1>Add Update Room</h1>

<p>Add Logic for Add/Update Room</p>
<style>
#mycombo,#roomName,#price,#totalRoomAvaliable,#totalRoomBooked
{
 width:160px
 }
  .form-container label {
 width: 200px;
 text-align: left;
 margin-right:90px;
 padding: 5px;

/* text-align: right;
margin-right: 90px;
gap:50px;
padding: 5px; */ 
}
  #roomid,#rmo{
 display:none;
 }
 </style>

<portlet:actionURL name="addRoomData" var="addRoomDataURL" />

<aui:form name="addRoomData" id="addRoomDataId" action="<%=addRoomDataURL%>" method="POST">

	<div class="form-container">
		<label id="rmo" for="roomid">Room ID:</label>
		<input type="text" id="roomid" name="<portlet:namespace/>roomid" value=${room.roomId}>
	</div>
	
	<div class="form-container">
		<label>RoomType:</label>
		<select id="mycombo" class="custom-select" name="<portlet:namespace/>roomtype"></select><br>
		<span class="error" id="roomTypeError"></span>
	</div>
	
	<div class="form-container">
		<label>RoomName:</label>
		<input type="text"  name="<portlet:namespace/>roomName" id="roomName" value="${room.roomName}"/><br>
		<span class="error" id="roomNameError"></span>
	</div>
	
	<div class="form-container">
		<label for="quantity">Price :</label>
		<input type="number"  name= "<portlet:namespace/>price"	id="price"  value=${room.price} min="1000" max="25000"/><br>
		<span class="error" id="priceError"></span>
	</div>

	<div class="form-container">
		<label>Please Choose Amenties1:</label>
  		<input type="radio" name="<portlet:namespace/>isACRoom" id="isACRoom" value="true"/> AC    
  		<input type="radio"  name="<portlet:namespace/>isACRoom" value="false"/> NON-AC <br>
  		<span class="error" id="acNonError"></span>
	</div>
  
	<div class="form-container">
		<label>Please Choose Amenties2:</label>
		<input type="radio"  name="<portlet:namespace/>SmokingAvailable" value="true"/> Smoking 
		<input type="radio"  name="<portlet:namespace/>SmokingAvailable" value="false"/> Non-Smoking Room<br>
		<span class="error" id="smokNonSmokError"></span>
	</div>
	
	<div class="form-container">
		<label>Total Room Availability:</label>
		<input type="number"  name="<portlet:namespace/>totalRoomAvaliable" id="totalRoomAvaliable" value=${room.totalRoomsAvailable} />
		<span class="error" id="roomAvailError"></span>
	</div>
	
	<div class="form-container">
		<label>Total Room Booked:</label>
		<input type="number" name="<portlet:namespace/>totalRoomBooked"  id="totalRoomBooked"/>
		<span class="error" id="roomBookedError"></span>
	</div>

	<div class="form-container">
		<label>Select Facility: </label>   
        <input type="checkbox" id="WIFI" name="<portlet:namespace/>checkdata" value="WIFI"/>WI-FI    
        <input type="checkbox" id="TV" name="<portlet:namespace/>checkdata" value="TV"/>TV    
        <input type="checkbox" id="Geyser" name="<portlet:namespace/>checkdata" value="Geyser"/>Geyser <br> 
   </div>
   
	<div id="errorMessages" style="color: red;"></div>

	<button name="saveButton" type="submit" id="updateRoombtn"class="btn btn-primary btn-default " 
	onclick="return validateForm()">Update ROOM</button>
	
	<button name="saveButton" type="submit" id="AddRoombtn" class="btn btn-primary btn-default " 
	onclick="return validateForm()">ADD ROOM</button>
											
</aui:form>


<script>

$(document).ready(function(){
	
	var roomidval=$("#roomid").val();
	
	if(roomidval>0 || typeof !roomidval==="undefined"){
		$("#updateRoombtn").show();	
		$("#AddRoombtn").hide();	
	}
	else {
		$("#AddRoombtn").show();	
		$("#updateRoombtn").hide();	
	}

    
	var dataList=[];
	
	$.ajax({// collect Room Type Data From Dynamic DB
		type :'GET',
		url:'/o/infy/getRoomType',
		success: function(result) {
          console.log("value addded:::::"+result);
          dataList=result;
          populateComboBox(dataList);
		},
         error:function(xhr,status,error){
			console.error(error);
           }
	});
	
	var comboBox;
	var roomtypedata='<%=request.getAttribute("roomtypedata")%>';

	function populateComboBox(data) {// this method used for showing Roomtype in dynamicDrop Down
		 comboBox=$("#mycombo");
		comboBox.empty();
		comboBox.append($('<option>').text("Select roomType...").val(''));
		$.each(data,function(index,value){
			comboBox.append($('<option>').text(value).val(value));
			comboBox.find("option").each(function(){
				if($(this).val()===roomtypedata){
					$(this).prop("selected",true);
				}
			});
		});
	}

	

	
 	var isWifiAvailable="";
 	var isTVAvailable="";
 	var isGeyserAvailable="";
 	var isSmokingAvailable="";
 	var isACAvailable="";
 	
	 isWifiAvailable="${amenities.isWifiAvailable}";
	 isTVAvailable="${amenities.isTVAvailable}";
	 isGeyserAvailable="${amenities.isGeyserAvailable}";
	 isSmokingAvailable="${amenities.isSmokingAvailable}";
	 isACAvailable="${amenities.isACAvailable}";
	
	if(roomidval>0 ||  typeof !roomidval==="undefined"){
/* 	if(${amenities.isWifiAvailable})
		{
		isWifiAvailable="WIFI";
		}
	
	if(${amenities.isTVAvailable}){
		isTVAvailable="TV";
		}
	
	if(${amenities.isGeyserAvailable}){
		isGeyserAvailable="Geyser"
		} */
		if(isWifiAvailable=="true")
		{
		isWifiAvailable="WIFI";
		}
	
	if(isTVAvailable=="true"){
		isTVAvailable="TV";
		}
	
	if(isGeyserAvailable=="true"){
		isGeyserAvailable="Geyser"
		}
/* 	$('input[name="<portlet:namespace/>SmokingAvailable"][value="'+${amenities.isSmokingAvailable}+'"]').prop('checked',true);
	$('input[name="<portlet:namespace/>isACRoom"][value="'+${amenities.isACAvailable}+'"]').prop('checked',true);
	$('input[name="<portlet:namespace/>checkdata"][value="'+isWifiAvailable+'"]').prop('checked',true);
	$('input[name="<portlet:namespace/>checkdata"][value="'+isTVAvailable+'"]').prop('checked',true);
	$('input[name="<portlet:namespace/>checkdata"][value="'+isGeyserAvailable+'"]').prop('checked',true); */
	
	$('input[name="<portlet:namespace/>SmokingAvailable"][value="'+isSmokingAvailable+'"]').prop('checked',true);
	$('input[name="<portlet:namespace/>isACRoom"][value="'+isACAvailable+'"]').prop('checked',true);
	$('input[name="<portlet:namespace/>checkdata"][value="'+isWifiAvailable+'"]').prop('checked',true);
	$('input[name="<portlet:namespace/>checkdata"][value="'+isTVAvailable+'"]').prop('checked',true);
	$('input[name="<portlet:namespace/>checkdata"][value="'+isGeyserAvailable+'"]').prop('checked',true);
	$('#mycombo').prop('checked',$('#mycombo').val()===roomtypedata);
	
	var roomname1="${roomName}";//used for Decoding the roomName ::issue::not taking full name of  roomName.
    var decodedRoomName = atob(roomname1);
    $("#roomName").val(decodedRoomName);
	
    console.log("inside decodedString..!! "+decodedRoomName);
	}
});


function validateForm() {
	console.log("inside validateForm..!! ");
    var isValid = true;
    var radioValue=$('input[name="<portlet:namespace/>SmokingAvailable"]:checked').val();
	var ACValue=$('input[name="<portlet:namespace/>isACRoom"]:checked').val();
	var rmtype=$("#mycombo").val();
	var totalRoomAvaliable=$("#totalRoomAvaliable").val();
	var totalRoomBooked=$("#totalRoomBooked").val();
	var price=$("#price").val();
	var roomName=$("#roomName").val();
	
	console.log("inside SmokingAvailable..!! "+radioValue);
	console.log("inside isACRoom..!! "+ACValue);
	console.log("inside rmtype..!! "+rmtype);
	console.log("inside roomName..!! "+roomName);
	console.log("inside price..!! "+price);
	
	var errorMessages = [];
	 
	    if (rmtype === "") {
			        errorMessages.push("Please select a RoomType");
			        $("#roomTypeError").css("display", "block");
			        isValid = false;
	    } 
	    else {
	        		$("#roomTypeError").css("display", "none");
	    }
	    
	    if (roomName === "") {
			        errorMessages.push("Please Enter a RoomName");
			        $("#roomTypeError").css("display", "block");
			        isValid = false;
	    } else {
	       			$("#roomTypeError").css("display", "none");
	    }
	    
	    if (price <1000) {
			        errorMessages.push("Please enter a price value grater then 1000");
			        $("#priceError").css("display", "block");
			        isValid = false;
	    } else {
	        		$("#priceError").css("display", "none");
	    }
	    

	    if (ACValue === "" || typeof ACValue === "undefined") {
			        errorMessages.push("Please select Amenitites1");
			        $("#acNonError").css("display", "block");
			        isValid = false;
	    } else {
	       			$("#acNonError").css("display", "none");
	    }
	    
	    if (totalRoomAvaliable<1) {
			        errorMessages.push("totalRoom Avaliable must be greater then 0 ");
			        $("#acNonError").css("display", "block");
			        isValid = false;
	    } else {
	        		$("#acNonError").css("display", "none");
	    }
	    
	    if (totalRoomBooked<0 || totalRoomBooked ==="") {
			        errorMessages.push("please fill value  totalRoomBooked field  ");
			        $("#acNonError").css("display", "block");
			        isValid = false;
	    } else {
	       			$("#acNonError").css("display", "none");
	    }
	    
	    if (radioValue === "" || typeof radioValue === "undefined") {
			        errorMessages.push("Please select Amenitites2");
			        $("#acNonError").css("display", "block");
			        isValid = false;
	    } else {
	        		$("#acNonError").css("display", "none");
	    }
	    
	    if (errorMessages.length > 0) {
			        var errorMessage = "Please provide data based on the belows message::::<br>" + errorMessages.join("<br>");
			        $("#errorMessages").html(errorMessage);
			        event.preventDefault();
			        return false;
	    } else {
	        		$("#errorMessages").html("");
	        		return true;
	    }
	    
    }

$("#addRoomData").submit(validateForm);

	function checkValidRoomName() {
		
		console.log("inside checkValidRoomName..!! ");
		
	}

</script>