package org.brijframework.expression.meta;

import org.brijframework.expression.constant.OperatorCatagaries;
import org.brijframework.expression.constant.OperatorType;
import org.brijframework.util.reflect.InstanceUtil;
import org.brijframework.util.text.StringUtil;
import org.brijframework.util.validator.ValidationUtil;

public class OperatorMeta {
	public Integer position;
	public Object result;
	public String expression;
	public String operator;
	public String query;
	public String catagaries;
	public String type;
	public String key;
	public Object param;
	

	public static OperatorMeta getSetup() {
		return (OperatorMeta) InstanceUtil.getInstance(OperatorMeta.class);
	}

	public void referOperator() {
		if (ArithmeticOperatorMeta.getSetup().isOperators(operator)) {
			if (ArithmeticOperatorMeta.getSetup().getUnaryOperators().containsKey(operator)) {
				catagaries = OperatorCatagaries.ArithmeticOperators.toString();
				type = OperatorType.Unary.toString();
			}
			if (ArithmeticOperatorMeta.getSetup().getBinaryOperators().containsKey(operator)) {
				catagaries = OperatorCatagaries.ArithmeticOperators.toString();
				type = OperatorType.Binary.toString();
			}
			if (ArithmeticOperatorMeta.getSetup().getTernaryOperators().containsKey(operator)) {
				catagaries = OperatorCatagaries.ArithmeticOperators.toString();
				type = OperatorType.Ternary.toString();
			}
		}
		if (RelationalOperatorMeta.getSetup().isOperators(operator)) {
			if (RelationalOperatorMeta.getSetup().getUnaryOperators().containsKey(operator)) {
				catagaries = OperatorCatagaries.RelationalOperators.toString();
				type = OperatorType.Unary.toString();
			}
			if (RelationalOperatorMeta.getSetup().getBinaryOperators().containsKey(operator)) {
				catagaries = OperatorCatagaries.RelationalOperators.toString();
				type = OperatorType.Binary.toString();
			}
			if (RelationalOperatorMeta.getSetup().getTernaryOperators().containsKey(operator)) {
				catagaries = OperatorCatagaries.RelationalOperators.toString();
				type = OperatorType.Ternary.toString();
			}
		}
		if (AssignmentOperatorMeta.getSetup().isOperators(operator)) {
			if (AssignmentOperatorMeta.getSetup().getUnaryOperators().containsKey(operator)) {
				catagaries = OperatorCatagaries.AssignmentOperators.toString();
				type = OperatorType.Unary.toString();
			}
			if (AssignmentOperatorMeta.getSetup().getBinaryOperators().containsKey(operator)) {
				catagaries = OperatorCatagaries.AssignmentOperators.toString();
				type = OperatorType.Binary.toString();
			}
			if (AssignmentOperatorMeta.getSetup().getTernaryOperators().containsKey(operator)) {
				catagaries = OperatorCatagaries.AssignmentOperators.toString();
				type = OperatorType.Ternary.toString();
			}
		}
		if (LogicalOperatorMata.getSetup().isOperators(operator)) {
			if (LogicalOperatorMata.getSetup().getUnaryOperators().containsKey(operator)) {
				catagaries = OperatorCatagaries.LogicalOperators.toString();
				type = OperatorType.Unary.toString();
			}
			if (LogicalOperatorMata.getSetup().getBinaryOperators().containsKey(operator)) {
				catagaries = OperatorCatagaries.LogicalOperators.toString();
				type = OperatorType.Binary.toString();
			}
			if (LogicalOperatorMata.getSetup().getTernaryOperators().containsKey(operator)) {
				catagaries = OperatorCatagaries.LogicalOperators.toString();
				type = OperatorType.Ternary.toString();
			}
		}
		if (BitwiseOperatorMeta.getSetup().isOperators(operator)) {
			if (BitwiseOperatorMeta.getSetup().getUnaryOperators().containsKey(operator)) {
				catagaries = OperatorCatagaries.BitwiseOperators.toString();
				type = OperatorType.Unary.toString();
			}
			if (BitwiseOperatorMeta.getSetup().getBinaryOperators().containsKey(operator)) {
				catagaries = OperatorCatagaries.BitwiseOperators.toString();
				type = OperatorType.Binary.toString();
			}
			if (BitwiseOperatorMeta.getSetup().getTernaryOperators().containsKey(operator)) {
				catagaries = OperatorCatagaries.BitwiseOperators.toString();
				type = OperatorType.Ternary.toString();
			}
		}
		if (SearchOperatorMeta.getSetup().isOperators(operator)) {
			if (SearchOperatorMeta.getSetup().getUnaryOperators().containsKey(operator)) {
				catagaries = OperatorCatagaries.SearchOperators.toString();
				type = OperatorType.Unary.toString();
			}
			if (SearchOperatorMeta.getSetup().getBinaryOperators().containsKey(operator)) {
				catagaries = OperatorCatagaries.SearchOperators.toString();
				type = OperatorType.Binary.toString();
			}
			if (SearchOperatorMeta.getSetup().getTernaryOperators().containsKey(operator)) {
				catagaries = OperatorCatagaries.SearchOperators.toString();
				type = OperatorType.Ternary.toString();
			}
		}
		if (SpecialOperatorMeta.getSetup().isOperators(operator)) {
			if (SpecialOperatorMeta.getSetup().getUnaryOperators().containsKey(operator)) {
				catagaries = OperatorCatagaries.SpecialOperators.toString();
				type = OperatorType.Unary.toString();
			}
			if (SpecialOperatorMeta.getSetup().getBinaryOperators().containsKey(operator)) {
				catagaries = OperatorCatagaries.SpecialOperators.toString();
				type = OperatorType.Binary.toString();
			}
			if (SpecialOperatorMeta.getSetup().getTernaryOperators().containsKey(operator)) {
				catagaries = OperatorCatagaries.SpecialOperators.toString();
				type = OperatorType.Ternary.toString();
			}
		}
	}

	public static String key(int start, String query) {
		boolean read = false;
		String returnStr = "";
		for (int i = start; i >= 0; i--) {
			if (ValidationUtil.isAlphabet(query.charAt(i)) || ValidationUtil.isNumber(query.charAt(i))) {
				read = true;
			}
			if (read) {
				if (query.charAt(i) == ' ') {
					break;
				} else {
					returnStr += query.charAt(i) + "";
				}

			}
		}
		return StringUtil.reverseText(returnStr);
	}

	public static String param(int start, String query) {
		boolean read = false;
		String returnStr = "";
		for (int i = start + 1; i < query.length(); i++) {
			if (ValidationUtil.isAlphabet(query.charAt(i)) || ValidationUtil.isNumber(query.charAt(i))) {
				read = true;
			}
			if (read) {
				if (query.charAt(i) == ' ') {
					break;
				} else {
					returnStr += query.charAt(i) + "";
				}

			}
		}
		return returnStr;
	}

	public void initOperator(int keyIndex, int valIndex, String query) {
		if (keyIndex - 1 > 0)
			this.key = key(keyIndex - 1, query);
		if (valIndex < query.length())
			this.param = param(valIndex, query);
		if (keyIndex > 0 && keyIndex < query.length()) {
			this.expression = "";
			if (key != null)
				this.expression += this.key.trim();
			this.expression += " " + operator.trim();
			if (this.param != null)
				this.expression += " " + this.param;
		}
		referOperator();
	}

}
