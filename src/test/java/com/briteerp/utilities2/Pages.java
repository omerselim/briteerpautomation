package com.briteerp.utilities2;

import com.briteerp.notes.ActivitiesPage;
import com.briteerp.notes.HomePage;
import com.briteerp.notes.LoginPage;

public class Pages {
    private LoginPage loginPage;
    private HomePage homePage;
    private ActivitiesPage activitiesPage;


    public LoginPage login(){
        if(loginPage==null){

            loginPage=new LoginPage();
        }

        return loginPage;

    }

    public HomePage homePage(){
        if(homePage==null){

            homePage=new HomePage();
        }

        return homePage;

    }

    public ActivitiesPage activitiesPage(){
        if(activitiesPage==null){

            activitiesPage=new ActivitiesPage();
        }

        return activitiesPage;

    }

}
