package org.watermelon.framework.utils.network.services;

import org.watermelon.framework.utils.network.httpconnection.HttpSender;

public class HttpConnectionServiceImpl implements HttpConnectionService {
    HttpSender httpSender;

    @Override
    public void setHttpSender(HttpSender sender) {
        httpSender = sender;
    }

    @Override
    public HttpSender getHttpSender() {
        return httpSender;
    }
}
