package com.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Topic implements Comparable<Topic>, Serializable{

	private String topicId;
	private String topicName;
	private LocalDateTime topicStartTime;
	private LocalDateTime topicEndTime;
	private String subjectId;
	private String chapterId;
	private String importance;
	private String status;
	private int flag;

	
	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public int getFlag() {
		return flag;
	}



	public void setFlag(int flag) {
		this.flag = flag;
	}



	public String getTopicId() {
		return topicId;
	}



	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}



	public String getTopicName() {
		return topicName;
	}



	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}



	public LocalDateTime getTopicStartTime() {
		return topicStartTime;
	}



	public void setTopicStartTime(LocalDateTime topicStartTime) {
		this.topicStartTime = topicStartTime;
	}



	public LocalDateTime getTopicEndTime() {
		return topicEndTime;
	}



	public void setTopicEndTime(LocalDateTime topicEndTime) {
		this.topicEndTime = topicEndTime;
	}



	public String getSubjectId() {
		return subjectId;
	}



	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}



	public String getChapterId() {
		return chapterId;
	}



	public void setChapterId(String chapterId) {
		this.chapterId = chapterId;
	}



	public String getImportance() {
		return importance;
	}



	public void setImportance(String importance) {
		this.importance = importance;
	}



	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", topicName=" + topicName + ", topicStartTime=" + topicStartTime
				+ ", topicEndTime=" + topicEndTime + ", subjectId=" + subjectId + ", chapterId=" + chapterId
				+ ", importance=" + importance + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	@Override
	public int compareTo(Topic object) {

		Integer thisIntID = Integer.parseInt(this.topicId);
		Integer objectIntID = Integer.parseInt(object.topicId);
		
		// TODO arrange the topics according to topic_id
		return (thisIntID > objectIntID ? 1 :
			(thisIntID < objectIntID ? -1 :0));
	}
	
	
}
