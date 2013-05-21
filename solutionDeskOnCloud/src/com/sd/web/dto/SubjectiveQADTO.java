package com.sd.web.dto;

public class SubjectiveQADTO extends BaseDTO {

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
