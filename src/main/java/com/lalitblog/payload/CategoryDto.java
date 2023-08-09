package com.lalitblog.payload;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CategoryDto {

	private Integer categoryId;

	@NotEmpty
	private String categoryTitle;
	@NotEmpty
	private String cateforyDescription;
}
