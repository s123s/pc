package pc.service;

import com.fasterxml.jackson.annotation.JsonView;

import pc.jackson.View;

public class OperationStatus {

    @JsonView(View.REST.class)
	Boolean successfully = false;

	public OperationStatus() {}

	public OperationStatus(Boolean successfully) {
		this.successfully = successfully;
	}

}
