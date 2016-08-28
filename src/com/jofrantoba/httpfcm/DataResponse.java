package com.jofrantoba.httpfcm;

import java.util.Collection;

public class DataResponse {
	private Long multicast_id;
	private Integer success;
	private Integer failure;
	private Integer canonical_ids;
	private Collection<Result> results;
	private String message_id;

	public Long getMulticast_id() {
		return multicast_id;
	}

	public void setMulticast_id(Long multicast_id) {
		this.multicast_id = multicast_id;
	}

	public Integer getSuccess() {
		return success;
	}

	public void setSuccess(Integer success) {
		this.success = success;
	}

	public Integer getFailure() {
		return failure;
	}

	public void setFailure(Integer failure) {
		this.failure = failure;
	}

	public Integer getCanonical_ids() {
		return canonical_ids;
	}

	public void setCanonical_ids(Integer canonical_ids) {
		this.canonical_ids = canonical_ids;
	}	
	
	public Collection<Result> getResults() {
		return results;
	}

	public void setResults(Collection<Result> results) {
		this.results = results;
	}

	public String getMessage_id() {
		return message_id;
	}

	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DataResponse [multicast_id=");
		builder.append(multicast_id);
		builder.append(", success=");
		builder.append(success);
		builder.append(", failure=");
		builder.append(failure);
		builder.append(", canonical_ids=");
		builder.append(canonical_ids);
		builder.append(", results=");
		builder.append(results);
		builder.append(", message_id=");
		builder.append(message_id);
		builder.append("]");
		return builder.toString();
	}
	
	
}
