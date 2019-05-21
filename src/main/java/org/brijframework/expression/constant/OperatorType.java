package org.brijframework.expression.constant;

public enum OperatorType {
	Unary("Unary"),
	Binary("Binary"),
	Ternary("Ternary");
	
	private final String id;

	private OperatorType(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return this.id;
	}

	public boolean isEqualTo(String id) {
		return id != null && this.toString().equals(id);
	}
}
