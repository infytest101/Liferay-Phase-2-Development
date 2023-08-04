package room.rest.api.application;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import ROOMSERVICES.model.RoomType;
import ROOMSERVICES.service.RoomTypeLocalServiceUtil;
import ROOMSERVICES.service.RoomsLocalServiceUtil;
import room.rest.api.application.bean.RequestBodydata;

/**
 * @author biswajit.nayak01
 */
@Component(property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/infy",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Greetings.Rest" }, service = Application.class)
public class RoomRestApiApplication extends Application {
	private static final Log logger = LogFactoryUtil.getLog(RoomRestApiApplication.class);

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Produces("text/plain")
	public String working() {
		return "It works!";
	}

	@GET
	@Path("/morning")
	@Produces("text/plain")
	public String hello() {
		return "Good morning!";
	}

	@GET
	@Path("/morning/{name}")
	@Produces("text/plain")
	public String morning(@PathParam("name") String name, @QueryParam("drink") String drink) {

		String greeting = "Good Morning " + name;

		if (drink != null) {
			greeting += ". Would you like some " + drink + "?";
		}

		return greeting;
	}

	@GET

	@Path("/getRoomType")

	@Produces("application/json")
	public List<String> fetchRoomType() throws Exception {
		List<RoomType> rtype = RoomTypeLocalServiceUtil.getRoomTypes(-1, -1);
		logger.info("getRoomTypesCount roomType Data from DB:::" + RoomTypeLocalServiceUtil.getRoomTypesCount());
		boolean isAvaliable = rtype.stream().allMatch(Objects::isNull);
		if (isAvaliable)
			throw new Exception("Room Type Data Not avaliable in DB table kindly insert data::::");
		List<String> roomtypedata = rtype.stream().map(RoomType::getRoomType).collect(Collectors.toList());
		logger.info("fetching roomType Data from DB:::" + roomtypedata);
		return roomtypedata;
	}
	@POST
    @Path("/addRoomData")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addRoomData(RequestBodydata requestdata, @Context HttpServletRequest httpServletRequest) {
        System.out.println("inside addRoomData() @RequestBody VALUES:::::::::::::::::" + JSONFactoryUtil.serialize(requestdata));

        try {
            // Extract the required data from the requestdata object and pass it to your service method.
            // For example:
            String amenitiesJsonData = requestdata.getAmenitiesjsonData();
            String formData = requestdata.getFormData();
            logger.info("inside addRoomData() @RequestBody formData VALUES:::::::::::::::::" + formData);
            logger.info("inside addRoomData() @RequestBody amenitiesJsonData VALUES:::::::::::::::::" + amenitiesJsonData);
            // Call your service method to add room details
            String value =   RoomsLocalServiceUtil.addRoomDetails(amenitiesJsonData, formData);
            		//roomService.addRoomDetails(amenitiesJsonData, formData);
            // If everything went well, return success response
            JSONObject responseJson = JSONFactoryUtil.createJSONObject();
            responseJson.put("success", true);
            responseJson.put("message", "Room details added successfully");
            responseJson.put("value", value); // Include the returned value if needed.
            return Response.status(Response.Status.OK).entity(responseJson.toString()).build();
        } catch (Exception e) {
            // In case of an exception, return an error response
            JSONObject errorJson = JSONFactoryUtil.createJSONObject();
            errorJson.put("success", false);
            errorJson.put("message", "Error adding room details: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorJson.toString()).build();
        }
	}
	/*
	 * public ResponseEntity<List<RoomPriceTypeDto>> fetchBookingDetails() {
	 * List<RoomPriceTypeDto> rpto = roomService.fetchAllRoomData();
	 * logger.info("fetchAllRoooms ::::::::::::::::::::::::::::::::::"+rpto); return
	 * ResponseEntity.ok(rpto); }
	 */
}