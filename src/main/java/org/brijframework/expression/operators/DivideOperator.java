
package org.brijframework.expression.operators;

import java.util.Collection;

import org.brijframework.expression.base.IOperator;
import org.brijframework.expression.core.Operators;
import org.brijframework.expression.util.OperatorUtil;

public class DivideOperator extends Operators implements IOperator {
	@SuppressWarnings("rawtypes")
	public Object divide(Collection _array,String _s) {
		Object aobj[] = _array.toArray();
		Object objResult = null;
		if(aobj.length>0){
			objResult = OperatorUtil.bigDecimalForValue(this.operationValue(aobj[0], _s));
		}
		for (int i = 1; i < aobj.length; i++) {
			objResult=OperatorUtil.divide(objResult, aobj[i]);
		}
		return objResult;
	}
	
	@SuppressWarnings("rawtypes")
	public Object divide(Collection _array,String _s,Object obj) {
		Object aobj[] = _array.toArray();
		Object objResult = null;
		if(aobj.length>0){
			objResult = OperatorUtil.bigDecimalForValue(this.operationValue(aobj[0], _s));
		}
		for (int i = 1; i < aobj.length; i++) {
			objResult=OperatorUtil.divide(objResult, obj);
			objResult=aobj[i];
		}
		return objResult;
	}
	@SuppressWarnings("rawtypes")
	public Object compute(Collection _array, String _s) {
		return this.divide(_array, _s);
	}
	
	@SuppressWarnings("rawtypes")
	public Object compute(Collection _array, String _s,Object obj) {
		return this.divide(_array, _s,obj);
	}
}
