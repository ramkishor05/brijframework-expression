package org.brijframework.expression.operators;

import java.util.Collection;

import org.brijframework.expression.base.IOperator;
import org.brijframework.expression.constant.OperatorType;
import org.brijframework.expression.core.Operators;
import org.brijframework.expression.meta.OperatorMeta;
import org.brijframework.util.reflect.InstanceUtil;
import org.brijframework.util.validator.ValidationUtil;

public class CountOperator extends Operators implements IOperator {
	public static CountOperator getOperator() {
		return (CountOperator) InstanceUtil.getInstance(CountOperator.class);
	}
	@SuppressWarnings("rawtypes")
	@Override
	public Object compute(Collection _array, OperatorMeta setup) {
		if(setup.type.contentEquals(OperatorType.Unary.toString())){
			return resultUnarySetup(_array,  setup);
		}
		if(setup.type.contentEquals(OperatorType.Unary.toString())){
			return resultBinarySetups(_array, setup);
		}
		if(setup.type.contentEquals(OperatorType.Unary.toString())){
			return resultTernarySetup(_array, setup);
		}
		return 0;
	}
	@SuppressWarnings("rawtypes")
	public int  resultUnarySetup(Collection _array,OperatorMeta setup) {
		int count=0;
		for(Object object:(Collection)_array){
			if(ValidationUtil.isValidObject(this.operationValue(object, setup.key))){
				count++;
			}
		}
		return count;
	}
	
	@SuppressWarnings("rawtypes")
	public int  resultBinarySetups(Collection _array,OperatorMeta setup) {
		int count=0;
		for(Object object:(Collection)_array){
			if(ValidationUtil.isValidObject(this.operationValue(object, setup.key))){
				count++;
			}
		}
		return count;
	}
	
	@SuppressWarnings("rawtypes")
	public int  resultTernarySetup(Collection _array,OperatorMeta setup) {
		int count=0;
		for(Object object:(Collection)_array){
			if(ValidationUtil.isValidObject(this.operationValue(object, setup.key))){
				count++;
			}
		}
		return count;
	}
}
