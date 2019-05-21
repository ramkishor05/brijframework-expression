package org.brijframework.expression.base;

import java.util.Collection;
import java.util.Map;

import org.brijframework.expression.meta.OperatorMeta;


public interface IOperator {
	
	@SuppressWarnings("rawtypes")
	public Object compute(Collection collection,OperatorMeta operatorSetups);
	
	@SuppressWarnings("rawtypes")
	public Object compute(Collection collection,OperatorMeta ...operatorSetups);
	
	@SuppressWarnings("rawtypes")
	public Object compute(Map collection,OperatorMeta operatorSetups);
	
	public Object compute(Object[] collection,OperatorMeta operatorSetups);
	
	public boolean state(Object... obj1);
}