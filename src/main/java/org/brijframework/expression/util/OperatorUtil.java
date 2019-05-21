package org.brijframework.expression.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.brijframework.util.casting.CastingUtil;
import org.brijframework.util.casting.DateUtil;
import org.brijframework.util.reflect.FieldUtil;
import org.brijframework.util.reflect.LogicUnit;
import org.brijframework.util.text.StringUtil;
import org.brijframework.util.validator.ValidationUtil;

public abstract class OperatorUtil {

	public  static BigDecimal bigDecimalForValue(Object obj) {
		if (ValidationUtil.isEmptyObject(obj)) {
			if (ValidationUtil.isClassAsNumberOrABoolean(obj.getClass())) {
				return (BigDecimal) CastingUtil.convertNumberOrBooleanIntoCompatibleValue(obj,
						CastingUtil._BigDecimalClass);
			}
			if (obj instanceof Date || obj instanceof java.sql.Date
						|| obj instanceof Time || obj instanceof Timestamp) {
				return new BigDecimal( DateUtil.getTime(obj));
			}
			if (obj instanceof BigDecimal) {
				return (BigDecimal) obj;
			}
			if (obj instanceof String) {
				return new BigDecimal((String) obj);
			} else {
				throw new IllegalStateException(
						"Can't convert " + obj + " (class " + obj.getClass().getName() + ") into number");
			}
		} else {
			return new BigDecimal(0);
		}
	}

	public static BigDecimal addition(Object obj1, Object obj2) {
		BigDecimal bigdecimal1 = bigDecimalForValue(obj1);
		BigDecimal bigdecimal2 = bigDecimalForValue(obj2);
		return bigdecimal1.add(bigdecimal2);
	}

	public static BigDecimal subtract(Object obj1, Object obj2) {
		BigDecimal bigdecimal1 = bigDecimalForValue(obj1);
		BigDecimal bigdecimal2 = bigDecimalForValue(obj2);
		return bigdecimal1.subtract(bigdecimal2);
	}

	public static BigDecimal multiply(Object obj1, Object obj2) {
		BigDecimal bigdecimal1 = bigDecimalForValue(obj1);
		BigDecimal bigdecimal2 = bigDecimalForValue(obj2);
		return bigdecimal1.subtract(bigdecimal2);
	}


	public static  BigDecimal divide(Object obj1, Object obj2) {
		BigDecimal bigdecimal1 = bigDecimalForValue(obj1);
		BigDecimal bigdecimal2 = bigDecimalForValue(obj2);
		return bigdecimal1.subtract(bigdecimal2);
	}


	public static BigDecimal differ(Object obj1, Object obj2) {
		BigDecimal bigdecimal1 = bigDecimalForValue(obj1);
		BigDecimal bigdecimal2 = bigDecimalForValue(obj2);
		return bigdecimal1.subtract(bigdecimal2);
	}


	public static BigDecimal remainder(Object obj1, Object obj2) {
		BigDecimal bigdecimal1 = bigDecimalForValue(obj1);
		BigDecimal bigdecimal2 = bigDecimalForValue(obj2);
		return bigdecimal1.subtract(bigdecimal2);
	}

