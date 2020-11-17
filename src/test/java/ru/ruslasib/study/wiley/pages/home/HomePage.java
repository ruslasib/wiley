package ru.ruslasib.study.wiley.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.ruslasib.study.wiley.pages.PageObject;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends PageObject {

    public HomePage(WebDriver wd) {
        super(wd);
    }

    private SearchBar searchBar = new SearchBar(wd);

    public SearchBar searchBar() {
        return searchBar;
    }

    @FindBy(css = "#main-header-navbar li:nth-child(1)")
    private WebElement whoWeServeMenu;

    public String whoWeServeName() {
        return whoWeServeMenu.getText();
    }

    public void clickWhoWeServe() {
        whoWeServeMenu.click();
    }

    @FindBy(xpath = "//*[@id=\"Level1NavNode1\"]/ul/li/a")
    private WebElement whoWeserveItems;

    public List<String> whoWeServeItemsNames() {
        List<WebElement> elements = wd.findElements(locatorOf(whoWeserveItems));
        List<String> elementsNames = new ArrayList<String>();
        for (WebElement element : elements) {
            elementsNames.add(element.getAttribute("textContent").replace("\n", "").replace("  ", ""));
        }
        return elementsNames;
    }

    @FindBy(css = "[href $=subjects]")
    private WebElement subjectsMenu;

    public String subjectsName() {
        return subjectsMenu.getText();
    }

    public void clickSubjects() {
        subjectsMenu.click();
    }

    @FindBy(css = "#main-header-navbar > ul:first-child > li:nth-child(4)")
    private WebElement aboutMenu;

    public String aboutName() {
        return aboutMenu.getText();
    }

    @FindBy(xpath = ".Level1NavNode1 > ul > li")
    private WebElement whoWeServeSubmenuItems;

    @FindBy(linkText = "Students")
    private WebElement students;

    public void clickStudents() {
        students.click();
    }

    @FindBy(linkText = "Education")
    private WebElement education;

    public void clickEducation() {
        education.click();
    }

    @FindBy(xpath = "//button[.='Search']")
    private WebElement searchBtn;

    public void clickSearchBtn() {
      searchBtn.click();
    }

    public void navigateToSubjects() {
        Actions actions = new Actions(wd);
        actions.moveToElement(subjectsMenu).perform();
    }

    public String url() {
        return wd.getCurrentUrl();
    }

}
