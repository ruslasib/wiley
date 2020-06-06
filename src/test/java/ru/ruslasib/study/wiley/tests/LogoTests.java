package ru.ruslasib.study.wiley.tests;

import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LogoTests extends TestBase {

  @Test
  public void testClickLogo() {
    homePage.clickStudents();
    studentsPage.clickLogo();
    assertThat(homePage.url(), equalTo("https://www.wiley.com/en-us"));
  }
}
