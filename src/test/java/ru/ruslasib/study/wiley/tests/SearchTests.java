package ru.ruslasib.study.wiley.tests;

import org.testng.annotations.Test;
import ru.ruslasib.study.wiley.pages.models.Items;

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
    String[] suggestionsItems = {"java", "java", "java", "java"};
    assertThat(searchResults.suggestionsItems().size(), equalTo(4));
    assertThat(searchResults.suggestionsItems(), equalTo(new Items(suggestionsItems)));
    assertThat(searchResults.productsItems().size(), equalTo(0));
  }

  @Test
  public void testJavaSearch() {
    homePage.searchBar().inputSerchRequest("java");
    homePage.clickSearchBtn();
    assertThat(search.productsItems().names().size(), equalTo(10));
    assertThat(search.productsItems().addtoCartList().size(), equalTo(10));
  }
}
