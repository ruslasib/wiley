package ru.ruslasib.study.wiley.tests;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StudentsTests extends TestBase {

    @BeforeClass
    public static void prepare() throws InterruptedException {
        homePage.clickWhoWeServe();
        homePage.clickStudents();
    }

    @Test
    public void testStudentsPageUrl() {
        assertThat(wd.getCurrentUrl(), equalTo(studentsPage.url()));
    }

    @Test
    public void testHeaderName() {
        assertThat(studentsPage.headerName(), equalTo("Students1"));
    }

    @Test
    public void testLearnMoreExist() throws InterruptedException {
        assertThat(studentsPage.learnMoreOfBeYorBestSectionName(), equalTo("Learn More"));
    }

    @Test
    public void testLearnMoreLink() {
        assertThat(studentsPage.learnMoreOfBeYorBestSectionLink(), containsString("www.wileyplus.com"));
    }
}
