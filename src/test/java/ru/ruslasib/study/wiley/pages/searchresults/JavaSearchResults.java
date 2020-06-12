package ru.ruslasib.study.wiley.pages.searchresults;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ruslasib.study.wiley.pages.PageObject;

import java.util.ArrayList;
import java.util.List;

public class JavaSearchResults extends PageObject {

  public JavaSearchResults(WebDriver wd) {
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

  @NotNull
  private Items getItems(WebElement webElement) {
    try {
      List<WebElement> elements = wd.findElements(locatorOf(webElement));
      List<String> elementsNames = new ArrayList<String>();
      for (WebElement element : elements) {
        elementsNames.add(element.getText());
      }
      return new Items(elementsNames);
    } catch (ArrayIndexOutOfBoundsException ex) {
      return new Items();
    }
  }
}