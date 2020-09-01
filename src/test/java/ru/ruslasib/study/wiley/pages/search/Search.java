package ru.ruslasib.study.wiley.pages.search;

import org.openqa.selenium.WebDriver;
import ru.ruslasib.study.wiley.pages.PageObject;

public class Search extends PageObject {

  public Search(WebDriver wd) {
    super(wd);
  }

  private ProductsItems productsItems = new ProductsItems(wd);

  public ProductsItems productsItems() {
    return productsItems;
  }
}
