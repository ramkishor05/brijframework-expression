package org.brijframework.expression.constant;

public enum OperatorsKeys {
	// Arithmetical Operator
	Plus("PLUS"),
	Minus("MINUS"), 
	Multi("MULTI"), 
	Division("DIVISION"), 
	Ampersad("AMPERSAD"),
	Increment("INCREMENT"),
	Decrement("DECREMENT"), 
	Sum("SUM"),
	Sub("SUB"),
	Div("DIV"),
	Prod("PROD"),
	Mod("MOD"),
	Inc("INC"),
	Dec("DEC"),
	
	// Bit Operator
	BitAND("BITAND"),
	BitOR("BITOR"),
	BitNOT("BITNOT"),
	BitXOR("BITXOR"),
	BitLeftShift("BITLEFTSHIFT"),
	BitRightShift("BITRIGHTSHIFT"),
	BitRightShiftZero("BITRIGHTSHIFTZERO"),
	BitLeftShiftZero("BITLEFTSHIFTZERO"),
	
	PlusEqualsTo("PLUSEQUALSTO"),
	ProdEqualsTo("PRODEQUALSTO"), 
	SubEqualsTo("SUBEQUALSTO"),
	DivEqualsTo("DIVEQUALSTO"),
	ModEqualsTo("MODEQUALSTO"), 
	LeftShiftEqualsTo("BITLEFTSHIFTEQUALSTO"),
	RightShiftEqualsTo("BITRIGHTSHIFTEQUALSTO"),
	BitANDEqualsTo("BITANDEQUALSTO"),
	BitOREqualsTo("BITOREQUALSTO"),
	BitNotEqualsTo("BITNOTEQUALSTO"),
	BitXOREqualsTo("BITXOREQUALSTO"),
	
	// Logical Operator
	AND("AND"),
	OR("OR"),
	NOT("NOT"),
	XOR("XOR"),
	
	// Relational Operator
	EqualsTo("EQUALSTO"),
	NotEqualsTo("NOTEQUALSTO"),
	LessThen("LESSTHEN"),
	LessThenEqualsTo("LESSTHENEQUALSTO"),
	GreaterThen("GREATERTHEN"), 
	GreaterThenEqualTo("GREATERTHENEQUALSTO"),
	
	
	// Search Operator
	EqualsIgnoreCase("EQUALSTOIGNORE"),
	Contains("CONTAINS"),
	ContantEquals("CONTANTEQUALS"),
	StartsWith("STARTSWITH"),
	EndsWith("ENDSWITH"),
	
	
	// Special Operator
	Count("COUNT"),
	Max("MAX"),
	Min("MIN"),
	Avg("AVG"), 
	OrderBy("ORDERBY"), 
	OrderByAsc("ORDERBY ASC"),
	OrderByDesc("ORDERBY DESC"),
	OrderByIgnoreCaseDesc("ORDERBY DESC#"),
	OrderByIgnoreCaseAsc("ORDERBY ASC$"),
	
	OrderByINC("ORDERBY +"),
	OrderByDEC("ORDERBY -"),
	OrderByIgnoreCaseINC("ORDERBY +#"),
	OrderByIgnoreCaseDEC("ORDERBY -$"),
	
	GroupBy("GROUPBY"),
	Group("GROUP"),
	Merge("MERGE"),
	Compare("COMPARE"),
    
    // HQL
	ILike("ILIKE"),
	Like("LIKE"),
	EqualsToOrNull("EQUALSTOORNULL"),
	In("IN");
	
	private final String id;

	private OperatorsKeys(String id) {
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
