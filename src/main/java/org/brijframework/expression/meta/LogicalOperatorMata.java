package org.brijframework.expression.meta;

import java.util.HashMap;
import java.util.Map;

import org.brijframework.expression.constant.OperatorsKeys;
import org.brijframework.util.reflect.InstanceUtil;
import org.brijframework.util.reflect.LogicUnit;

public class LogicalOperatorMata extends OperatorMeta {
	public OperatorMeta[] operatorSetups;

	public static LogicalOperatorMata getSetup() {
		return (LogicalOperatorMata) InstanceUtil.getInstance(LogicalOperatorMata.class);
	}

	public void loadSetup(Map<String, Object> map) {
		LogicUnit.setAllField(this, map);
	}

	public Map<String, String> getUnaryOperators() {
		Map<String, String> list = new HashMap<String, String>();
		list.put("!", "!");
		list.put(OperatorsKeys.NOT.toString(), "!");
		return list;
	}

	public Map<String, String> getBinaryOperators() {
		Map<String, String> list = new HashMap<>();
		list.put("&&", "&&");
		list.put("||", "||");
		list.put(OperatorsKeys.AND.toString(), "&&");
		list.put(OperatorsKeys.OR.toString(), "||");
		return list;
	}

	public Map<String, String> getTernaryOperators() {
		Map<String, String> list = new HashMap<String, String>();
		return list;
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
}
