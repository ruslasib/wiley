package ru.ruslasib.study.wiley.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.ruslasib.study.wiley.pages.HomePage;
import ru.ruslasib.study.wiley.pages.StudentsPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase {
  static WebDriver wd;
  static HomePage homePage;
  static StudentsPage studentsPage;
  /**
   * operation system may be:
   * IOS
   * WINDOWS
   */
  private static String operationSystem = "IOS";

  @BeforeClass
  public static void setUp() {
    wd = defineDriver(operationSystem);
    wd.manage().window().maximize();
    wd.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    wd.get("https://www.wiley.com/en-us");
    wd.findElement(By.xpath("/html/body/main/div[1]/div/div/form/div[3]/button[2]")).click();
    homePage = new HomePage(wd);
  }

  @AfterClass
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
