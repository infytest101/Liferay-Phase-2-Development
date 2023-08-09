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

package ROOMSERVICES.model.impl;

import ROOMSERVICES.model.Customer;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Customer in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CustomerCacheModel
	implements CacheModel<Customer>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CustomerCacheModel)) {
			return false;
		}

		CustomerCacheModel customerCacheModel = (CustomerCacheModel)object;

		if (customerId == customerCacheModel.customerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, customerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{customerId=");
		sb.append(customerId);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", middleName=");
		sb.append(middleName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", email=");
		sb.append(email);
		sb.append(", mobile=");
		sb.append(mobile);
		sb.append(", age=");
		sb.append(age);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Customer toEntityModel() {
		CustomerImpl customerImpl = new CustomerImpl();

		customerImpl.setCustomerId(customerId);

		if (firstName == null) {
			customerImpl.setFirstName("");
		}
		else {
			customerImpl.setFirstName(firstName);
		}

		if (middleName == null) {
			customerImpl.setMiddleName("");
		}
		else {
			customerImpl.setMiddleName(middleName);
		}

		if (lastName == null) {
			customerImpl.setLastName("");
		}
		else {
			customerImpl.setLastName(lastName);
		}

		if (email == null) {
			customerImpl.setEmail("");
		}
		else {
			customerImpl.setEmail(email);
		}

		if (mobile == null) {
			customerImpl.setMobile("");
		}
		else {
			customerImpl.setMobile(mobile);
		}

		customerImpl.setAge(age);

		if (description == null) {
			customerImpl.setDescription("");
		}
		else {
			customerImpl.setDescription(description);
		}

		customerImpl.resetOriginalValues();

		return customerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		customerId = objectInput.readLong();
		firstName = objectInput.readUTF();
		middleName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		email = objectInput.readUTF();
		mobile = objectInput.readUTF();

		age = objectInput.readInt();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(customerId);

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (middleName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(middleName);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (mobile == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobile);
		}

		objectOutput.writeInt(age);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long customerId;
	public String firstName;
	public String middleName;
	public String lastName;
	public String email;
	public String mobile;
	public int age;
	public String description;

}