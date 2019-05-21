package org.brijframework.expression.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

import org.brijframework.expression.base.IOperator;
import org.brijframework.expression.constant.OperatorsKeys;
import org.brijframework.expression.core.Expressions;
import org.brijframework.expression.core.Operators;
import org.brijframework.expression.meta.LogicalOperatorMata;
import org.brijframework.expression.meta.OperatorMeta;
import org.brijframework.util.reflect.InstanceUtil;
import org.brijframework.util.validator.ValidationUtil;

public class ExpressionUtil {

	public static List<OperatorMeta> getOperationSetups(String query){
		List<OperatorMeta> operationSetups=new ArrayList<>();
		int position=0;
		for(int i=0; i<query.length();i++){
			   if(ValidationUtil.isPunctuation(query.charAt(i))){
					String operator="";
					int j=i;
					while(j<query.length()){
					   if(ValidationUtil.isPunctuation(query.charAt(j))){
						  operator+=""+query.charAt(j);
					   }else{
						   break;
					   }
					   j++;
					}
					
					if(Operators.operatorForKey(operator)!=null){
						OperatorMeta setup=new  OperatorMeta();
						setup.operator=operator.toUpperCase();
						setup.position=position++;
						
						setup.initOperator(i, j-1, query);
						operationSetups.add(setup);
					}
					i=j;
			   }
		}
		return operationSetups;
	}
	
	public static List<OperatorMeta> getOperationSetupsWith(String query){
		List<OperatorMeta> operationSetups=new ArrayList<>();
        if(!query.contentEquals(" ")){
			return operationSetups;
		}
		int position=0;
		for(int i=0; i<query.length();i++){
			    String operator="";
				int j=i;
				while(j<query.length()){
				   if(ValidationUtil.isSpace(query.charAt(j))){
					   break;
				   }
				   operator+=""+query.charAt(j);
				   j++;
				}
				if(Expressions.operatorForKey(operator)!=null){
					OperatorMeta setup=new  OperatorMeta();
					setup.operator=operator.toUpperCase();;
					setup.position=position++;
					setup.initOperator(i, j-1, query);
					operationSetups.add(setup);
				}
				i=j;
		}
		return operationSetups;
	}
	
	public static OperatorMeta[] getOperationSetupArray(String query){
		List<OperatorMeta> operatorsSetup=getOperationSetups(query);
		Object[] objects=operatorsSetup.toArray();
		OperatorMeta[] operationSetups=new OperatorMeta[objects.length];
		for(int i=0;i<objects.length;i++){
			operationSetups[i]=(OperatorMeta) objects[i];
		}
		return operationSetups;
	}
	
	public static void fill(Stack<OperatorMeta> stack, OperatorMeta[] operationSetups ) {
    	for(int i=0;i<operationSetups.length;i++){
    		if(operationSetups[i].operator.contentEquals("&&")||operationSetups[i].operator.toUpperCase().contentEquals(OperatorsKeys.AND.toString())){
    			stack.push(operationSetups[i]);
    		}
    		if(operationSetups[i].operator.contentEquals("||")||operationSetups[i].operator.toUpperCase().contentEquals(OperatorsKeys.OR.toString())){
    			stack.push(operationSetups[i]);
    		}
    		
    	}
    	for(int i=0;i<operationSetups.length;i++){
	    	if(operationSetups[i].operator.contentEquals("not")||operationSetups[i].operator.toUpperCase().contentEquals("!")){
				stack.push(operationSetups[i]);
			}
    	}
	}
	
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static Collection compositeResult(Collection list,Stack<OperatorMeta> stack,OperatorMeta[] operationSetups){
		Collection result=(Collection) InstanceUtil.getInstance(list.getClass());
		result.addAll(list);
		Stack<Integer> not=new Stack<>();
		boolean isApply=false;
		while(!stack.isEmpty()){
			OperatorMeta setups=stack.pop();
			String op=LogicalOperatorMata.getSetup().getOperators(setups.operator);
			if(op.contentEquals("!")){
				not.push(setups.position+1);
				continue;
			}
			OperatorMeta left=operationSetups[setups.position-1];
			OperatorMeta right=operationSetups[setups.position+1];
			Collection response=(Collection) InstanceUtil.getInstance(result.getClass());
			for(Object obj:result){
				Object leftVal=Expressions.operationValue(obj, left.key);
				IOperator operatorLeft=Operators.operatorForKey(left.operator);
			    boolean stateLeft=operatorLeft.state(leftVal, left.param);
				Object rightVal=Expressions.operationValue(obj, right.key);
				IOperator operatorRight=Operators.operatorForKey(right.operator);
				boolean stateRight=operatorRight.state(rightVal, right.param);
				if(!not.isEmpty()){
				  int notop=not.peek();
				  if(left.position==notop){
					  stateLeft=!stateLeft;
					  isApply=true;
				  }
				  if(right.position==notop){
					  stateRight=!stateRight;
					  isApply=true;
				  }
				}
				String query=stateLeft+" "+op+" "+stateRight;
				Object res=Operators.getOperators().excutor(query);
				if(res instanceof Boolean)
				{
					boolean status=(boolean) res;
					if(status){
						response.add(obj);
					}
				}
			}
			if(isApply){
				not.pop();
			}
			result=response;
		}
		return result;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Collection singleResult(Collection list,Stack<OperatorMeta> stack,OperatorMeta[] operationSetups){
		Collection result=(Collection) InstanceUtil.getInstance(list.getClass());
		result.addAll(list);
		for(int i=0;i<operationSetups.length;i++){
		  operationSetups[i].result= Expressions.operatorForKey(operationSetups[i].operator).compute(result,operationSetups[i]);
		  result=(Collection) operationSetups[i].result;
		}
		return result;
	}

}
