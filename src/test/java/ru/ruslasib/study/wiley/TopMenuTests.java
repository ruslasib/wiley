package ru.ruslasib.study.wiley;

import org.junit.Test;

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
}
