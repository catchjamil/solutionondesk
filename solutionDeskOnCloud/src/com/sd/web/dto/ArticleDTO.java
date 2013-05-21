package com.sd.web.dto;

public class ArticleDTO extends BaseDTO {
	private Long technologyId;
	private String description;

	public String getDescription() {
		return description;
	}

	public Long getTechnologyId() {
		return technologyId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTechnologyId(Long technologyId) {
		this.technologyId = technologyId;
	}
}
