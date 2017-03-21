package com.craigstockton.teksystems.state.search;

import com.craigstockton.teksystems.state.data.StateInfo;
import com.craigstockton.teksystems.state.data.StateInfoRepository;

public class StateSearch {
    private final static StateInfoRepository stateInfoRepository = StateInfoRepository.getInstance();
    private final String term;

    private StateSearch(String term) {
        this.term = term;
    }

    public static StateSearch getInstance(String term) {
        return new StateSearch(term);
    }

    public StateQueryResult query() {
        StateInfo searchInfo;
        try {
            searchInfo = stateInfoRepository.query(term);
        } catch (Exception e) {
            return StateQueryResult.getInstance(term, "ERROR: State search is currently unavailable");
        }
        return StateQueryResult.getInstance(term, searchInfo);
    }
}
