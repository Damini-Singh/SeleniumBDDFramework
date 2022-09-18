package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.After;
import utilities.TextContextSetup;

public class Hooks {
	
	TextContextSetup textContextSetup;
	public Hooks(TextContextSetup textContextSetup) 
	{
		this.textContextSetup = textContextSetup;
	}
	
	@After
	public void AfterScenario() throws IOException, Exception
	{
		textContextSetup.testbase.webDriverManager().quit();
	}

}
