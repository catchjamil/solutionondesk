package com.sd.web.model.bo;

public class ArticleBO extends BaseBO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4619342751720970821L;
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
