package ru.ruslasib.study.wiley.pages.students;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ruslasib.study.wiley.pages.PageObject;

public class StudentsPage extends PageObject {

  public StudentsPage(WebDriver wd) {
    super(wd);
  }

  private BeYourBest beYourBest = new BeYourBest(wd);

  public BeYourBest beYourBest() {
    return beYourBest;
  }

  private String url = "https://www.wiley.com/en-us/students";

  @FindBy(xpath = "//*[@id=\"breadcrumbStyle\"]/li[2]")
  private WebElement header;

  public String url() {
    return wd.getCurrentUrl();
  }

  public String headerName() {
    return header.getText();
  }
}
