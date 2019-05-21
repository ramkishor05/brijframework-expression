package org.brijframework.expression.operators;

import java.util.Collection;

import org.brijframework.expression.base.IOperator;
import org.brijframework.expression.core.Operators;
import org.brijframework.expression.meta.OperatorMeta;

public class BetweenOperator extends Operators implements IOperator {

	@SuppressWarnings("rawtypes")
	@Override
	public Object compute(Collection collection, OperatorMeta operatorSetup) {
		return null;
	}

	@Override
	public boolean state(Object... obj1) {
		return false;
	}
}