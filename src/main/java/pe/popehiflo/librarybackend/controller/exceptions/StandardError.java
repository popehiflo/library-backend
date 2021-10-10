package pe.popehiflo.librarybackend.controller.exceptions;

public class StandardError {
	
	/*
	 * Momento en que ocurre la exception
	 */
	private Long timestamp;
	/*
	 * HTTP status 401, 404
	 */
	private Integer status;
	/*
	 * mensaje error
	 */
	private String error;
	
	public StandardError() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StandardError(Long timestamp, Integer status, String error) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
}
