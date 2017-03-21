package com.craigstockton.teksystems.state.data;

import com.craigstockton.teksystems.state.service.StateInfoRequest;
import com.craigstockton.teksystems.state.service.StateInfoResponse;

public class StateInfoRepository {
    public static StateInfoRepository getInstance() {
        return new StateInfoRepository();
    }

    public StateInfo query(String searchTerm) throws Exception {
        if (searchTerm == null) {
            return null;
        }
        StateInfoResponse stateInfoResponse = StateInfoRequest.getInstance().get();
        if(!stateInfoResponse.getStatus().equals(StateInfoResponse.SUCCESS)){
            throw new Exception("ERROR: State search is currently unavailable!");
        }
        for (StateInfo candidate : stateInfoResponse.getStateInfos()) {
            if (searchTerm.equalsIgnoreCase(candidate.getName()) || searchTerm.equalsIgnoreCase(candidate
                    .getAbbreviation())) {
                return candidate;
            }
        }
        return null;
    }
}
