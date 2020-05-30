package ru.ruslasib.study.wiley.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

//TODO This class need to be reworked
public class NavigationPanelTests extends TestBase {

  @Test
  public void testWhoWeServeOfNavigationPanel() {
    assertThat("Element " + "Who we serve" + " not existed", isElementPresent(By.linkText("WHO WE SERVE")));
  }

  @Test
  public void testSubjectsOfNavigationPanel() {
    assertThat("Element " + "Subjects" + " not existed", isElementPresent(By.linkText("SUBJECTS")));
  }

  @Test
  public void testAboutOfNavigationPanel() {
    assertThat("Element " + "About" + " not existed", isElementPresent(By.linkText("ABOUT")));
  }
}
