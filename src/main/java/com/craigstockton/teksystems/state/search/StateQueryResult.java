package com.craigstockton.teksystems.state.search;

import com.craigstockton.teksystems.state.data.StateInfo;

public class StateQueryResult {
    private final static String NOT_FOUND_MSG = "State 'Name' or 'Abbreviation' \"%s\" NOT FOUND; verify spelling";
    private final static String STATE_DETAILS = "Name: %s\tAbbreviation: %s\tCapital: %s\tLargest City:%s";
    private String message;

    private StateQueryResult(String searchTerm, StateInfo stateInfo, String errorMessage) {
        String notFoundMessage = String.format(NOT_FOUND_MSG, searchTerm);
        if (errorMessage != null) {
            message = errorMessage;
        } else if (stateInfo == null) {
            message = notFoundMessage;
        } else {
            String capital = stateInfo.getCapital() == null ? "[NO CAPITAL]" : stateInfo.getCapital();
            String largestCity = stateInfo.getLargestCity() == null ? "[UNSPECIFIED]" : stateInfo.getLargestCity()      ;
            message = String.format(STATE_DETAILS, stateInfo.getName(), stateInfo.getAbbreviation(), capital,
                    largestCity);
        }
    }

    static StateQueryResult getInstance(String searchTerm, StateInfo stateInfo) {
        return new StateQueryResult(searchTerm, stateInfo, null);
    }

    static StateQueryResult getErrorInstance(String searchTerm) {
        return new StateQueryResult(searchTerm, null, "ERROR: State search is currently unavailable");
    }

    public String getMessage() {
        return message;
    }
}
