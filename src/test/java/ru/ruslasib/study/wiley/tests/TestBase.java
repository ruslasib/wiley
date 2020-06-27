package ru.ruslasib.study.wiley.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import ru.ruslasib.study.wiley.pages.search.Search;
import ru.ruslasib.study.wiley.pages.education.EducationPage;
import ru.ruslasib.study.wiley.pages.home.HomePage;
import ru.ruslasib.study.wiley.pages.searchresults.SearchResults;
import ru.ruslasib.study.wiley.pages.students.StudentsPage;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase {
  static WebDriver wd;
  static HomePage homePage;
  static StudentsPage studentsPage;
  static EducationPage educationPage;
  static SearchResults searchResults;
  static Search search;
  /**
   * operation system may be:
   * IOS
   * WINDOWS
   */
  private static String operationSystem = "WINDOWS";
  Logger log = LoggerFactory.getLogger(TestBase.class);

  @BeforeSuite
  public static void setUp() throws InterruptedException {
    wd = defineDriver(operationSystem);
    wd.manage().window().maximize();
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wd.get("https://www.wiley.com/en-us");
    closeModalWindow();
    homePage = new HomePage(wd);
    studentsPage = new StudentsPage(wd);
    educationPage = new EducationPage(wd);
    searchResults = new SearchResults(wd);
    search = new Search(wd);
    homePage.clickLogo();
  }

  private static void closeModalWindow() throws InterruptedException {
    wd.findElement(By.xpath("/html/body/main/div[1]/div/div/form/div[3]/button[2]")).click();
    Thread.sleep(2000);
  }

  @AfterSuite(alwaysRun = true)
  public static void tearDown() {
    wd.quit();
  }

  public static WebDriver defineDriver(String operationSystem) {
    String chromeDriverPath = "";
    if (operationSystem.equals("WINDOWS")) {
      chromeDriverPath = System.getProperty("user.dir") + "\\src\\test\\java\\ru\\ruslasib\\study\\wiley\\resourses\\chromedriver.exe";
      System.setProperty("webdriver.chrome.driver", chromeDriverPath);
    } else if (operationSystem.equals("IOS")) {
      chromeDriverPath = System.getProperty("user.dir") + "/src/test/java/ru/ruslasib/study/wiley/resourses/chromedriver_mac64";
      System.setProperty("webdriver.chrome.driver", chromeDriverPath);
    }
    return new ChromeDriver();
  }

  @BeforeMethod
  public void logStart(Method m) {
    homePage.clickLogo();
    log.info("Start test " + m.getName());
  }

  @AfterMethod(alwaysRun = true)
  public void logStop(Method m) {
    log.info("Stop test " + m.getName());
  }

  public boolean isElementPresent(By locator) {
    wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    List<WebElement> webElementList = wd.findElements(locator);
    if (webElementList.size() > 0) {
      return true;
    }
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    return false;
  }
}
