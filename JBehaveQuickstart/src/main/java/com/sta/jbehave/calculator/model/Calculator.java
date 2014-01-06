package com.sta.jbehave.calculator.model;

public class Calculator {

	// This is subtotal held in the calculators memory
	private Double subtotal = 0.00;			
	
	// The entered / displayed value on the screen
	private Double displayedValue = 0.00;		
	
	// Only used when sending a calculation from the browser to the server, 
	// this value holds the operator the user just pressed (i.e., "+", "-", "=").
	private Operator operator = Operator.EQUALS;			
	
	// The last operator the user entered before the current one. This is
	// required because infix binary expressions can't be evaluated until
	// a second operator has been keyed. For example: 2 + 2 [ENTER] can't
	// be evaluated when the user presses '+', we have to wait for [ENTER].
	private Operator lastOperator = Operator.EQUALS;		 
	
	public Double getDisplayedValue() {
		return displayedValue;
	}
	
	public void setDisplayedValue(Double subtotal) {
		this.displayedValue = subtotal;
	}
	
	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Operator getOperator() {
		return operator;
	}
	
	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public Operator getLastOperator() {
		return lastOperator;
	}

	public void setLastOperator(Operator lastOperator) {
		this.lastOperator = lastOperator;
	}	
}
