
package com.demo.portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.demo.constants.DemoPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
@Component(property = { "javax.portlet.name=" + DemoPortletKeys.DEMO,
		"mvc.command.name=/" }, service = MVCRenderCommand.class)
public class AddRoom implements MVCRenderCommand {
	private static final Log logger = LogFactoryUtil.getLog(AddRoom.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		String pagea=renderRequest.getParameter("Room_Master_Room_MasterPortlet_INSTANCE_sxkm_page");
		String mvcRenderCommandName=(String) renderRequest.getAttribute("mvcRenderCommandName");
		//String mvcRenderCommandName=renderRequest.getParameter("mvcRenderCommandName");
		
		logger.info("inside AddRoom Render::::::::::::::"+pagea);
		logger.info("inside mvcRenderCommandNamepage11 Render::::::::::::::"+mvcRenderCommandName);
		return "/view.jsp";
	}


}
