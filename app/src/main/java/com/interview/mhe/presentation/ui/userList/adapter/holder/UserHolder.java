package com.interview.mhe.presentation.ui.userList.adapter.holder;

import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.RelativeLayout;


import com.interview.mhe.presentation.base.BaseRecyclerViewHolder;
import com.interview.mhe.presentation.uiObjects.UserObject;
import com.mhe.R;

import butterknife.BindView;

public class UserHolder extends BaseRecyclerViewHolder<UserObject> {

    public interface UserClickListener {
        void clickedOnFriend(UserObject userObject);
    }

    UserClickListener userClickListener;

    @BindView(R.id.lblTitle)
    AppCompatTextView lblTitle;
    @BindView(R.id.rlContainer)
    RelativeLayout rlContainer;


    public UserHolder(View view, UserClickListener userClickListener) {
        super(view);
        this.userClickListener = userClickListener;
    }

    @Override
    public void onBindViewHolder(UserObject data) {
        lblTitle.setText(data.getTitle());
        rlContainer.setOnClickListener(v -> {
            if (userClickListener != null) {
                userClickListener.clickedOnFriend(data);
            }
        });
    }
}
