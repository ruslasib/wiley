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
    public static void prepare()  {
        homePage.clickWhoWeServe();
        homePage.clickStudents();
    }

    @Test
    public void testStudentsPageUrl() throws InterruptedException {
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
    public void testLearnMoreLink() throws InterruptedException {
        System.out.println("Start scrolling...");
        Point hoverItem = wd.findElement(By.xpath("/html/body/main/div[2]/div/div[3]/div/p[15]/a")).getLocation();
        System.out.println("1...");
        JavascriptExecutor jse = (JavascriptExecutor) wd;
//        jse.executeScript("return window.title;");
//        System.out.println("2...");
//        Thread.sleep(6000);
        System.out.println("3...");
        jse.executeScript("window.scrollBy(0,"+(hoverItem.getY())+");");
        //
        Thread.sleep(6000);
        System.out.println("Coordinates: " + hoverItem.getY());
        System.out.println("Stop scrolling...");
        assertThat(studentsPage.learnMoreOfBeYorBestSectionLink(), containsString("www.wileyplus.com"));
    }
}
