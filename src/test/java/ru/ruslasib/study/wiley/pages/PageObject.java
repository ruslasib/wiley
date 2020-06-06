package ru.ruslasib.study.wiley.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

  protected WebDriver wd;

  public PageObject(WebDriver wd) {
    this.wd = wd;
    PageFactory.initElements(wd, this);
  }

  public void scrollTo(By locator) {
    Point requiredElement = wd.findElement(locator).getLocation();
    JavascriptExecutor jse = (JavascriptExecutor) wd;
    jse.executeScript("window.scrollBy(0," + (requiredElement.getY()) + ");");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }
  }

  public By locatorOf(WebElement element) {
    By by = null;

    String[] elementToArray = element.toString()
            .substring(0, element.toString().length() - 1) // remove last "]"
            .split("->")[1].split(":");
    String selector = elementToArray[0].trim().replace(":", "");
    String value = elementToArray[1].trim();

    // TODO replace to switch-case. It didn't work for string when I wrote it
    if (selector.equals("id")) {
      by = By.id(value);
    } else if (selector.equals("className")) {
      by = By.className(value);
    } else if (selector.equals("xpath")) {
      by = By.xpath(value);
      System.out.println(by);
    } else if (selector.equals("cssSelector")) {
      by = By.cssSelector(value);
    } else if (selector.equals("linkText")) {
      by = By.linkText(value);
    } else if (selector.equals("name")) {
      by = By.name(value);
    } else if (selector.equals("partialLinkText")) {
      by = By.partialLinkText(value);
    } else if (selector.equals("tagName")) {
      by = By.tagName(value);
    }
    return by;
  }
}
