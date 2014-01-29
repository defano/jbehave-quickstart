package com.sta.jbehave.calculator.service;

import com.sta.jbehave.calculator.model.Operator;

public interface CalculatorService {

	/**
	 * Evaluates a mathematical expression. 
	 * 
	 * @param operator The operator to evaluate (i.e., add, subtract, negate, etc.)
	 * @param lhs The left-hand operand to be used for infix binary operations; ignored
	 * by unary operators.   
	 * @param rhs The right-hand operand to be used for infix binary operations and the
	 * (singular) operand to be used in unary operations. 
	 * @return The resulting value.
	 */
	public Double evaluate (Operator operator, Double lhs, Double rhs);
}
