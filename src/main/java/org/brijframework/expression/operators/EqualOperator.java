package org.brijframework.expression.operators;

import java.util.Collection;

import org.brijframework.expression.base.IOperator;
import org.brijframework.expression.constant.OperatorType;
import org.brijframework.expression.core.Operators;
import org.brijframework.expression.meta.OperatorMeta;
import org.brijframework.expression.util.OperatorUtil;
import org.brijframework.util.reflect.InstanceUtil;

public class EqualOperator extends Operators implements IOperator {
	@SuppressWarnings("rawtypes")
	
	@Override
	public Object compute(Collection _array, OperatorMeta setup) {
		if(setup.type.contentEquals(OperatorType.Unary.toString())){
			return equalsUnarySetup(_array, setup);
		}
		if(setup.type.contentEquals(OperatorType.Binary.toString())){
			return equalsBinarySetups(_array,  setup);
		}
		if(setup.type.contentEquals(OperatorType.Ternary.toString())){
			return equalsTernarySetup(_array,  setup);
		}
		return null;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object   equalsUnarySetup(Collection _array,OperatorMeta setup) {
		Object aobj[] = _array.toArray();
		Collection<Object> list=InstanceUtil.getInstance(_array.getClass());
		for (int i = 0; i < aobj.length; i++) {
			if(OperatorUtil.equalsObject(setup.param, this.operationValue(aobj[i], setup.key))){
				list.add(aobj[i]);
			}
		}
		return list;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object  equalsBinarySetups(Collection _array,OperatorMeta setup) {
		Object aobj[] = _array.toArray();
		Collection<Object> list= InstanceUtil.getInstance(_array.getClass());
		for (int i = 0; i < aobj.length; i++) {
			if(OperatorUtil.equalsObject(setup.param, this.operationValue(aobj[i], setup.key))){
				list.add(aobj[i]);
			}
		}
		return list;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object  equalsTernarySetup(Collection _array,OperatorMeta setup) {
		Object aobj[] = _array.toArray();
		Collection<Object> list=InstanceUtil.getInstance(_array.getClass());
		for (int i = 0; i < aobj.length; i++) {
			if(OperatorUtil.equalsObject(setup.param, this.operationValue(aobj[i], setup.key))){
				list.add(aobj[i]);
			}
		}
		return list;
	}
	
	@Override
	public boolean state(Object... objs) {
		return OperatorUtil.equalsObject(objs[0],objs[1]);
	}
}
