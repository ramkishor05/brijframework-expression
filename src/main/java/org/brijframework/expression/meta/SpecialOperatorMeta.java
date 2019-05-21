package org.brijframework.expression.meta;

import java.util.HashMap;
import java.util.Map;

import org.brijframework.expression.constant.OperatorsKeys;
import org.brijframework.util.reflect.InstanceUtil;
import org.brijframework.util.reflect.LogicUnit;

public class SpecialOperatorMeta extends OperatorMeta {

	public static SpecialOperatorMeta getSetup() {
		return (SpecialOperatorMeta) InstanceUtil.getInstance(SpecialOperatorMeta.class);
	}

	public void loadSetup(Map<String, Object> map) {
		LogicUnit.setAllField(this, map);
	}

	public Map<String, String> getBinaryOperators() {
		Map<String, String> list = new HashMap<>();
		list.put(OperatorsKeys.Count.toString(), OperatorsKeys.Count.toString());
		list.put(OperatorsKeys.Max.toString(), OperatorsKeys.Max.toString());
		list.put(OperatorsKeys.Min.toString(), OperatorsKeys.Min.toString());
		list.put(OperatorsKeys.Avg.toString(), OperatorsKeys.Avg.toString());
		list.put(OperatorsKeys.OrderBy.toString(), OperatorsKeys.OrderBy.toString());
		list.put(OperatorsKeys.OrderByAsc.toString(), OperatorsKeys.OrderByAsc.toString());
		list.put(OperatorsKeys.OrderByDesc.toString(), OperatorsKeys.OrderByDesc.toString());
		list.put(OperatorsKeys.OrderByDEC.toString(), OperatorsKeys.OrderByDEC.toString());
		list.put(OperatorsKeys.OrderByINC.toString(), OperatorsKeys.OrderByINC.toString());
		list.put(OperatorsKeys.OrderByIgnoreCaseINC.toString(), OperatorsKeys.OrderByIgnoreCaseINC.toString());
		list.put(OperatorsKeys.OrderByIgnoreCaseDEC.toString(), OperatorsKeys.OrderByIgnoreCaseDEC.toString());
		list.put(OperatorsKeys.OrderByIgnoreCaseAsc.toString(), OperatorsKeys.OrderByIgnoreCaseAsc.toString());
		list.put(OperatorsKeys.OrderByIgnoreCaseDesc.toString(), OperatorsKeys.OrderByIgnoreCaseDesc.toString());
		list.put(OperatorsKeys.GroupBy.toString(), OperatorsKeys.GroupBy.toString());
		list.put(OperatorsKeys.Group.toString(), OperatorsKeys.Group.toString());
		return list;
	}

	public Map<String, String> getUnaryOperators() {
		Map<String, String> list = new HashMap<>();
		return list;
	}

	public Map<String, String> getTernaryOperators() {
		Map<String, String> list = new HashMap<>();
		return list;
	};

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
