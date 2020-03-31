package ru.ruslasib.study.wiley.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

  protected WebDriver wd;

  public PageObject(WebDriver wd) {
    this.wd = wd;
    PageFactory.initElements(wd, this);
  }

  public void scrollDownTo(WebElement element) throws InterruptedException {
      Point requiredElement = element.getLocation();
      JavascriptExecutor jse = (JavascriptExecutor) wd;
      jse.executeScript("window.scrollBy(0,"+(requiredElement.getY())+");");
      Thread.sleep(1000);
  }
}
