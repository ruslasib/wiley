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

  @FindBy(xpath = "//div[@class='products-list']/section/div/h3")
  private WebElement names;

  public Items names() {
    return getItems(names);
  }

  @FindBy(xpath = "//div[@class='products-list']//section//span[@class='pr-not-available']")
  // "//*[@id=\"eBundlePlpTabMainTabPanel\"]/div/div[1]/div/div/div[last()]"
  private WebElement productNotAvailable;

  public Items productNotAvailable() {
    return getItems(productNotAvailable);
  }

  @FindBy(xpath = "//*[contains(text(), 'cart')]")
  private WebElement addToCart;

  public Items addToCart() {
    return getItems(addToCart);
  }
}
