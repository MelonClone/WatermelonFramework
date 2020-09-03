package org.watermelon.framework.global.model.viewmodel;


import androidx.lifecycle.MutableLiveData;

import org.watermelon.framework.global.model.view.states.LoginState;

public interface ViewModelLoginState<U extends LoginState.Login> {
    MutableLiveData<LoginState<U>> getLoginState();
}
