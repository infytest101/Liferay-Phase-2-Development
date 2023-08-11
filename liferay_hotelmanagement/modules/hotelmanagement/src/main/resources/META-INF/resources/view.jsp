<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.7/css/jquery.dataTables.css">

<portlet:defineObjects/>

<style>
	table {
		width: 100%;
	}
</style>

<h2>Hotel Management System</h2>
<br>
<table>
	<thead>
		<tr>
			<th>
				<div>Room Type : <label> <select onchange="actionHandler(this)"
						id="roomTypes" name="roomType">
							<option id="roomType">All</option>
					</select>
					</label>
				</div>
			</th>
			<th>
			  <div>AC/Non-AC  : <label> <select onchange="handleClickAcOrNonAc(this)" id="acOrNonAc" >
			                <option>All</option>
							<option>AC</option>
							<option>Non-AC</option>
					</select>
					</label>
			  </div>
			</th>
			<th>
			  <div>Smoking/Non-Smoking  :  <label> <select onchange="handleClickSmokingOrNonSmoking(this)" id="isSmoking" >
			                <option>All</option>
							<option>Smoking</option>
							<option>Non-Smoking</option>
					</select>
					</label>
			  </div>
			</th>

		</tr>
		<tr>
			<th>
				<div>
					Amenities : &nbsp;&nbsp; <label><input
						onclick='actionHandlerWifi(this);' type="checkbox" id="wifi"
						class="amenities" value="WIFI"> WIFI</label> <label><input
						onclick='actionHandlerTv(this);' type="checkbox" id="tv"
						class="amenities" value="TV"> TV</label> <label><input
						onclick='actionHandlerGeyser(this);' type="checkbox" id="geyser" class="amenities" value="Geyser">
						Geyser</label>
				</div>
			</th>
		</tr>

	</thead>

	</tbody>
</table>

<br>

<table id="roomTable" class="display">
	<thead>
		<tr>
			<th>Room Type</th>
			<th>Room Name</th>
			<th>Price</th>
			<th>AC/Non-AC</th>
			<th>Smoking/Non-Smoking</th>
			<th id="amenities">Amenities</th>
			<th></th>

		</tr>
	</thead>

	</tbody>
</table>

