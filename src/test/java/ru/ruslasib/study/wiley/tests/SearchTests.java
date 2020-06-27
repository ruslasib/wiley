package ru.ruslasib.study.wiley.tests;

import org.testng.annotations.Test;
import ru.ruslasib.study.wiley.pages.models.Items;
import ru.ruslasib.study.wiley.pages.search.ProductsItems;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTests extends TestBase {

  @Test
  public void testEmptySearch() {
    homePage.searchBar().inputSerchRequest("");
    homePage.searchBar().clickSearchBtn();
    assertThat(homePage.url(), equalTo("https://www.wiley.com/en-us"));
  }

  @Test
  public void testJavaSearchWithoutPressingSearchButton() {
    homePage.searchBar().inputSerchRequest("java");
    String[] suggestionsItemsExpected = {"java", "java", "java", "java"};
    Items suggestionsItemsActual = searchResults.suggestionsItems();
    assertThat(suggestionsItemsActual.size(), equalTo(4));
    assertThat(suggestionsItemsActual, equalTo(new Items(suggestionsItemsExpected)));
    assertThat(searchResults.productsItems().size(), equalTo(0));
  }

  @Test
  public void testJavaSearch() {
    homePage.searchBar().inputSerchRequest("java");
    homePage.clickSearchBtn();
    ProductsItems productsItemsNames = search.productsItems();
    assertThat(productsItemsNames.names().list().iterator().next().toLowerCase(), containsString("java"));
    assertThat(productsItemsNames.names().size(), equalTo(10));
    assertThat(productsItemsNames.addtoCartList().size(), equalTo(10));

    homePage.searchBar().inputSerchRequest("java");
    homePage.clickSearchBtn();
    assertThat(search.productsItems().names(), equalTo(productsItemsNames.names()));
  }
}
