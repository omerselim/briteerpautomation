package com.briteerp.utilities;

import com.briteerp.pages.activities.ActivitiesPage;
import com.briteerp.pages.crm.OpportunityPage;
import com.briteerp.pages.crm.PipelineRevenuePage;
import com.briteerp.pages.login.HomePage;
import com.briteerp.pages.login.LoginPage;

public class Pages {
    private LoginPage loginPage;
    private HomePage homePage;
    private ActivitiesPage activitiesPage;
    private OpportunityPage opportunityPage;
    private PipelineRevenuePage pipelineRevenuePage;

    public LoginPage loginPage(){
        if(loginPage==null){ loginPage=new LoginPage();}
        return loginPage;
    }

    public HomePage homePage(){
        if(homePage==null){ homePage=new HomePage(); }
        return homePage;
    }

    public OpportunityPage opportunityPage(){
        if(opportunityPage==null){ opportunityPage=new OpportunityPage(); }
        return opportunityPage;
    }

    public PipelineRevenuePage pipelineRevenuePage(){
        if(pipelineRevenuePage==null){ pipelineRevenuePage=new PipelineRevenuePage(); }
        return pipelineRevenuePage;
    }


    public ActivitiesPage activitiesPage(){
        if(activitiesPage==null){ activitiesPage=new ActivitiesPage(); }
        return activitiesPage;
    }

}
