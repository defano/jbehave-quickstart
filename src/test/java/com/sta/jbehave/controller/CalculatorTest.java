package com.sta.jbehave.controller;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.sta.jbehave.CalculatorTestUtils;
import com.sta.jbehave.JBehaveJUnitTest;
import com.sta.jbehave.calculator.model.Calculator;
import com.sta.jbehave.calculator.model.Operator;
import com.sta.jbehave.calculator.service.CalculatorServiceImpl;

public class CalculatorTest extends JBehaveJUnitTest {

	private CalculatorController calculator;
	private Calculator model;
	
	@Given("a calculator in its initial state")
	public void initialize() {
		calculator = new CalculatorController();
		calculator.setCalculatorService(new CalculatorServiceImpl());		
		
		model = new Calculator();
	}
	
	@When("I press $input")
	@Alias("then $input")
	public void processInput (String input) {
		Operator op = CalculatorTestUtils.getOperator(input);
		
		if (op == null)
			model.setDisplayedValue(Double.valueOf(input));
		else {
			model.setOperator(op);
			calculator.evaluate(model);
		}		
	}
	
	@Then("I expect the calculator to display $expectedValue") 
	public void validateOutput(String expectedValue) {
		assertEquals(model.getDisplayedValue(), Double.valueOf(expectedValue));
	}
}
