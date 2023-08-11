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

<form id="roomForm">

	<table>
		<tr>
			<td><label for="roomType" >Room Type</label></td>
			<td><label>:</label></td>
			<td><select  id="roomType" name="roomType"
				style="width: 250px; height: 40px;">
			</select></td>
		</tr>
		<tr>
		    <td></td>
		    <td></td>
		    <td></td>
		</tr>
		<tr>
			<td><label>Price</label></td>
			<td><label>:</label></td>
			<td><input type="number" min="0" id="price"
				name="price" style="width: 250px; height: 40px;" required></td>
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
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" id="ac" name="acNonAc"
						value="AC" required> <label class="form-check-label"
						for="ac">AC</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" id="non-ac"
						name="acNonAc" value="Non-AC" required> <label
						class="form-check-label" for="non-ac">Non-AC</label>
				</div> <br>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" id="smoking"
						name="smokingNonSmoking" value="Smoking" required> <label
						class="form-check-label" for="smoking">Smoking</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" id="non-smoking"
						name="smokingNonSmoking" value="Non-Smoking" required> <label
						class="form-check-label" for="non-smoking">Non-Smoking</label>
				</div> <br>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" id="wifi"
						name="wi-fi/tv/geyser" value="WI-FI"> <label
						class="form-check-label" for="wifi">WI-FI</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" id="tv"
						name="wi-fi/tv/geyser" value="TV"> <label
						class="form-check-label" for="tv">TV</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" id="geyser"
						name="wi-fi/tv/geyser" value="Geyser"> <label
						class="form-check-label" for="geyser">Geyser</label>
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
			<td><input type="number" min="0" id="totalRoomAvailable"
				name="totalRoomAvailable" style="width: 250px; height: 40px;">
			</td>
		</tr>

	</table>

	<br>

	<div style="text-align: left; margin-left: 45px;">
		<input type="submit" value="Update Room" name="action"
			style="width: 100px; height: 30px; background-color: white;">
	</div>

</form>

<script type="text/javascript">
var beforeEditData = ${beforeEditData};

	$(document).ready(function() {
						var roomTypeNames = ${roomTypeNames};
						var roomTypeNamesArray = [];
						
	      $.each(beforeEditData, function(key, value) {

							roomType = value[0].roomType;
							
							$('#roomType').append('<option selected="selected" value="'+roomType+'">'+ roomType + '</option>');
							
							$('#price').val(value[0].price);
							if (value[0].isACAvailable === true)
								$('#ac').prop('checked', true);
							else
								$('#non-ac').prop('checked', true);

							if (value[0].isSmokingAvailable === true)
								$('#smoking').prop('checked', true);
							else
								$('#non-smoking').prop('checked', true);

							if (value[0].isWifiAvailable == true) {
								$('#wifi').prop('checked', true);
							}

							if (value[0].isTVAvailable == true) {
								$('#tv').prop('checked', true);
							}

							if (value[0].isGeyserAvailable == true) {
								$('#geyser').prop('checked', true);
							}
							$('#totalRoomAvailable').val(value[0].totalRoomsAvailable);

	     });
	      
	      var roomTypeNames = ${roomTypeNames};
	    	$.each(roomTypeNames, function(index, data) {
				if(data.RoomType != roomType){
				    $('#roomType').append(
						'<option value="'+data.RoomType +'">'
								+ data.RoomType + '</option>');
				}
			})
	
	});
	
</script>