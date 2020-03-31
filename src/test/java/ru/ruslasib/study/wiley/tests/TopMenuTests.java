package ru.ruslasib.study.wiley.tests;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TopMenuTests extends TestBase {

  @Test
  public void testWhoWeServeMenuExist() {
    assertThat(homePage.whoWeServeName(),equalTo("WHO WE SERVE"));
  }

  @Test
  public void testSubjectsMenuExist() {
    assertThat(homePage.subjectsName(), equalTo("SUBJECTS"));
  }

  @Test
  public void testAboutMenuExist() {
    assertThat(homePage.aboutName(), equalTo("ABOUT"));
  }

  @Test
  public void testWhoWeServeSubmenu() {
    assertThat(homePage.whoWeServeSubmenuItemsNames().size(),equalTo(12));
    List<String> items = Arrays.asList("Students", "Instructors", "Book Authors", "Professionals", "Researchers", "Institutions", "Librarians", "Corporations", "Societies", "Journal Editors", "Bookstores", "Government");
    assertThat(homePage.whoWeServeSubmenuItemsNames(), equalTo(items));
  }
}
