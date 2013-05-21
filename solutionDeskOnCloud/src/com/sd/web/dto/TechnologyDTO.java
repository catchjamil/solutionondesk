package com.sd.web.dto;

import java.util.Set;

public class TechnologyDTO extends BaseDTO {
	private String techName;
	private String chapterName;
	private String topicName;
	private Set<ArticleDTO> articleDTO;
	private Set<ObjectiveQADTO> objectiveQADTO;
	private Set<SubjectiveQADTO> subjectiveQADTO;

	public String getChapterName() {
		return chapterName;
	}

	public Set<ObjectiveQADTO> getObjectiveQADTO() {
		return objectiveQADTO;
	}

	public Set<ArticleDTO> getSrticleDTO() {
		return articleDTO;
	}

	public Set<SubjectiveQADTO> getSubjectiveQADTO() {
		return subjectiveQADTO;
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

	public void setObjectiveQADTO(Set<ObjectiveQADTO> objectiveQADTO) {
		this.objectiveQADTO = objectiveQADTO;
	}

	public void setSrticleDTO(Set<ArticleDTO> articleDTO) {
		this.articleDTO = articleDTO;
	}

	public void setSubjectiveQADTO(Set<SubjectiveQADTO> subjectiveQADTO) {
		this.subjectiveQADTO = subjectiveQADTO;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

}
