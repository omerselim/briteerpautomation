/*
1.  open URL    http://34.220.250.213/
    Should be able to access BriteERP log in page.
2.  Enter login credentials 1 - user names.  eventscrmmanager28@info.com
    Able to write credential 1 - valid username inside the box.
3.  Enter login credential 2 - valid password.  eventscrmmanager
    Able to write credential 2 - valid password inside the box, and able to login to the main page.
4.  Click on the CRM tab.
    Should be able to access CRM page.
5.  Click on the opportunity box which is willing to be deleted.
    The the opportunity window should open.
6.  Click on the Action tab to open drop down menu.
    Action drop down menu should be able to open.
7.  Click on Delete option.
    The Confirmation window should popup.
8.  Click on Ok button.
    Should able to delete the opportunity.
9.  Click the Pipeline Title to open the opportunity list
    Be able to open opportunity list page and verify that the opportunity just deleted is not exist on the list
10. Click on the useraccount on the right-upper corner to open drop down menu
    Account drop down menu should be able to open.
11. Click the Log out option
    Should be able to Log out and the log in page should be visible.

 */
package com.briteerp.tests.components.crm;
import com.briteerp.pages.CRM.OpportunityPage;
import com.briteerp.utilities.BriteErpUtilsOST;
import com.briteerp.utilities.Driver;
import com.briteerp.utilities.SeleniumUtils;
import com.briteerp.utilities.TestBase;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateOpportunityTest extends TestBase {

    OpportunityPage opportunity = new OpportunityPage();
    int i = 0;

    @Test
    public void createOpportunity1() {
        System.out.println("==============================\nProceeding createOpportunity1 Test\n------------------------------");
        BriteErpUtilsOST.navigateToModule("CRM");
        SeleniumUtils.waitPlease(2);
        BriteErpUtilsOST.captureScreenShot("createOpportunity1"+(++i));
        opportunity.CreateElement.click();
        SeleniumUtils.waitPlease(1);
        opportunity.OpportunityTitle.sendKeys("Aaaa");
        SeleniumUtils.waitPlease(1);
        opportunity.CustomerElement.click();
        opportunity.CustomerChoiceElement.click();
        opportunity.ExpectedRevenueElement.click();
        opportunity.ExpectedRevenueElement.clear();
        opportunity.ExpectedRevenueElement.sendKeys("100.45");
        SeleniumUtils.waitPlease(1);
        opportunity.TwoStarElement.click();
        SeleniumUtils.waitPlease(1);
        opportunity.CreateFinalElement.click();
        SeleniumUtils.waitPlease(1);
        BriteErpUtilsOST.captureScreenShot("createOpportunity1"+(++i));


//        SeleniumUtils.clickWithJS(opportunity.optToggleElement);
//        SeleniumUtils.waitPlease(1);
//        opportunity.DeleteButton1Locator.click();
//        SeleniumUtils.waitPlease(1);
//        opportunity.okButton1Locator.click();
//        SeleniumUtils.waitPlease(1);
//        BriteErpUtilsOST.captureScreenShot("createOpportunity1"+(++i));
    }

//    @Test
//    public void createOpportunity2() {
//        System.out.println("==============================\nProceeding createOpportunity2 Test\n------------------------------");
//        BriteErpUtilsOST.navigateToModule("CRM");
//        SeleniumUtils.waitPlease(2);
//        opportunity.FirstOptElement.click();
//        SeleniumUtils.waitPlease(1);
//        String OptNumberBeforeDelete = opportunity.optNumberBeforeDelete.getText();
//        int OnBd = Integer.parseInt(OptNumberBeforeDelete);
//        BriteErpUtilsOST.captureScreenShot("createOpportunity2"+(++i));
//        opportunity.ActionButtonLocator.click();
//        SeleniumUtils.waitPlease(1);
//        opportunity.DeleteButton2Locator.click();
//        opportunity.okButton1Locator.click();
//        SeleniumUtils.waitPlease(1);
//        String OptNumberAfterDelete = opportunity.optNumberAfterDelete.getText();
//        int OnAd = Integer.parseInt(OptNumberAfterDelete);
//        BriteErpUtilsOST.captureScreenShot("createOpportunity2"+(++i));
//        System.out.println("Opportunity Number Before Delete :"+OptNumberBeforeDelete);
//        System.out.println("Opportunity Number After Delete :"+OptNumberAfterDelete);
//        Assert.assertEquals((OnAd+1),OnBd);
//
//    }







}
