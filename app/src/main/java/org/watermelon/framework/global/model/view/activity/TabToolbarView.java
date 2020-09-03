package org.watermelon.framework.global.model.view.activity;

import android.content.Context;
import android.view.LayoutInflater;

import com.google.android.material.tabs.TabLayout;

import org.watermelon.framework.global.model.handler.TabMenu;

public interface TabToolbarView {
    void tabLayoutInit(TabLayout tabLayout);
    void setupCustomTab(LayoutInflater inflater, TabMenu tabMenu);
    void optionInit();
    void addOnTabSelectedListener(Context context, TabSelectedAction action);

    interface TabSelectedAction {
        void onSelected(TabLayout.Tab tab);
    }

    TabLayout getLayout();
    TabLayout.TabLayoutOnPageChangeListener getListener();
}
