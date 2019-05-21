package org.brijframework.expression.operators;

import java.util.Collection;

import org.brijframework.expression.base.IOperator;
import org.brijframework.expression.constant.OperatorType;
import org.brijframework.expression.core.Operators;
import org.brijframework.expression.meta.OperatorMeta;
import org.brijframework.expression.util.OperatorUtil;
import org.brijframework.util.casting.CastingUtil;
import org.brijframework.util.reflect.InstanceUtil;
import org.brijframework.util.validator.ValidationUtil;

public class NOTEqualsOperator extends Operators implements IOperator {
	@SuppressWarnings("rawtypes")
	@Override
	public Object compute(Collection  _array, OperatorMeta setup){ 
		if(setup.type.contentEquals(OperatorType.Unary.toString())){
			return resultUnarySetup(_array,  setup);
		}
		if(setup.type.contentEquals(OperatorType.Binary.toString())){
			return resultBinarySetups(_array,  setup);
		}
		if(setup.type.contentEquals(OperatorType.Ternary.toString())){
			return resultTernarySetup(_array,  setup);
		}
		return null;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object   resultUnarySetup(Collection _array,OperatorMeta setup) {
		Object aobj[] = ((Collection)_array).toArray();
		Collection list=(Collection) InstanceUtil.getInstance(_array.getClass());
		for (int i = 0; i < aobj.length; i++) {
			Object arg=this.operationValue(aobj[i], setup.key);
			if(!ValidationUtil.isValidObject(arg)){
				continue;
			}
			Object obj=CastingUtil.castObject(setup.param, arg.getClass());
			if(OperatorUtil.notEqualTo(obj, arg)){
				list.add(aobj[i]);
			}
		}
		return list;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object  resultBinarySetups(Collection _array,OperatorMeta setup) {
		Object aobj[] = ((Collection)_array).toArray();
		Collection list=(Collection) InstanceUtil.getInstance(_array.getClass());
		for (int i = 0; i < aobj.length; i++) {
			Object arg=this.operationValue(aobj[i], setup.key);
			if(!ValidationUtil.isValidObject(arg)){
				continue;
			}
			Object obj=CastingUtil.castObject(setup.param, arg.getClass());
			if(OperatorUtil.notEqualTo(obj, arg)){
				list.add(aobj[i]);
			}
		}
		return list;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object  resultTernarySetup(Collection _array,OperatorMeta setup) {
		Object aobj[] = ((Collection)_array).toArray();
		Collection list=(Collection) InstanceUtil.getInstance(_array.getClass());
		for (int i = 0; i < aobj.length; i++) {
			Object arg=this.operationValue(aobj[i], setup.key);
			if(!ValidationUtil.isValidObject(arg)){
				continue;
			}
			Object obj=CastingUtil.castObject(setup.param, arg.getClass());
			if(OperatorUtil.notEqualTo(obj, arg)){
				list.add(aobj[i]);
			}
		}
		return list;
	}
	@Override
	public boolean state(Object ...objs) {
		return !OperatorUtil.equalsObject(objs[0],objs[1]);
	}
}