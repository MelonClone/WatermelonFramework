package org.watermelon.framework.global.model.viewmodel;

import androidx.lifecycle.LiveData;

import java.util.List;

public interface ListViewModel<T> {
    LiveData<List<T>> getList();
}
