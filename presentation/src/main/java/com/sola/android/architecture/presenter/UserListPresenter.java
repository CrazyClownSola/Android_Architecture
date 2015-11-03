package com.sola.android.architecture.presenter;

import com.sola.android.architecture.domain.User;
import com.sola.android.architecture.domain.exception.DefaultErrorBundle;
import com.sola.android.architecture.domain.interactor.DefaultSubscriber;
import com.sola.android.architecture.domain.interactor.UserCase;
import com.sola.android.architecture.exception.ErrorMessageFactory;
import com.sola.android.architecture.internal.di.PerActivity;
import com.sola.android.architecture.mapper.UserModelDataMapper;
import com.sola.android.architecture.model.UserModel;
import com.sola.android.architecture.view.UserListView;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * author: Sola
 * 2015/11/2
 */
@PerActivity
public class UserListPresenter implements Presenter {

    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    private final UserCase userCase;

    private final UserModelDataMapper dataMapper;

    private UserListView mListView;


    // ===========================================================
    // Constructors
    // ===========================================================

    @Inject
    public UserListPresenter(@Named("UserList") UserCase userCase,
                             UserModelDataMapper dataMapper) {
        this.userCase = userCase;
        this.dataMapper = dataMapper;
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    public void setUserListView(UserListView mListView) {
        this.mListView = mListView;
    }

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        //销毁Observer的进程
        userCase.unsubscribe();
    }

    // ===========================================================
    // Methods
    // ===========================================================

    public void getUserList() {
        userCase.execute(new UserListSubscriber());
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

    private final class UserListSubscriber
            extends DefaultSubscriber<List<User>> {

        @Override
        public void onCompleted() {
            if (mListView != null)
                mListView.doComplete();
        }

        @Override
        public void onNext(List<User> users) {
            final Collection<UserModel> userModels = dataMapper.transform(users);
            if (mListView != null)
                mListView.refreshUserList(userModels);
//            userModels.st

        }

        @Override
        public void onError(Throwable e) {
            if (mListView != null) {
                //其实不是很明白这么做的原因是什么
                String errorMessage =
                        ErrorMessageFactory.create(
                                mListView.getContext(),
                                //在这里对e进行一次强转的意义未知
                                new DefaultErrorBundle((Exception) e).getException());
                mListView.showError(errorMessage);
            }
        }

    }

}
