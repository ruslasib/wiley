package ru.ruslasib.study.wiley.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

  protected WebDriver wd;

  public PageObject(WebDriver wd) {
    this.wd = wd;
    PageFactory.initElements(wd, this);
  }
}
