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

import com.briteerp.tests.pages.CRM.crmDeleteOopportunityPage;

import com.briteerp.utilities.BriteErpUtilsOST;
import com.briteerp.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class crmDeleteOopportunityTest extends TestBase {

    crmDeleteOopportunityPage crmPage = new crmDeleteOopportunityPage();


    @Test
    public void enterCRM() {

        BriteErpUtilsOST.login();
        BriteErpUtilsOST.navigateToModule("CRM");
        driver.findElement(By.xpath("(//div[@class='oe_kanban_content'])[1]")).click();

    }







}
