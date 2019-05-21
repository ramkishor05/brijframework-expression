package org.brijframework.expression.operators;

import java.util.Collection;

import org.brijframework.expression.base.IOperator;
import org.brijframework.expression.constant.OperatorType;
import org.brijframework.expression.core.Operators;
import org.brijframework.expression.meta.OperatorMeta;
import org.brijframework.expression.util.OperatorUtil;
import org.brijframework.util.reflect.InstanceUtil;
import org.brijframework.util.validator.ValidationUtil;

public class OROperator extends Operators implements IOperator {
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object compute(Collection _array, OperatorMeta setup) {
		if(setup.type.contentEquals(OperatorType.Binary.toString())){
			return resultUnarySetup(_array, setup);
		}
		if(setup.type.contentEquals(OperatorType.Binary.toString())){
			return resultBinarySetups(_array,  setup);
		}
		if(setup.type.contentEquals(OperatorType.Binary.toString())){
			return resultTernarySetup(_array,  setup);
		}
		return null;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object   resultUnarySetup(Collection _array,OperatorMeta setup) {
		Object aobj[] = ((Collection)_array).toArray();
		Collection list=InstanceUtil.getInstance(_array.getClass());
		for (int i = 0; i < aobj.length; i++) {
			Object obj=this.operationValue(aobj[i], setup.key);
			if(ValidationUtil.isValidObject(obj,setup.param))
			if(OperatorUtil.equalTo(setup.param, obj)){
				list.add(aobj[i]);
			}
		}
		return list;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object  resultBinarySetups(Collection _array,OperatorMeta setup) {
		Object aobj[] = ((Collection)_array).toArray();
		Collection list=InstanceUtil.getInstance(_array.getClass());
		for (int i = 0; i < aobj.length; i++) {
			Object obj=this.operationValue(aobj[i], setup.key);
			if(ValidationUtil.isValidObject(obj,setup.param))
			if(OperatorUtil.equalTo(setup.param, obj)){
				list.add(aobj[i]);
			}
		}
		return list;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object  resultTernarySetup(Collection _array,OperatorMeta setup) {
		Object aobj[] = ((Collection)_array).toArray();
		Collection list=InstanceUtil.getInstance(_array.getClass());
		for (int i = 0; i < aobj.length; i++) {
			Object obj=this.operationValue(aobj[i], setup.key);
			if(ValidationUtil.isValidObject(obj,setup.param))
			if(OperatorUtil.equalTo(setup.param, obj)){
				list.add(aobj[i]);
			}
		}
		return list;
	}
}