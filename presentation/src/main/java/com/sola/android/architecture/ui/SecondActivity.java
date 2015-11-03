package com.sola.android.architecture.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sola.android.architecture.R;
import com.sola.android.architecture.adapter.RecyclerContainerAdapter;
import com.sola.android.architecture.internal.di.HasComponent;
import com.sola.android.architecture.internal.di.components.DaggerSecondComponent;
import com.sola.android.architecture.internal.di.components.SecondComponent;
import com.sola.android.architecture.internal.di.modules.ActivityModule;
import com.sola.android.architecture.internal.di.modules.SecondModule;
import com.sola.android.architecture.model.UserModel;
import com.sola.android.architecture.view.RecycleFixHeaderView;
import com.sola.android.architecture.view.RecycleFixHeaderView_;
import com.sola.android.architecture.view.UserListView;
import com.sola.android.architecture.view.interactor.IRecycleListItem;
import com.sola.module.recycle.fix_container.PTRLMRecyclerContainer;
import com.sola.module.recycle.fix_container.RecyclerContainerBase;
import com.sola.module.recycle.fix_container.utils.PtrDefaultHandler;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * author: Sola
 * 2015/11/2
 */
@EActivity(R.layout.activity_second)
public class SecondActivity extends BaseActivity
        implements HasComponent<SecondComponent>, UserListView {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    SecondComponent secondComponent;

    @ViewById
    PTRLMRecyclerContainer id_container;

//    @ViewById
//    RecycleFixHeaderView id_header_view;

    @ViewById
    RecyclerView id_recycler_view;

    RecycleFixHeaderView headerView;

    List<IRecycleListItem> cacheList;

    RecyclerContainerAdapter<IRecycleListItem> adapter;

    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        secondComponent = DaggerSecondComponent.builder()
                .applicationComponent(getApplicationComponent())
                .secondModule(new SecondModule())
                .activityModule(new ActivityModule(this))
                .build();
    }


    // ===========================================================
    // Methods
    // ===========================================================

    @AfterViews
    public void afterViews() {
        headerView = RecycleFixHeaderView_.build(this);
        //添加一个监听在这里
        getComponent().getUserListPresenter().setUserListView(this);
        //添加
        id_container.setHeaderView(headerView);
        id_container.addPTRUIHandler(headerView);
        id_container.setPTRHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(RecyclerContainerBase recyclerContainerBase) {
                getComponent().getUserListPresenter().getUserList();
            }
        });
        id_container.setShowLoadingForFirstPage(false);

        id_recycler_view.setLayoutManager(new LinearLayoutManager(this));
        id_recycler_view.setItemAnimator(new DefaultItemAnimator());

        if (cacheList == null)
            cacheList = new ArrayList<>();

        adapter = new RecyclerContainerAdapter<>(this, cacheList);
        adapter.setOnRecyclerItemClickListener(o -> {
            if (o instanceof UserModel) {
//                getComponent().getUserListPresenter().
            }
        });
        id_recycler_view.setAdapter(adapter);

        id_container.postDelayed(
                () -> id_container.autoRefresh(false)
                , 200);
    }


    @Override
    public SecondComponent getComponent() {
        return secondComponent;
    }

    @Override
    public void refreshUserList(Collection<UserModel> userModels) {
        cacheList.clear();
        cacheList.addAll(userModels);
        adapter.refreshList(cacheList);
    }

    @Override
    public void userListItem(UserModel userModel) {

    }

    @Override
    public void doComplete() {
        adapter.notifyDataSetChanged();
        id_container.refreshComplete();
    }

    @Override
    public void showError(String message) {
        Snackbar.make(
                id_container,
                message,
                Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return this;
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
