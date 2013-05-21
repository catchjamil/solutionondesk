package com.sd.web.enums;

public enum ArticleType {
	ARTICLE {
		@Override
		public String toString() {
			return "Article";
		}
	},
	SUBJECTIVEQA {
		@Override
		public String toString() {
			return "SubjectiveQA";
		}
	},
	OBJECTIVEQA {
		@Override
		public String toString() {
			return "ObjectiveAQ";
		}
	}
}
