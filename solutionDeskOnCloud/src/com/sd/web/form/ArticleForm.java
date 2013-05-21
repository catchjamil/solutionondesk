package com.sd.web.form;

public class ArticleForm extends SubjectiveQAForm {
	private String description;
	private String articleType;
	private String technologyId;

	public String getArticleType() {
		return articleType;
	}

	public String getDescription() {
		return description;
	}

	public String getTechnologyId() {
		return technologyId;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTechnologyId(String technologyId) {
		this.technologyId = technologyId;
	}

}
