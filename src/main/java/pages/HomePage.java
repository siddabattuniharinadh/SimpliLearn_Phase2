package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testBase.TestBase;
public class HomePage
{
	WebDriver dr;
	//public WebElement searchBox;
	By searchBox=By.id("twotabsearchtextbox");
	public HomePage(WebDriver dr)
	{
		this.dr=dr;
	}
	public void searchforproduct()
	{
		TestBase.dr.findElement(searchBox).sendKeys(TestBase.searhProduct);
		TestBase.dr.findElement(searchBox).submit();
	}
	
}