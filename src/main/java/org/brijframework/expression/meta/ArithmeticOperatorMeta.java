package org.brijframework.expression.meta;

import java.util.HashMap;
import java.util.Map;

import org.brijframework.expression.constant.OperatorsKeys;
import org.brijframework.util.reflect.InstanceUtil;
import org.brijframework.util.reflect.LogicUnit;

public class ArithmeticOperatorMeta extends OperatorMeta {
	public static ArithmeticOperatorMeta getSetup() {
		return (ArithmeticOperatorMeta) InstanceUtil.getInstance(ArithmeticOperatorMeta.class);
	}

	public void loadSetup(Map<String,Object> map) {
		LogicUnit.setAllField(this, map);
	}

	public boolean isOperators(String key) {
		if (this.getUnaryOperators().containsKey(key)) {
			return true;
		}
		if (this.getBinaryOperators().containsKey(key)) {
			return true;
		}
		if (this.getTernaryOperators().containsKey(key)) {
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
		Map<String, String> list = new HashMap<String, String>();
		list.put("++", "++");
		list.put("--", "--");
		list.put(OperatorsKeys.Increment.toString(), "++");
		list.put(OperatorsKeys.Decrement.toString(), "--");
		list.put(OperatorsKeys.Inc.toString(), "++");
		list.put(OperatorsKeys.Dec.toString(), "--");
		return list;
	}

	public Map<String, String> getBinaryOperators() {
		Map<String, String> list = new HashMap<String, String>();
		list.put("+", "+");
		list.put("-", "-");
		list.put("%", "%");
		list.put("*", "*");
		list.put("/", "/");
		list.put(OperatorsKeys.Plus.toString(), "+");
		list.put(OperatorsKeys.Minus.toString(), "-");
		list.put(OperatorsKeys.Multi.toString(), "*");
		list.put(OperatorsKeys.Ampersad.toString(), "%");
		list.put(OperatorsKeys.Division.toString(), "/");
		list.put(OperatorsKeys.Sum.toString(), "+");
		list.put(OperatorsKeys.Sub.toString(), "-");
		list.put(OperatorsKeys.Prod.toString(), "*");
		list.put(OperatorsKeys.Mod.toString(), "%");
		list.put(OperatorsKeys.Div.toString(), "/");
		return list;
	}

	public Map<String, String> getTernaryOperators() {
		Map<String, String> list = new HashMap<String, String>();
		return list;
	}

}
