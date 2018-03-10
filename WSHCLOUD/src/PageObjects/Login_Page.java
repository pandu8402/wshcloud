package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login_Page 
{
   final WebDriver driver;
   
   @FindBy(how = How.ID, using = "userName")
   public static WebElement txtUserName;
   
   @FindBy(how = How.ID, using = "password")
   public static WebElement txtPassword;
   
   @FindBy(how = How.ID, using = "login")
   public static WebElement btnLogin;
   
   
   public Login_Page(WebDriver driver)
   {
	   this.driver = driver;
   }
   
   //Login action
   public static void LogIn_Action(String sUserName, String sPassword)
   {	   
	 txtUserName.sendKeys(sUserName);
     txtPassword.sendKeys(sPassword);
     btnLogin.click();
   }    
}
