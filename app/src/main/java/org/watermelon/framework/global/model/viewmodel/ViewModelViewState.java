package org.watermelon.framework.global.model.viewmodel;


import androidx.lifecycle.MutableLiveData;

import org.watermelon.framework.global.model.view.states.ViewState;

public interface ViewModelViewState {
    MutableLiveData<ViewState> getViewState();
}
