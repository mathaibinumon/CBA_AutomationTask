package com.webauto.tests.pageRepo;

import org.openqa.selenium.WebDriver;

import com.webauto.framework.ui.FindBy;
import com.webauto.framework.ui.Page;
import com.webauto.framework.ui.controls.Control;
import com.webauto.framework.ui.controls.Edit;

public class Loc_SearchHomePage extends Page {
	@FindBy(locator = "xpath=(//input[@id='search-input']")
	public Edit searchQueryInput;
	
	@FindBy(locator = "xpath=(//button[@id='search-button']")
	public Control searchButton;
	
	@FindBy(locator = "//li")
    public Edit autocomplete_Islands;


	public Loc_SearchHomePage(WebDriver driverValue) {
		super(driverValue);
		// TODO Auto-generated constructor stub
	}

}
