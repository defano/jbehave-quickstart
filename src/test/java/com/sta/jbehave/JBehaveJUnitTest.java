package com.sta.jbehave;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

/**
 * This class provides "boilerplate" functionality to wrap JBehave inside JUnit. 
 * 
 * Extend a steps class with this abstract base class to make the steps class look like a JUnit. 
 * Then, you can execute your steps class using any toolset that supports JUnit (for example, in 
 * Eclipse, you could right-click the steps class and choose Run As-->JUnit Test).
 * 
 * @author mattd
 */
@RunWith(JUnitReportingRunner.class)
public abstract class JBehaveJUnitTest extends JUnitStory {

	/**
	 * Returns a default JBehave configuration (this configuration will apply to all steps classes
	 * that extend us).
	 */
	@Override
	public Configuration configuration() {
		
		return new MostUsefulConfiguration()		

			/* Load story files (.story) from the classpath using the same 
			 * classloader as this object. The story file should have the same
			 * name (and package location) as the steps file, but replacing
			 * each camel-case with an underscore and using .story as the
			 * file extension. For example, a steps class called MyTestCase.java
			 * would look for the stories in my_test_case.story. */
			.useStoryLoader(new LoadFromClasspath(this.getClass()))
			
			// Produce a standard report on the console and as a text file. 
			.useStoryReporterBuilder(new StoryReporterBuilder()
				.withDefaultFormats()
				.withFormats(Format.CONSOLE, Format.TXT)
			);
	}

	/**
	 * Returns a factory that provides a configuration (above) and one or more steps files. 
	 */
	@Override
	public InjectableStepsFactory stepsFactory() {		
		return new InstanceStepsFactory(configuration(), this);
	}
}
