package ru.ruslasib.study.wiley.tests;

import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class SubjectsTests extends TestBase {

  @Test
  public void testHeaderName() {
    homePage.navigateToSubjects();
    homePage.clickEducation();
    assertThat(educationPage.headerName(), equalTo("Education"));
  }
}
