package com.sta.jbehave.controller;

import java.util.List;
import java.util.Vector;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.sta.jbehave.CalculatorTestUtils;
import com.sta.jbehave.JBehaveTest;
import com.sta.jbehave.calculator.service.CalculatorServiceImpl;

public class CalculatorAltTabularTest extends JBehaveTest {

	private CalculatorController calculator;
	
	private List<String> sequenceList = new Vector<String>();
	private List<Double> resultList = new Vector<Double>();
	
	public void run() throws Throwable {
		super.run(this);
	}
	
	@Given("a calculator in its initial state")
	public void setup() {
		calculator = new CalculatorController();
		calculator.setCalculatorService(new CalculatorServiceImpl());		
	}
	
	@When("I enter <sequence>")
	public void inputSequence (@Named("sequence") String sequence) {
		sequenceList.add(sequence);
	}
	
	@Then("I expect <result> to be displayed")
	public void validateResult(@Named("result") String result) {
		resultList.add(Double.valueOf(result));
		
		for (int index = 0; index < resultList.size(); index++) 
			CalculatorTestUtils.validateSequence(sequenceList.get(index), resultList.get(index), calculator);
	}	
}
