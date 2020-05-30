package ru.ruslasib.study.wiley.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StudentsPage extends PageObject {

  public StudentsPage(WebDriver wd) {
    super(wd);
  }

  private String url = "https://www.wiley.com/en-us/students";

  @FindBy(xpath = "//*[@id=\"breadcrumbStyle\"]/li[2]")
  private WebElement header;

  @FindBy(xpath = "/html/body/main/div[2]/div/div[3]/div/p[15]/a")
  private WebElement learnMoreOfBeYorBestSectionLink;

  @FindBy(xpath = "/html/body/main/div[2]/div/div[3]/div/p[15]/a/span/span")
  private WebElement learnMoreOfBeYorBestSectionName;

  public String url() {
    return url;
  }

  public String headerName() {
    return header.getText();
  }

  public String learnMoreOfBeYourBestSectionLink() {
    return learnMoreOfBeYorBestSectionLink.getAttribute("href");
  }

  public String learnMoreOfBeYourBestSectionName() {
    return learnMoreOfBeYorBestSectionName.getText();
  }

  public By learnMoreOfBeYourBest() {
    return locatorOf(learnMoreOfBeYorBestSectionName);
  }
}
