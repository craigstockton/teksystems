package com.craigstockton.teksystems.state.service;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

public class StateInfoRequest {
    private final static String REQUEST_URI = "http://services.groupkt.com/statequery/get/USA/all";
    private Invocation.Builder request = new ResteasyClientBuilder().build().target(REQUEST_URI).request();

    public static StateInfoRequest getInstance() {
        return new StateInfoRequest();
    }

    public StateInfoResponse get() {
        Response response = request.get();
        return StateInfoResponse.getInstance(response);
    }
}
