package com.interview.mhe.presentation.ui.userDetail;

import com.interview.mhe.presentation.uiObjects.UserObject;
import com.mhe.R;

public class UserDetailPresenterImpl implements UserDetailPresenter.Presenter {
    UserDetailPresenter.View view;

    public UserDetailPresenterImpl(UserDetailPresenter.View view) {
        this.view = view;
    }

    @Override
    public void handleUserData(UserObject userObject) {
        if (view != null) {
            if (userObject != null) {
                view.bindUserDataToView(userObject);
            }else {
                view.showMessage(view.getContext().getString(R.string.invalid_user_data));
            }
        }
    }

    @Override
    public void release() {
        view = null;
    }
}
