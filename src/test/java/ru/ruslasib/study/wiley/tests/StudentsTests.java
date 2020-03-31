package ru.ruslasib.study.wiley.tests;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StudentsTests extends TestBase {

    @BeforeClass
    public static void prepare()  {
        homePage.clickWhoWeServe();
        homePage.clickStudents();
    }

    @Test
    public void testStudentsPageUrl() {
        assertThat(wd.getCurrentUrl(), equalTo(studentsPage.url()));
    }

    @Test
    public void testHeaderName() {
        assertThat(studentsPage.headerName(), equalTo("Students"));
    }

    @Test
    public void testLearnMoreExist() throws InterruptedException {
        studentsPage.scrollTo(studentsPage.learnMoreOfBeYorBestSectionNameLocator());
        assertThat(studentsPage.learnMoreOfBeYorBestSectionName(), containsString("Learn More"));
    }

    @Test
    public void testLearnMoreLink() throws InterruptedException {
        studentsPage.scrollTo(studentsPage.learnMoreOfBeYorBestSectionNameLocator());
        assertThat(studentsPage.learnMoreOfBeYorBestSectionLink(), containsString("www.wileyplus.com"));
    }
}
