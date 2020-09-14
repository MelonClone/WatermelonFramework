package org.watermelon.framework.utils.network.httpconnection;

import java.net.HttpURLConnection;

import lombok.Setter;

public class HttpSender {
    public interface Call<T> {
        void execute(Callback<T> callback);
    }
    public interface Callback<T> {
        void onResponse(HttpURLConnection response, T data);
    }

    @Setter
    HttpConnector.HttpMethod method = HttpConnector.HttpMethod.GET;
    String serverUrl;
    public HttpSender(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public <T> void call(HttpMessage<T> message, Callback<T> callback) {
        HttpURLConnection connection = HttpConnector.post(method, serverUrl);

        // TODO Do something on HttpConnectionService
        T data = message.send();
        callback.onResponse(connection, data);
        HttpConnector.disconnect(connection);
    }
}
