package org.watermelon.framework.global.model.view.states;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class NetworkState {
    private int errorCode;
    @Setter
    private String msg;
}
