package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerpage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.openqa.selenium.By.*;
public class steps extends BaseClass{

    @Before
    public void setup() throws IOException {
        //Reading properties....
        configprop=new Properties();
        FileInputStream configpropfiles=new FileInputStream("Config.properties");
        configprop.load(configpropfiles);
        String br =configprop.getProperty("browser");

        if (br.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", configprop.getProperty("firefoxpath"));
            driver = new FirefoxDriver();
        } else if (br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", configprop.getProperty("chromepath"));
            driver = new ChromeDriver();
            
        }

    }



    @Given("User Launch Firefox browser")
    public void user_launch_firefox_browser() {
        driver.manage().window().maximize();
        lp = new LoginPage(driver);

    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
    }

    @And("When User Enter Email as {string} and password as {string}")
    public void when_user_enter_email_as_and_password_as(String email, String password) throws InterruptedException {
        lp.setUserName(email);
        lp.setTxtPassword(password);
        Thread.sleep(3000);
    }

    @And("Click on Login")
    public void click_on_login() {
        lp.clickLogin();

    }

    @Then("page titled should be {string}")
    public void page_titled_should_be(String title) throws InterruptedException {
        if (driver.getPageSource().contains("Login was unsuccessful")) {
            driver.close();
            Assert.assertTrue(false);
        } else {
            Assert.assertEquals(title, driver.getTitle());
        }
        Thread.sleep(2000);
    }

    @When("User clicks on Logout button")
    public void user_clicks_on_logout_button() throws InterruptedException {
        lp.clickLogout();
        Thread.sleep(3000);
    }

    @Then("page titled {string}")
    public void page_titled(String title) {
        if (driver.getPageSource().contains("Login was unsuccessful")) {
            driver.close();
            Assert.assertTrue(false);
        } else {
            Assert.assertEquals(title, driver.getTitle());
        }
    }

    @And("Close Browser")
    public void close_browser() {
        driver.quit();
    }
// Customers.features step def........


    @Given("When User opens URL {string}")
    public void when_user_opens_url(String url) {
        driver.get(url);

    }


    @Then("user can view page titled  {string}")
    public void user_can_view_page_titled(String string) {
        addcust= new AddCustomerPage(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration",addcust.getpagetitle());
    }
    @When("User Clicks on customer Menu")
    public void user_clicks_on_customer_menu() throws InterruptedException {
        Thread.sleep(3000);
        addcust.clickOnCustomerMenu();
    }
    @When("user clicks on customer menu item")
    public void user_clicks_on_customer_menu_item() throws InterruptedException {

        addcust.clickOnCustomerMenu_iten();
        Thread.sleep(3000);
    }
    @When("click Add Customer")
    public void click_add_customer() throws InterruptedException {
        addcust.clickOnAddBtn();
        Thread.sleep(2000);
    }
    @Then("user can view add customer page")
    public void user_can_view_add_customer_page() throws InterruptedException {
        Assert.assertEquals("Add a new customer / nopCommerce administration",addcust.getpagetitle());
        Thread.sleep(2000);
    }
    @When("User enters customer info")
    public void user_enters_customer_info() throws InterruptedException {
        String email =randomstring()+"@gmail.com";
        addcust.setEmail(email);
        addcust.setPassword("test123");
        Thread.sleep(2000);

        addcust.setFirstname("kevin");
        addcust.setLasstname("Anderson");
        addcust.setGender("Male");
        Thread.sleep(1000);
        addcust.setDob("7/27/2019");
        addcust.setCompanyname("ABC infotech");
        addcust.setCustomerRoles("Administrators");
        Thread.sleep(2000);
        addcust.setManagerofVendors("0");
        Thread.sleep(2000);
        addcust.setAdmincontent("this is for testing");
        Thread.sleep(2000);


    }
    @When("Clicks on save button")
    public void clicks_on_save_button() throws InterruptedException {
        addcust.clickSaveBtn();
        Thread.sleep(2000);
    }
    @Then("user can view confirmation msg {string}")
    public void user_can_view_confirmation_msg(String msg) {
      Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
    }

    //Steps for searching customer using Email ID.....
    @When("Enter Customer Email")
    public void enter_customer_email() throws InterruptedException {
        searchcust=new SearchCustomerpage(driver);
        searchcust.setEmail("victoria_victoria@nopCommerce.com");
        Thread.sleep(3000);
    }
    @When("Click on Search button")
    public void click_on_search_button() throws InterruptedException {
        searchcust.clickOnSearch();
        Thread.sleep(3000);

    }
    @Then("User should find the email in the search table")
    public void user_should_find_the_email_in_the_search_table() throws InterruptedException {
      boolean status =searchcust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
      Assert.assertEquals(true,status);
      Thread.sleep(3000);
    }
// steps for searching customer by first name and last name..........

    @When("Enter Customer First Name")
    public void enter_customer_first_name() throws InterruptedException {
        searchcust=new SearchCustomerpage(driver);
        searchcust.setFirstName("Victoria");
        Thread.sleep(3000);
    }
    @When("Enter Customer Last Name")
    public void enter_customer_last_name() throws InterruptedException {
        searchcust.setLastname("Terces");
        Thread.sleep(3000);
    }
    @Then("User should find the Name in the search table")
    public void user_should_find_the_name_in_the_search_table() {
        boolean status=searchcust.searchCustomerByName("Victoria Terces");
        Assert.assertTrue(status);
    }



}
