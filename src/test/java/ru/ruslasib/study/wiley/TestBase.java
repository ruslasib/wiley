package ru.ruslasib.study.wiley;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.ruslasib.study.wiley.pages.HomePage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase {
  static WebDriver wd;
  static HomePage homePage;

  @BeforeClass
  public static void setUp() {
    String chromeDriverPath = System.getProperty("user.dir") + "\\src\\test\\java\\ru\\ruslasib\\study\\wiley\\resourses\\chromedriver.exe";
    System.setProperty("webdriver.chrome.driver", chromeDriverPath);
    wd = new ChromeDriver();
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
