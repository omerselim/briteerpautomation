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
import com.briteerp.utilities.BriteErpUtilsOST;
import com.briteerp.utilities.Pages;
import com.briteerp.utilities.SeleniumUtils;
import com.briteerp.utilities.TestBase;
import org.testng.annotations.Test;

public class CreateOpportunityTest extends TestBase {
    Pages pages = new Pages();

    @Test
    public void createNewOpportunity() {
        int NumOfNewOpportunities =2;
        extentLogger=report.createTest("Creating "+NumOfNewOpportunities+" new opportunities ");
        pages.loginPage().login();                              SeleniumUtils.waitPlease(2);
        BriteErpUtilsOST.navigateToModule("CRM");           SeleniumUtils.waitPlease(1);
        pages.opportunityPage().createOpportunity(NumOfNewOpportunities,7,3);           //SeleniumUtils.waitPlease(1);
        pages.loginPage().logout();
        extentLogger.pass(NumOfNewOpportunities+" opportunit(y/ies) has/have been created.");
    }
}
