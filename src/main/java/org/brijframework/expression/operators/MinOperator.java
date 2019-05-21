package org.brijframework.expression.operators;

import java.util.Collection;

import org.brijframework.expression.base.IOperator;
import org.brijframework.expression.constant.OperatorType;
import org.brijframework.expression.core.Operators;
import org.brijframework.expression.meta.OperatorMeta;
import org.brijframework.expression.util.OperatorUtil;

public class MinOperator extends Operators implements IOperator {
	@SuppressWarnings("rawtypes")
	@Override
	public Object compute(Collection _array, OperatorMeta setup) {
		if(setup.type.contentEquals(OperatorType.Unary.toString())){
			return resultUnarySetup(_array, setup);
		}
		if(setup.type.contentEquals(OperatorType.Binary.toString())){
			return resultBinarySetups(_array,  setup);
		}
		if(setup.type.contentEquals(OperatorType.Ternary.toString())){
			return resultTernarySetup(_array,  setup);
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public Object   resultUnarySetup(Collection _array,OperatorMeta setup) {
		Object obj = null;
		Object aobj[] = _array.toArray();
		if(aobj.length>0){
			obj=this.operationValue(aobj[0], setup.key);
		}
		for (int i = 0; i < aobj.length; i++) {
			obj = OperatorUtil.minOrMaxValue(obj, this.operationValue(aobj[i], setup.key), false);
		}
		return obj;
	}
	
	@SuppressWarnings("rawtypes")
	public Object  resultBinarySetups(Collection _array,OperatorMeta setup) {
		Object obj = null;
		Object aobj[] = _array.toArray();
		if(aobj.length>0){
			obj=this.operationValue(aobj[0], setup.key);
		}
		for (int i = 0; i < aobj.length; i++) {
			obj = OperatorUtil.minOrMaxValue(obj, this.operationValue(aobj[i], setup.key), false);
		}
		return obj;
	}
	
	@SuppressWarnings("rawtypes")
	public Object  resultTernarySetup(Collection _array,OperatorMeta setup) {
		Object obj = null;
		Object aobj[] = _array.toArray();
		if(aobj.length>0){
			obj=this.operationValue(aobj[0], setup.key);
		}
		for (int i = 0; i < aobj.length; i++) {
			obj = OperatorUtil.minOrMaxValue(obj, this.operationValue(aobj[i], setup.key), false);
		}
		return obj;
	}
	
}