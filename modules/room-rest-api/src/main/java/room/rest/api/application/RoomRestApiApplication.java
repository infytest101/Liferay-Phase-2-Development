package room.rest.api.application;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import ROOMSERVICES.model.RoomType;
import ROOMSERVICES.model.Rooms;
import ROOMSERVICES.service.RoomTypeLocalServiceUtil;
import ROOMSERVICES.service.RoomsLocalServiceUtil;

/**
 * @author biswajit.nayak01
 */
@Component(property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/infy",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Greetings.Rest" }, service = Application.class)
public class RoomRestApiApplication extends Application {
	private static final Log LOGGER = LogFactoryUtil.getLog(RoomRestApiApplication.class);

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
		LOGGER.info("getRoomTypesCount roomType Data from DB:::" + RoomTypeLocalServiceUtil.getRoomTypesCount());
		boolean isAvaliable = rtype.stream().allMatch(Objects::isNull);
		if (isAvaliable)
			throw new Exception("Room Type Data Not avaliable in DB table kindly insert data::::");
		List<String> roomtypedata = rtype.stream().map(RoomType::getRoomType).collect(Collectors.toList());
		LOGGER.info("fetching roomType Data from DB:::" + roomtypedata);
		return roomtypedata;
	}

	@GET
	@Path("/getRoomName")
	@Produces("application/json")
	public List<String> fetchRoomName() throws Exception {
		List<Rooms> rmName = RoomsLocalServiceUtil.getRoomses(-1, -1);
		LOGGER.info("getRoomName Count roomType Data from DB:::" + RoomsLocalServiceUtil.getRoomsesCount());
		boolean isAvaliable = rmName.stream().allMatch(Objects::isNull);
		if (isAvaliable)
			throw new Exception("Room Type Data Not avaliable in DB table kindly insert data::::");
		List<String> roomNamedata = rmName.stream().map(Rooms::getRoomName).collect(Collectors.toList());
		LOGGER.info("fetching roomType Data from DB:::" + roomNamedata);
		return roomNamedata;
	}

	@GET
	@Path("/getRoomAvalibilityByName")
	@Produces("application/json")
	public int fetchRoomAvalibility(@QueryParam("roomName") String roomName) throws Exception {
		LOGGER.info("roomName roomName roomName" + roomName);
		Rooms rmAvalibility = RoomsLocalServiceUtil.findByRoomName(roomName);
		if (rmAvalibility == null) {
			throw new Exception("Room Name Data Not avaliable in DB table kindly insert data::::");
		}
		int totalRoomAvalibility = rmAvalibility.getTotalRoomsAvailable();
		LOGGER.info("fetching roomType Data from DB:::" + totalRoomAvalibility);
		return totalRoomAvalibility;
	}

}