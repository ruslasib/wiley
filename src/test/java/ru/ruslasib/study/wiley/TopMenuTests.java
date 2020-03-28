package ru.ruslasib.study.wiley;

import org.junit.Assert;
import org.junit.Test;

public class TopMenuTests extends TestBase {

  @Test
  public void testWhoWeServeMenuExsists() {
    Assert.assertEquals("WHO WE SERVE", homePage.whoWeServeName());
  }

  @Test
  public void testSubjectsMenuExists() {
    Assert.assertEquals("SUBJECTS", homePage.subjectsName());
  }

  @Test
  public void testAboutMenuExists() {
    Assert.assertEquals("ABOUT", homePage.aboutName());
  }
}
