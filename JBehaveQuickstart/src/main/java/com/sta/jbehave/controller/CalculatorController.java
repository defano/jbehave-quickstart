package com.sta.jbehave.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sta.jbehave.calculator.model.Calculator;
import com.sta.jbehave.calculator.model.Operator;
import com.sta.jbehave.calculator.service.CalculatorService;

@Controller
public class CalculatorController {
	
	@Autowired
	private CalculatorService calculatorService;
	
	/**
	 * Evaluates a partial mathematical expression using "immediate execution rules"
	 * (order of operations is not followed). This Spring MVC controller method
	 * is invoked each time the user enters an operator (i.e., '+', '-', '=') on the
	 * calculator. 
	 * 
	 * Note that for infix binary operations, we cannot complete the calculation at 
	 * the time the operator is keyed. For example, the key sequence: '2' '+' '2' '='
	 * does not allow us to calculate 2+2 until the second operator--equals--has 
	 * been keyed. Thus, for binary operations, we have to "squirrel away" the current
	 * operator and maintain a running subtotal so that calculations can be completed 
	 * during future invocations.  
	 * 
	 * @param model The "form bean" POJO that represents data on the page. 
	 * @return The name of the view to render (always "calculator"). 
	 */
	@RequestMapping(value = "/calculate")
	public String evaluate (@ModelAttribute("calculator") Calculator model) {

		// Pull apart the form bean for convenience. 
		Double subtotal 			= model.getSubtotal();
		Double displayedValue 		= model.getDisplayedValue();
		Operator operator 			= model.getOperator();
		Operator lastOperator 		= model.getLastOperator();
												
		if (operator.isBinary()) {			
			// Calculate the result using the last operator entered
			Double result = calculatorService.evaluate(lastOperator, subtotal, displayedValue);
			
			// Squirrel away the current operator; it'll be evaluated during the next invocation
			model.setLastOperator(operator);
			
			// Update the calculator subtotal (memory) and display value
			model.setSubtotal(result);
			model.setDisplayedValue(result);
		} 		
		
		else {
			// Calculate the result using the current operator and update the displayed value
			Double result = calculatorService.evaluate(operator, subtotal, displayedValue);
			model.setDisplayedValue(result);
		}
		
		// Tell Spring MVC which view to render (calculator.jsp)
		return "calculator";
	}

	public CalculatorService getCalculatorService() {
		return calculatorService;
	}

	public void setCalculatorService(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}	
}
