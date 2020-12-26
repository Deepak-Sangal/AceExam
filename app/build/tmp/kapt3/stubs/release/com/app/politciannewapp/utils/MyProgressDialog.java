package com.app.politciannewapp.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/app/politciannewapp/utils/MyProgressDialog;", "", "()V", "Companion", "app_release"})
public final class MyProgressDialog {
    private static android.app.ProgressDialog progress;
    public static final com.app.politciannewapp.utils.MyProgressDialog.Companion Companion = null;
    
    public MyProgressDialog() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/app/politciannewapp/utils/MyProgressDialog$Companion;", "", "()V", "progress", "Landroid/app/ProgressDialog;", "dismissProgress", "", "setMsg", "msg", "", "showProgress", "context", "Landroid/content/Context;", "showProgressforimport", "total", "current", "app_release"})
    public static final class Companion {
        
        public final void showProgress(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        public final void showProgressforimport(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.lang.String total, @org.jetbrains.annotations.NotNull()
        java.lang.String current) {
        }
        
        public final void setMsg(@org.jetbrains.annotations.NotNull()
        java.lang.String msg) {
        }
        
        public final void dismissProgress() {
        }
        
        private Companion() {
            super();
        }
    }
}