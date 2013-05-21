package com.sd.web.model.bo;

public class ObjectiveQABO extends BaseBO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5732786573406715628L;
	private Long technologyId;
	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String answer;

	public String getAnswer() {
		return answer;
	}

	public String getOption1() {
		return option1;
	}

	public String getOption2() {
		return option2;
	}

	public String getOption3() {
		return option3;
	}

	public String getOption4() {
		return option4;
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

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setTechnologyId(Long technologyId) {
		this.technologyId = technologyId;
	}

}
