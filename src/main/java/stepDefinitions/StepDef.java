package stepDefinitions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LaptopBagPage;
import testBase.TestBase;

public class StepDef
{
	WebDriver dr;
	HomePage homePage=new HomePage(dr);
	LaptopBagPage laptopbagpage=new LaptopBagPage(dr);
	
	@Given("Launch Browser and navigate to amazon website and verify the title")
	public void Launch_Browser_and_navigate_to_amazon_website_and_verify_the_title()
	{
		TestBase.OpenBrowser();
		String ActualHomePageTitle=TestBase.dr.getTitle();
		System.out.println("ACT_title = "+ActualHomePageTitle);
		System.out.println("EXP_title = "+TestBase.ExpectedHomePageTitle);
		Assert.assertEquals(ActualHomePageTitle,TestBase.ExpectedHomePageTitle);
	}
	
	@And("search for particular product")
	public void search_for_particular_product()
	{
		homePage.searchforproduct();
		String productPageTitle=TestBase.dr.getTitle();
		System.out.println("Product Page Title = "+productPageTitle);
		
	}
	
	@When("user selects and adds a product to the cart")
	public void user_selects_and_adds_a_product_to_the_cart() throws InterruptedException
	{
		laptopbagpage.ClickOnBag();
		laptopbagpage.additemtoCart();
	}
	
	@Then("Verify whether selected product added to the cart or not")
	public void Verify_whether_selected_product_added_to_the_cart_or_not()
	{
		if(laptopbagpage.bagTitlefromProductPage.equals(laptopbagpage.bagtitlefromCartPage))
		{
			System.out.println("Laptop Bag Titles from products page & cart page are equal");
		}
		else
		{
			System.out.println("!!!!! Laptop Bag Titles are not equal.");
		}
		//TestBase.teardown();
	}
}