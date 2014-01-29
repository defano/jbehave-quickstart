package com.sta.jbehave.model;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

import com.sta.jbehave.JBehaveJUnitTest;
import com.sta.jbehave.calculator.model.Operator;

public class OperatorTest extends JBehaveJUnitTest {

	private Operator operatorUnderTest;
	
	@Override
	public Object getStepsClass() {
		return this;
	}

	@Given("the $operatorName operator")
	public void given (String operatorName) {
		operatorUnderTest = Operator.valueOf(Operator.class, operatorName);
	}
	
	@Then("isBinary() should return $boolean")
	public void then (String bool) {
		assertEquals((Boolean) operatorUnderTest.isBinary(), Boolean.valueOf(bool));
	}	
}

