package com.sta.jbehave.calculator.model;

public enum Operator {

	EQUALS(true), ADD(true), SUBTRACT(true), MULTIPLY(true), DIVIDE(true), PERCENT(false), NEGATE(false);

	boolean isBinary; 
	
	private Operator (boolean isBinary) {
		this.isBinary = isBinary;
	}
	
	public boolean isBinary () {
		return isBinary;
	}
	
	public static Operator fromSymbolChar (char c) throws IllegalArgumentException {
		switch (c) {
		case '+': return ADD;
		case '-': return SUBTRACT;
		case 'x':
		case '*': return MULTIPLY;
		case '/': return DIVIDE;
		case '%': return PERCENT;
		case '!': return NEGATE;
		case '=': return EQUALS;
		default: throw new IllegalArgumentException("Operation symbol not defined: " + c);
		}
	}
}
