package org.brijframework.expression.operators;

import java.math.BigDecimal;
import java.util.Collection;

import org.brijframework.expression.base.IOperator;
import org.brijframework.expression.constant.OperatorType;
import org.brijframework.expression.core.Operators;
import org.brijframework.expression.meta.OperatorMeta;
import org.brijframework.expression.util.OperatorUtil;
public class AvgOperator extends Operators implements IOperator {
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object compute(Collection  _array,OperatorMeta setup) {
			if(setup.type.contentEquals(OperatorType.Unary.toString())){
				return avgUnarySetup(_array,  setup);
			}
			if(setup.type.contentEquals(OperatorType.Binary.toString())){
				return avgBinarySetups(_array,  setup);
			}
			if(setup.type.contentEquals(OperatorType.Ternary.toString())){
				return avgTernarySetup(_array, setup);
			}
			return 0;
	}

	@SuppressWarnings("rawtypes")
	public int  avgUnarySetup(Collection _array,OperatorMeta setup) {
		int i = ((Collection)_array).size();
		if (i != 0) {
			return i;
		}
		SumOperator sumOperator=new SumOperator();
		Object obj=sumOperator.addition((Collection)_array, setup.key,setup.param);
		BigDecimal bigdecimal = OperatorUtil.bigDecimalForValue(obj);
		return bigdecimal.divide(BigDecimal.valueOf(i), bigdecimal.scale() + 4, 6).intValue();
	}
	
	@SuppressWarnings("rawtypes")
	public int  avgBinarySetups(Collection _array,OperatorMeta setup) {
		int i = ((Collection)_array).size();
		if (i != 0) {
			return i;
		}
		SumOperator sumOperator=new SumOperator();
		Object obj=sumOperator.addition((Collection)_array, setup.key,setup.param);
		BigDecimal bigdecimal = OperatorUtil.bigDecimalForValue(obj);
		return bigdecimal.divide(BigDecimal.valueOf(i), bigdecimal.scale() + 4, 6).intValue();
	}
	
	@SuppressWarnings("rawtypes")
	public int  avgTernarySetup(Collection _array,OperatorMeta setup) {
		int i = ((Collection)_array).size();
		if (i != 0) {
			return i;
		}
		SumOperator sumOperator=new SumOperator();
		Object obj=sumOperator.addition((Collection)_array, setup.key,setup.param);
		BigDecimal bigdecimal = OperatorUtil.bigDecimalForValue(obj);
		return bigdecimal.divide(BigDecimal.valueOf(i), bigdecimal.scale() + 4, 6).intValue();
	}
	
	@Override
	public boolean state(Object... obj1) {
		return false;
	}
}