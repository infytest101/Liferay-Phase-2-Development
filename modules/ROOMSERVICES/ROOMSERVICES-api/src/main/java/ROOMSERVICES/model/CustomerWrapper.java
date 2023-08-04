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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Customer}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Customer
 * @generated
 */
public class CustomerWrapper
	extends BaseModelWrapper<Customer>
	implements Customer, ModelWrapper<Customer> {

	public CustomerWrapper(Customer customer) {
		super(customer);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("customerId", getCustomerId());
		attributes.put("firstName", getFirstName());
		attributes.put("middleName", getMiddleName());
		attributes.put("lastName", getLastName());
		attributes.put("email", getEmail());
		attributes.put("mobile", getMobile());
		attributes.put("age", getAge());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer customerId = (Integer)attributes.get("customerId");

		if (customerId != null) {
			setCustomerId(customerId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String middleName = (String)attributes.get("middleName");

		if (middleName != null) {
			setMiddleName(middleName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String mobile = (String)attributes.get("mobile");

		if (mobile != null) {
			setMobile(mobile);
		}

		Integer age = (Integer)attributes.get("age");

		if (age != null) {
			setAge(age);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	 * Returns the age of this customer.
	 *
	 * @return the age of this customer
	 */
	@Override
	public int getAge() {
		return model.getAge();
	}

	/**
	 * Returns the customer ID of this customer.
	 *
	 * @return the customer ID of this customer
	 */
	@Override
	public int getCustomerId() {
		return model.getCustomerId();
	}

	/**
	 * Returns the description of this customer.
	 *
	 * @return the description of this customer
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the email of this customer.
	 *
	 * @return the email of this customer
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the first name of this customer.
	 *
	 * @return the first name of this customer
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the last name of this customer.
	 *
	 * @return the last name of this customer
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the middle name of this customer.
	 *
	 * @return the middle name of this customer
	 */
	@Override
	public String getMiddleName() {
		return model.getMiddleName();
	}

	/**
	 * Returns the mobile of this customer.
	 *
	 * @return the mobile of this customer
	 */
	@Override
	public String getMobile() {
		return model.getMobile();
	}

	/**
	 * Returns the primary key of this customer.
	 *
	 * @return the primary key of this customer
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the age of this customer.
	 *
	 * @param age the age of this customer
	 */
	@Override
	public void setAge(int age) {
		model.setAge(age);
	}

	/**
	 * Sets the customer ID of this customer.
	 *
	 * @param customerId the customer ID of this customer
	 */
	@Override
	public void setCustomerId(int customerId) {
		model.setCustomerId(customerId);
	}

	/**
	 * Sets the description of this customer.
	 *
	 * @param description the description of this customer
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the email of this customer.
	 *
	 * @param email the email of this customer
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the first name of this customer.
	 *
	 * @param firstName the first name of this customer
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the last name of this customer.
	 *
	 * @param lastName the last name of this customer
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets the middle name of this customer.
	 *
	 * @param middleName the middle name of this customer
	 */
	@Override
	public void setMiddleName(String middleName) {
		model.setMiddleName(middleName);
	}

	/**
	 * Sets the mobile of this customer.
	 *
	 * @param mobile the mobile of this customer
	 */
	@Override
	public void setMobile(String mobile) {
		model.setMobile(mobile);
	}

	/**
	 * Sets the primary key of this customer.
	 *
	 * @param primaryKey the primary key of this customer
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected CustomerWrapper wrap(Customer customer) {
		return new CustomerWrapper(customer);
	}

}