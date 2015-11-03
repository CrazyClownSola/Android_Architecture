package com.sola.android.architecture.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;


import com.sola.android.architecture.view.interactor.IRecycleExtraItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * <p/>
 * author: Sola
 * 2015/10/13
 */
public abstract class RecyclerContainerBaseAdapter
        extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    protected final List<IRecycleExtraItem> headers;

    protected final List<IRecycleExtraItem> footers;

    protected final Context mContext;


    // ===========================================================
    // Constructors
    // ===========================================================
    public RecyclerContainerBaseAdapter(Context mContext) {
        this.mContext = mContext;
        headers = new ArrayList<>();
        footers = new ArrayList<>();
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    public void addHeaderView(IRecycleExtraItem header) {
        headers.add(header);
        notifyItemInserted(headers.size());
    }

    public void removeHeaderView(int headerType) {
        List<IRecycleExtraItem> indexesToRemove = new ArrayList<>();
        for (int i = 0; i < headers.size(); i++) {
            IRecycleExtraItem item = headers.get(i);
            if (item.getViewType() == headerType)
                indexesToRemove.add(item);
        }
        for (IRecycleExtraItem item : indexesToRemove) {
            int index = headers.indexOf(item);
            headers.remove(item);
            notifyItemRemoved(index);
        }
    }

    public void removeHeaderView(IRecycleExtraItem header) {
        int indexToRemove = headers.indexOf(header);
        if (indexToRemove >= 0) {
            headers.remove(indexToRemove);
            notifyItemRemoved(indexToRemove);
        }
    }

    public void addFooterView(IRecycleExtraItem footerView) {
        footers.add(footerView);
        notifyItemInserted(getItemCount());
    }

    public void removeFooterView(int type) {
        List<IRecycleExtraItem> indexesToRemove = new ArrayList<>();
        for (int i = 0; i < footers.size(); i++) {
            IRecycleExtraItem item = footers.get(i);
            if (item.getViewType() == type)
                indexesToRemove.add(item);
        }

        for (IRecycleExtraItem item : indexesToRemove) {
            int index = footers.indexOf(item);
            footers.remove(item);
            notifyItemRemoved(headers.size() + getCount() + index);
        }
    }

    public void removeFooterView(IRecycleExtraItem footerView) {
        int indexToRemove = footers.indexOf(footerView);
        if (indexToRemove >= 0) {
            footers.remove(indexToRemove);
            notifyItemRemoved(headers.size() + getCount() + indexToRemove);
        }
    }
    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        for (IRecycleExtraItem item : headers)
            if (viewType == item.getViewType())
                return item.getHolder(mContext, parent);
        for (IRecycleExtraItem item : footers)
            if (viewType == item.getViewType())
                return item.getHolder(mContext, parent);
        return onCreateView(mContext, parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position >= headers.size() && (position - headers.size()) < getCount())
            onBindView(mContext, holder, position - headers.size());
        else if (position < headers.size())
            headers.get(position).refreshView(mContext, holder);
        else
            footers.get(position - (headers.size() + getCount())).refreshView(mContext, holder);
    }


    @Override
    public int getItemCount() {
        int count = headers.size();
        count += getCount();
        count += footers.size();
        return count;
    }


    @Override
    public int getItemViewType(int position) {
        if (position < headers.size()) {
            return headers.get(position).getViewType();
        } else if (position >= headers.size() + getCount()) {
            return footers.get(position - (headers.size() + getCount())).getViewType();
        } else
            return position;
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

    protected abstract int getCount();

    protected abstract void onBindView(Context mContext, RecyclerView.ViewHolder holder, int position);

    protected abstract RecyclerView.ViewHolder onCreateView(Context mContext, ViewGroup parent, int viewType);

}
