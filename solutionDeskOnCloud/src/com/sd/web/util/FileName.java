package com.sd.web.util;

public class FileName {
	private static String entityId;
	private static String createdBy;
	private static Long createdOn;
	private static Long randomNumber;
	private static Integer sequence;

	public static String getCreatedBy() {
		return createdBy;
	}

	public static Long getCreatedOn() {
		return System.currentTimeMillis();
	}

	public static String getEntityId() {
		return entityId;
	}

	public static String getFileName(String... strings) {
		return getSequence() + "_" + strings[0] + "_" + getCreatedOn() + "_" + getRandomNumber() + ".html";

	}

	public static Long getRandomNumber() {
		return Math.round(Math.random() * 100000);
	}

	public static Integer getSequence() {
		return sequence;
	}

	public static void setCreatedBy(String createdBy) {
		FileName.createdBy = createdBy;
	}

	public static void setCreatedOn(Long createdOn) {
		FileName.createdOn = createdOn;
	}

	public static void setEntityId(String entityId) {
		FileName.entityId = entityId;
	}

	public static void setRandomNumber(Long randomNumber) {
		FileName.randomNumber = randomNumber;
	}

	public static void setSequence(Integer fileSequence) {
		FileName.sequence = fileSequence;
	}

	FileName(String fileName) {
		String[] fileData = fileName.split("_");
		this.setEntityId(fileData[0]);
		this.setCreatedBy(fileData[1]);
		this.setCreatedOn(Long.parseLong(fileData[2]));
	}

}
