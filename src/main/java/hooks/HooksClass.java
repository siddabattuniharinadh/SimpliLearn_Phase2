package hooks;

import java.io.IOException;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import testBase.TestBase;

public class HooksClass 
{		
	
	int i=1;
	@BeforeStep
	public void before()
	{
		System.out.println(" ***** Execution Started ***** ");
	}
	@AfterStep
	public void after() throws IOException, InterruptedException
	{
		System.out.println(" ***** Execution Completed ***** ");
		Thread.sleep(1000);
		TestBase.getSS("./ScreenShots/Screenshot"+i+".png");
		//System.out.println("ScreenShot Captured Successfully");
		//System.out.println(i);
		i=i+1;
	}
	
	
}