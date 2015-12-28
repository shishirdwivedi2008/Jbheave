package org.jbehave.tutorials.etsy.pages;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

public class AdvancedSearch extends FluentWebDriverPage {

    public AdvancedSearch(WebDriverProvider webDriverProvider) {
        super(webDriverProvider);
    }

    public void go() {
        get("http://www.etsy.com/search_advanced.php");
    }

    public void go(String section) {
        go();
        link(xpath("@title = '" + section + "'")).click();
    }

    public void search(String thing) {
        input(id("search-query")).sendKeys(thing);
        input(id("search_submit")).click();
    }

    public void subCategory(String subCategory) {        
        link(By.partialLinkText(subCategory)).click();
    }

    public void searchFor(String thing) {
        input(id("search-query")).sendKeys(thing).submit();
    }
    
}
