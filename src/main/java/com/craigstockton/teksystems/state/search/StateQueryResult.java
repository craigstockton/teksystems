package com.craigstockton.teksystems.state.search;

import com.craigstockton.teksystems.state.data.StateInfo;

public class StateQueryResult {
    private final static String NOT_FOUND_MSG = "State 'Name' or 'Abbreviation' \"%s\" NOT FOUND; verify spelling";
    private final static String STATE_DETAILS = "Name: %s\tAbbreviation: %s\tCapital: %s\tLargest City:%s";
    private final String message;

    private StateQueryResult(String searchTerm, StateInfo stateInfo, String errorMessage) {
        String notFoundMessage = String.format(NOT_FOUND_MSG, searchTerm);
        String generatedMessage = stateInfo == null ? notFoundMessage : String.format(STATE_DETAILS, stateInfo
                .getName(), stateInfo.getAbbreviation(), stateInfo.getCapital(), stateInfo.getLargestCity());
        this.message = errorMessage != null ? errorMessage : generatedMessage;
    }

    static StateQueryResult getInstance(String searchTerm, StateInfo stateInfo) {
        return new StateQueryResult(searchTerm, stateInfo, null);
    }

    static StateQueryResult getInstance(String searchTerm, String errorMessage) {
        return new StateQueryResult(searchTerm, null, errorMessage);
    }

    public String getMessage() {
        return message;
    }
}
