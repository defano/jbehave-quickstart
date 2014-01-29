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
public abstract class JBehaveJUnitTest extends JUnitStory {

	public abstract Object getStepsClass();

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
			.useStoryReporterBuilder(new StoryReporterBuilder()
				.withDefaultFormats()
				.withFormats(Format.CONSOLE, Format.TXT)
			);
	}

	/**
	 * Returns a factory that provides a configuration (above) and one or more
	 * steps files. 
	 */
	@Override
	public InjectableStepsFactory stepsFactory() {
		
		Object steps = getStepsClass();
		
		if (steps == null)
			throw new RuntimeException("Steps class is null. Assure that steps class has implemented getStepsClass() and that it returns 'this'.");
		
		return new InstanceStepsFactory(configuration(), steps);
	}
}
