package ru.ruslasib.study.wiley.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ruslasib.study.wiley.pages.PageObject;

public class SearchBar extends PageObject {

  public SearchBar(WebDriver wd) {
    super(wd);
  }

  @FindBy(xpath = "//*[.='Search']")
  private WebElement searchBtn;

  public void clickSearchBtn() {
    searchBtn.click();
  }

  @FindBy(id = "js-site-search-input")
  private WebElement inputField;

  public void inputSerchRequest(String input) {
    inputField.sendKeys(input);
  }
}
