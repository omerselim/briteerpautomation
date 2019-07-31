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
    int i = 0;

    @Test(priority = 1)
    public void PreConditionCreateOpportunity() {
        System.out.println("==============================\nPrecondition Creating Opportunities\n------------------------------");
        BriteErpUtilsOST.navigateToModule("CRM");
        SeleniumUtils.waitPlease(2);
        BriteErpUtilsOST.captureScreenShot("PreConditionCreateOpportunity"+(++i));
        OpportunityPage.createOpportunity("Bbbb","200.00");
        OpportunityPage.createOpportunity("Cccc","300.00");
        OpportunityPage.createOpportunity("Dddd","400.00");
        SeleniumUtils.waitPlease(2);
        BriteErpUtilsOST.captureScreenShot("PreConditionCreateOpportunity"+(++i));
    }


   @Test(priority = 2)
    public void deleteOpportunity1() {
        System.out.println("==============================\nProceeding deleteOpportunity1 Test\n------------------------------");
        BriteErpUtilsOST.navigateToModule("CRM");
        SeleniumUtils.waitPlease(2);
        BriteErpUtilsOST.captureScreenShot("deleteOpportunity1"+(++i));
        SeleniumUtils.clickWithJS(opportunity.optToggleElement);
        SeleniumUtils.waitPlease(1);
        opportunity.DeleteButton1Locator.click();
        SeleniumUtils.waitPlease(1);
        opportunity.okButton1Locator.click();
        SeleniumUtils.waitPlease(1);
        BriteErpUtilsOST.captureScreenShot("deleteOpportunity1"+(++i));
    }

    @Test(priority = 3)
    public void deleteOpportunity2() {
        System.out.println("==============================\nProceeding deleteOpportunity2 Test\n------------------------------");
        BriteErpUtilsOST.navigateToModule("CRM");
        SeleniumUtils.waitPlease(2);
        opportunity.FirstOptElement.click();
        SeleniumUtils.waitPlease(1);
        String OptNumberBeforeDelete = opportunity.optNumberBeforeDelete.getText();
        int OnBd = Integer.parseInt(OptNumberBeforeDelete);
        BriteErpUtilsOST.captureScreenShot("deleteOpportunity2"+(++i));
        opportunity.ActionButtonLocator.click();
        SeleniumUtils.waitPlease(1);
        opportunity.DeleteButton2Locator.click();
        opportunity.okButton1Locator.click();
        SeleniumUtils.waitPlease(1);
        String OptNumberAfterDelete = opportunity.optNumberAfterDelete.getText();
        int OnAd = Integer.parseInt(OptNumberAfterDelete);
        BriteErpUtilsOST.captureScreenShot("deleteOpportunity2"+(++i));
        System.out.println("Opportunity Number Before Delete :"+OptNumberBeforeDelete);
        System.out.println("Opportunity Number After Delete :"+OptNumberAfterDelete);
        Assert.assertEquals((OnAd+1),OnBd);

    }

    @Test(priority = 4)
    public void deleteOpportunity3() {
        System.out.println("==============================\nProceeding deleteOpportunity3 Test\n------------------------------");
        BriteErpUtilsOST.navigateToModule("CRM");
        SeleniumUtils.waitPlease(2);
        opportunity.listElement.click();
        SeleniumUtils.waitPlease(1);
        String OptNumberBeforeDelete = opportunity.optNumberBeforeDelete.getText();
        int OnBd = Integer.parseInt(OptNumberBeforeDelete);
        BriteErpUtilsOST.captureScreenShot("deleteOpportunity3"+(++i));
        opportunity.checkBoxLocator.click();
        opportunity.ActionButtonLocator.click();
        SeleniumUtils.waitPlease(1);
        opportunity.DeleteButton2Locator.click();
        opportunity.okButton1Locator.click();
        SeleniumUtils.waitPlease(1);
        String OptNumberAfterDelete = opportunity.optNumberAfterDelete.getText();
        int OnAd = Integer.parseInt(OptNumberAfterDelete);
        BriteErpUtilsOST.captureScreenShot("deleteOpportunity3"+(++i));
        System.out.println("Opportunity Number Before Delete :"+OptNumberBeforeDelete);
        System.out.println("Opportunity Number After Delete :"+OptNumberAfterDelete);
        Assert.assertEquals((OnAd+1),OnBd);


    }

}
