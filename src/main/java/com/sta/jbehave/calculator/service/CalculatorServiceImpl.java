package com.sta.jbehave.calculator.service;

import org.springframework.stereotype.Component;

import com.sta.jbehave.calculator.model.Operator;

@Component
public class CalculatorServiceImpl implements CalculatorService {

	public Double evaluate(Operator operator, Double lhs, Double rhs) {

		switch (operator) {
		case ADD:
			return lhs + rhs;

		case SUBTRACT:
			return lhs - rhs;

		case MULTIPLY:
			return lhs * rhs;

		case DIVIDE:
			return lhs / rhs;

		case EQUALS:
			return rhs;			
			
		case NEGATE:
			return rhs * -1;
			
		case PERCENT:
			return rhs / 100;
			
		// Should be impossible. 
		default:
			throw new RuntimeException("BUG! This operation has not been implemented: " + operator);
		}
	}
}
