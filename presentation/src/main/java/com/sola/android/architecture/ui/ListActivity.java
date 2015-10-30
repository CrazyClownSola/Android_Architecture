package com.sola.android.architecture.ui;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.sola.android.architecture.R;
import com.sola.android.architecture.adapter.BasicRecycleViewAdapter;
import com.sola.android.architecture.domain.User;
import com.sola.android.architecture.domain.interactor.DefaultSubscriber;
import com.sola.android.architecture.internal.di.HasComponent;
import com.sola.android.architecture.internal.di.components.DaggerDataComponent;
import com.sola.android.architecture.internal.di.components.DataComponent;
import com.sola.android.architecture.internal.di.modules.ActivityModule;
import com.sola.android.architecture.internal.di.modules.DataModule;
import com.sola.android.architecture.view.RecycleFixHeaderView;
import com.sola.android.architecture.view.RecycleFixHeaderView_;
import com.sola.android.architecture.view.interactor.IRecycleListItem;
import com.sola.module.recycle.fix_container.RecyclerViewPTRFixLoadMoreContainer;
import com.sola.module.recycle.fix_container.RecyclerViewRefreshContainerBase;
import com.sola.module.recycle.fix_container.utils.PtrDefaultHandler;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * author: Sola
 * 2015/10/30
 */
@EActivity(R.layout.activity_list)
public class ListActivity extends BaseActivity implements HasComponent<DataComponent> {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    @ViewById
    Toolbar id_tool_bar;

    @ViewById
    RecyclerViewPTRFixLoadMoreContainer id_container;

    @ViewById
    RecyclerView id_recycler_view;

    DataComponent component;

    BasicRecycleViewAdapter<IRecycleListItem> adapter;

    List<IRecycleListItem> cacheList;

    RecycleFixHeaderView headerView;

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
        component = DaggerDataComponent.builder()
                .applicationComponent(getApplicationComponent())
                .dataModule(new DataModule())
                .activityModule(new ActivityModule(this))
                .build();
    }

    @Override
    public DataComponent getComponent() {
        return component;
    }

    // ===========================================================
    // Methods
    // ===========================================================

    @AfterViews
    public void afterViews() {

        setSupportActionBar(id_tool_bar);
        // 初始化header
        headerView = RecycleFixHeaderView_.build(this);
        //设定PullToRefresh的事件监听
        id_container.setPTRHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(RecyclerViewRefreshContainerBase frame) {
                refreshMore();
            }
        });
        // 代码级别的动态设定HeaderView，也可以在Xml文件中添加进去
        id_container.setHeaderView(headerView);
        //添加UI监听
        id_container.addPTRUIHandler(headerView);

        //初始配置，后期我会进行一定的优化把这个去除掉
        id_container.setShowLoadingForFirstPage(true);

        // RecyclerView的设定，如果不懂这方面的知识请百度
        id_recycler_view.setLayoutManager(new LinearLayoutManager(this));
        id_recycler_view.setItemAnimator(new DefaultItemAnimator());

        if (cacheList == null)
            cacheList = new ArrayList<>();
        //设定适配器
        adapter = new BasicRecycleViewAdapter<>(this, cacheList);
        id_recycler_view.setAdapter(adapter);

        //这里有设置一个延迟只是为了更好的呈现效果
        id_container.postDelayed(new Runnable() {
            @Override
            public void run() {
                id_container.autoRefresh(false);
            }
        }, 300);

    }


    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

    private void refreshMore() {
        //包含网络请求，数据转换等操作
        component.getUserCase().execute(new UserListSubscriber());
    }


    private final class UserListSubscriber extends DefaultSubscriber<List<User>> {

        @Override
        public void onCompleted() {
            adapter.refreshList(cacheList);
            adapter.notifyDataSetChanged();
            id_container.refreshComplete();
        }

        @Override
        public void onError(Throwable e) {
            id_container.refreshComplete();
        }

        @Override
        public void onNext(List<User> users) {
            if (users != null) {
                cacheList.clear();
                cacheList.addAll(component.getModelMapper().transform(users));
            }
        }
    }
}
