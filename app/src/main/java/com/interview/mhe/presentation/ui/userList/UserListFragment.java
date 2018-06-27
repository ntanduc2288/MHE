package com.interview.mhe.presentation.ui.userList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.interview.mhe.presentation.ui.userList.adapter.UserAdapter;
import com.interview.mhe.presentation.base.BaseFragment;
import com.interview.mhe.presentation.ui.userDetail.UserDetailFragment;
import com.interview.mhe.presentation.uiObjects.UserObject;
import com.interview.mhe.presentation.utils.TransactionUtil;
import com.mhe.R;

import java.util.ArrayList;

import butterknife.BindView;

public class UserListFragment extends BaseFragment implements UserListPresenter.View{

    @BindView(R.id.recyclerViewUserList)
    RecyclerView recyclerViewUserList;
    private LinearLayoutManager layoutManager;
    private UserAdapter userAdapter;
    private UserListPresenter.Presenter presenter;

    public static UserListFragment newInstance() {
        UserListFragment userListFragment = new UserListFragment();
        return userListFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        presenter = new UserListPresenterImpl(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.user_list_container;
    }

    @Override
    protected void initViews() {
        initUserListView();
        presenter.triggerLoadUserDatas();
    }

    @Override
    public void initUserListView() {
        layoutManager = new LinearLayoutManager(getContext(), OrientationHelper.VERTICAL, false);
        recyclerViewUserList.setLayoutManager(layoutManager);
        recyclerViewUserList.setItemAnimator(new DefaultItemAnimator());
        recyclerViewUserList.setHasFixedSize(true);
        recyclerViewUserList.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        userAdapter = new UserAdapter(getContext(), userObject -> {
            gotoUserDetailScreen(userObject);
        });
        recyclerViewUserList.setAdapter(userAdapter);
    }

    @Override
    public void bindUsersToUI(ArrayList<UserObject> userObjects) {
        userAdapter.refreshItems(userObjects);
    }

    @Override
    public void gotoUserDetailScreen(UserObject userObject) {
        TransactionUtil.addFragment(getFragmentManager(), R.id.container, UserDetailFragment.newInstance(userObject), true);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        presenter.release();
        super.onDestroy();
    }


}
