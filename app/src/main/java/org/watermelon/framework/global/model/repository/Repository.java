package org.watermelon.framework.global.model.repository;

import org.watermelon.framework.global.model.domain.Domain;
import org.watermelon.framework.global.model.view.states.NetworkState;

import java.util.List;

public interface Repository {
    interface RepoCallback<D extends Domain> {

        void success(D domain);

        void fail(NetworkState e);
    }

    interface RepoListCallback<L extends List> {

        void success(L domain);

        void fail(NetworkState e);
    }
}