	public static BigDecimal not(Object obj) {
		BigDecimal bigdecimal = bigDecimalForValue(obj);
		return bigdecimal.negate();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object minOrMaxValue(Object _obj1, Object _obj2, boolean _flag) {
		if (_obj1 == null) {
			return _obj1;
		}
		if (_obj2 == null) {
			return _obj2;
		}
		int i;
		if (ValidationUtil.isClassAsNumberOrABoolean(_obj1.getClass())) {
			i = CastingUtil.compareNumbersOrBooleans(_obj1, _obj2);
		} else if (_obj1 instanceof Date) {
			i = ((Date) _obj1).compareTo((Date) _obj1);
		} else if (_obj1 instanceof Comparable) {
			i = ((Comparable) _obj1).compareTo(_obj1);
		} else {
			throw new IllegalStateException(
					"Cannot compare values " + _obj1 + " and " + _obj2 + " (they are not instance of Comparable");
		}
		if (_flag) {
			if (i >= 0) {
				return _obj1;
			}
		} else if (i <= 0) {
			return _obj1;
		}
		return _obj2;
	}

	

	public static boolean equalsObject(Object obj1, Object obj2) {
		if (StringUtil.containsEquals("null", new String(""+obj1))&&StringUtil.containsEquals("null", new String(""+obj2))) {
			return true;
		} 
		if(!ValidationUtil.isValidObject(obj2,obj1)){
			return false;
		}
		if (ValidationUtil.isPrimative(obj1)&&ValidationUtil.isPrimative(obj2)) {
			return obj1.equals(obj2);
		}
		
		if (!obj1.getClass().equals(obj2.getClass())) {
			return false;
		}
		 if((ValidationUtil.isPrimative(obj1) || obj1 instanceof Date || obj1 instanceof java.sql.Date
					|| obj1 instanceof Time || obj1 instanceof Timestamp) &&(ValidationUtil.isPrimative(obj2) || obj2 instanceof Date || obj2 instanceof java.sql.Date
							|| obj2 instanceof Time || obj2 instanceof Timestamp)) {
			 return obj1.equals(obj2);
		 }
		List<Field> list1 = FieldUtil.getAllField(obj1.getClass());
		List<Field> list2 = FieldUtil.getAllField(obj2.getClass());
		if (!list2.containsAll(list1)){
			return false;
		}
		int count = 0;
		for (Field field : list1) {
			Object VAL1 = LogicUnit.getField(obj1, field);
			Object VAL2 = LogicUnit.getField(obj2, field);
			if (ValidationUtil.isPrimative(VAL1)&&ValidationUtil.isPrimative(VAL2)) {
				if (VAL1.equals(VAL2.toString())) {
					count++;
				}
			} else {
				if (equalsRelObject(VAL1, VAL2)) {
					count++;
				}
			}
		}
		return count == list1.size() ? true : false;
	}

	public static boolean equalsRelObject(Object obj1, Object obj2) {
		if (!obj1.getClass().equals(obj2.getClass())) {
			return false;
		}
		if (ValidationUtil.isPrimative(obj1) && ValidationUtil.isPrimative(obj2)) {
			return obj1.equals(obj2);
		}
		List<Field> list1 = FieldUtil.getAllField(obj1.getClass());
		List<Field> list2 = FieldUtil.getAllField(obj2.getClass());
		if (!list2.containsAll(list1)) {
			return false;
		}
		int count = 0;
		for (Field field : list1) {
			Object VAL1 = LogicUnit.getField(obj1, field);
			Object VAL2 = LogicUnit.getField(obj2, field);
			if (VAL1.equals(VAL2)) {
				count++;
			}
		}
		return count == list1.size() ? true : false;
	}

	public static boolean equalsIgnoreCaseObject(Object obj1, Object obj2) {
		if (ValidationUtil.isPrimative(obj1) && ValidationUtil.isPrimative(obj2)) {
			return obj1.toString().equalsIgnoreCase(obj2.toString());
		}
		int count = 0;
		List<Field> list1 = FieldUtil.getAllField(obj1.getClass());
		List<Field> list2 = FieldUtil.getAllField(obj2.getClass());
		if (!list2.containsAll(list1)) {
			return false;
		}
		for (Field field : list1) {
			String VAL1 = LogicUnit.getField(obj1, field).toString();
			String VAL2 = LogicUnit.getField(obj2, field).toString();
			if (VAL1.equalsIgnoreCase(VAL2)) {
				count++;
			}
		}
		return count == list1.size() ? true : false;
	}
	
	
	public static boolean equalTo(Object obj1, Object obj2) {
		return equalsObject(obj1, obj2);
	}

	public static boolean notEqualTo(Object obj1, Object obj2) {
		return !equalsObject(obj1, obj2);
	}
	
	public static boolean lessThan(Object obj1, Object obj2) {
		int sign=(bigDecimalForValue(obj1).subtract(bigDecimalForValue(obj2))).signum();
		return sign==-1?true:false;
	}
	
	public static boolean lessThanEqualTo(Object obj1, Object obj2) {
		int sign=(bigDecimalForValue(obj1).subtract(bigDecimalForValue(obj2))).signum();
		return sign==-1 || sign==0 ?true:false;
	}
	
	public static boolean greaterThan(Object obj1, Object obj2) {
		int sign=(bigDecimalForValue(obj1).subtract(bigDecimalForValue(obj2))).signum();
		return sign==1 ?true:false;
	}
	
	public static boolean greaterThanEqualTo(Object obj1, Object obj2) {
		int sign=(bigDecimalForValue(obj1).subtract(bigDecimalForValue(obj2))).signum();
		return sign==1 || sign==0 ?true:false;
	}
	
}
