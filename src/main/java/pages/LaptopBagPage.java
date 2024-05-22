package pages;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import testBase.TestBase;

public class LaptopBagPage 
{
	WebDriver dr;
	public String bagTitlefromProductPage;
	Set<String> windows=new HashSet<String>();
	public String bagtitlefromCartPage;
	
	By selectBag=By.xpath("//img[@data-image-index='1']");
	By addtoCartButton=By.xpath("//input[@id='add-to-cart-button']");
	By titlefromProductPage=By.xpath("//span[@id='productTitle']");
	By addtoCartBtn=By.xpath("//input[@id='add-to-cart-button']");
	By cartimg=By.xpath("//div[@id='nav-cart-count-container']");
	By titlefromCartPage=By.xpath("(//span[@class='a-truncate-cut'])[1]");
	
	public LaptopBagPage(WebDriver dr)
	{
		this.dr=dr;
	}
	
	public void ClickOnBag()
	{
		System.out.println("mainWindowHandle = "+TestBase.mainWindowHandle);
		
		TestBase.dr.findElement(selectBag).click();
		
		windows=TestBase.dr.getWindowHandles();
		System.out.println(windows);
		for(String s:windows)
		{
			if(!s.equals(TestBase.mainWindowHandle))
			{
				TestBase.dr.switchTo().window(s);
			}
		}
		bagTitlefromProductPage=TestBase.dr.findElement(titlefromProductPage).getText();
		System.out.println(bagTitlefromProductPage);
		
	}
	
	public void additemtoCart() throws InterruptedException
	{
		TestBase.dr.findElement(addtoCartBtn).click();
		Thread.sleep(4000);
		TestBase.dr.findElement(cartimg).click();
		bagtitlefromCartPage=TestBase.dr.findElement(titlefromCartPage).getText();
		System.out.println(bagtitlefromCartPage);
	}
	
}