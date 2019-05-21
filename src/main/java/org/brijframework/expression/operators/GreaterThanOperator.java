package org.brijframework.expression.operators;

import java.util.Collection;

import org.brijframework.expression.base.IOperator;
import org.brijframework.expression.constant.OperatorType;
import org.brijframework.expression.core.Operators;
import org.brijframework.expression.meta.OperatorMeta;
import org.brijframework.expression.util.OperatorUtil;
import org.brijframework.util.reflect.InstanceUtil;

public class GreaterThanOperator  extends Operators implements IOperator {
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object compute(Collection _array, OperatorMeta setup) {
		if(setup.type.contentEquals(OperatorType.Unary.toString())){
			return resultUnarySetup(_array,  setup);
		}
		if(setup.type.contentEquals(OperatorType.Binary.toString())){
			return resultBinarySetups(_array, setup);
		}
		if(setup.type.contentEquals(OperatorType.Ternary.toString())){
			return resultTernarySetup(_array, setup);
		}
		return null;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object   resultUnarySetup(Collection _array,OperatorMeta setup) {
		Object aobj[] = ((Collection)_array).toArray();
		Collection list=InstanceUtil.getInstance(_array.getClass());
		for (int i = 0; i < aobj.length; i++) {
			if(OperatorUtil.greaterThan(this.operationValue(aobj[i], setup.key), setup.param)){
				list.add(aobj[i]);
			}
		}
		return list;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object  resultBinarySetups(Collection _array,OperatorMeta setup) {
		Object aobj[] = ((Collection)_array).toArray();
		Collection<Object> list=InstanceUtil.getInstance(_array.getClass());
		for (int i = 0; i < aobj.length; i++) {
			if(OperatorUtil.greaterThan(this.operationValue(aobj[i], setup.key), setup.param)){
				list.add(aobj[i]);
			}
		}
		return list;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object  resultTernarySetup(Collection _array,OperatorMeta setup) {
		Object aobj[] = ((Collection)_array).toArray();
		Collection<Object> list=InstanceUtil.getInstance(_array.getClass());
		for (int i = 0; i < aobj.length; i++) {
			if(OperatorUtil.greaterThan(this.operationValue(aobj[i], setup.key), setup.param)){
				list.add(aobj[i]);
			}
		}
		return list;
	}
	@Override
	public boolean state(Object ...objs) {
		return OperatorUtil.greaterThan(objs[0],objs[1]);
	}
}
