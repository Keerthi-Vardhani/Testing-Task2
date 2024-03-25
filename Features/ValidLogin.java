import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidLogin {
	WebDriver driver;
	@Given("User is on Home Page")
	public void user_is_on_home_page() {
		System.out.println("Given Executed...");
		  System.setProperty("webdriver.chrome.driver","C:/Users/Keerthi Vardhani/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		  driver= new ChromeDriver();					
		  driver.manage().window().maximize();			
		  driver.get("https://tutorialsninja.com/demo/");

	}

	@When("User navigate to Login Page")
	public void user_navigate_to_login_page() {
			WebElement myAccount = driver.findElement(By.xpath("//a[@title='My Account']"));
	        myAccount.click();

	        // Locate and click the "Login" link within the dropdown menu
	        WebElement loginLink = driver.findElement(By.xpath("//a[@href='https://tutorialsninja.com/demo/index.php?route=account/login']"));
	        loginLink.click();

	}

	@Then("User enters {string} and {string} Keeping case as Valid")
	public void user_enters_and_keeping_case_as_valid(String string, String string2) {
		System.out.println("When Executed...");
	    WebElement ur=driver.findElement(By.id("input-email"));
	    ur.sendKeys(string);
	    WebElement ps=driver.findElement(By.id("input-password"));
	    ps.sendKeys(string2);
	}
	@Then("User enters {string} and {string} Keeping case as InValid")
    public void user_enters_invalid_credentials(String username, String password) {
        WebElement ur = driver.findElement(By.id("input-email"));
        ur.sendKeys(username);
        WebElement ps = driver.findElement(By.id("input-password"));
        ps.sendKeys(password);
    }

	@Then("User should get logged in")
	public void user_should_get_logged_in() {
		WebElement loginButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));
	    loginButton.click();
	    String expectedURL="https://tutorialsninja.com/demo/index.php?route=account/account";
	    String actualURL=driver.getCurrentUrl();
	    System.out.println("Actual URL"+actualURL);
	    Assert.assertEquals(expectedURL,actualURL);
	}

	@Then("Message displayed Login Successfully")
	public void message_displayed_login_successfully() {
		
	    System.out.println("Login Successfull");
		
	}
	@Then("user will be asked to go back to login page")
    public void user_will_be_asked_to_go_back_to_login_page() {
		WebElement loginButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));
	    loginButton.click();
	    String expectedURL="https://tutorialsninja.com/demo/index.php?route=account/account";
	    String actualURL=driver.getCurrentUrl();
	    System.out.println("Actual URL"+actualURL);
	    Assert.assertEquals(expectedURL,actualURL);
	    WebElement warningmessage=driver.findElement(By.className("alert alert-danger alert-dismissible"));
	    if(warningmessage.isDisplayed()) {
	    	driver.get(actualURL);
	    }
	    
    }

    @Then("Provide correct credentials")
    public void provide_correct_credentials() {
    	System.out.println("Failed to login please Provide correct credentials");
    	
    }
}
