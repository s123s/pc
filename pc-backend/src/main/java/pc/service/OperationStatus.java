package pc.service;

import com.fasterxml.jackson.annotation.JsonView;

import pc.jackson.View;

public class OperationStatus {

	@JsonView(View.REST.class)
	Boolean successfully = false;

	@JsonView(View.REST.class)
	Object retObject;

	public OperationStatus() {
	}

	public OperationStatus(Boolean successfully) {
		this.successfully = successfully;
	}

	public OperationStatus(Boolean successfully, Object retObject) {
		this.successfully = successfully;
		this.retObject = retObject;
	}
}
