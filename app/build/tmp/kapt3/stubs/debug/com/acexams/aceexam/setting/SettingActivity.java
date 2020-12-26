package com.acexams.aceexam.setting;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u00020.J\u0012\u00100\u001a\u00020.2\b\u00101\u001a\u0004\u0018\u000102H\u0014J\u0006\u00103\u001a\u00020.J\b\u00104\u001a\u00020.H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\'\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001a\u0010*\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\b\u00a8\u00065"}, d2 = {"Lcom/acexams/aceexam/setting/SettingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "course", "", "getCourse", "()Ljava/lang/String;", "setCourse", "(Ljava/lang/String;)V", "dialog", "Landroid/app/Dialog;", "getDialog", "()Landroid/app/Dialog;", "setDialog", "(Landroid/app/Dialog;)V", "google_login_value", "getGoogle_login_value", "setGoogle_login_value", "id", "getId", "setId", "mAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "getMAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "setMAuth", "(Lcom/google/firebase/auth/FirebaseAuth;)V", "mGoogleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "getMGoogleSignInClient", "()Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "setMGoogleSignInClient", "(Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;)V", "progressDoalog", "Landroid/app/ProgressDialog;", "getProgressDoalog", "()Landroid/app/ProgressDialog;", "setProgressDoalog", "(Landroid/app/ProgressDialog;)V", "token", "getToken", "setToken", "userName", "getUserName", "setUserName", "dialig", "", "logout", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "opendialog", "profile", "app_debug"})
public final class SettingActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String token = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String id = "";
    @org.jetbrains.annotations.Nullable()
    private android.app.ProgressDialog progressDoalog;
    @org.jetbrains.annotations.NotNull()
    public java.lang.String course;
    @org.jetbrains.annotations.NotNull()
    public java.lang.String google_login_value;
    @org.jetbrains.annotations.NotNull()
    public com.google.android.gms.auth.api.signin.GoogleSignInClient mGoogleSignInClient;
    @org.jetbrains.annotations.NotNull()
    public java.lang.String userName;
    @org.jetbrains.annotations.NotNull()
    public com.google.firebase.auth.FirebaseAuth mAuth;
    @org.jetbrains.annotations.NotNull()
    public android.app.Dialog dialog;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getToken() {
        return null;
    }
    
    public final void setToken(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.app.ProgressDialog getProgressDoalog() {
        return null;
    }
    
    public final void setProgressDoalog(@org.jetbrains.annotations.Nullable()
    android.app.ProgressDialog p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCourse() {
        return null;
    }
    
    public final void setCourse(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGoogle_login_value() {
        return null;
    }
    
    public final void setGoogle_login_value(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.auth.api.signin.GoogleSignInClient getMGoogleSignInClient() {
        return null;
    }
    
    public final void setMGoogleSignInClient(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.auth.api.signin.GoogleSignInClient p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserName() {
        return null;
    }
    
    public final void setUserName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.auth.FirebaseAuth getMAuth() {
        return null;
    }
    
    public final void setMAuth(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Dialog getDialog() {
        return null;
    }
    
    public final void setDialog(@org.jetbrains.annotations.NotNull()
    android.app.Dialog p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void dialig() {
    }
    
    private final void profile() {
    }
    
    public final void logout() {
    }
    
    public final void opendialog() {
    }
    
    public SettingActivity() {
        super();
    }
}