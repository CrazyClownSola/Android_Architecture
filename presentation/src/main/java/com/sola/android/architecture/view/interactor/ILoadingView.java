package com.sola.android.architecture.view.interactor;

import android.content.Context;

/**
 * author: Sola
 * 2015/11/3
 */
public interface ILoadingView {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    /**
     * do something after loading complete
     */
    void doComplete();

    /**
     * Show an error message
     *
     * @param message A string representing an error.
     */
    void showError(String message);

    /**
     * Get a {@link android.content.Context}.
     */
    Context getContext();
}
