package ru.ruslasib.study.wiley.pages.students;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ruslasib.study.wiley.pages.PageObject;

public class BeYourBest extends PageObject {

  public BeYourBest(WebDriver wd) {
    super(wd);
  }

  @FindBy(xpath = "/html/body/main/div[2]/div/div[3]/div/p[15]/a")
  private WebElement learnMoreLink;

  @FindBy(xpath = "/html/body/main/div[2]/div/div[3]/div/p[15]/a/span/span")
  private WebElement learnMoreName;

  public String learnMoreLink() {
    return learnMoreLink.getAttribute("href");
  }

  public String learnMoreName() {
    return learnMoreName.getText();
  }

  public By learnMore() {
    return locatorOf(learnMoreName);
  }
}
