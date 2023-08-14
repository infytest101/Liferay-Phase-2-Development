<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.7/css/jquery.dataTables.css">

<portlet:defineObjects/>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<title>UpdateRoom</title>

<style>
	table {
		width: 100%;
	}
</style>

<h2>Update Room Details</h2>

<portlet:actionURL var="submitFormURL">
<portlet:param name="action" value="submitForm" />
</portlet:actionURL>

<aui:form action="<%= submitFormURL %>" method="post">
	<table>
		<tr>
			<td><label for="roomType">Room Type</label></td>
			<td><label>:</label></td>
			<td>
			  <select id="roomType" name="<portlet:namespace/>roomType" style="width: 250px; height: 40px;"></select>
			  <span class = "error-message">${errorMessageRoomType}</span>
			</td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td><label>Price</label></td>
			<td><label>:</label></td>
			<td><input type="number"  name= "<portlet:namespace/>price"  id="price"  value=${room.price} min="0" max="25000"/>
			 <span class = "error-message">${errorMessagePrice}</span>
			 </td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td><label>Amenities</label>
				<table id=table_two>
					<tr>
						<td><label for="ac/non-ac">AC/Non-AC</label></td>
						<td><label></label></td>
					</tr>
					<tr>
					</tr>
					<tr>
						<td><label for="smoking/non-smoking">Smoking/Non-Smoking</label>
						</td>
						<td><label></label></td>
					</tr>
					<tr>
					</tr>
					<tr>
						<td><label for="wi-fi/tv/geyser">WI-FI/TV/Geyser</label></td>
						<td><label></label></td>
					</tr>
					<tr>
					</tr>
				</table></td>
			<td><br> <br> <label>:</label> <br> <label>:</label><br>
				<label>:</label><br></td>
			<td><br> <br>
				<div>
					<input type="radio" id="ac" name="<portlet:namespace/>isACAvailable" ${amenities.isACAvailable  == 'true' ? 'checked' : ''}>
					<label for="ac">AC</label>
				</div>
				<div>
					<input type="radio" id="non-ac" name="<portlet:namespace/>isNonACAvailable" ${amenities.isACAvailable  == 'false' ? 'checked' : ''}> 
					<label for="non-ac">Non-AC</label>
				</div> 
				 <span class = "error-message">${errorMessageAC}</span>
				 <br>
				<div>
					<input type="radio" id="smoking" name="<portlet:namespace/>isSmokingAvailable" ${amenities.isSmokingAvailable  == 'true' ? 'checked' : ''}> 
					<label for="smoking">Smoking</label>
				</div>
				<div>
					<input type="radio" id="non-smoking" name="<portlet:namespace/>isNonSmokingAvailable" ${amenities.isSmokingAvailable  == 'false' ? 'checked' : ''}> 
					<label for="non-smoking">Non-Smoking</label>
				</div> <br>
				<div>
					<input type="checkbox" id="wifi" name="<portlet:namespace/>isWifiAvailable " ${amenities.isWifiAvailable  == 'true' ? 'checked' : ''}> 
					<label for="wifi">WI-FI</label>
				</div>
				<div>
					<input type="checkbox" id="tv" name="<portlet:namespace/>isTVAvailable " ${amenities.isTVAvailable  == 'true' ? 'checked' : ''}>
					<label for="tv">TV</label>
				</div>
				<div>
					<input type="checkbox" id="geyser" name="<portlet:namespace/>isGeyserAvailable" ${amenities.isGeyserAvailable == 'true' ? 'checked' : ''}> 
					<label for="geyser">Geyser</label>
				</div></td>

		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td><label>Total Room Available</label></td>
			<td><label>:</label></td>
			<td>
			  <input type="number"  name= "totalRoomAvailable"  id="totalRoomAvailable"  value=${room.totalRoomsAvailable} min="0" max="25000"/>
			</td>
		</tr>

	</table>

	<br>
    <input type="text" value=${room.roomId} name="<portlet:namespace/>roomId" id=roomId style="display: none;">
	
	<div style="text-align: left; margin-left: 45px;">
		<input type="submit" value="Update Room" name="action" id=updateRoom;>
		<input type="submit" value="Add Room" name="action" id=addRoom;>
	</div>
</aui:form>

<script type="text/javascript">

	var roomType = ${roomType};
	var room = ${room};
	var roomId;
	
	$(document).ready(
			function() {
				if(${room.roomId}>0){
					  $("#updateRoom").show();
				}
				else{ 
					 $("#addRoom").show();
				}
				var roomTypeNames = ${roomTypeNames};
				var roomTypeNamesArray = [];

				roomId = room.roomId;
				roomType = roomType.RoomType;

				$('#roomType').append(
						'<option selected="selected" value="'+roomType+'">'
								+ roomType + '</option>');

				$.each(roomTypeNames, function(key, value) {
					if (value.RoomType != roomType) {
						$('#roomType').append(
								'<option value="'+value.RoomType +'">'
										+ value.RoomType + '</option>');
					}
				})

			});
</script>