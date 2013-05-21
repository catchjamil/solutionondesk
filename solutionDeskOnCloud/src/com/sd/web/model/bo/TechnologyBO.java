package com.sd.web.model.bo;


public class TechnologyBO extends BaseBO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -843893194693947887L;
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
