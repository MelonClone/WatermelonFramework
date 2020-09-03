package org.watermelon.framework.global.model.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.watermelon.framework.global.model.view.states.LoginState;
import org.watermelon.framework.global.model.view.states.ViewState;

public abstract class BaseViewModel<U extends LoginState.Login> extends ViewModel implements ViewModelLoginState<U>, ViewModelViewState {

    // Need binding with view (login state managing)
    private MutableLiveData<ViewState> viewState;
    private MutableLiveData<LoginState<U>> loginState;
/*

    // TODO DI
    private UserDataSource userDataSource;

    private DatabaseCallback userDataSourceCallback = new DatabaseCallback() {
        @Override
        public void callback(Message msg) {
            if (msg.arg1 == UserDataSource.GET_USER) {
                User user = (User) msg.obj;
                if (user == null) loginState.setValue(new LoginState(false, null));
                else if (!JwtParser.verify(user.getJwtToken()))
                    loginState.setValue(new LoginState(false, null));

                loginState.setValue(new LoginState(true, user));
            }
        }
    };
*/

    public BaseViewModel() {
        beforeInit();
        init();
    }

    protected void beforeInit() {
        viewState = new MutableLiveData<>();
        loginState = new MutableLiveData<>();

//        userDataSource = new LocalUserDataSource(DBHelper.getInstance().getDB().userDao(), userDataSourceCallback);
    }

    abstract protected void init();
/*

    // 로그인 확인
    public void checkLogin() {
        userDataSource.getUserInfo();
    }
*/

    @Override
    public MutableLiveData<LoginState<U>> getLoginState() {
        return loginState;
    }

    @Override
    public MutableLiveData<ViewState> getViewState() {
        return viewState;
    }
}
