package com.lalitblog.eceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

	String resouceName;
	String fieldName;
	Integer fieldValue;

	public ResourceNotFoundException(String resouceName, String fieldName, Integer userId) {
		super(String.format("%s not found with %s : %s ", resouceName, fieldName, userId));
		this.resouceName = resouceName;
		this.fieldName = fieldName;
		this.fieldValue = userId;
	}

}
