<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Hotel</title>
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

<style type="text/css">
.form-row{
margin-bottom:200px;
}
body{  
  font-family: Calibri, Helvetica, sans-serif;  
  background-color:#33ffff;
  padding: 50px;
} 
#mycombo,#roomName,#price,#fromDate,#toDate{
 width:160px
 }
 
 h1{
 text-align:left
 }
   #back{
position:absolute;
bottom:-20px;
left:45%;
transform: translateX(-50%);
 }
 #adddata{
position:absolute;
bottom:-20px;
left:25%;
transform: translateX(-50%);
 }

 .form-container label {
 width: 200px;
 text-align:left;
 margin-right:90px;
 padding: 5px;
}
</style> 
</head>
<body>
<portlet:renderURL var="backRoomURL">
<portlet:param name="page" value="back"/>
</portlet:renderURL>
<portlet:renderURL var="editRoomURL">
<portlet:param name="page" value="costumerBookRoom"/>

</portlet:renderURL>
<!-- action="/infy/o/addCostumer" -->
<form id="myForm"  method="POST">
<h1> Book Hotel Management Form</h1>
<h3> Room Details::</h3>
<div class="form-container">
<label>RoomName:</label>
<select id="mycombo" class="custom-select" name="RoomName"></select><br>
</div>
<div class="form-container">
<label>Total Room Availability:</label>
<input type="text" id="totalRoomAvaliable" name="totalRoomAvaliable" >
</div>
<h3>Booking details:</h3>
  <div class="form-container">
<label id="fdt">Please Select Booking From:</label>
<input type="date" id="fromDate" name="fromDate"><br>
</div>
 <div class="form-container">
<label id="tdt">Please Select Booking To:</label>
<input type="date" id="toDate" name="toDate"><br>
</div>
  <div class="form-container">               
<button id="adddata" class="btn btn-dark" type="submit">BOOK ROOM</button>
</div>
</form>

<div class="form-container1">
<button id="back" class="btn btn-dark">BACK</button>
</div>

</body>

<script> 

