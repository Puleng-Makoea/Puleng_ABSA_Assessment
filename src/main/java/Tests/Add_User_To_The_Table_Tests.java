package Tests;

import Functionality.Add_New_User;
import Functionality.Setup_And_Launch_Browser;
import Helpers.ExtentReportClass;
import com.aventstack.extentreports.Status;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;

public class Add_User_To_The_Table_Tests extends ExtentReportClass {

    private WebDriver driver;
    private static String dir = System.getProperty("user.dir");
    private static final String Chromedriver = dir + "/src/main/java/Drivers/chromedriver.exe";
    private static final String excel = dir + "/src/main/java/TestData/TestData.xlsx";

    @BeforeTest(description = "this method will do the setup with correct chromedriver")
    public void setup_test()
    {
        System.setProperty("webdriver.chrome.driver", Chromedriver);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver(options);

    }
    @Test(priority = 1,description = "Add the user to the User Table")
    public void Add_New_User_One() throws IOException {
        test = extent.createTest("Test To Check User Is Added Correctly To User Table ", "Add User To User Table");
        test.log(Status.PASS, "Add User To User Table Test Started");

        Add_New_User add_user= PageFactory.initElements(driver,Add_New_User.class);
        FileInputStream fis = new FileInputStream(excel);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        String first_name = sheet.getRow(1).getCell(0).getStringCellValue();
        String last_name = sheet.getRow(1).getCell(1).getStringCellValue();
        String user_name = sheet.getRow(1).getCell(2).getStringCellValue();
        String pass_word = sheet.getRow(1).getCell(3).getStringCellValue();
        String email = sheet.getRow(1).getCell(4).getStringCellValue();
        String cellphone = sheet.getRow(1).getCell(5).getStringCellValue();
        test.log(Status.PASS, "Click Add New User Button");
        add_user.Click_Add_New_User_Button();
        test.log(Status.PASS, "Populate First Name Field");
        add_user.Populate_First_Name(first_name);
        test.log(Status.PASS, "Populate Last Name Field");
        add_user.Populate_Last_Name(last_name);
        test.log(Status.PASS, "Populate User Name Field");
        add_user.Populate_UserName(user_name);
        test.log(Status.PASS, "Populate Password Field");
        add_user.Populate_Password(pass_word);
        test.log(Status.PASS, "Select Customer Radio Button");
        add_user.Populate_Customer();
        test.log(Status.PASS, "Select Role From DropDown");
        add_user.Populate_Role();
        test.log(Status.PASS, "Populate Email Field");
        add_user.Populate_Email(email);
        test.log(Status.PASS, "Populate CellPhone Field");
        add_user.Populate_Mobile_Phone(cellphone);
        test.log(Status.PASS, "ClickSave Button");
        add_user.Click_Button_Save();
        test.log(Status.PASS, "Add User To User Table Test Completed Successfully");
    }
    @Test(priority = 3,description = "Add the user to the User Table")
    public void Add_New_User_Two() throws IOException {
        test = extent.createTest("Test To Check User Is Added Correctly To User Table ", "Add User To User Table");
        test.log(Status.PASS, "Add User To User Table Test Started");

        Add_New_User add_user= PageFactory.initElements(driver,Add_New_User.class);
        FileInputStream fis = new FileInputStream(excel);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        String first_name = sheet.getRow(2).getCell(0).getStringCellValue();
        String last_name = sheet.getRow(2).getCell(1).getStringCellValue();
        String user_name = sheet.getRow(2).getCell(2).getStringCellValue();
        String pass_word = sheet.getRow(2).getCell(3).getStringCellValue();
        String email = sheet.getRow(2).getCell(4).getStringCellValue();
        String cellphone = sheet.getRow(2).getCell(5).getStringCellValue();
        test.log(Status.PASS, "Click Add New User Button");
        add_user.Click_Add_New_User_Button();
        test.log(Status.PASS, "Populate First Name Field");
        add_user.Populate_First_Name(first_name);
        test.log(Status.PASS, "Populate Last Name Field");
        add_user.Populate_Last_Name(last_name);
        test.log(Status.PASS, "Populate User Name Field");
        add_user.Populate_UserName(user_name);
        test.log(Status.PASS, "Populate Password Field");
        add_user.Populate_Password(pass_word);
        test.log(Status.PASS, "Select Customer Radio Button");
        add_user.Populate_Customer();
        test.log(Status.PASS, "Select Role From DropDown");
        add_user.Populate_Role();
        test.log(Status.PASS, "Populate Email Field");
        add_user.Populate_Email(email);
        test.log(Status.PASS, "Populate CellPhone Field");
        add_user.Populate_Mobile_Phone(cellphone);
        test.log(Status.PASS, "ClickSave Button");
        add_user.Click_Button_Save();
        test.log(Status.PASS, "Add User To User Table Test Completed Successfully");
    }
    @Test (description = "Verify that correct User Table is displayed")
    public void Check_That_User_Table_Is_Displayed()
    {
        test = extent.createTest("Test To Verify Correct User Table ", "Verify User Table");
        test.log(Status.PASS, "Verify User Table Test Started");
        test.log(Status.PASS, "Launching Browser");

        Setup_And_Launch_Browser setup_and_launch_browser =new Setup_And_Launch_Browser(driver);
        test.log(Status.PASS, "Deleting all cookies");
        setup_and_launch_browser.driver.manage().deleteAllCookies();
        test.log(Status.PASS, "Verify Correct User Table");
        setup_and_launch_browser.Verify_Correct_User_Table();
        test.log(Status.PASS, "Verify User Table Test Completed");
    }
    @Test(priority = 2,description = "Verify that user is added correctly to the table")
    public void Verify_Data_Saved_One() throws IOException, InterruptedException {
        test = extent.createTest("Test To Verify Correct Data Was Added To User Table ", "Verify User Added Correctly");
        test.log(Status.PASS, "Verify Correct USer Added Test Started");
        FileInputStream fis = new FileInputStream(excel);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Add_New_User add_user= PageFactory.initElements(driver,Add_New_User.class);
        String first_name = sheet.getRow(1).getCell(0).getStringCellValue();
        String last_name = sheet.getRow(1).getCell(1).getStringCellValue();
        test.log(Status.PASS, "Verify Correct User Added");
        add_user.Verify_Data_Saved(first_name,last_name);
        test.log(Status.PASS, "Verify Correct User Added Test Completed Successfully");
    }
    @Test(priority = 4,description = "Verify that user is added correctly to the table")
    public void Verify_Data_Saved_Two() throws IOException, InterruptedException {
        test = extent.createTest("Test To Verify Correct Data Was Added To User Table ", "Verify User Added Correctly");
        test.log(Status.PASS, "Verify Correct USer Added Test Started");
        FileInputStream fis = new FileInputStream(excel);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Add_New_User add_user= PageFactory.initElements(driver,Add_New_User.class);
        String first_name = sheet.getRow(2).getCell(0).getStringCellValue();
        String last_name = sheet.getRow(2).getCell(1).getStringCellValue();
        test.log(Status.PASS, "Verify Correct User Added");
        add_user.Verify_Data_Saved(first_name,last_name);
        test.log(Status.PASS, "Verify Correct User Added Test Completed Successfully");
    }
    @AfterTest(description = "This method will quit the driver after all the test")
    public void Exit_Test()
    {
        driver.quit();
    }
}
