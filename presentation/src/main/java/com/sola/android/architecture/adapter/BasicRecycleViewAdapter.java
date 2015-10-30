package com.sola.android.architecture.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.sola.android.architecture.view.interactor.IRecycleListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * <p>
 * author: Sola
 * 2015/10/13
 */
public class BasicRecycleViewAdapter<Param extends IRecycleListItem>
        extends RecycleHeaderAndFooterViewAdapter {

    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    protected List<Param> cacheList;

    // ===========================================================
    // Constructors
    // ===========================================================

    public BasicRecycleViewAdapter(Context mContext, List<Param> cacheList) {
        super(mContext);
        refreshList(cacheList);
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================
    @Override
    protected int getCount() {
        return cacheList == null ? 0 : cacheList.size();
    }

    @Override
    protected void onBindView(Context mContext, RecyclerView.ViewHolder holder, int position) {
        cacheList.get(position).refreshView(mContext, holder);
    }

    @Override
    protected RecyclerView.ViewHolder onCreateView(Context mContext, ViewGroup parent, int viewType) {
        return cacheList.get(viewType).getHolder(mContext, parent);
    }

    // ===========================================================
    // Methods
    // ===========================================================

    public void refreshList(List<Param> params) {
        if (params == null || params.size() == 0) {
            cacheList = new ArrayList<>();
        } else {
            if (cacheList == null)
                cacheList = new ArrayList<>();
            cacheList.clear();
            cacheList.addAll(params);
        }
    }

    public void addItem(int position, Param item) {
        cacheList.add(position, item);
        notifyItemInserted(position);
    }

    public void removeItem(int position) {
        cacheList.remove(position);
        notifyItemRemoved(position);
    }

    public void removeItem(Param item) {
        int position = cacheList.indexOf(item);
        if (position != -1) {
            cacheList.remove(item);
            notifyItemRemoved(position);
        }
    }
    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
