package org.brijframework.expression.operators;

import java.util.Collection;

import org.brijframework.expression.base.IOperator;
import org.brijframework.expression.constant.OperatorType;
import org.brijframework.expression.core.Operators;
import org.brijframework.expression.meta.OperatorMeta;
import org.brijframework.expression.util.OperatorUtil;

public class SumOperator extends Operators implements IOperator {
	@SuppressWarnings("rawtypes")
	public Object addition(Collection _array,String _s,Object obj) {
		Object aobj[] = _array.toArray();
		Object objResult = null;
		Object val=null;
		for (int i = 0; i < aobj.length; i++) {
			val=this.operationValue(aobj[i], _s);
			objResult=OperatorUtil.addition(objResult, val);
		}
		return objResult;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object compute(Collection _array, OperatorMeta setup) {
		if(setup.type.contentEquals(OperatorType.Unary.toString())){
			return resultUnarySetup(_array,  setup);
		}
		if(setup.type.contentEquals(OperatorType.Binary.toString())){
			return resultBinarySetups(_array,setup);
		}
		if(setup.type.contentEquals(OperatorType.Ternary.toString())){
			return resultTernarySetup(_array,setup);
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public Object  resultUnarySetup(Collection _array,OperatorMeta setup) {
		return this.addition(_array, setup.key,setup.param);
	}
	
	@SuppressWarnings("rawtypes")
	public Object  resultBinarySetups(Collection _array,OperatorMeta setup) {
		return this.addition(_array, setup.key,setup.param);
	}
	
	@SuppressWarnings("rawtypes")
	public Object  resultTernarySetup(Collection _array,OperatorMeta setup) {
		return this.addition(_array, setup.key,setup.param);
	}
}