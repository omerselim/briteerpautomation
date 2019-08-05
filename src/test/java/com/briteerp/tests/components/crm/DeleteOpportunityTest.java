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
import com.briteerp.utilities.SeleniumUtils;
import com.briteerp.utilities.TestBase;
import net.bytebuddy.build.Plugin;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteOpportunityTest extends TestBase {

    OpportunityPage opportunity = new OpportunityPage();

    @Test(priority = 1)
    public void PreConditionCreateOpportunity() {
        int NumOfNewOpportunities = 3;
        extentLogger = report.createTest("Creating "+NumOfNewOpportunities+" new opportunities for precondition ");
        BriteErpUtilsOST.login();
        SeleniumUtils.waitPlease(2);
        BriteErpUtilsOST.navigateToModule("CRM");
        SeleniumUtils.waitPlease(2);
        OpportunityPage.createOpportunity(NumOfNewOpportunities);
        SeleniumUtils.waitPlease(2);
        BriteErpUtilsOST.logout();
        SeleniumUtils.waitPlease(1);
        extentLogger.pass(NumOfNewOpportunities+" opportunit(y/ies) has/have been created.");

    }


    @Test(priority = 2)
    public void deleteOpportunity1() {
        extentLogger = report.createTest("Deleting Opportunity 1 ");
        BriteErpUtilsOST.login();
        SeleniumUtils.waitPlease(2);
        BriteErpUtilsOST.navigateToModule("CRM");
        SeleniumUtils.waitPlease(2);
        SeleniumUtils.clickWithJS(opportunity.optToggleElement);
        SeleniumUtils.waitPlease(1);
        opportunity.DeleteButton1Locator.click();
        SeleniumUtils.waitPlease(1);
        opportunity.okButton1Locator.click();
        SeleniumUtils.waitPlease(1);
        BriteErpUtilsOST.logout();
        SeleniumUtils.waitPlease(1);
        extentLogger.pass("First opportunity has been deleted.");
    }

    @Test(priority = 3)
    public void deleteOpportunity2() {
        extentLogger = report.createTest("Deleting Opportunity 2 ");
        BriteErpUtilsOST.login();
        SeleniumUtils.waitPlease(2);
        BriteErpUtilsOST.navigateToModule("CRM");
        SeleniumUtils.waitPlease(1);

        opportunity.FirstOptElement.click();
        SeleniumUtils.waitPlease(1);
        String OptNumberBeforeDelete = opportunity.optNumberBeforeDelete.getText();
        int OnBd = Integer.parseInt(OptNumberBeforeDelete);

        opportunity.ActionButtonLocator.click();
        SeleniumUtils.waitPlease(1);
        opportunity.DeleteButton2Locator.click();
        opportunity.okButton1Locator.click();
        SeleniumUtils.waitPlease(1);
        String OptNumberAfterDelete = opportunity.optNumberAfterDelete.getText();
        int OnAd = Integer.parseInt(OptNumberAfterDelete);

        extentLogger.info("Opportunity Number Before Delete :"+OptNumberBeforeDelete);
        extentLogger.info("Opportunity Number After Delete :"+OptNumberAfterDelete);
        Assert.assertEquals((OnAd+1),OnBd);
        BriteErpUtilsOST.logout();
        SeleniumUtils.waitPlease(1);
        extentLogger.pass("Second opportunity has been deleted.");

    }

    @Test(priority = 4)
    public void deleteOpportunity3() {
        extentLogger = report.createTest("Deleting Opportunity 3 ");
        BriteErpUtilsOST.login();
        SeleniumUtils.waitPlease(2);
        BriteErpUtilsOST.navigateToModule("CRM");
        SeleniumUtils.waitPlease(1);

        opportunity.listElement.click();
        SeleniumUtils.waitPlease(1);
        String OptNumberBeforeDelete = opportunity.optNumberBeforeDelete.getText();
        int OnBd = Integer.parseInt(OptNumberBeforeDelete);

        opportunity.checkBoxLocator.click();
        opportunity.ActionButtonLocator.click();
        SeleniumUtils.waitPlease(1);
        opportunity.DeleteButton2Locator.click();
        opportunity.okButton1Locator.click();
        SeleniumUtils.waitPlease(1);
        String OptNumberAfterDelete = opportunity.optNumberAfterDelete.getText();
        int OnAd = Integer.parseInt(OptNumberAfterDelete);

        extentLogger.info("Opportunity Number Before Delete :"+OptNumberBeforeDelete);
        extentLogger.info("Opportunity Number After Delete :"+OptNumberAfterDelete);
        Assert.assertEquals((OnAd+1),OnBd);
        BriteErpUtilsOST.logout();
        SeleniumUtils.waitPlease(1);
        extentLogger.pass("Third opportunity has been deleted.");

    }

}
