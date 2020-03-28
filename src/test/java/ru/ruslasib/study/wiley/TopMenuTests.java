package ru.ruslasib.study.wiley;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TopMenuTests extends TestBase {

  @Test
  public void testWhoWeServeMenuExsist() {
    assertThat("WHO WE SERVE", equalTo(homePage.whoWeServeName()));
  }

  @Test
  public void testSubjectsMenuExist() {
    assertThat("SUBJECTS", equalTo(homePage.subjectsName()));
  }

  @Test
  public void testAboutMenuExist() {
    assertThat("ABOUT", equalTo(homePage.aboutName()));
  }

  @Test
  public void testWhoWeServeSubmenu() {
    assertThat(11, equalTo(homePage.whoWeServeSubmenuItems().size()));
    List<String> items = Arrays.asList("Students", "Instructors", "Book Authors", "Professionals", "Researchers", "Institutions", "Librarians", "Corporations", "Societies", "Journal Editors", "Government");
    assertThat(items, equalTo(homePage.whoWeServeSubmenuItems()));
  }
}
