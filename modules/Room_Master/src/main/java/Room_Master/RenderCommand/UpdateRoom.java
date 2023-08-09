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
		"mvc.command.name=back",
		"mvc.command.name=costumerBookRoomURL"}, service = MVCRenderCommand.class)
public class UpdateRoom implements MVCRenderCommand {
	private static final Log logger = LogFactoryUtil.getLog(AddRoom.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		//String page = renderRequest.getParameter("mvcRenderCommandName");
		String page = renderRequest.getParameter("page");
		logger.info("inside AddRoom Render::::::::::::::"+page);
		//logger.info("inside AddRoom Render::::::::::::::"+page1);
		//List<RoomType> rtype = RoomTypeLocalServiceUtil.getRoomTypes(-1, -1);
		//logger.info("getRoomTypesCount roomType Data from DB:::::"+RoomTypeLocalServiceUtil.getRoomTypesCount());
		 if ("costumerBookRoomURL".equals(page)) {
			 return "/CostumerBookRoom.jsp";	
		} else if ("back".equals(page)) {
			return "/view.jsp";	
		}
		return "/view.jsp";	
	}
}

