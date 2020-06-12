package ru.ruslasib.study.wiley.pages.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ruslasib.study.wiley.pages.models.Items;
import ru.ruslasib.study.wiley.pages.PageObject;

public class ProductsItems extends PageObject {

  public ProductsItems(WebDriver wd) {
    super(wd);
  }

  @FindBy(xpath = "//*[@id=\"search-result-page-row\"]/div[3]/div/div[3]/div/div/div/div[3]/section/div[2]/h3/a")
  WebElement names;

  public Items names() {
    return getItems(names);
  }

  @FindBy(xpath = "//*[@id=\"tabContentStyle\"]/div/div/div/div[6]")
  private WebElement addtoCartList;

  public Items addtoCartList() {
    System.out.println(addtoCartList.getText());
    return getItems(addtoCartList);
  }
}
