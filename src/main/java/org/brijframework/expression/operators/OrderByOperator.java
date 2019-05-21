package org.brijframework.expression.operators;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.brijframework.expression.base.IOperator;
import org.brijframework.expression.constant.OperatorType;
import org.brijframework.expression.core.Operators;
import org.brijframework.expression.meta.OperatorMeta;
import org.brijframework.util.text.StringUtil;

public class OrderByOperator extends Operators implements IOperator {
	
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
			return resultTernarySetup(_array, setup);
		}
		return null;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object   resultUnarySetup(Collection _array,OperatorMeta setup) {
        Collections.sort((List) _array, new CompareOperator(setup.key,StringUtil.containsEquals(""+setup.param, "desc")));
		return _array;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object  resultBinarySetups(Collection _array,OperatorMeta setup) {
        Collections.sort((List) _array, new CompareOperator(setup.key,StringUtil.containsEquals(""+setup.param, "desc")));
		return _array;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object  resultTernarySetup(Collection _array,OperatorMeta setup) {
        Collections.sort((List) _array, new CompareOperator(setup.key,StringUtil.containsEquals(""+setup.param, "desc")));
		return _array;
	}
	public void set(Collection<Object> _array,Object...a) {
        for (int j=0; j<_array.toArray().length; j++) {
            _array.add(a[j]);
        }
	}
}