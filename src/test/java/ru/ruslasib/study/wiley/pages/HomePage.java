package ru.ruslasib.study.wiley.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends PageObject {

  public HomePage(WebDriver wd) {
    super(wd);
  }

  @FindBy(xpath = "//*[@id=\"main-header-navbar\"]/ul[1]/li[1]")
  private WebElement whoWeServeMenu;

  public String whoWeServeName() {
    return whoWeServeMenu.getText();
  }

  public void clickWhoWeServe() {
    whoWeServeMenu.click();
  }

  @FindBy(xpath = "//*[@id=\"main-header-navbar\"]/ul[1]/li[2]/a")
  private WebElement subjectsMenu;

  public String subjectsName() {
    return subjectsMenu.getText();
  }

  @FindBy(xpath = "//*[@id=\"main-header-navbar\"]/ul[1]/li[4]/a")
  private WebElement aboutMenu;

  public String aboutName() {
    return aboutMenu.getText();
  }

  @FindBy(xpath = "//*[@id=\"Level1NavNode1\"]/ul/li")
  private WebElement whoWeServeSubmenuItems;

  @FindBy(linkText = "Students")
  private WebElement students;

  public void clickStudents() {
    System.out.println("Students click starts");
    students.click();
    System.out.println("Students click finishes");
  }

  public List<String> whoWeServeSubmenuItemsNames() {
    List<WebElement> elements = wd.findElements(By.xpath("//*[@id=\"Level1NavNode1\"]/ul/li/a"));
    // System.out.println("First element: " + wd.findElement(By.xpath("//*[@id=\"Level1NavNode1\"]/ul/li[1]/a")).getAttribute("textContent"));
    List<String> elementsNames = new ArrayList<String>();
    for (WebElement element : elements) {
      elementsNames.add(element.getAttribute("textContent").replace("\n", "").replace("  ", ""));
      //System.out.println("Element #" + elements.indexOf(element)+ ": " + element.getText());
    }
    return elementsNames;
  }
}
