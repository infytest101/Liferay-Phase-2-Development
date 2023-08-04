/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package ROOMSERVICES.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CustomerSoap implements Serializable {

	public static CustomerSoap toSoapModel(Customer model) {
		CustomerSoap soapModel = new CustomerSoap();

		soapModel.setCustomerId(model.getCustomerId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setMiddleName(model.getMiddleName());
		soapModel.setLastName(model.getLastName());
		soapModel.setEmail(model.getEmail());
		soapModel.setMobile(model.getMobile());
		soapModel.setAge(model.getAge());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static CustomerSoap[] toSoapModels(Customer[] models) {
		CustomerSoap[] soapModels = new CustomerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CustomerSoap[][] toSoapModels(Customer[][] models) {
		CustomerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CustomerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CustomerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CustomerSoap[] toSoapModels(List<Customer> models) {
		List<CustomerSoap> soapModels = new ArrayList<CustomerSoap>(
			models.size());

		for (Customer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CustomerSoap[soapModels.size()]);
	}

	public CustomerSoap() {
	}

	public int getPrimaryKey() {
		return _customerId;
	}

	public void setPrimaryKey(int pk) {
		setCustomerId(pk);
	}

	public int getCustomerId() {
		return _customerId;
	}

	public void setCustomerId(int customerId) {
		_customerId = customerId;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getMiddleName() {
		return _middleName;
	}

	public void setMiddleName(String middleName) {
		_middleName = middleName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getMobile() {
		return _mobile;
	}

	public void setMobile(String mobile) {
		_mobile = mobile;
	}

	public int getAge() {
		return _age;
	}

	public void setAge(int age) {
		_age = age;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private int _customerId;
	private String _firstName;
	private String _middleName;
	private String _lastName;
	private String _email;
	private String _mobile;
	private int _age;
	private String _description;

}