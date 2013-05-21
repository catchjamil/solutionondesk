package com.sd.web.model.bo;

public class SubjectiveQABO extends BaseBO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6491186480194984974L;
	private Long technologyId;
	private String question;
	private String answer;

	public String getAnswer() {
		return answer;
	}

	public String getQuestion() {
		return question;
	}

	public Long getTechnologyId() {
		return technologyId;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setTechnologyId(Long technologyId) {
		this.technologyId = technologyId;
	}

}
