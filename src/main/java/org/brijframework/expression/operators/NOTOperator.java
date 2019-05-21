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

public class NOTOperator extends Operators implements IOperator {
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object compute(Collection _array, OperatorMeta setup) {
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object   resultUnarySetup(Collection _array,OperatorMeta setup) {
		Collection list=(Collection) InstanceUtil.getInstance(_array.getClass());
		list.addAll((Collection) _array);
		Object aobj[] = list.toArray();
		for (int i = 0; i < aobj.length; i++) {
			Object arg=this.operationValue(aobj[i], setup.key);
			if(!ValidationUtil.isValidObject(arg)){
				continue;
			}
			Object obj=CastingUtil.castObject(setup.param, arg.getClass());
			Object val=OperatorUtil.not(this.operationValue(obj, setup.key));
			aobj[i]=this.setOperationValue(obj, setup.key,val);
			list.add(obj);
		}
		return list;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object  resultBinarySetups(Collection _array,OperatorMeta setup) {
		Collection list=(Collection) InstanceUtil.getInstance(_array.getClass());
		list.addAll((Collection) _array);
		Object aobj[] = list.toArray();
		for (int i = 0; i < aobj.length; i++) {
			Object arg=this.operationValue(aobj[i], setup.key);
			if(!ValidationUtil.isValidObject(arg)){
				continue;
			}
			Object val=OperatorUtil.not(this.operationValue(aobj[i], setup.key));
			aobj[i]=this.setOperationValue(aobj[i], setup.key,val);
			list.add(aobj[i]);
		}
		return list;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object  resultTernarySetup(Collection _array,OperatorMeta setup) {
		Collection list=(Collection) InstanceUtil.getInstance(_array.getClass());
		list.addAll((Collection) _array);
		Object aobj[] = list.toArray();
		for (int i = 0; i < aobj.length; i++) {
			Object arg=this.operationValue(aobj[i], setup.key);
			if(!ValidationUtil.isValidObject(arg)){
				continue;
			}
			Object val=OperatorUtil.not(this.operationValue(aobj[i], setup.key));
			aobj[i]=this.setOperationValue(aobj[i], setup.key,val);
			list.add(aobj[i]);
		}
		return list;
	}
	@Override
	public boolean state(Object ...objs) {
		return false;
	}
}