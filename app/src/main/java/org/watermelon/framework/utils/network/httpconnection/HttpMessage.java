package org.watermelon.framework.utils.network.httpconnection;

public interface HttpMessage<T> {
    T send();
}
