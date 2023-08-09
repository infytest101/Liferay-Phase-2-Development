<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOTEL MANAGMENT SYSTEM</title>
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
 
 <style>
 #fromDate,#toDate{/* 21/06/2023 */
 display:none;
 }
 td,th,h1{
	 text-align:center
	 }
	 .rm,#roomid{
	 display:none
	 }

 </style>
 </head>
<body>
<portlet:renderURL var="backRoomURL">
<portlet:param name="page" value="back"/>
</portlet:renderURL>
<portlet:renderURL var="costumerBookRoomURL">
<portlet:param name="page" value="costumerBookRoomURL"/>
</portlet:renderURL>
<h1>HOTEL MANAGMENT SYSTEM</h1>
<!-- Filter>>> //21/06/2023
from Date::<input type="date" id="fromDateFilter" name="fromDate">
to Date::<input type="date" id="toDateFilter" name="toDate"> -->
 Filter>>> RoomType:<select id="mycombo" name="roomtype"></select>
<button id="searchid"class="btn btn-dark">Search</button>

<button id="back" class="btn btn-dark">BACK</button>

<!-- <button class="btn btn-secondary">Search</button> -->
<table id="Hotel" class="table table-bordered table-striped"style="width: 100%">
<thead>
	<tr>
		<th id="roomid">Room ID</th>
		<th id="roomtypedata">Room Type</th>
		<th id="roomName">Room Name</th>
		<th id="price">Price</th>
		<th id="formDate">FROM DATE</th>
		<th id="toDate">TO DATE</th>
		<th id="totalRoomAvaliable">Room availability</th>
		<th id="totalRoomBooked">Room Booked</th>
		<th id="acnonac">AC</th>
		<th id="smoknosmok">Smoking</th>
		<th id="amentis">Amenities</th>
		<th id="editdel">Action</th>
		
	</tr>
</thead>
<tbody>
</tbody>
</table>
<script>


	
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
$('#back').click(function(e){
	var backRoomURL = '<%= backRoomURL %>';
	window.location.href  = backRoomURL;
		//window.location.href = "http://localhost:8084/infy/homepage";
	});
