package org.jbehave.tutorials.etsy.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.tutorials.etsy.pages.AdvancedSearch;
import org.jbehave.tutorials.etsy.pages.Buy;
import org.jbehave.tutorials.etsy.pages.CartContents;
import org.jbehave.tutorials.etsy.pages.Home;
import org.jbehave.tutorials.etsy.pages.PageFactory;
import org.jbehave.tutorials.etsy.pages.SearchResults;
import org.jbehave.tutorials.etsy.pages.Site;
import org.jbehave.tutorials.etsy.pages.Treasury;

public class SampleStoryClass {

	 private AdvancedSearch advancedSearch;
	    private Home home;
	    private Site site;
	    private SearchResults searchResults;
	    private CartContents cartContents;
	    private Buy buy;
	    private Treasury treasury;

	    private String justBought = "";

	    public SampleStoryClass(PageFactory pageFactory){
	        advancedSearch = pageFactory.newAdvancedSearch();
	        home = pageFactory.newHome();
	        site = pageFactory.newSite();
	        searchResults = pageFactory.newSearchResults();
	        cartContents = pageFactory.newCartContents();
	        buy = pageFactory.newBuy();
	        treasury = pageFactory.newTreasury();
	    }
	    
	    
	    @Given("I am shopping for a $thing in $section on Etsy.com")
	    public void shoppingForSomethingOnEtsyDotCom(String thing, String section) {
	        home.go(section);
	        home.search(thing);
	    }

	    @Given("I am at facebook.com")
	    public void homepageOnEtsyDotCom() {
	        home.go();
	    }

	    @Given("I am searching on Etsy.com")
	    public void advancedSearchingOnEtsyDotCom() {
	        advancedSearch.go();
	    }

	    @Given("that the cart is empty")
	    public void cartIsEmptyAndOnStartPage() {
	        home.go();
	        cartIsEmpty();
	    }

	    @Then("cart is empty")
	    public void cartIsEmpty() {
	        assertThat(site.cartSize(), equalTo(0));
	    }
	    
	    @When("I search for an item")
	    public void searchForItem() {
	        home.search("hat");
	    }

}
