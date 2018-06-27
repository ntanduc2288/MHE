package com.interview.mhe.presentation.ui.userDetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.widget.Toast;

import com.interview.mhe.presentation.base.BaseFragment;
import com.interview.mhe.presentation.uiObjects.UserObject;
import com.mhe.R;

import butterknife.BindView;

public class UserDetailFragment extends BaseFragment implements UserDetailPresenter.View{

    private UserObject userObject;
    @BindView(R.id.lblTitle)
    public AppCompatTextView lblTitle;
    @BindView(R.id.lblUserId)
    public AppCompatTextView lblUserId;
    @BindView(R.id.lblBody)
    public AppCompatTextView lblBody;

    UserDetailPresenter.Presenter presenter;

    public static UserDetailFragment newInstance(UserObject userObject){
        UserDetailFragment userDetailFragment = new UserDetailFragment();
        userDetailFragment.userObject = userObject;
        return userDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        presenter = new UserDetailPresenterImpl(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.user_detail;
    }

    @Override
    protected void initViews() {
        presenter.handleUserData(userObject);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void bindUserDataToView(UserObject userObject) {
        lblTitle.setText(userObject.getTitle());
        lblUserId.setText(String.valueOf(userObject.getUserId()));
        lblBody.setText(userObject.getBody());
    }

    @Override
    public void onDestroy() {
        presenter.release();
        super.onDestroy();
    }
}
