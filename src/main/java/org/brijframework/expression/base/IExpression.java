package org.brijframework.expression.base;
/**
 * Expression Evaluation
 * @author Ram
 *
 */
public interface IExpression {

	/**
	 * <p>
	 * Returns value for given object.
	 * </p>
	 * 
	 * @param object the object to retrieve a value from
	 * @return the value
	 * @since Oct 16, 2016 Brijframework 1.0
	 */
	public Object valueForObject(final Object _object);
}