package org.brijframework.expression.constant;

public enum OperatorCatagaries {
	ArithmeticOperators("ArithmeticOperators"),
	AssignmentOperators("AssignmentOperators"),
	BitwiseOperators("BitwiseOperators"),
	LogicalOperators("LogicalOperators"),
	RelationalOperators("RelationalOperators"),
	MiscOperators("MiscOperators"), 
	SearchOperators("SearchOperators"),
	SpecialOperators("SpecialOperators");
	
	private final String id;

	private OperatorCatagaries(String id) {
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
