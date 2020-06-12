package ru.ruslasib.study.wiley.pages.searchresults;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ruslasib.study.wiley.pages.models.Items;
import ru.ruslasib.study.wiley.pages.PageObject;

public class SearchResults extends PageObject {

  public SearchResults(WebDriver wd) {
    super(wd);
  }

  @FindBy(xpath = "//*[@id=\"ui-id-2\"]/section[1]/div/div/a/span")
  WebElement suggestionsList;

  public Items suggestionsItems() {
    return getItems(suggestionsList);
  }

  @FindBy(xpath = "//*[@id=\"ui-id-2\"]/section[2]/div/div/a/span")
  WebElement productsList;

  public Items productsItems() {
    return getItems(productsList);
  }
}