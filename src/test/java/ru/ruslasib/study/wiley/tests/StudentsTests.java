package ru.ruslasib.study.wiley.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StudentsTests extends TestBase {

  @BeforeMethod
  public static void prepare() {
    homePage.clickWhoWeServe();
    homePage.clickStudents();
  }

  @Test
  public void testPageUrl() {
    assertThat(studentsPage.url(), equalTo("https://www.wiley.com/en-us/students"));
  }

  @Test
  public void testHeaderName() {
    assertThat(studentsPage.headerName(), equalTo("Students"));
  }

  @Test
  public void testLearnMoreExist() {
    studentsPage.scrollTo(studentsPage.beYourBest().learnMore());
    assertThat(studentsPage.beYourBest().learnMoreName(), containsString("Learn More"));
  }

  @Test
  public void testLearnMoreLink() {
    studentsPage.scrollTo(studentsPage.beYourBest().learnMore());
    assertThat(studentsPage.beYourBest().learnMoreLink(), containsString("www.wileyplus.com"));
  }
}
