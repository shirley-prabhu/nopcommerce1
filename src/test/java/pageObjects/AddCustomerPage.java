package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage  {

WebDriver ldriver;
    public AddCustomerPage(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }
By lnkCustomers_menu = By.xpath("//a[@href='#']//*[contains(text(),'Customers')]");
   By lnkCustomers_menuitem=By.xpath("//a[@href='/Admin/Customer/List']//*[contains(text(),'Customers')]");
   By btnAddnew =By.xpath("//a[@class='btn btn-primary']");
   By txtEmail =By.xpath("//input[@id='Email']");
   By txtPassword=By.xpath("//input[@id='Password']");
   By txtCustomerRoles=By.xpath("(//div[@class='k-multiselect-wrap k-floatwrap'])[2]");
By lstitemsAdministrator =By.xpath("//li[contains(text(),'Administrators')]");
By lstitemsForumModerator=By.xpath("//li[contains(text(),'Forum Moderators')]");
By lstitemsGuests=By.xpath("//li[contains(text(),'Guests')]");
By lstitemsRegistered=By.xpath("//li[contains(text(),'Registered')]");
By lstitemsVendors=By.xpath("//li[contains(text(),'Vendors')]");
By drpMngrofVendor=By.xpath("//select[@id='VendorId']");
By rdMaleGender=By.xpath("//input[@id='Gender_Male']");
By rdFemaleGender=By.xpath("//input[@id='Gender_Female']");
By txtFirstname = By.xpath("//input[@id='FirstName']");
By txtLastname = By.xpath("//input[@id='LastName']");
By txtDob=By.xpath("//input[@id='DateOfBirth']");
By txtCompanyname =By.xpath("//input[@id='Company']");
By  txtAdmincontent=By.xpath("//textarea[@id='AdminComment']");
By btnSave=By.xpath("//button[@name='save']");

public String getpagetitle(){
    return ldriver.getTitle();
}

public void  clickOnCustomerMenu (){
    ldriver.findElement(lnkCustomers_menu).click();

}
public void clickOnCustomerMenu_iten(){
    ldriver.findElement(lnkCustomers_menuitem).click();
}
public void clickOnAddBtn(){
    ldriver.findElement(btnAddnew).click();
}
public void setEmail(String email){
    ldriver.findElement(txtEmail).sendKeys(email);
}

//Action Methods

public void setPassword(String password){

    ldriver.findElement(txtPassword).sendKeys(password);
}
public void setCustomerRoles(String roles) throws InterruptedException {
    if (!roles.equals("Vendors")) {
        ldriver.findElement(By.xpath("(//*[@id='SelectedCustomerRoleIds_taglist']/li/span)[2]"));
    }
    ldriver.findElement(txtCustomerRoles).click();
    WebElement listitem;
    Thread.sleep(2000);

    if (roles.equals("Administrators")) {
        listitem = ldriver.findElement(lstitemsAdministrator);
    } else if (roles.equals("Forum Moderators")) {
        listitem = ldriver.findElement(lstitemsForumModerator);
    } else if (roles.equals("Guests")) {
        listitem = ldriver.findElement(lstitemsGuests);
    } else if (roles.equals("Registered")) {
        listitem = ldriver.findElement(lstitemsRegistered);
    } else {
        listitem = ldriver.findElement(lstitemsGuests);
    }
    listitem.click();
}

public void setManagerofVendors(String value){

        Select drp = new Select(ldriver.findElement(drpMngrofVendor));
        drp.selectByValue(value);
    }
    public void setGender(String gender)
    {
        if(gender.equals("Male")) {
            ldriver.findElement(rdMaleGender).click();
        }
        else
                ldriver.findElement(rdFemaleGender).click();
            }


public void setFirstname(String fname)
        {
        ldriver.findElement(txtFirstname).sendKeys(fname);
            }
public void setLasstname(String lname)
        {
            ldriver.findElement(txtLastname).sendKeys(lname);
        }
public void setDob(String dob)
        {
            ldriver.findElement(txtDob).sendKeys(dob);
        }
        public void setCompanyname(String cname)
        {
            ldriver.findElement(txtCompanyname).sendKeys(cname);
        }
        public void setAdmincontent(String content)
        {
            ldriver.findElement(txtAdmincontent).sendKeys(content);
        }
public void clickSaveBtn(){

        ldriver.findElement(btnSave).click();
    }
    }







