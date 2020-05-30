package ru.ruslasib.study.wiley.pages.education;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ruslasib.study.wiley.pages.PageObject;

public class EducationPage extends PageObject {

  public EducationPage(WebDriver wd) {
    super(wd);
  }

  public SubjectsSidePanel subjectsSidePanel = new SubjectsSidePanel(wd);

  @FindBy(xpath = "//*[@id=\"breadcrumbStyle\"]/li[3]")
  private WebElement header;

  public String headerName() {
    return header.getText();
  }
}
