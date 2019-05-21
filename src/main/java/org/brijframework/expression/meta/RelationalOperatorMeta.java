package org.brijframework.expression.meta;

import java.util.HashMap;
import java.util.Map;

import org.brijframework.expression.constant.OperatorsKeys;
import org.brijframework.util.reflect.InstanceUtil;
import org.brijframework.util.reflect.LogicUnit;

public class RelationalOperatorMeta extends OperatorMeta {
	public static RelationalOperatorMeta getSetup() {
		return (RelationalOperatorMeta) InstanceUtil.getInstance(RelationalOperatorMeta.class);
	}

	public void loadSetup(Map<String, Object> map) {
		LogicUnit.setAllField(this, map);
	}

	public boolean isOperators(String key) {
		if (getUnaryOperators().containsKey(key)) {
			return true;
		}
		if (getBinaryOperators().containsKey(key)) {
			return true;
		}
		if (getTernaryOperators().containsKey(key)) {
			return true;
		}
		return false;
	}

	public String getOperators(String key) {
		if (getUnaryOperators().containsKey(key)) {
			return getUnaryOperators().get(key);
		}
		if (getBinaryOperators().containsKey(key)) {
			return getBinaryOperators().get(key);
		}
		if (getTernaryOperators().containsKey(key)) {
			return getTernaryOperators().get(key);
		}
		return "";
	}
	
	public Map<String, String> getUnaryOperators() {
		Map<String, String> list = new HashMap<>();
		return list;
	}

	public Map<String, String> getTernaryOperators() {
		Map<String, String> list = new HashMap<>();
		return list;
	};

	public Map<String, String> getBinaryOperators() {
		Map<String, String> list = new HashMap<>();
		list.put("==", "==");
		list.put("!=", "!=");
		list.put(">", ">");
		list.put("<", "<");
		list.put(">=", ">=");
		list.put("<=", "<=");

		list.put(OperatorsKeys.EqualsTo.toString(), "==");
		list.put(OperatorsKeys.NotEqualsTo.toString(), "!=");
		list.put(OperatorsKeys.LessThen.toString(), "<");
		list.put(OperatorsKeys.LessThenEqualsTo.toString(), "<=");
		list.put(OperatorsKeys.GreaterThen.toString(), ">");
		list.put(OperatorsKeys.GreaterThenEqualTo.toString(), ">=");

		return list;
	}

}
