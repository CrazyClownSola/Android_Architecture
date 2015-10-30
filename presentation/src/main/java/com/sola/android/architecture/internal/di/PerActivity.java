package com.sola.android.architecture.internal.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;
import javax.inject.Singleton;

/**
 * A scoping annotation to permit objects whose lifetime should
 * conform to the life of the activity to be memorized in the
 * correct component.
 * 为了确保Activity的生命周期是被记录在正确的组件中
 * <p>
 * author: Sola
 * 2015/10/28
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
