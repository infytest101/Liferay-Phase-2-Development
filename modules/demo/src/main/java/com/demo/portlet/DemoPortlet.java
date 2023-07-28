package com.demo.portlet;

import com.demo.constants.DemoPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import custom.services.model.Employee;
import custom.services.service.EmployeeLocalServiceUtil;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author nayana.m05
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Hotel",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Demo",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DemoPortletKeys.DEMO,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DemoPortlet extends MVCPortlet {
	
	private static final Log _LOG = LogFactoryUtil.getLog(DemoPortlet.class);
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		_LOG.info("inside diViewmethod.!");
		
		int employeesCount = EmployeeLocalServiceUtil.getEmployeesCount();
		
		_LOG.info("employeesCount :: " + employeesCount);
		
		long empId = CounterLocalServiceUtil.increment((Employee.class.getName()));
		Employee employee = EmployeeLocalServiceUtil.createEmployee(empId);
		employee.setUserName("abc");
		employee = EmployeeLocalServiceUtil.updateEmployee(employee);
		
		_LOG.info("exiting diViewmethod.!");
		// TODO Auto-generated method stub
		super.doView(renderRequest, renderResponse);
	}
	
}