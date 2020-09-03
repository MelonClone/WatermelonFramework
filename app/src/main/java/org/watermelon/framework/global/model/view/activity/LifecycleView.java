package org.watermelon.framework.global.model.view.activity;

import android.view.ViewGroup;

import org.watermelon.framework.global.model.viewmodel.BaseViewModel;

public interface LifecycleView {
    void layoutInit(ViewGroup parentViewGroup);
    void viewInit(ViewGroup viewGroup);
    void viewModelInit(BaseViewModel... viewModels);
    void listenerInit();
}
