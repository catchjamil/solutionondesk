package com.sd.web.enums;

public enum Roles {
	ADMIN {
		@Override
		public String toString() {
			return "Admin";
		}
	},
	CONTRIBUTOR {
		@Override
		public String toString() {
			return "Contributor";
		}
	},
	COLLABORATOR {
		@Override
		public String toString() {
			return "Collaborator";
		}
	},

	USER {
		@Override
		public String toString() {
			return "User";
		}
	}

}
