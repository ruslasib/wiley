package ru.ruslasib.study.wiley.pages.education;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ruslasib.study.wiley.pages.PageObject;

import java.util.List;

public class SubjectsSidePanel extends PageObject {

  public SubjectsSidePanel(WebDriver wd) {
    super(wd);
  }

  @FindBy(xpath = "/html/body/main/div[3]/div/div/div[4]/div[1]/ul/li")
  private WebElement items;

  public String[] itemsNames() {
    List<WebElement> elements = wd.findElements(locatorOf(items));
    String[] elementsNames = new String[elements.size()];
    for (int i = 0; i < elements.size(); i++) {
      elementsNames[i] = elements.get(i).getText();
    }
    return elementsNames;
  }
}
