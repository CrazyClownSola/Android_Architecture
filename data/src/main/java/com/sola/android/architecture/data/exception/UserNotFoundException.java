package com.sola.android.architecture.data.exception;

/**
 * author: Sola
 * 2015/11/3
 */
public class UserNotFoundException extends Exception {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Constructors
    // ===========================================================

    public UserNotFoundException() {
    }

    public UserNotFoundException(String detailMessage) {
        super(detailMessage);
    }

    public UserNotFoundException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public UserNotFoundException(Throwable throwable) {
        super(throwable);
    }


    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
