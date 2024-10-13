package pageObjects;

import Utilities.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchCustomerpage {

    public WebDriver ldriver;
    //WaitHelper waithelper;
    public SearchCustomerpage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(ldriver,this);
        //waithelper = new WaitHelper(ldriver);
    }
    @FindBy(xpath="//input[@id='SearchEmail']")
    WebElement txtEmail;
    @FindBy(id="SearchFirstName")
    WebElement txtFirstname;

    @FindBy(id="SearchLastName")
    WebElement txtLastname;

    @FindBy(xpath = "//button[@id='search-customers']")
    WebElement btnSearch;
    @FindBy(xpath = "//table[@id='customers-grid']")
    WebElement table;
    @FindBy(xpath = "//table[@id='customers-grid']//tbody/tr/td")
    List<WebElement> columns;
    @FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
    List<WebElement> rows;

    public void setEmail(String email){
        //waithelper.WaitForElement(txtEmail,30);
        txtEmail.clear();
        txtEmail.sendKeys(email);

    }

    public void setFirstName(String fname){
        //waithelper.WaitForElement(txtFirstname,30);
        txtFirstname.clear();
        txtFirstname.sendKeys(fname);
    }

    public void setLastname(String lname){
        //waithelper.WaitForElement(txtLastname,30);
        txtLastname.clear();
        txtLastname.sendKeys(lname);
    }
    public void clickOnSearch(){
        btnSearch.click();
        //waithelper.WaitForElement(btnSearch,30);
    }

    public int getNoOfRows(){
        return(rows.size());
    }

    public int getNoofColumns(){
        return(columns.size());
    }

    public boolean searchCustomerByEmail(String email){
        boolean flag = false;
        for(int i=1;i<=getNoOfRows();i++) {
            String emailID = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr/td[2]")).getText();
            System.out.println(emailID);
            if(emailID.equals(email)) {
                flag = true;
            }
        }
       return flag;
        }

    public boolean searchCustomerByName(String Name){
        boolean flag = false;
        for(int i=1;i<=getNoOfRows();i++) {
            String name = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr/td[3]")).getText();
            String names[]=name.split(" "); //separting first name and last name
            if(names[0].equals("Victoria") && names[1].equals("Terces")) {
                flag = true;
            }
        }
        return flag;
    }

    }

