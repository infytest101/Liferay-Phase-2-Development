package Room_Master.portlet;
import java.io.IOException;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import ROOMSERVICES.service.RoomTypeLocalServiceUtil;
import Room_Master.constants.Room_MasterPortletKeys;

/**
 * @author biswajit.nayak01
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Room_Master", "javax.portlet.init-param.template-path=/",
		/* "javax.portlet.init-param.view-template=/view.jsp", */
		"javax.portlet.name=" + Room_MasterPortletKeys.ROOM_MASTER, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class Room_MasterPortlet extends MVCPortlet {
	private static final Log logger = LogFactoryUtil.getLog(Room_MasterPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		String page = renderRequest.getParameter("page");
		logger.info("getRoomTypesCount"+RoomTypeLocalServiceUtil.getRoomTypesCount());
		if ("manageRoom".equals(page)) {
			include("/META-INF/resources/manageRoom.jsp", renderRequest, renderResponse);
		} else if ("manageBooking".equals(page)) {
			include("/META-INF/resources/manageBooking.jsp", renderRequest, renderResponse);
		} else {
			include("/META-INF/resources/view.jsp", renderRequest, renderResponse);
		}
		/* super.doView(renderRequest, renderResponse); */
	}
}