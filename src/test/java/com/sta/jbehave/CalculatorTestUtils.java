package com.sta.jbehave;

import static org.junit.Assert.assertEquals;

import com.sta.jbehave.calculator.model.Calculator;
import com.sta.jbehave.calculator.model.Operator;
import com.sta.jbehave.controller.CalculatorController;

public class CalculatorTestUtils {

	/**
	 * Attempts to convert a String to an Operator (enum); returns null if the
	 * String does not represent an Operator.
	 * 
	 * @param token 
	 * @return
	 */
	public static Operator getOperator(String token) {
		
		if (token.length() > 1)
			return null;
		
		try {
			return Operator.fromSymbolChar(token.charAt(0));
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
	
	/**
	 * Validates that a String sequence of input evaluates to an expected result 
	 * when using a provided CalculatorController.
	 * 
	 * @param inputSequence Whitespace delimited set of input, for example: "2 + 2 ="
	 * @param expectedResult The expected calculated result, for example: 4.0
	 * @param calculator The CalculatorController with which to evaluate the expression.
	 */
	public static void validateSequence (String inputSequence, Double expectedResult, CalculatorController calculator) {
		
		String tokens[] = inputSequence.split("\\s");
		Calculator model = new Calculator();
		
		for (int index = 0; index < tokens.length; index++) {			
			Operator op = getOperator(tokens[index]);
			
			if (op == null)
				model.setDisplayedValue(Double.valueOf(tokens[index]));
			else {
				model.setOperator(op);
				calculator.evaluate(model);
			}			
		}
		
		assertEquals(model.getDisplayedValue(), expectedResult);
	}		
}
