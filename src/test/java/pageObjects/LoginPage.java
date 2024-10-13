package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver ldriver;

    public LoginPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    @FindBy(id ="Email")
    WebElement txtEmail;
    @FindBy(id = "Password")
    WebElement txtPassword ;
    @FindBy (xpath = "//button[@type='submit']")
    WebElement Loginbtn ;

    @FindBy(linkText ="Logout")
    WebElement Logoutlnk;

   public void setUserName(String uname) {
       txtEmail.clear();
       txtEmail.sendKeys(uname);
   }
   public void setTxtPassword(String pwd) {
       txtPassword.clear();
       txtPassword.sendKeys(pwd);
   }
   public void clickLogin(){
        Loginbtn.click();
    }
public void clickLogout() {
    Logoutlnk.click();
}


}


