package org.watermelon.framework.global.model.view.activity;

import org.watermelon.framework.global.consts.Constants;

public interface ThemeApplicableState<T> {
    void colorChange(Constants.Theme colorTheme);
    void setTheme(Constants.Theme colorTheme);
    Constants.Theme getTheme();
    void setApplicableState(T t);
    T getApplicableState();
}
