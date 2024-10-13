package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerpage;

import java.util.Properties;


public class BaseClass {

    public WebDriver driver;
    public LoginPage lp;
    public AddCustomerPage addcust;

    public SearchCustomerpage searchcust;

    public Properties configprop;

    public static String randomstring(){

            String generatedstring1= RandomStringUtils.randomAlphabetic(5);
            return(generatedstring1);
    }


}
