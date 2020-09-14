package org.watermelon.framework.utils.network.httpconnection;

import java.net.HttpURLConnection;

public interface HttpMessage<T> {
    T send(HttpURLConnection connection);
}
