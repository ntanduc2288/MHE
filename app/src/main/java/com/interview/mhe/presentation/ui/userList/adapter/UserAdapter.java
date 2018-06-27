package com.interview.mhe.presentation.ui.userList.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.interview.mhe.presentation.base.BaseRecyclerViewAdapter;
import com.interview.mhe.presentation.ui.userList.adapter.holder.UserHolder;
import com.interview.mhe.presentation.uiObjects.UserObject;
import com.mhe.R;


public class UserAdapter extends BaseRecyclerViewAdapter<UserHolder, UserObject> {

    UserHolder.UserClickListener userClickListener;


    public UserAdapter(Context context, UserHolder.UserClickListener userClickListener) {
        super(context);
        this.userClickListener = userClickListener;
    }

    @Override
    public void onBindViewHolder(UserHolder viewHolder, int position, UserObject data) {
        viewHolder.onBindViewHolder(data);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.user_item, parent, false);
        return new UserHolder(view, userClickListener);
    }
}
