package org.watermelon.framework.utils.network.services;

import org.watermelon.framework.utils.network.httpconnection.HttpSender;

public interface HttpConnectionService extends NetworkService {
    void setHttpSender(HttpSender sender);
    HttpSender getHttpSender();
}