$(document).ready(function(){ // collect Room Type Data From Dynamic DB(RoomsController.java)
	
	var dataList=[];
	$.ajax({
		type :'GET',
		url:'/o/infy/getRoomName',
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
	function populateComboBox(data) {// this method used for showing Roomtype in dynamicDrop Down
		 comboBox=$("#mycombo");
		comboBox.empty();
		comboBox.append($('<option>').text("Select roomType...").val(''));
		$.each(data,function(index,value){
			comboBox.append($('<option>').text(value).val(value));
		});
	}
	var dataList1=[];
	$('#mycombo').change(function(){
		var roomName1=$(this).val();
		$.ajax({
			type :'GET',
			url:'/o/infy/getRoomAvalibilityByName?roomName='+roomName1,
			success: function(result) {
	          console.log("value addded::getRoomTypeAllData:::"+result);       
	   	       $('#totalRoomAvaliable').val(result);
			},
	         error:function(xhr,status,error){
				console.error(error);
	           }
		});
	});
	var formData;
	var allData={};
	$('#myForm').submit(function(e){
	var submitdata=confirm("Kindly check once Before submiting,Are you sure to submit." );
		console.log("submitted value"+submitdata);
		if(submitdata==false) {
			return false;
		}
	/* 	var fromdatedata=$('#fromDate').val();//21/06/2023
		var todatedata=$('#toDate').val();
		var  date1 = new Date(fromdatedata);
		var date2 = new Date(todatedata);
			if((fromdatedata=="") || (todatedata=="")){
			alert("kindly provide Date input for add Room");
			return false;
		}
			else if(date1>date2){
				alert(" toDate Should be Greater then or equals to fromDate");
				return false;
			} */
			
		e.preventDefault();
	// formdata=$(this).serialize();
	 //console.log("rffffffffffffffffff"+formdata);
	 
	 console.log("all the form data:::::::"+allData);
	/*allData= {
			formData:formdata,
			AmenitiesjsonData};
			console.log("all the form data:::::::"+JSON.stringify(allData));*/
	$.ajax({
		type :'POST',
		url:'/o/infy/addRoomData',
		contentType:'application/json;charset=utf-8',
		 data:JSON.stringify({
			//formData:formdata,
			formData:allData,
			AmenitiesjsonData:AmenitiesjsonData
		 }),
		success: function(result) {
          console.log("value addded for ADD Data:::::"+result.value);
          
          if(result.value ==='ADDROOM') {
  			showMassage("new room record added sucessFully",5000,"green");
        }
          else{
        	  showMassage("Error occured while adding room record,Please contact admin",5000,"red"); 
          }
          //window.location.href = "/infy/SuccessAddPage";
		},
         error:function(xhr,status,error){
        	 showMassage("Error occured while adding room record,Please contact admin",5000,"red");
			console.error(error);
           }
	});
	});
	
	
	var AmenitiesjsonData={};
	$('#adddata').click(function(e){
		var amentis= {};
		var amentisAllData= {};
		var CheckValue=[];
		var radioValue=$('input[name="SmokingAvailable"]:checked').val();
		var ACValue=$('input[name="isACRoom"]:checked').val();
		var rmtype=$("#mycombo").val();
		var totalRoomAvaliable=$("#totalRoomAvaliable").val();
		var totalRoomBooked=$("#totalRoomBooked").val();
		var price=$("#price").val();
		var roomName=$("#roomName").val();
		
		
		amentisAllData.roomType=rmtype;
		amentisAllData.roomName=roomName;
		amentisAllData.price=price;
		amentisAllData.isACAvailable=ACValue;
		amentisAllData.isSmokingAvailable=radioValue;
		amentisAllData.totalRoomAvaliable=totalRoomAvaliable;
		amentisAllData.totalRoomBooked=totalRoomBooked;
		//amentisAllData.bookDetails="";
	if(rmtype==""){
		alert("please select a RoomType");
		return false;
		
	}
	else if(price==""){
		alert("please enter price value");
		return false;
		
	}
	else if(ACValue=="" || typeof ACValue==="undefined"){
		alert("please  select AC ROOM / NON-AC ROOM");
		return false;
		
	}

	else if(radioValue=="" || typeof radioValue==="undefined"){
		alert("please select Smoking Room or Non-Smoking Room ");
		return false;
		
	}
		amentis.isSmokingAvailable=radioValue;
		amentis.isACAvailable=ACValue;

		
				$('input[name="checkdata"]:checked').each(function(){
					//CheckValue.push($(this).val());
					 var value = $(this).val();
					 amentis["is" + value + "Available"] = "true";
				});
				//amentis.checkboxes=	CheckValue;
				amentis.amenties=	CheckValue;
				//amentisAllData.amenties=CheckValue;
				AmenitiesjsonData=JSON.stringify(amentis);
				allData=JSON.stringify(amentisAllData);
				
				console.log(" Amenities jSONData::::::::::"+AmenitiesjsonData);
	});
	
	$('#fromDate').on('change', function() {
		var fromDate = $('#fromDate').val().trim();
		$('#toDate').attr('min',fromDate);
		$('#Hotel').DataTable().draw();
		});

		$('#toDate').on('change', function() {
		var toDate = $('#toDate').val().trim();
		$('#fromDate').attr('max',toDate);
		$('#Hotel').DataTable().draw();
		}); 
});
$('#back').click(function(e){
	var backRoomURL = '<%= backRoomURL %>';
	window.location.href  = backRoomURL;
		//window.location.href = "http://localhost:8084/infy/homepage";
	});
function showMassage(message,duration,colordata) {  
	var massageElement=document.createElement("div");
	massageElement.textContent=message;
	massageElement.style.position="fixed";
	massageElement.style.top="50px";
	massageElement.style.left="50px";
	massageElement.style.display="flex";
	//massageElement.style.tranform="translate(-50%, -50%)";
	massageElement.style.justifyContent="center";
	massageElement.style.alignItems="center";
	massageElement.style.textAlign="center";
	massageElement.style.padding="10px";
	massageElement.style.backgroundColor=colordata;
	massageElement.style.color="white";
	massageElement.style.borderRadius="5px";
	massageElement.style.width="60%";
	massageElement.style.textAlign="center";
	document.body.appendChild(massageElement);
	setTimeout(function(){
		massageElement.remove();
		},duration);
	 }

</script>

</html>