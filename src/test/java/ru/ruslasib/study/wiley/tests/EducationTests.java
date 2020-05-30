package ru.ruslasib.study.wiley.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class EducationTests extends TestBase {

  @BeforeClass
  public void prepare() {
    homePage.navigateToSubjects();
    homePage.clickEducation();
  }

  @Test
  public void testHeaderName() {
    assertThat(educationPage.headerName(), equalTo("Education"));
  }

  @Test
  public void testSubjectsSidePanelItems() {
    String[] items = {"Information & Library Science",
            "Education & Public Policy",
            "K-12 General",
            "Higher Education General",
            "Vocational Technology",
            "Conflict Resolution & Mediation (School settings)",
            "Curriculum Tools- General",
            "Special Educational Needs",
            "Theory of Education",
            "Education Special Topics",
            "Educational Research & Statistics",
            "Literacy & Reading",
            "Classroom Management"};
    assertThat(educationPage.subjectsSidePanel.itemsNames(), equalTo(items));
  }
}
