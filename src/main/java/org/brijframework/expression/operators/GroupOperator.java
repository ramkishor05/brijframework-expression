package org.brijframework.expression.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.brijframework.expression.base.IOperator;
import org.brijframework.expression.constant.OperatorType;
import org.brijframework.expression.core.Operators;
import org.brijframework.expression.meta.OperatorMeta;
import org.brijframework.expression.util.OperatorUtil;
import org.brijframework.util.reflect.InstanceUtil;

public class GroupOperator  extends Operators  implements IOperator {
	String key;
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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object   resultUnarySetup(Collection _array,OperatorMeta setup) {
		Collection collection=(Collection) InstanceUtil.getInstance(_array.getClass());
		Map<Object, Collection> map=new HashMap<Object, Collection>();
		List groupKeys=new ArrayList<>();
		this.key=setup.key;
		Object aobj[] = ((Collection)_array).toArray();
		for (int i = 0; i < aobj.length; i++) {
			groupKeys.add(this.operationValue(aobj[i], this.key));
		}
		for(Object group:groupKeys){
			Collection list=(Collection) InstanceUtil.getInstance(_array.getClass());
			for (int i = 0; i < aobj.length; i++) {
			if(OperatorUtil.equalTo(this.operationValue(aobj[i], this.key), group))
				list.add(aobj[i]);
			}
			map.put(group, list);
		}
		return collection.add(map) ;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object  resultBinarySetups(Collection _array,OperatorMeta setup) {
		Collection collection=(Collection) InstanceUtil.getInstance(_array.getClass());
		Map<Object, Collection> map=new HashMap<Object, Collection>();
		List groupKeys=new ArrayList<>();
		this.key=setup.key;
		Object aobj[] = ((Collection)_array).toArray();
		for (int i = 0; i < aobj.length; i++) {
			groupKeys.add(this.operationValue(aobj[i], this.key));
		}
		for(Object group:groupKeys){
			Collection list=InstanceUtil.getInstance(_array.getClass());
			for (int i = 0; i < aobj.length; i++) {
			if(OperatorUtil.equalTo(this.operationValue(aobj[i], this.key), group))
				list.add(aobj[i]);
			}
			map.put(group, list);
		}
		return collection.add(map) ;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object  resultTernarySetup(Collection _array,OperatorMeta setup) {
		Collection collection=(Collection) InstanceUtil.getInstance(_array.getClass());
		Map<Object, Collection> map=new HashMap<Object, Collection>();
			List groupKeys=new ArrayList<>();
		this.key=setup.key;
		Object aobj[] = ((Collection)_array).toArray();
		for (int i = 0; i < aobj.length; i++) {
			groupKeys.add(this.operationValue(aobj[i], this.key));
		}
		for(Object group:groupKeys){
			Collection list=(Collection) InstanceUtil.getInstance(_array.getClass());
			for (int i = 0; i < aobj.length; i++) {
			if(OperatorUtil.equalTo(this.operationValue(aobj[i], this.key), group))
				list.add(aobj[i]);
			}
			map.put(group, list);
		}
		return collection.add(map) ;
	}
	@Override
	public boolean state(Object ...obj) {
		return false;
	}
}