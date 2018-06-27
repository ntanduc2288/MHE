package com.interview.mhe.presentation.base;

import android.content.Context;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

public abstract class BaseRecyclerViewHolder <T> extends RecyclerView.ViewHolder {

    // Bind data to view
    public abstract void onBindViewHolder(T data);

    public BaseRecyclerViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public Context getBaseContext() {
        return itemView.getContext();
    }

    protected String getString(@StringRes int resid) {
        return getBaseContext().getString(resid);
    }

    protected String getString(@StringRes int resid, Object... objects) {
        return getBaseContext().getString(resid, objects);
    }

}