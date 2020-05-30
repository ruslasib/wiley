package ru.ruslasib.study.wiley.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EducationPage extends PageObject {

  public EducationPage(WebDriver wd) {
    super(wd);
  }

  @FindBy(xpath = "//*[@id=\"breadcrumbStyle\"]/li[3]")
  private WebElement header;

  public String headerName() {
    return header.getText();
  }
}
