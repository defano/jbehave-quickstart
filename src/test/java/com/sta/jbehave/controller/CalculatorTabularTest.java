package com.sta.jbehave.controller;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Vector;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.steps.Parameters;

import com.sta.jbehave.CalculatorTestUtils;
import com.sta.jbehave.JBehaveJUnitTest;
import com.sta.jbehave.calculator.service.CalculatorServiceImpl;

public class CalculatorTabularTest extends JBehaveJUnitTest {

	// Unit under test
	private CalculatorController calculator;
	
	private List<String> sequenceList = new Vector<String>();
	private List<Double> resultList = new Vector<Double>();
	
	@Override
	public Object getStepsClass() {
		return this;
	}

	@Given("a calculator in its initial state")
	public void setup () {
		calculator = new CalculatorController();
		calculator.setCalculatorService(new CalculatorServiceImpl());
	}

	@When("I enter these key sequences: $sequences")
	public void inputSequence(ExamplesTable sequences) {
		for (Parameters row : sequences.getRowsAsParameters()) 
			sequenceList.add(row.valueAs("sequence", String.class));
	}

	@Then("I expect these values to be displayed: $values")
	public void validateCalculation(ExamplesTable values) {
		for (Parameters row : values.getRowsAsParameters())
			resultList.add(row.valueAs("results", Double.class));
		
		assertEquals(resultList.size(), sequenceList.size());
		
		for (int index = 0; index < resultList.size(); index++) 
			CalculatorTestUtils.validateSequence(sequenceList.get(index), resultList.get(index), calculator);
	} 
}
