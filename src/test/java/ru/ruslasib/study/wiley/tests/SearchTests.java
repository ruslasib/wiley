package ru.ruslasib.study.wiley.tests;

import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTests extends TestBase {

  @Test
  public void testEmptySearch() {
    homePage.searchBar().inputSerchRequest("");
    homePage.searchBar().clickSearchBtn();
    assertThat(homePage.url(), equalTo("https://www.wiley.com/en-us"));
  }
}
