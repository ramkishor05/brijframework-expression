package org.brijframework.expression.operators;

import java.util.Comparator;

import org.brijframework.expression.base.IOperator;
import org.brijframework.expression.core.Operators;

public class CompareOperator<T> extends Operators implements IOperator, Comparator<T>{
	String key;
	boolean flag;
	public CompareOperator( String _s,boolean flag) {
		this.key=_s;
		this.flag=flag;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int compare(T o1, T o2) {
		Object obj1=this.operationValue(o1,key);
		Object obj2=this.operationValue(o2,key);
		if(!flag)
		    return ((Comparable)obj1).compareTo((Comparable)obj2);
		else
			return ((Comparable)obj2).compareTo((Comparable)obj1);
	}
}
