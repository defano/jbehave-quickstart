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

/**
 * This class provides "boilerplate" functionality to wrap JBehave in JUnit. Extend a steps class
 * with this abstract base class to make the steps class look like a JUnit. Then, you can execute
 * your steps class using any toolset that supports JUnit (for example, in Eclipse, you could right-click
 * the steps class and choose Run As-->JUnit Test).
 * 
 * @author mattd
 */
@Ignore
public abstract class JBehaveJUnitTest extends JUnitStory {

	/**
	 * All JBehave steps classes (that is, those which provide methods annotated with given/when/then) must
	 * implement this method. This enables us--the superclass--to register our subclass as the candidate steps 
	 * used for behavioral testing. (Essentially, this technique works around Java's inability to reference a 
	 * subclass from within a superclass.)
	 * 
	 * @return An instance of the class implementing the given/when/then methods for a story; typically, 'this'.	 
	 */	
	public abstract Object getStepsClass();

	/**
	 * Returns a default JBehave configuration (this configuration will apply to all steps classes
	 * that extend us).
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
	 * Returns a factory that provides a configuration (above) and one or more steps files. 
	 */
	@Override
	public InjectableStepsFactory stepsFactory() {
		
		// Ask the subclass for the candidate steps object--we're assuming the subclass *is* the candidate steps class.
		Object steps = getStepsClass();
		
		if (steps == null)
			throw new RuntimeException("Steps class is null. Assure that steps class has implemented getStepsClass() and that it returns 'this'.");
		
		return new InstanceStepsFactory(configuration(), steps);
	}
}
