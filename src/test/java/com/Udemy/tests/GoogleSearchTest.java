package com.Udemy.tests;

import com.Udemy.pages.GoogleSearch;
import com.amazon.utilities.BrowserUtil;
import com.amazon.utilities.TestBase;
import org.testng.annotations.Test;

public class GoogleSearchTest extends TestBase {
    GoogleSearch googleSearch;

    @Test
    public void testGoogleSearch(){
        googleSearch = new GoogleSearch();

        googleSearch.goTo();
        BrowserUtil.waitFor(2);

        googleSearch.inputData();
        BrowserUtil.waitFor(8);

        googleSearch.selectUdemy();
        BrowserUtil.waitFor(5);

        googleSearch.confirmUdemy();
        BrowserUtil.waitFor(2);

        googleSearch.searchUdemy();
        BrowserUtil.waitFor(3);

        googleSearch.selectMostRated();
        BrowserUtil.waitFor(3);


    }


}
