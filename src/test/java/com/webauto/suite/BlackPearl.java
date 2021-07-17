package com.webauto.suite;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.webauto.framework.Driver;
import com.webauto.framework.baseinfo.Application;
import com.webauto.framework.ui.PageFactory;
import com.webauto.tests.pageRepo.Loc_SearchHomePage;
import com.webauto.tests.utils.DataProviderSource;

//import utils.ExtentReports.ExtentTestManager;

public class BlackPearl extends SuiteInitialization {
	 private Loc_SearchHomePage loc_SearchHomePage;
	
	 	
                @Test(dataProvider = "AutoTestData_Provider", dataProviderClass = DataProviderSource.class)
                public void verifyHotelBooking(Application application) throws Exception {
                                logger = extent.createTest("BlackPearl"+application.get_TestCaseNo(),
                                                                "Smoke Test BlackPearl");
                                logger.assignCategory("verifyBlackPearlSearch");
                                verifyHotelBooking_TC(application);
                }
       

                public void verifyHotelBooking_TC(Application application) throws Exception {
                			
                	loc_SearchHomePage = PageFactory.init(Driver.current(), Loc_SearchHomePage.class);         				
                				//Asserts Search query input field
                	loc_SearchHomePage.searchQueryInput.assertExists();
                	//Asserts Search Button  field
                	loc_SearchHomePage.searchButton.assertExists();
                	
                	//Check for islands
                	loc_SearchHomePage.searchQueryInput.setText(application.get_SearchInput());
                	
                	
                	loc_SearchHomePage.searchQueryInput.click();
                	
                
 				Assert.assertTrue(loc_SearchHomePage.autocomplete_Islands.checkFuzzyLogic(application.get_SearchInput()),application.get_SearchInput()+" : Island Not Found: ");
////    				
                				
//          				//Switch to New window
//           				String defaultWindow = Driver.current().getWindowHandle();
//       				Thread.sleep(3000);
//        				Set<String> childWindows = Driver.current().getWindowHandles();
//                				for(String child : childWindows){
//                				if(!child.equalsIgnoreCase(defaultWindow)){
//                					Driver.current().switchTo().window(child);
//                				System.out.println("Child windows- "+child);
//                				} else {
//                				System.out.println("There are no child windows");
//                				}
//                				}
                			     
//                				loc_demoHomePage = PageFactory.init(Driver.current(), Loc_SearchHomePage.class);  
//                				loc_demoHomePage.HotelMenuName.assertExists();
//                				
//                				//Click on Search for Hotel
//                				loc_demoHomePage.searchByHotel.clickable();
//                				loc_demoHomePage.searchByHotel.click();
                }

}
