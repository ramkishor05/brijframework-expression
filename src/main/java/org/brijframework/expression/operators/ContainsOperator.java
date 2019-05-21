package org.brijframework.expression.operators;

import java.util.Collection;
import java.util.Map;

import org.brijframework.expression.base.IOperator;
import org.brijframework.expression.core.Operators;
import org.brijframework.expression.meta.OperatorMeta;

public class ContainsOperator extends Operators implements IOperator {

	@SuppressWarnings("rawtypes")
	@Override
	public Object compute(Collection collection, OperatorMeta operatorSetups) {
		
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object compute(Collection collection, OperatorMeta... operatorSetups) {
		
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object compute(Map collection, OperatorMeta operatorSetups) {
		
		return null;
	}

	@Override
	public Object compute(Object[] collection, OperatorMeta operatorSetups) {
		
		return null;
	}

	@Override
	public boolean state(Object... obj1) {
		
		return false;
	}

}
