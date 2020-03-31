package ru.ruslasib.study.wiley.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StudentsPage extends PageObject {

    public StudentsPage(WebDriver wd) {
        super(wd);
    }

    private String url = "https://www.wiley.com/en-ru/students";
    public String url() {
        return url;
    }

    @FindBy(xpath = "/html/body/main/div[2]/div/div[1]/ul/li[2]")
    private WebElement header;

    public String headerName() {
        return header.getText();
    }

    @FindBy(xpath = "/html/body/main/div[2]/div/div[3]/div/p[15]/a")
    private WebElement learnMoreOfBeYorBestSectionLink;

    public String learnMoreOfBeYorBestSectionLink() {
        return learnMoreOfBeYorBestSectionLink.getText();
    }

    @FindBy(xpath = "/html/body/main/div[2]/div/div[3]/div/p[15]/a/span/span/text()")
    private WebElement learnMoreOfBeYorBestSectionName;

    public String learnMoreOfBeYorBestSectionName() {
        return learnMoreOfBeYorBestSectionName.getText();
    }
}
