package org.watermelon.framework.global.model.view.activity;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseActivity extends AppCompatActivity {
    private Map<String, ViewModel> viewModelContainer = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layoutInit();
        toolbarInit();
        viewInit();
        viewModelInit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        listenerInit();
    }

    abstract protected void layoutInit();
    protected void toolbarInit() {

    }
    abstract protected void viewInit();
    abstract protected void viewModelInit();
    abstract protected void listenerInit();

    // -- View methods
    protected void getCleanActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(false);
    }

    protected ViewGroup getRootView() {
        return (ViewGroup) getWindow().getDecorView();
    }

    public void addViewModel(ViewModel viewModel) {
        viewModelContainer.put(viewModel.getClass().getSimpleName(), viewModel);
    }

    public ViewModel getViewModel(String viewModelName) {
        return viewModelContainer.get(viewModelName);
    }
}
