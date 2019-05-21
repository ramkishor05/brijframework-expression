package org.brijframework.expression.operators;

import java.util.Collection;

import org.brijframework.expression.base.IOperator;
import org.brijframework.expression.core.Operators;
import org.brijframework.expression.meta.OperatorMeta;
import org.brijframework.util.reflect.InstanceUtil;

public class ANDOperator   extends Operators implements IOperator {
	public static ANDOperator getOperator() {
		return (ANDOperator) InstanceUtil.getInstance(ANDOperator.class);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object compute(Collection _arrays, OperatorMeta ...operatorSetup) {
		return null;
	}

	@Override
	public boolean state(Object... obj1) {
		return false;
	}
	
}
