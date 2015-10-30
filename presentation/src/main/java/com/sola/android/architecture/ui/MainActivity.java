package com.sola.android.architecture.ui;

import android.widget.TextView;

import com.sola.android.architecture.R;
import com.sola.android.architecture.domain.executor.ThreadExecutor;
import com.sola.android.architecture.internal.di.components.DaggerApplicationComponent;
import com.sola.android.architecture.test.MyInjectClass;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

/**
 * Description:
 * <p>
 * author: Sola
 * 2015/10/28
 */
@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    @ViewById
    TextView id_test_text;

    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    @AfterViews
    public void afterViews() {
        id_test_text.setText("有数据");
//        myInjectClass.execute(() -> {
//            try {
//                Thread.sleep(5 * 1000);
//            } catch (InterruptedException e) {
//                 e.printStackTrace();
//            }
//            refreshView();
//        });
    }

    @UiThread
    public void refreshView() {
        id_test_text.setText("");
    }

    @Click
    public void id_btn_switch() {
        navigator.navigatorToListActivity(this);
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
