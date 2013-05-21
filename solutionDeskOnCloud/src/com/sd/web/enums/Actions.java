package com.sd.web.enums;

public enum Actions {
	DELETED {
		@Override
		public String toString() {
			return "Deleted";
		}
	},
	UPDATED {
		@Override
		public String toString() {
			return "Updated";
		}
	},
	CREATED {
		@Override
		public String toString() {
			return "Created";
		}
	}
}
