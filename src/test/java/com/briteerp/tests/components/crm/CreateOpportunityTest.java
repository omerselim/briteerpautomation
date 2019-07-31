/*
1.  open URL    http://34.220.250.213/
    Should be able to access BriteERP log in page.
2.  Enter login credentials 1 - user names.  eventscrmmanager28@info.com
    Able to write credential 1 - valid username inside the box.
3.  Enter login credential 2 - valid password.  eventscrmmanager
    Able to write credential 2 - valid password inside the box, and able to login to the main page.
4.  Click on the CRM tab.
    Should be able to access CRM page.
5.
6.
7.
8.
9.
10.
11.

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
        OpportunityPage.createOpportunity(4,5,3);
        SeleniumUtils.waitPlease(1);
        BriteErpUtilsOST.captureScreenShot("createOpportunity1"+(++i));

    }

}
