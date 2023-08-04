
package Room_Master.RenderCommand;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import Room_Master.constants.Room_MasterPortletKeys;
//import room.services.service.RoomTypeLocalServiceUtil;
@Component(property = { "javax.portlet.name=" + Room_MasterPortletKeys.ROOM_MASTER,
		"mvc.command.name=addRoom"}, service = MVCRenderCommand.class)
public class AddRoom implements MVCRenderCommand {
	private static final Log logger = LogFactoryUtil.getLog(AddRoom.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		String page = renderRequest.getParameter("mvcRenderCommandName");
		logger.info("inside AddRoom Render::::::::::::::"+page);
		//List<RoomType> rtype = RoomTypeLocalServiceUtil.getRoomTypes(-1, -1);
		//logger.info("getRoomTypesCount roomType Data from DB:::::"+RoomTypeLocalServiceUtil.getRoomTypesCount());
		if ("addRoom".equals(page)) {
			return "/bookHotel.jsp";
			
		} else if ("manageBooking".equals(page)) {
			logger.info("inside manageBooking Render::::::::::::::");	
		} else {
			logger.info("inside empty page Render::::::::::::::");	
		}
		return "/view.jsp";
	}
}
