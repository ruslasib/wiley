package ru.ruslasib.study.wiley.pages;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.ruslasib.study.wiley.pages.models.Items;

import java.util.ArrayList;
import java.util.List;

public abstract class PageObject {

  protected WebDriver wd;

  public PageObject(WebDriver wd) {
    this.wd = wd;
    PageFactory.initElements(wd, this);
  }

  @FindBy(id = "wileyLogo")
  private WebElement logo;

  public void clickLogo() {
    logo.click();
  }

  public void scrollTo(By locator) {
    Point requiredElement = wd.findElement(locator).getLocation();
    JavascriptExecutor jse = (JavascriptExecutor) wd;
    jse.executeScript("window.scrollBy(0," + (requiredElement.getY()) + ");");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }
  }

  public By locatorOf(WebElement element) {
    By by = null;

    String[] elementToArray = element.toString()
            .substring(0, element.toString().length() - 1) // remove last "]"
            .split("->")[1].split(":");
    String selector = elementToArray[0].trim().replace(":", "");
    String value = elementToArray[1].trim();

    // TODO replace to switch-case. It didn't work for string when I wrote it
    if (selector.equals("id")) {
      by = By.id(value);
    } else if (selector.equals("className")) {
      by = By.className(value);
    } else if (selector.equals("xpath")) {
      by = By.xpath(value);
    } else if (selector.equals("cssSelector")) {
      by = By.cssSelector(value);
    } else if (selector.equals("linkText")) {
      by = By.linkText(value);
    } else if (selector.equals("name")) {
      by = By.name(value);
    } else if (selector.equals("partialLinkText")) {
      by = By.partialLinkText(value);
    } else if (selector.equals("tagName")) {
      by = By.tagName(value);
    }
    return by;
  }

  public String xpathOf(WebElement suggestionsList) {
    String[] str = suggestionsList.toString().split(" ");
    String last = str[str.length - 1];
    return last.substring(0, last.length() - 1);
  }

  @NotNull
  protected Items getItems(WebElement webElement) {
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
