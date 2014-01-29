package com.sta.jbehave;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Ignore;

@Ignore
public abstract class JBehaveTest extends JUnitStory {

	private Object steps;

	/**
	 * Runs a JBehave steps class as a JUnit test.
	 * 
	 * @param steps The steps class to execute.
	 * @throws Throwable Any throwable resulting from test execuction.
	 */
	public void run (Object steps) throws Throwable {
		this.steps = steps;
		super.run();
	}
	
	/**
	 * Don't invoke this from your steps class--use the overloaded run method
	 * that takes a step class as input, instead.
	 * 
	 * This method is invoked implicitly by the superclass as part of a @Test 
	 * annotated method. Fails if the test has not been initialized with a  
	 * steps class.
	 */
	public void run() throws Throwable {
		
		if (steps == null)
			throw new RuntimeException("Please invoke run() with a steps class object.");
	}
	
	/**
	 * Returns a default JBehave configuration for each run.
	 */
	@Override
	public Configuration configuration() {
		
		return new MostUsefulConfiguration()		

			// Load story files (.story) from the classpath using the same 
			// classloader as this object. The story file should have the same
			// name (and package location) as the steps file, but replacing
			// each camel-case with an underscore and using .story as the
			// file extension. For example, a steps class called MyTestCase.java
			// would look for the stories in my_test_case.story.
			.useStoryLoader(new LoadFromClasspath(this.getClass()))
			
			// Produce a standard report on the console and as a text file. 
			.useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE, Format.TXT));
	}

	/**
	 * Returns a factory that provides a configuration (above) and one or more
	 * steps files. 
	 */
	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), steps);
	}
}
