package org.brijframework.expression.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.brijframework.bean.impl.BeanBuilder;
import org.brijframework.expression.base.IOperator;
import org.brijframework.expression.constant.OperatorCatagaries;
import org.brijframework.expression.constant.OperatorsKeys;
import org.brijframework.expression.meta.OperatorMeta;
import org.brijframework.expression.operators.ANDOperator;
import org.brijframework.expression.operators.AssignOperator;
import org.brijframework.expression.operators.AvgOperator;
import org.brijframework.expression.operators.ContainsOperator;
import org.brijframework.expression.operators.CountOperator;
import org.brijframework.expression.operators.DiffOperator;
import org.brijframework.expression.operators.DivideOperator;
import org.brijframework.expression.operators.EqualOperator;
import org.brijframework.expression.operators.GTEqualToOperator;
import org.brijframework.expression.operators.GreaterThanOperator;
import org.brijframework.expression.operators.GroupOperator;
import org.brijframework.expression.operators.LTEqualToOperator;
import org.brijframework.expression.operators.LessThanOperator;
import org.brijframework.expression.operators.MaxOperator;
import org.brijframework.expression.operators.MergeOperator;
import org.brijframework.expression.operators.MinOperator;
import org.brijframework.expression.operators.ModOperator;
import org.brijframework.expression.operators.NOTEqualsOperator;
import org.brijframework.expression.operators.NOTOperator;
import org.brijframework.expression.operators.OROperator;
import org.brijframework.expression.operators.OrderByOperator;
import org.brijframework.expression.operators.ProductOperator;
import org.brijframework.expression.operators.SubOperator;
import org.brijframework.expression.operators.SumOperator;
import org.brijframework.util.reflect.InstanceUtil;

public class Operators implements IOperator{
	public static Operators getOperators(){
		return (Operators) InstanceUtil.getInstance(Operators.class);
	}
	
	public OperatorCatagaries catagaries;

	private static HashMap<String, IOperator> _operators = new HashMap<>();
	static {
		setOperatorForKey("+", new SumOperator());
		setOperatorForKey("-", new SubOperator());
		setOperatorForKey("/", new DivideOperator());
		setOperatorForKey("%", new ModOperator());
		setOperatorForKey("*", new ProductOperator());
		setOperatorForKey("~", new DiffOperator());
		setOperatorForKey("=", new AssignOperator());
		setOperatorForKey("==", new EqualOperator());
		setOperatorForKey("&&", new ANDOperator());
		setOperatorForKey("||", new OROperator());
		setOperatorForKey("!", new NOTOperator());
		setOperatorForKey("!=", new NOTEqualsOperator());
		setOperatorForKey("<", new LessThanOperator());
		setOperatorForKey(">", new GreaterThanOperator());
		setOperatorForKey("<=", new LTEqualToOperator());
		setOperatorForKey(">=", new GTEqualToOperator());
		
		setOperatorForKey(OperatorsKeys.Sum.toString(), new SumOperator());
		setOperatorForKey(OperatorsKeys.Sub.toString(), new SubOperator());
		setOperatorForKey(OperatorsKeys.Mod.toString(), new ModOperator());
		setOperatorForKey(OperatorsKeys.Div.toString(), new DivideOperator());
		setOperatorForKey(OperatorsKeys.Prod.toString(), new ProductOperator());
		setOperatorForKey(OperatorsKeys.Compare.toString(), new DiffOperator());
		setOperatorForKey(OperatorsKeys.Count.toString(), new CountOperator());
		setOperatorForKey(OperatorsKeys.Max.toString(), new MaxOperator());
		setOperatorForKey(OperatorsKeys.Min.toString(), new MinOperator());
		setOperatorForKey(OperatorsKeys.Avg.toString(), new AvgOperator());
		setOperatorForKey(OperatorsKeys.OrderBy.toString(), new OrderByOperator());
		setOperatorForKey(OperatorsKeys.Group.toString(), new GroupOperator());
		setOperatorForKey(OperatorsKeys.Merge.toString(), new MergeOperator());
		setOperatorForKey(OperatorsKeys.AND.toString(), new ANDOperator());
		setOperatorForKey(OperatorsKeys.OR.toString(), new OROperator());
		setOperatorForKey(OperatorsKeys.NOT.toString(), new NOTOperator());
		setOperatorForKey(OperatorsKeys.NotEqualsTo.toString(), new NOTEqualsOperator());
		setOperatorForKey(OperatorsKeys.EqualsTo.toString(), new EqualOperator());
		setOperatorForKey(OperatorsKeys.LessThen.toString(), new LessThanOperator());
		setOperatorForKey(OperatorsKeys.LessThenEqualsTo.toString(), new LTEqualToOperator());
		setOperatorForKey(OperatorsKeys.GreaterThen.toString(), new GreaterThanOperator());
		setOperatorForKey(OperatorsKeys.GreaterThenEqualTo.toString(), new GTEqualToOperator());
		setOperatorForKey(OperatorsKeys.Contains.toString(), new ContainsOperator());
	}
	
	public static IOperator operatorForKey(String _key) {
		IOperator operator;
		synchronized (_operators) {
			operator = _operators.get(_key.toUpperCase());
		}
		return operator;
	}
	
	public static void setOperatorForKey(String _key, IOperator _operator) {
		if (_key == null) {
			throw new IllegalArgumentException("Operator key cannot be null");
		}
		if (_operator == null) {
			throw new IllegalArgumentException("Operator cannot be null for " + _key);
		}
		synchronized (_operators) {
			_operators.put(_key, _operator);
		}
	}
	protected Object operationValue(Object obj, String _s) {
		return _s == null || _s.length() <= 0 ? obj : BeanBuilder.getBuilder(obj).getProperty( _s);
	}

	protected Object setOperationValue(Object obj, String _s,Object val) {
		return _s == null || _s.length() <= 0 ? obj :BeanBuilder.getBuilder(obj).setProperty( _s,val);
	}

	public Operators() {
	}
	
	public Object excutor(String expression) {
		 ScriptEngineManager factory = new ScriptEngineManager();
		 ScriptEngine engine = factory.getEngineByName("JavaScript");
		 Object result=null;
		 try {
			result= engine.eval(expression);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object compute(Map collection, OperatorMeta operatorSetups) {
		return null;
	}

	@Override
	public Object compute(Object[] collection, OperatorMeta operatorSetups) {
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object compute(Collection _array, OperatorMeta operatorSetups) {
		IOperator operator=Operators.operatorForKey(operatorSetups.operator);
		Object result=null;
		if(operator!=null){
			result=operator.compute(_array, operatorSetups);
		}
		return result;
	}

	@Override
	public boolean state(Object ...obj) {
		return false;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object compute(Collection collection, OperatorMeta... operatorSetups) {
		return null;
	}

	

}
