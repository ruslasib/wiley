package ru.ruslasib.study.wiley;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WhoWeServeItemsTest extends TestBase {

  @Test
  public void testWhoWeServeItems() {
    WebElement element = wd.findElement(By.linkText("WHO WE SERVE"));
    Actions actions = new Actions(wd);
    actions.moveToElement(element).build().perform();

  }
}
