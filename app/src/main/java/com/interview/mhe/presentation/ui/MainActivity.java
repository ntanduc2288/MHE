package com.interview.mhe.presentation.ui;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.interview.mhe.presentation.ui.userList.UserListFragment;
import com.interview.mhe.presentation.utils.TransactionUtil;
import com.mhe.R;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addUserListFragment();
    }

    private void addUserListFragment(){
        TransactionUtil.addFragmentDefaultAnimation(getSupportFragmentManager(), R.id.container, UserListFragment.newInstance(), false);
    }

}
