package com.craigstockton.teksystems.state;

import com.craigstockton.teksystems.state.search.StateSearch;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class StateInfoTest {
    @DataProvider
    public static Object[][] scenarios() {
        String abbr = "NC";
        String name = "North Carolina";
        String largest = "Charlotte";
        String capital = "Raleigh";
        String abbr_caseIncorrect = "nC";
        //noinspection SpellCheckingInspection
        String name_caseIncorrect = "nORTH cAROLINA";
        String abbr_nonExistent = "XJ";
        String abbr_empty = "";
        String abbr_quote = "\"";
        String abbr_newLine = "\n";
        String name_nonExistent = "West Karolina";
        String name_empty = "";
        String name_quote = "\"";
        String name_newLine = "\n";
        String existentMessage = String.format("Name: %s\tAbbreviation: %s\tCapital: %s\tLargest City:%s", name,
                abbr, capital, largest);
        String abbrNonExistentMsg = getNonExistentMessage(abbr_nonExistent);
        String abbrEmptyMsg = getNonExistentMessage(abbr_empty);
        String abbrQuoteMsg = getNonExistentMessage(abbr_quote);
        String abbrNewLineMsg = getNonExistentMessage(abbr_newLine);
        String nameNonExistentMsg = getNonExistentMessage(name_nonExistent);
        String nameEmptyMsg = getNonExistentMessage(name_empty);
        String nameQuoteMsg = getNonExistentMessage(name_quote);
        String nameNewLineMsg = getNonExistentMessage(name_newLine);
        return new Object[][]{{abbr, existentMessage}, {name, existentMessage}, {abbr_caseIncorrect,
                existentMessage}, {name_caseIncorrect, existentMessage}, {abbr_nonExistent, abbrNonExistentMsg},
                {abbr_empty, abbrEmptyMsg}, {abbr_quote, abbrQuoteMsg}, {abbr_newLine, abbrNewLineMsg},
                {name_nonExistent, nameNonExistentMsg}, {name_empty, nameEmptyMsg}, {name_quote, nameQuoteMsg},
                {name_newLine, nameNewLineMsg}};

    }

    private static String getNonExistentMessage(String abbr_nonExistent) {
        return String.format("State 'Name' or 'Abbreviation' \"%s\" NOT FOUND; verify spelling", abbr_nonExistent);
    }

    @Test
    public void smoke() {
        String actual = StateSearch.getInstance("NC").query().getMessage();
        String unexpected = "ERROR: State search is currently unavailable";
        Assert.assertNotEquals(actual, unexpected, "FAILURE: 'State Info' service is currently unavailable");
    }

    @Test(dependsOnMethods = "smoke", dataProvider = "scenarios")
    public void existentNameOrAbbr(String searchTerm, String expected) {
        String actual = StateSearch.getInstance(searchTerm).query().getMessage();
        Assert.assertEquals(actual, expected);
    }
}
