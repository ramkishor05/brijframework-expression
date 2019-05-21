package org.brijframework.expression.meta;

import java.util.HashMap;
import java.util.Map;

import org.brijframework.expression.constant.OperatorsKeys;
import org.brijframework.util.reflect.InstanceUtil;
import org.brijframework.util.reflect.LogicUnit;

public class SearchOperatorMeta extends OperatorMeta {

	public static SearchOperatorMeta getSetup() {
		return (SearchOperatorMeta) InstanceUtil.getInstance(SearchOperatorMeta.class);
	}

	public void loadSetup(Map<String, Object> map) {
		LogicUnit.setAllField(this, map);
	}

	public Map<String, String> getBinaryOperators() {
		Map<String, String> list = new HashMap<>();
		list.put(OperatorsKeys.EndsWith.toString(), OperatorsKeys.EndsWith.toString());
		list.put(OperatorsKeys.StartsWith.toString(), OperatorsKeys.StartsWith.toString());
		list.put(OperatorsKeys.ContantEquals.toString(), OperatorsKeys.ContantEquals.toString());
		list.put(OperatorsKeys.Contains.toString(), OperatorsKeys.Contains.toString());
		list.put(OperatorsKeys.EqualsIgnoreCase.toString(), OperatorsKeys.EqualsIgnoreCase.toString());

		list.put(OperatorsKeys.EndsWith.toString(), OperatorsKeys.EndsWith.toString());
		list.put(OperatorsKeys.StartsWith.toString(), OperatorsKeys.StartsWith.toString());
		list.put(OperatorsKeys.ContantEquals.toString(), OperatorsKeys.ContantEquals.toString());
		list.put(OperatorsKeys.Contains.toString(), OperatorsKeys.Contains.toString());
		list.put(OperatorsKeys.EqualsIgnoreCase.toString(), OperatorsKeys.EqualsIgnoreCase.toString());
		return list;
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

	public Map<String, String> getUnaryOperators() {
		Map<String, String> list = new HashMap<>();
		return list;
	}

	public Map<String, String> getTernaryOperators() {
		Map<String, String> list = new HashMap<>();
		return list;
	};
}
