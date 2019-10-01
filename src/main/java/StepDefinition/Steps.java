package StepDefinition;		
import java.util.concurrent.TimeUnit;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;

/* 
 * Maven java 8
 * Chrome version 71.0.3578.98 (Official Build) (64-bit)
 * Selenium 3.0.1
 * Cucumber 1.2.5
 * Junit 4.11
 */

public class Steps {				
    static WebDriver driver; 
    //Open chrome signup site
    @Given("^Open the Chrome and open google site$")				
    public void Open_the_Chrome_and_open_google_site() throws Throwable							
    {		
    	driver = new ChromeDriver();
    	driver.get("https://accounts.google.com/SignUp");
    }		
    
    // Enter all creation data
    @When("^Fill all required fields$")					
    public void Fill_all_required_fields() throws Throwable 							
    {		
       driver.findElement(By.id("firstName")).sendKeys("Hala");	
       driver.findElement(By.id("lastName")).sendKeys("Mohamed");
       driver.findElement(By.id("username")).sendKeys("halamohamed86757556");
       driver.findElement(By.name("Passwd")).sendKeys("halamohamed12345");
       driver.findElement(By.name("ConfirmPasswd")).sendKeys("halamohamed12345");
      
    }		
    
    // After fill all fields click on signup button
    @Then("^Click on signup button$")					
    public void Click_on_signup_button() throws Throwable 							
    {   
    	driver.findElement(By.xpath("//*[@id='accountDetailsNext']/content/span")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);				
    }	
    
    // Enter phone number then confirmation code
    // Note: in this section confirmation code is fake, So from this part script will be stopped 
    @And("^Enter user phone and confirmation code$")					
    public void Enter_user_phone_and_confirmation_code() throws Throwable 							
    {    		
    	driver.findElement(By.id("phoneNumberId")).sendKeys("01116844320");
        driver.findElement(By.xpath("//*[@id='gradsIdvPhoneNext']/content/span")).click();
        driver.findElement(By.id("code")).sendKeys("172978");
        driver.findElement(By.xpath("//*[@id='gradsIdvVerifyNext']/content/span")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);				
    }
    
    
    // Enter the rest of creation data (birthday and gender)
    @And("^Complete user data birthday and gender$")					
    public void Complete_user_data_birthday_and_gender() throws Throwable 							
    {    
    	driver.findElement(By.id("day")).sendKeys("19");
        driver.findElement(By.xpath("//*[@id='month']/option[9]")).click();
        driver.findElement(By.id("year")).sendKeys("1994");
        driver.findElement(By.xpath("//*[@id='gender']/option[2]")).click();
        driver.findElement(By.xpath("//*[@id='personalDetailsNext']/content/span")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);			
    }
    
    // Accept terms and click Ok
    @Then ("^Accept creation terms$")					
    public void Accept_creation_terms() throws Throwable 							
    {    		
    	driver.findElement(By.xpath("//*[@id='phoneUsageNext']/content/span")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='termsofserviceNext']/content/span")).click();
        				
    }
    
    // Here it will open signIn site 
    @Given("^Open SignIn site$")					
    public void Open_SignIn_site() throws Throwable 							
    {    		
    	driver.navigate().to("https://accounts.google.com/ServiceLogin/identifier?flowName=GlifWebSignIn&flowEntry=AddSession");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);					
    } 
    
    // Enter the created email and password
    @When ("^Enter email and password$")					
    public void Enter_email_and_password() throws Throwable 							
    {    		
        driver.findElement(By.id("identifierId")).sendKeys("halamohamed86757556");
        driver.findElement(By.xpath("//*[@id='identifierNext']/content/span")).click();
        driver.findElement(By.name("password")).sendKeys("halamohamed12345");				
    }
    
    
    // Click on login button
    @Then ("^SignIn with new credentials$")					
    public void SignIn_with_new_credentials() throws Throwable 							
    {    		
    	driver.findElement(By.xpath("//*[@id='passwordNext']/content/span")).click();					
    }
}