package ru.ruslasib.study.wiley;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class NavigationPanelTest {

  @Test
  public void testNavigationPanel(By locator) {
    String chromeDriverPath = System.getProperty("user.dir") + "\\src\\test\\java\\ru\\ruslasib\\study\\wiley\\resourses\\chromedriver.exe";
    System.setProperty("webdriver.chrome.driver", chromeDriverPath);
    WebDriver wd = new ChromeDriver();
    wd.manage().window().maximize();
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wd.get("https://www.wiley.com/en-us");
    wd.findElement(By.xpath("//*[@id=\"country-location-form\"]/div[3]/button[2]")).click();

    System.out.println("Text: " + wd.findElement(By.linkText("WHO WE SERVE")).getText());


    public boolean isElementPresent(By locator) {
      wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
      List<WebElement> webElementList = wd.findElements(locator);
      if (webElementList.size() > 0) {
        return true;
      }
      return false;
    }
  }
}