<script type="text/javascript">
    var roomDetails = ${roomDetails};
    $(document).ready(function() {
    	var roomTypeNames = ${roomTypeNames};
    	var roomTypeNamesArray =[];
    	$.each(roomTypeNames, function(key, value) {
    		
			if(value!=roomType && roomTypeNamesArray.indexOf(value.RoomType)=== -1){
				roomTypeNamesArray[key] = value.RoomType;
			    $('#roomTypes').append(
					'<option value="'+value.RoomType+'">'
							+ value.RoomType+ '</option>');
			}
		})
		
        if(roomDetails && roomDetails.length>0){
    	var rooms = [];

    	$.each(roomDetails,function(key, value) {
    	var acOrNonac ;
        var smokingOrNonsmoking;
        var amenities="";	
        if(value[0].isACAvailable===true)
        	acOrNonac="AC";
        else
        	acOrNonac="Non-AC";
        
        if(value[0].isSmokingAvailable===true)
        	smokingOrNonsmoking="Smoking";
        else
        	smokingOrNonsmoking="Non-Smoking";
        
        
        if(value[0].isWifiAvailable==true){
        	if(amenities==="")
        		amenities = "WIFI"
            else	
            	amenities = ",WIFI"
        }
        
        if(value[0].isTVAvailable==true){
        	if(amenities==="")
        		amenities="TV"
            else	
            	amenities=amenities+ ",TV"
        }
        	
         
        if(value[0].isGeyserAvailable==true){
        	if(amenities==="")
        		amenities="Geyser"
            else	
            	amenities=amenities+ ",Geyser"
        }
        
        if(amenities==="")
        	amenities="No amenities available."
       
    	rooms.push([
    		value[0].roomType,
    		value[0].roomName,
    		value[0].price,
    		acOrNonac,
    		smokingOrNonsmoking,
    		amenities,
    		'<select onchange="actionHandle(this)"><option selected="selected">Select</option><option value='+value[0].roomId+','+value[0].roomTypeId+'>EDIT</option><option value='+value[0].roomId+'>DELETE</option><option value='+value[0].roomId+','+value[0].roomTypeId+'>BOOK</option></select>'])

    	});
    	$('#roomTable').DataTable({
       		"aLengthMenu": [[5, 10, 15,-1], [5, 10, 15, "All"]],
       		"iDisplayLength": 5,
       		pagingType: 'full_numbers',
       		data : rooms,
	        initComplete: function() {
	        	
            }
    	 });
        }
    });
    
    function actionHandler(value){
    	var e = document.getElementById("roomTypes");

        var value = e.value;

        var text = e.options[e.selectedIndex].text;
    	   
    	if(value!='All'){
        	$('#roomTable').DataTable().column(0).search(value,true, false).draw();
		}
		else{
			$('#roomTable').DataTable().search('').columns().search('').draw();
		}
    }
    
    function actionHandlerWifi(value){
    	amenitiesCheck();
    }   
    
    function actionHandlerTv(value){
    	amenitiesCheck();
    }
    
    function actionHandlerGeyser(value){
    	amenitiesCheck();
    }
    
    function amenitiesCheck(){
    	
    	if ($('#wifi').is(':checked') == true && $('#tv').is(':checked') == true && $('#geyser').is(':checked') == true) {
			$('#roomTable').DataTable().column(5).search("^WIFI,TV,Geyser$",true, false).draw();
		} else if ($('#wifi').is(':checked') == true && $('#tv').is(':checked') == true ) {
			$('#roomTable').DataTable().column(5).search("^WIFI,TV$",true, false).draw();
		} else if ($('#tv').is(':checked') == true && $('#geyser').is(':checked') == true) {
			$('#roomTable').DataTable().column(5).search("^TV,Geyser$",true, false).draw();
		} else if ($('#wifi').is(':checked') == true && $('#geyser').is(':checked') == true) {
			$('#roomTable').DataTable().column(5).search("^WIFI,Geyser$",true, false).draw();
		} else if ($('#wifi').is(':checked')) {
			$('#roomTable').DataTable().column(5).search("^WIFI$",true, false).draw();
		} else if($('#tv').is(':checked') == true){
			$('#roomTable').DataTable().column(5).search("^TV$",true, false).draw();
		} else if($('#geyser').is(':checked') == true){
			$('#roomTable').DataTable().column(5).search("^Geyser$",true, false).draw();
		}else if($('#wifi').is(':checked') == false && $('#tv').is(':checked') == false && $('#geyser').is(':checked') == false){
			$('#roomTable').DataTable().search('').columns().search('').draw();
		}
    	
    }
    
    function handleClickAcOrNonAc(value){
    	var e = document.getElementById("acOrNonAc");

        var value = e.value;

        var text = e.options[e.selectedIndex].text;
    	   
    	if(value!='All'){
        	$('#roomTable').DataTable().column(3).search("^" + value + "$",true, false).draw();
		}
		else{
			$('#roomTable').DataTable().search('').columns().search('').draw();
		}
    }
    
    function handleClickSmokingOrNonSmoking(value){
    	var e = document.getElementById("isSmoking");

        var value = e.value;

        var text = e.options[e.selectedIndex].text;
    	   
    	if(value!='All'){
        	$('#roomTable').DataTable().column(4).search("^" + value + "$",true, false).draw();
		}
		else{
			$('#roomTable').DataTable().search('').columns().search('').draw();
		}
    }
   function actionHandle(selectedValue) {
    	var id = selectedValue.options[selectedValue.selectedIndex].value;
		var action = selectedValue.options[selectedValue.selectedIndex].text;
		var roomtype;
		if (action == 'EDIT') {
			roomId= id.split(',')[0];
			roomtype=id.split(',')[1];
			'<p><b>EDIT</b></p>'
			location.href='/add-or-update-room?roomId='+ encodeURIComponent(roomId);
		}
		
		if (action == 'DELETE') {
			
		}
		
       if (action == 'BOOK') {
			
		}
		
    }
  
    </script>