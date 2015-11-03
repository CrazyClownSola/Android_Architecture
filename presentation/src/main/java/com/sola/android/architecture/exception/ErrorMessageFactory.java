package com.sola.android.architecture.exception;

import android.accounts.NetworkErrorException;
import android.content.Context;

import com.sola.android.architecture.R;
import com.sola.android.architecture.data.exception.NetworkConnectionException;
import com.sola.android.architecture.data.exception.UserNotFoundException;

/**
 * author: Sola
 * 2015/11/3
 */
public class ErrorMessageFactory {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Constructors
    // ===========================================================

    private ErrorMessageFactory() {

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

    /**
     * Create a String to express an error message
     *
     * @param context need context to get String resource
     * @param exception the error occurred
     * @return the expression of error
     */
    public static String create(Context context, Exception exception) {
        String message = context.getString(R.string.E_A_001);
        if (exception instanceof NetworkConnectionException) {
            message = context.getString(R.string.E_A_002);
        } else if (exception instanceof UserNotFoundException) {
            message = context.getString(R.string.E_A_003);
        }
        return message;
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
