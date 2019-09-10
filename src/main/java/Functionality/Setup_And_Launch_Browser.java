package Functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Setup_And_Launch_Browser {

    public WebDriver driver;

    @FindBy(xpath = "/html//table[@class='smart-table table table-striped']")
    private
    WebElement UserTable;
    //Page URL
    private static String PAGE_URL = "http://www.way2automation.com/angularjs-protractor/webtables/";

    //Constructor
    public Setup_And_Launch_Browser(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }
    public void Verify_Correct_User_Table()
    {
        WebDriverWait user_table = new WebDriverWait(driver,10);
        user_table.until(ExpectedConditions.visibilityOf(UserTable));
        Assert.assertTrue(UserTable.isDisplayed());
    }


}


