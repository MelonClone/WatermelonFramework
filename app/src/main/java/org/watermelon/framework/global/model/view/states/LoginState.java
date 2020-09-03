package org.watermelon.framework.global.model.view.states;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginState<U extends LoginState.Login> {
    boolean isLogin;
    U user;

    public interface Login {

    }
}
