package ru.ruslasib.study.wiley.pages.searchresults;

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
    List<WebElement> elements = wd.findElements(locatorOf(suggestionsList));
    List<String> elementsNames = new ArrayList<String>();
    for (WebElement element : elements) {
      elementsNames.add(element.getText());
    }
    return new Items(elementsNames);
  }
}