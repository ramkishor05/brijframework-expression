package org.brijframework.expression.operators;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

import org.brijframework.expression.base.IOperator;
import org.brijframework.expression.constant.OperatorType;
import org.brijframework.expression.constant.OperatorsKeys;
import org.brijframework.expression.core.Operators;
import org.brijframework.expression.meta.OperatorMeta;
import org.brijframework.expression.util.OperatorUtil;
import org.brijframework.util.reflect.FieldUtil;
import org.brijframework.util.reflect.InstanceUtil;
import org.brijframework.util.reflect.LogicUnit;
import org.brijframework.util.validator.ValidationUtil;

public class MergeOperator  extends Operators implements IOperator {
	private String key;
	private Object destination;
	
	public static MergeOperator getOperator() {
		return (MergeOperator) InstanceUtil.getInstance(MergeOperator.class);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object compute(Collection _array, OperatorMeta setup) {
		if(setup.type.contentEquals(OperatorType.Unary.toString())){
			return resultUnarySetup(_array, setup);
		}
		if(setup.type.contentEquals(OperatorType.Binary.toString())){
			return resultBinarySetups(_array, setup);
		}
		if(setup.type.contentEquals(OperatorType.Ternary.toString())){
			return resultTernarySetup(_array,  setup);
		}
		return null;
	}
	@SuppressWarnings("rawtypes")
	public Object   resultUnarySetup(Collection _array,OperatorMeta setup) {
		this.destination=setup.param;
		for (Object source : (Collection) _array) {
			if (destination instanceof Map) {
				mergeObject(source, (Map) destination);
			} else if (destination instanceof Collection) {
				mergeObject(source, (Collection) destination);
			} else if (destination instanceof Object) {
				mergeObject(source, destination);
			}
		}
		return _array;
	}
	
	@SuppressWarnings("rawtypes")
	public Object  resultBinarySetups(Collection _array,OperatorMeta setup) {
		this.destination=setup.param;
		for (Object source : (Collection) _array) {
			if (destination instanceof Map) {
				mergeObject(source, (Map) destination);
			} else if (destination instanceof Collection) {
				mergeObject(source, (Collection) destination);
			} else if (destination instanceof Object) {
				mergeObject(source, destination);
			}
		}
		return _array;
	}
	
	@SuppressWarnings("rawtypes")
	public Object  resultTernarySetup(Collection _array,OperatorMeta setup) {
		this.destination=setup.param;
		for (Object source : (Collection) _array) {
			if (destination instanceof Map) {
				mergeObject(source, (Map) destination);
			} else if (destination instanceof Collection) {
				mergeObject(source, (Collection) destination);
			} else if (destination instanceof Object) {
				mergeObject(source, destination);
			}
		}
		return _array;
	}
	
	@SuppressWarnings("rawtypes")
	public Object mergeObject(Object source, Collection destination) {
		for (Object object : destination) {
			if (ValidationUtil.isValidObject(this.key)) {
				Object valS = this.operationValue(source, key);
				Object valD = source instanceof Map ?((Map)source).get(key):LogicUnit.getField(source, key);
				if (operatorForKey(OperatorsKeys.EqualsTo.toString()).state(valS, valD)) {
					this.mergeObject(object, (Map)source);
				}
			} else {
				for (Object key : ((Map)source).keySet()) {
					String[] ops = key.toString().split("_");
					if (ops.length >= 2) {
						Object valS = this.operationValue(source, ops[0]);
						Object valD = ((Map)source).get(key);
						if (operatorForKey(ops[1]).state(valS, valD)) {
							this.mergeObject(source, source);
						}
					}
				}
			}
		}
		return source;
	}

	@SuppressWarnings("rawtypes")
	public Object mergeObject(Object source, Map destination) {
		for (Object key : destination.keySet()) {
			Object sourVal = this.operationValue(source, (String) key);
			Object destiVal = destination.get(key);
			if (!OperatorUtil.equalsObject(sourVal, destiVal)) {
				if(ValidationUtil.isValidObject(destiVal))
				this.setOperationValue(source, (String) key, destiVal);
			}
		}
		return source;
	}

	public Object mergeObject(Object source, Object desti) {
		for (Field field : FieldUtil.getAllField(desti.getClass())) {
			Object sourVal = this.operationValue(source, (String) field.getName());
			Object destiVal = LogicUnit.getField(desti, field);
			if (!OperatorUtil.equalsObject(sourVal, destiVal)) {
				if(ValidationUtil.isValidObject(destiVal))
				this.setOperationValue(source, (String) field.getName(), destiVal);
			}
		}
		return source;
	}
	

	public Object[] mergeObject(Object[]... arrays) {
	    int length = 0;
	    for (Object[] array : arrays) {
	        length += array.length;
	    }
	    Object[] result = new Object[length];
	    int pos = 0;
	    for (Object[] array : arrays) {
	        for (Object element : array) {
	            result[pos] = element;
	            pos++;
	        }
	    }
	    return result;
	}
}