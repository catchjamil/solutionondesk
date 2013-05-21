package com.sd.web.form;

public class TechnologyForm extends BaseForm {
	private String techName;
	private String chapterName;
	private String topicName;

	public String getChapterName() {
		return chapterName;
	}

	public String getTechName() {
		return techName;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

}
