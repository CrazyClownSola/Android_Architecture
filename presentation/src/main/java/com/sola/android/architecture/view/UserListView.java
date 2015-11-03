package com.sola.android.architecture.view;

import com.sola.android.architecture.model.UserModel;
import com.sola.android.architecture.view.interactor.ILoadingView;

import java.util.Collection;
import java.util.Collections;

/**
 * author: Sola
 * 2015/11/2
 */
public interface UserListView extends ILoadingView {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    void refreshUserList(Collection<UserModel> userModels);

    void userListItem(UserModel userModel);

}
