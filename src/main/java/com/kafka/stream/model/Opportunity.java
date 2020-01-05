package com.kafka.stream.model;

public class Opportunity {
		
	private String opportunityId;
	private String page;
	private long cycleNumber;
		
	public String getOpportunityId() {
		return opportunityId;
	}
	public void setOpportunityId(String opportunityId) {
		this.opportunityId = opportunityId;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}

	
	public long getCycleNumber() {
		return cycleNumber;
	}
	public void setCycleNumber(long cycleNumber) {
		this.cycleNumber = cycleNumber;
	}
	@Override
	public String toString() {
		return "Opportunity [userId=" + opportunityId + ", page=" + page + ", duration=" + cycleNumber + "]";
	}

	
	
	

}
