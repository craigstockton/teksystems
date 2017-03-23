package com.craigstockton.teksystems.state.service;

import com.craigstockton.teksystems.state.data.StateInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class StateInfoResponse {
    public final static Integer SUCCESS = 200;
    private final static String BEGIN_STATE_DATA = "[ {\n      \"country\"";
    private final static String END_STATE_DATA = "]";
    private final String body;
    private Integer status;

    private StateInfoResponse(Response response) {
        this.status = response.getStatus();
        this.body = response.readEntity(String.class);
    }

    static StateInfoResponse getInstance(Response response) {
        return new StateInfoResponse(response);
    }

    @SuppressWarnings("SpellCheckingInspection")
    public List<StateInfo> getStateInfos() {
        //noinspection ConstantConditions
        if (!status.equals(SUCCESS) || !body.contains(BEGIN_STATE_DATA)) {
            return new ArrayList<>();
        }
        int resultBeginIndex = body.indexOf(BEGIN_STATE_DATA);
        int resultEndIndex = body.lastIndexOf(END_STATE_DATA) + 1;
        String result = body.substring(resultBeginIndex, resultEndIndex);
        return new Gson().fromJson(result, new TypeToken<List<StateInfo>>() {
        }.getType());
    }

    public Integer getStatus() {
        return status;
    }
}
