package ru.ruslasib.study.wiley.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class NavigationPanelTest extends TestBase {

  @Test
  public void testWhoWeServeOfNavigationPanel() {
    Assert.assertTrue("Element " + "Who we serve" + " not existed", isElementPresent(By.linkText("WHO WE SERVE")));
  }

  @Test
  public void testSubjectsOfNavigationPanel() {
    Assert.assertTrue("Element " + "Subjects" + " not existed", isElementPresent(By.linkText("SUBJECTS")));
  }

  @Test
  public void testAboutOfNavigationPanel() {
    Assert.assertTrue("Element " + "About" + " not existed", isElementPresent(By.linkText("ABOUT")));
  }
}
