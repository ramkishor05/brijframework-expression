package org.brijframework.expression.meta;

import java.util.HashMap;
import java.util.Map;

import org.brijframework.expression.constant.OperatorsKeys;
import org.brijframework.util.reflect.InstanceUtil;
import org.brijframework.util.reflect.LogicUnit;

public class AssignmentOperatorMeta extends OperatorMeta {
	public static  AssignmentOperatorMeta getSetup() {
		return (AssignmentOperatorMeta) InstanceUtil.getInstance(AssignmentOperatorMeta.class);
	}
	public void loadSetup(Map<String,Object> map) {
		LogicUnit.setAllField(this, map);
	}
	
	public Map<String, String> getUnaryOperators() {
		Map<String, String> list = new HashMap<String, String>();
		list.put("+=", "+=");
		list.put("*=", "*=");
		list.put("-=", "-=");
		list.put("/=", "/=");
		list.put("%=", "%=");
		list.put("<<=", "<<=");
		list.put(">>=", ">>=");
		list.put("~=", "~=");
		list.put("&=", "&=");
		list.put("^=", "^=");
		list.put("|=", "|=");
		list.put(OperatorsKeys.PlusEqualsTo.toString(), "+=");
		list.put(OperatorsKeys.BitNotEqualsTo.toString(), "~=");
		list.put(OperatorsKeys.ProdEqualsTo.toString(), "*=");
		list.put(OperatorsKeys.SubEqualsTo.toString(), "-=");
		list.put(OperatorsKeys.DivEqualsTo.toString(), "/=");
		list.put(OperatorsKeys.ModEqualsTo.toString(), "%=");
		list.put(OperatorsKeys.LeftShiftEqualsTo.toString(), "<<=");
		list.put(OperatorsKeys.RightShiftEqualsTo.toString(), ">>=");
		list.put(OperatorsKeys.BitANDEqualsTo.toString(), "&=");
		list.put(OperatorsKeys.BitXOREqualsTo.toString(), "^=");
		list.put(OperatorsKeys.BitOREqualsTo.toString(), "|=");
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
	public Map<String, String> getBinaryOperators() {
		Map<String, String> list = new HashMap<String, String>();
		return list;
	}
	public Map<String, String> getTernaryOperators() {
		Map<String, String> list = new HashMap<String, String>();
		return list;
	};
}
