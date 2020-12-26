package com.acexams.aceexam.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0012\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\u0018\u0010\u001f\u001a\u00020\u00182\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010!H\u0002J\u0018\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0002J\"\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u00042\u0006\u0010\'\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\u0012\u0010*\u001a\u00020\u00182\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\u0006\u0010-\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006."}, d2 = {"Lcom/acexams/aceexam/activity/CommonActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "RC_SIGN_IN", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "mAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "getMAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "setMAuth", "(Lcom/google/firebase/auth/FirebaseAuth;)V", "mGoogleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "getMGoogleSignInClient", "()Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "setMGoogleSignInClient", "(Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;)V", "FirebaseGoogleAuth", "", "account", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "UpdateUI", "user", "Lcom/google/firebase/auth/FirebaseUser;", "googleSign", "handleSignInResulyt", "completedTask", "Lcom/google/android/gms/tasks/Task;", "login", "email", "name", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "requestPermission", "app_release"})
public final class CommonActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public com.google.android.gms.auth.api.signin.GoogleSignInClient mGoogleSignInClient;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String TAG = "Login";
    @org.jetbrains.annotations.NotNull()
    public com.google.firebase.auth.FirebaseAuth mAuth;
    private final int RC_SIGN_IN = 234;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.auth.api.signin.GoogleSignInClient getMGoogleSignInClient() {
        return null;
    }
    
    public final void setMGoogleSignInClient(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.auth.api.signin.GoogleSignInClient p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTAG() {
        return null;
    }
    
    public final void setTAG(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.auth.FirebaseAuth getMAuth() {
        return null;
    }
    
    public final void setMAuth(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void requestPermission() {
    }
    
    private final void googleSign() {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void handleSignInResulyt(com.google.android.gms.tasks.Task<com.google.android.gms.auth.api.signin.GoogleSignInAccount> completedTask) {
    }
    
    private final void FirebaseGoogleAuth(com.google.android.gms.auth.api.signin.GoogleSignInAccount account) {
    }
    
    private final void UpdateUI(com.google.firebase.auth.FirebaseUser user) {
    }
    
    private final void login(java.lang.String email, java.lang.String name) {
    }
    
    public CommonActivity() {
        super();
    }
}