function editdata(value){
	
	var editformData='';
	 var editEncodingvalue='';
	 var rowdata1={};
	//var rmval= confirm("Are YOU SURE ,EDIT THE ROOM DATA");
	/*  $('#Hotel .deleteclasss').each(function(){
		 $(this).change(function(){
			 var data=$(this).val();
			 console.log("data11111111 ::::::::::::::::"+data);
				alert("data clicked111111::::"+data);
		 });
	 }); */
/* 	 console.log("data233333 ::::::::::::::::"+value);
		 var data=$('.deleteclasss').val();
		 console.log("data233333 ::::::::::::::::"+data);*/
			//alert("data clicked222222::::"+value); 
		if(value=="delete"){
			 $('#Hotel').on('change','.deleteclasss',function(){
				 showMassage("It Will be Implementing In Phase 2 Devlopment",5000,"red");
				 return false;
			 var rowdata=$(this).closest('tr').find('td').map(function(){
				  var fieldname=$(this).data('field-name');
				  var value=$(this).text();
				  return fieldname +'='+value;
			  }).get();
			  var fieldname1=$(this).closest('tr').find('.rm').data('field-name');
			  var rowdata111=$(this).closest('tr').find('.rm').text();
			  var rowdataid="&"+rowdata111;
			  console.log("rowdata111 rowdata111 rowdata111"+rowdata111);
			  var Encodingvalue1=rowdata.join('&');
			  var Encodingvalue=encodeURIComponent(rowdata.join('&'));
			  
			  var frmdt=$(this).closest('tr').find('.fmdate').text();
			  var tomdt=$(this).closest('tr').find('.tmdate').text();
			   var part=frmdt.split("-");
			  var day=parseInt(part[0],10);
			  var month=parseInt(part[1],10)-1;
			  var year=parseInt(part[2],10);
			  var fmd=new Date(year,month,day);
			  var part1=tomdt.split("-");
			  var day1=parseInt(part1[0],10);
			  var month1=parseInt(part1[1],10)-1;
			  var year1=parseInt(part1[2],10);
			  var tmd=new Date(year1,month1,day1);
			   var today = new Date();
			   today.setHours(0,0,0,0);
			  if(today<=fmd){
				  alert("you can't Delete ongoing/future booking");
				  return false;
			  }
			  else if(today<=tmd){
				  alert("you can't Delete ongoing/future booking");
				  return false;
			  } 
			  console.log("Encodingvalue"+Encodingvalue1);
			  var rmval= confirm("Are YOU SURE ,Delete THE ROOM DATA  ");
			  if(rmval==true) {
				  //window.location.href = "/infy/deleteroomdetails/"+rowdata111;
		 	  $.ajax({
					type :'GET',
					url:"/infy/deleteroomdetails/"+rowdata111,
					success: function(result) {
						if(result ==='deletedata') {
							//window.location.href = "/infy/deleteroomdetails/"+rowdata111;
							showMassage("Room data Deleted SucessFully",5000);
					/* 		var showMessage=$("<div>")
							.text("Room Data Deleted successfully")
							.css({
								position:"fixed"
								});
							$("body").append(showMessage);
							setTimeout(function(){
								showMessage.remove();
								},5000); */
							 //setTimeout(fun11, 2000);  
							  
							 
							}
					},
			         error:function(xhr,status,error){
						console.error(error);
			           }
				}); 
			  }
			  
		  });
		}
		else if(value=="edit"){
			 //showMassage("It Will be Implementing In Phase 2 Devlopment",5000,"red");
			// return false;
			// var rmval= confirm("Are YOU SURE ,BOOK THE ROOM DATA");
			 // if(rmval==true) {
					 $('#Hotel').on('change','.deleteclasss',function(){
						 var rowdata=$(this).closest('tr').find('td').map(function(){
							  var fieldname=$(this).data('field-name');
							  var value=$(this).text();
							//  return fieldname +': "'+value+'"';
							  return fieldname +'='+value;
						  }).get();
						  var fieldname1=$(this).closest('tr').find('.rm').data('field-name');
						  var rowdata111=$(this).closest('tr').find('.rm').text();
						  var rowdataid="&"+rowdata111;
						   editEncodingvalue=rowdata.join('&');
						  var Encodingvalue=encodeURIComponent(rowdata.join('&'));
						  rowdata1=rowdata;
						  console.log("Encodingvalue"+editEncodingvalue);
						  var costumerBookRoomURL = '<%= costumerBookRoomURL %>';
							  window.location.href  = costumerBookRoomURL;
			/*   $.ajax({
				 	url:'/infy/editroomdetails1?',
					type :'get',
					data:editEncodingvalue,
					success: function(result) {
						console.log("edit  sucess:::::"+result);
						if(result !=null) {
							window.location.href = "/infy/editroomdetails1?"+editEncodingvalue;
							//window.location.href = "EditHotel.jsp";
						}
					
					},
			         error:function(xhr,status,error){
						console.error(error);
			           }
				}); */ 
					 });
			 // }
		}
}
function addRoom(){
	var rmval= confirm("do you want to add new Room Data");
	if(rmval==true) {
	window.location.href = "/infy/addCostumer";
	}
}
/* function showMessage(message,duration){

} */
</script>
<script>
$(document).ready(function () {
	
	var tabledata=$('#Hotel').DataTable({
		"lengthMenu":[5, 10, 15, 20],
		"searching": false,
		"columnDefs": [ {
			//"targets":0,
		//	"visible":false
		},
		   {
				"targets":4,"width":"15%","visible":false
		   },
		   {
				"targets":5,"width":"10%","visible":false
		   },
		   {
				"targets":1,"width":"5%"
		   },
		   {
				"targets":2,"width":"5%"
		   },
		   {
				"targets":5,"width":"5%"
			},
			{
				"targets":6,"width":"5%"
			},
			{
				"targets":7,"width":"15%"
			},
			{
				"targets":8,"width":"15%"
			},
			{
				"targets":9,"width":"20%"
			},
			{
				"targets":10,"width":"10%"
			}
		   ]
	
		});
	
	
	
	var dataList=[];
	
	$('#searchid').click(function(){
		var rmdata=$('#mycombo').val();
		//var tdata=$('#Hotel').DataTable();
		//tdata.clear();
	/* 	var fromdatedata=$('#fromDateFilter').val();//21/06/2023
		var todatedata=$('#toDateFilter').val();
		
		console.log("roomType:::"+rmdata);
		var  date1 = new Date(fromdatedata);
		var date2 = new Date(todatedata);
			if((fromdatedata=="") || (todatedata=="")){
			alert("kindly provide Date input for Filtering Data");
			return false;
		}
			else if( todatedata==""){
				alert("kindly provide Date input for Filtering Data");
				return false;
			}
			else if(date1>date2){
				alert(" toDate Should be Greater then or equals to fromDate");
				return false;
			} */
			if(rmdata=="empty"){
				showMassage("please select a valid input",3000,"#33ffff");  
				return false;
			}
			
		var tdata=$('#Hotel').DataTable();
		tdata.clear();
		//console.log("fromdatedata"+fromdatedata);
		//console.log("todatedata"+fromdatedata);
		$.ajax({
			type :'GET',
			//url:'/infy/fetchAllFilterRoooms?fromdatedata='+fromdatedata+"&todatedata="+todatedata+"&roomtype="+rmdata,//21/06/2023
					url:'/infy/RoomTypeFilterSearch?roomtype='+rmdata,
			success: function(result) {
	          console.log("value addded:::::"+result);
	          if(result==""){
	        	  showMassage("filter-data not found in database,please provide different input",3000,"red");  
	          }
	          dataList=result;
	          console.log("value addded:::::"+dataList)
	          
	       for (var i=0;i<dataList.length; i++) { 
	       var roomType = dataList[i]; 
	       //var am=JSON.parse(roomType.amenties);
	       //var wifi=am.amenties;
	       //console.log("wifiiii"+wifi);
	       var wifidata='';
	 	  var ACAvailable='not avaliable';
	 	  var SmokingAvailable='not avaliable';
	  if(roomType.wifiAvailable){
	 	 wifidata+="WIFI,";
	  }
	  if(roomType.tvavailable){
	 	 wifidata+="TV,";
	  }
	  if(roomType.geyserAvailable){
	 	 wifidata+="Geyser,";
	  }
	  if(roomType.isACAvailable){
	 	 ACAvailable="avaliable";
	  }
	  if(roomType.isSmokingAvailable){
	 	 SmokingAvailable="avaliable";
	  }
	 var checkwifi = wifidata.includes(",", wifidata.length-1);
	 var dataresult='';
	 if(checkwifi){
	  dataresult = wifidata.substring(0, wifidata.length-1);
	 }
	 var wifi="";
	      var newrow= tabledata.row.add([
	    	   roomType.id,
	    	   roomType.roomtypedata,
	    	   roomType.roomName,
	    	   roomType.price,
	    	   roomType.fromDate,
	    	   roomType.toDate,
	    	   roomType.totalRoomAvaliable,
	    	   roomType.totalRoomBooked,
	    	   roomType.isACAvailable,
	    	   roomType.isSmokingAvailable,
	    	   dataresult,
	    	   '<td><select class="deleteclasss" onchange="editdata(this.value)"><option value="">Select..</option><option value="edit" Style=background:lightblue>Book Room</option><option value="delete" Style=background:red>Delete Room</option></select></td>'
	    	   ]).draw(false).node();
	      $(newrow).find('td:eq(0)').attr('data-field-name','roomid').addClass('rm');
	      $(newrow).find('td:eq(1)').attr('data-field-name','roomtypedata');
	      $(newrow).find('td:eq(1)').attr('data-field-name','roomName');
	      $(newrow).find('td:eq(2)').attr('data-field-name','price');
	      $(newrow).find('td:eq(3)').attr('data-field-name','formDate').addClass('fmdate');
	      $(newrow).find('td:eq(4)').attr('data-field-name','toDate').addClass('tmdate');
	      $(newrow).find('td:eq(5)').attr('data-field-name','totalRoomAvaliable').addClass('trma');
	      $(newrow).find('td:eq(6)').attr('data-field-name','totalRoomBooked').addClass('trbd');
	      $(newrow).find('td:eq(7)').attr('data-field-name','acnonac');
	      $(newrow).find('td:eq(8)').attr('data-field-name','smoknonsmok');
	      $(newrow).find('td:eq(9)').attr('data-field-name','wifitv');
	      $(newrow).find('td:eq(10)').attr('data-field-name','action');
	       
	       }
			},
	         error:function(xhr,status,error){
	        	 showMassage("Error occured while load room data,Please Contact Admin",5000,"red");
				console.error(error);
	           }
			
		});
	});
	
	
/* 	$('#fromDateFilter').on('change', function() { //when onload event fire data loaded in Jquery Data Table 21/03/2023
		var fromDate = $('#fromDateFilter').val().trim();
		$('#toDateFilter').attr('min',fromDate);
		$('#Hotel').DataTable().draw();
		});

		$('#toDateFilter').on('change', function() {
		var toDate = $('#toDateFilter').val().trim();
		$('#fromDateFilter').attr('max',toDate);
		$('#Hotel').DataTable().draw();
		});
	 */
	
	
	 $.ajax({
		type :'GET',
		url:'/o/infy/fetchAllRoooms',
		success: function(result) {
          console.log("value addded:::::"+result);
          dataList=result;
          console.log("value addded:::::"+dataList)
       for (var i=0;i<dataList.length; i++) { 
       var roomType = dataList[i]; 
       var wifidata='';
	 	  var ACAvailable='not avaliable';
	 	  var SmokingAvailable='not avaliable';
	  if(roomType.wifiAvailable){
	 	 wifidata+="WIFI,";
	  }
	  if(roomType.tvavailable){
	 	 wifidata+="TV,";
	  }
	  if(roomType.geyserAvailable){
	 	 wifidata+="Geyser,";
	  }
	  if(roomType.isACAvailable){
	 	 ACAvailable="avaliable";
	  }
	  if(roomType.isSmokingAvailable){
	 	 SmokingAvailable="avaliable";
	  }
	 var checkwifi = wifidata.includes(",", wifidata.length-1);
	 var dataresult='';
	 if(checkwifi){
	  dataresult = wifidata.substring(0, wifidata.length-1);
	 }
	 var wifi="";
       
       var newrow= tabledata.row.add([
    	   roomType.id,
    	   roomType.roomtypedata,
    	   roomType.roomName,
    	   roomType.price,
    	   roomType.fromDate,
    	   roomType.toDate,
    	   roomType.totalRoomAvaliable,
    	   roomType.totalRoomBooked,
    	   ACAvailable,
    	   SmokingAvailable,
    	   dataresult,
    	   '<td><select class="deleteclasss"  onchange="editdata(this.value)"><option value="">Select..</option><option class="opt2"value="edit" Style=background:lightblue>Book Room</option><option value="delete" Style=background:red>Delete Room</option></select></td>'
    	   ]).draw(false).node();
      $(newrow).find('td:eq(0)').attr('data-field-name','roomid').addClass('rm');
      $(newrow).find('td:eq(1)').attr('data-field-name','roomtypedata');
      $(newrow).find('td:eq(2)').attr('data-field-name','roomName');
      $(newrow).find('td:eq(3)').attr('data-field-name','price');
      $(newrow).find('td:eq(4)').attr('data-field-name','formDate').addClass('fmdate');
      $(newrow).find('td:eq(5)').attr('data-field-name','toDate').addClass('tmdate');
      $(newrow).find('td:eq(6)').attr('data-field-name','totalRoomAvaliable').addClass('trma');
      $(newrow).find('td:eq(7)').attr('data-field-name','totalRoomBooked').addClass('trbd');
      $(newrow).find('td:eq(8)').attr('data-field-name','acnonac');
      $(newrow).find('td:eq(9)').attr('data-field-name','smoknonsmok');
      $(newrow).find('td:eq(10)').attr('data-field-name','wifitv');
      $(newrow).find('td:eq(11)').attr('data-field-name','action').addClass('act');
     
       }
       },
         error:function(xhr,status,error){
			console.error(error);
           }
		
	}); 
	
	
	
	 
	$.ajax({
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
	function populateComboBox(data) {// this method used for showing Roomtype in dynamicDrop Down
		 comboBox=$("#mycombo");
		comboBox.empty();
		comboBox.append($('<option>').text("Select RoomType...").val('empty'));
		$.each(data,function(index,value){
			comboBox.append($('<option>').text(value).val(value));
		});
	}
	
	$('#Hotel').on('click', '.deleteclasss',function(){
		  var row=$(this).closest('tr');
		  var rwTotal=row.find('.fmdate').text();
		  var rwBooked=row.find('.tmdate').text();
		  var combo1=row.find('.deleteclasss');
		   if(rwTotal===rwBooked){
			   combo1.find('option[value="edit"]').prop('disabled',true);
		  } 
		   else{
			   combo1.find('option[value="edit"]').prop('disabled',false); 
		   }
	});
 
});
</script>
</body>
</html>
