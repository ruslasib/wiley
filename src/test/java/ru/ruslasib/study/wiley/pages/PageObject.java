package ru.ruslasib.study.wiley.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

  protected WebDriver wd;

  public PageObject(WebDriver wd) {
    this.wd = wd;
    PageFactory.initElements(wd, this);
  }

  public void scrollDown() throws InterruptedException {
    Point hoverItem = wd.findElement(By.xpath("/html/body/main/div[2]/div/div[3]/div/p[15]/a")).getLocation();
    ((JavascriptExecutor)wd).executeScript("return window.title;");
    Thread.sleep(6000);
    ((JavascriptExecutor)wd).executeScript("window.scrollBy(0,"+(hoverItem.getY())+");");
  }
}
