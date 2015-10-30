package com.sola.android.architecture.domain.exception;

/**
 * author: Sola
 * 2015/10/28
 */
public class DefaultErrorBundle implements ErrorBundle {

    // ===========================================================
    // Constants
    // ===========================================================

    private static final String DEFAULT_ERROR_MSG = "Unknown error";

    // ===========================================================
    // Fields
    // ===========================================================

    private final Exception mException;

    // ===========================================================
    // Constructors
    // ===========================================================

    public DefaultErrorBundle(Exception mException) {
        this.mException = mException;
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public Exception getException() {
        return mException;
    }

    @Override
    public String getErrorMessage() {
        return mException == null ? DEFAULT_ERROR_MSG : mException.getMessage();
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
