package org.brijframework.expression.core;

import java.util.Collection;
import java.util.Stack;

import org.brijframework.expression.base.IExpression;
import org.brijframework.expression.base.IOperator;
import org.brijframework.expression.constant.OperatorsKeys;
import org.brijframework.expression.meta.OperatorMeta;
import org.brijframework.expression.util.ExpressionUtil;
import org.brijframework.model.builder.ModelBuilder;
import org.brijframework.util.reflect.InstanceUtil;
import org.brijframework.util.text.StringUtil;

public class Expressions implements IExpression {

	@Override
	public Object valueForObject(Object _object) {
		return null;
	}

	public static Object operationValue(Object obj, String _s) {
		return _s == null || _s.length() <= 0 ? obj : ModelBuilder.getBuilder(obj).getProperty(_s);
	}

	public static IOperator operatorForKey(String _key) {
		IOperator operator = Operators.operatorForKey(_key);
		return operator;
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	public static Object propertyWithOperator(Collection list, String query) {
		OperatorMeta[] operationSetups = ExpressionUtil.getOperationSetupArray(query);
		for (int i = 0; i < operationSetups.length; i++) {
			OperatorMeta setupsp =operationSetups[i];
			if (!StringUtil.containsEquals("" + setupsp.param, "null")) {
				return Expressions.operatorForKey(operationSetups[i].operator).compute(list, operationSetups[i]);
			}
			return Expressions.operatorForKey(operationSetups[i].operator).compute(list, setupsp);
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	public static Object propertyWithOperator(Collection list, String query, Object obj) {
		OperatorMeta[] operationSetups = ExpressionUtil.getOperationSetupArray(query);
		for (int i = 0; i < operationSetups.length; i++) {
			OperatorMeta setupsp = operationSetups[i];
			if (setupsp.param.toString().trim().contentEquals("@")) {
				setupsp.param = obj;
			}
			return Expressions.operatorForKey(operationSetups[i].operator).compute(list, setupsp);

		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	public static Collection propertyWithExpression(Collection list, String query, Object... objects) {
		Collection result = (Collection) InstanceUtil.getInstance(list.getClass());
		OperatorMeta[] operationSetups = ExpressionUtil.getOperationSetupArray(query);
		int i = 0;
		for (OperatorMeta setupsp : operationSetups) {
			if (setupsp.param.toString().trim().contentEquals("@")) {
				setupsp.param = objects[i++];
			}
		}
		Stack<OperatorMeta> stack = new Stack<>();
		ExpressionUtil.fill(stack, operationSetups);
		if (operationSetups.length == 1) {
			result = ExpressionUtil.singleResult(list, stack, operationSetups);
		}
		if (isComposite(query)) {
			result = ExpressionUtil.compositeResult(list, stack, operationSetups);
		}
		return result;
	}

	@SuppressWarnings("rawtypes")
	public static Collection propertyWithExpression(Collection list, String query) {
		Collection result = (Collection) InstanceUtil.getInstance(list.getClass());
		OperatorMeta[] operationSetups = ExpressionUtil.getOperationSetupArray(query);
		Stack<OperatorMeta> stack = new Stack<>();
		ExpressionUtil.fill(stack, operationSetups);
		if (operationSetups.length == 1) {
			result = ExpressionUtil.singleResult(list, stack, operationSetups);
		}
		if (isComposite(query)) {
			result = ExpressionUtil.compositeResult(list, stack, operationSetups);
		}
		return result;
	}

	public static boolean isComposite(String query) {
		if (query.toUpperCase().contains(OperatorsKeys.AND.toString()) || query.contains("&&")) {
			return true;
		}
		if (query.toUpperCase().contains(OperatorsKeys.OR.toString()) || query.contains("||")) {
			return true;
		}
		return false;
	}

	public static boolean isCombined(String query) {
		if (query.toUpperCase().contains("(") && query.contains(")")) {
			return true;
		}
		return false;
	}

}
