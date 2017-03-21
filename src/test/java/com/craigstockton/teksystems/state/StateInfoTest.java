package com.craigstockton.teksystems.state;

import com.craigstockton.teksystems.state.search.StateSearch;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class StateInfoTest {
    @DataProvider
    public static Object[][] successfulScenarios() {
        String abbr = "NC";
        String name = "North Carolina";
        String largest = "Charlotte";
        String capital = "Raleigh";
        String abbr_caseIncorrect = "nC";
        //noinspection SpellCheckingInspection
        String name_caseIncorrect = "nORTH cAROLINA";
        String existentMessage = String.format("Name: %s\tAbbreviation: %s\tCapital: %s\tLargest City:%s", name,
                abbr, capital, largest);
        return new Object[][]{{abbr, existentMessage}, {name, existentMessage}, {abbr_caseIncorrect,
                existentMessage}, {name_caseIncorrect, existentMessage}};
    }

    private static String getNonExistentMessage(String abbr_nonExistent) {
        return String.format("State 'Name' or 'Abbreviation' \"%s\" NOT FOUND; verify spelling", abbr_nonExistent);
    }

    @DataProvider
    public static Object[][] notFoundScenarios() {
        String abbr_nonExistent = "XJ";
        String abbr_empty = "";
        String abbr_quote = "\"";
        String abbr_newLine = "\n";
        String name_nonExistent = "West Karolina";
        String name_empty = "";
        String name_quote = "\"";
        String name_newLine = "\n";
        String abbrNonExistentMsg = getNonExistentMessage(abbr_nonExistent);
        String abbrEmptyMsg = getNonExistentMessage(abbr_empty);
        String abbrQuoteMsg = getNonExistentMessage(abbr_quote);
        String abbrNewLineMsg = getNonExistentMessage(abbr_newLine);
        String nameNonExistentMsg = getNonExistentMessage(name_nonExistent);
        String nameEmptyMsg = getNonExistentMessage(name_empty);
        String nameQuoteMsg = getNonExistentMessage(name_quote);
        String nameNewLineMsg = getNonExistentMessage(name_newLine);
        return new Object[][]{{abbr_nonExistent, abbrNonExistentMsg}, {abbr_empty, abbrEmptyMsg}, {abbr_quote,
                abbrQuoteMsg}, {abbr_newLine, abbrNewLineMsg}, {name_nonExistent, nameNonExistentMsg}, {name_empty,
                nameEmptyMsg}, {name_quote, nameQuoteMsg}, {name_newLine, nameNewLineMsg}};
    }

    @DataProvider
    public static Object[][] existingStatesAbbreviations() {
        return new Object[][]{{"AL"}, {"CO"}, {"DE"}, {"FL"}, {"GA"}, {"HI"}, {"IN"}, {"KY"}, {"LA"}, {"MI"}, {"NM"},
                {"OR"}, {"PA"}, {"RI"}, {"SD"}, {"TX"}, {"UT"}, {"VT"}, {"WY"}};
    }

    @DataProvider
    public static Object[][] existingStatesNames() {
        //noinspection SpellCheckingInspection
        return new Object[][]{{"washington"}, {"vermont"}, {"utah"}, {"tennessee"}, {"south carolina"}, {"rhode " +
                "island"}, {"pennsylvania"}, {"oklahoma"}, {"new mexico"}, {"mississippi"}, {"Louisiana"},
                {"Kansas"}, {"Illinois"}, {"Hawaii"}, {"Georgia"}, {"Florida"}, {"Delaware"}, {"Colorado"},
                {"Arkansas"}};
    }

    @Test
    public void smoke() {
        String actual = StateSearch.getInstance("NC").query().getMessage();
        String unexpected = "ERROR: State search is currently unavailable";
        Assert.assertNotEquals(actual, unexpected, "FAILURE: 'State Info' service is currently unavailable");
    }

    @Test(dependsOnMethods = "smoke", dataProvider = "successfulScenarios")
    public void successfulSearches(String searchTerm, String expected) {
        String actual = StateSearch.getInstance(searchTerm).query().getMessage();
        Assert.assertEquals(actual, expected);
    }

    @Test(dependsOnMethods = "smoke", dataProvider = "notFoundScenarios")
    public void notFoundSearches(String searchTerm, String expected) {
        String actual = StateSearch.getInstance(searchTerm).query().getMessage();
        Assert.assertEquals(actual, expected);
    }

    @Test(dependsOnMethods = "smoke", dataProvider = "existingStatesAbbreviations")
    public void existingStateAbbreviations(String searchTerm) {
        String actual = StateSearch.getInstance(searchTerm).query().getMessage();
        Assert.assertFalse(actual.contains("ERROR"));
    }

    @Test(dependsOnMethods = "smoke", dataProvider = "existingStatesNames")
    public void existingStateNames(String searchTerm) {
        String actual = StateSearch.getInstance(searchTerm).query().getMessage();
        Assert.assertFalse(actual.contains("ERROR"));
    }
}
