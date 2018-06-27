package com.interview.mhe.presentation.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;


public abstract class BaseRecyclerViewAdapter <E, T> extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public abstract void onBindViewHolder(E viewHolder, int position, T data);

    public Context context;
    public LayoutInflater inflater = null;
    public List<T> list;

    private T data;

    public BaseRecyclerViewAdapter(Context context){
        initBase(context, null);
    }

    public BaseRecyclerViewAdapter(Context context, List<T> list){
        initBase(context, list);
    }

    private void initBase(Context context, List<T> list){
        this.context = context;
        if(null == list){
            list = new ArrayList<T>();
        }
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemCount() {
        if(null != list){
            return list.size();
        }
        return 0;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        data = list.get(position);
        onBindViewHolder((E) holder, position, data);
    }

    /**
     * Push new item to top list
     * @param data
     */
    public void pushFirst(T data){
        if(null != data) {
            list.add(0, data);
            notifyItemInserted(0);
        }
    }

    /**
     * Push item to list and only refresh view at index just inserted
     * @param data
     */
    public void pushItem(T data){
        if(null != data) {
            int index = list.size();
            list.add(data);
            notifyItemInserted(index);
        }
    }

    /**
     * Push items to list and only refresh item in range
     * @param data
     */
    public void pushItem(List<T> data){
        if(null != data) {
            int size = data.size();
            if (0 < size) {
                int currentTotal = list.size();
                list.addAll(data);
                notifyItemRangeInserted(currentTotal, (currentTotal + size));
            }
        }
    }

    /**
     * Push items to list and only refresh item in range
     * @param data
     */
    public void pushItemsToFirst(List<T> data){
        if(null != data) {
            int size = data.size();
            if (0 < size) {
                int currentTotal = list.size();
                list.addAll(0, data);
//                notifyItemRangeInserted(0, currentTotal);
                notifyDataSetChanged();
            }
        }
    }

    /**
     * Using for push to refresh (Clear all data and reload view)
     * @param data
     */
    public void refreshItems(List<T> data){
        if(null != list){
            list.clear();
        }
        if((null != data) && (0 < data.size())) {
            list.addAll(data);
        }
        notifyDataSetChanged();
    }

    public void refreshItems(T data){
        if(null != list){
            list.clear();
        }
        if((null != data)) {
            list.add(data);
        }
        notifyDataSetChanged();
    }


    public T getItem(int position){
        if(null != list){
            return list.get(position);
        }
        return null;
    }

    public List<T> getList() {
        return list;
    }
}
