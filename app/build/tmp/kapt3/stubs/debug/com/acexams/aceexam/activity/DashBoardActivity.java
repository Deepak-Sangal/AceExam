package com.acexams.aceexam.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\'\u001a\u00020(J\b\u0010)\u001a\u00020(H\u0002J\u0010\u0010*\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\u0006\u0010+\u001a\u00020(J\b\u0010,\u001a\u00020(H\u0016J\u0012\u0010-\u001a\u00020(2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0012\u00100\u001a\u00020(2\b\u00101\u001a\u0004\u0018\u000102H\u0014J0\u00103\u001a\u00020(2\f\u00104\u001a\b\u0012\u0002\b\u0003\u0018\u0001052\b\u00106\u001a\u0004\u0018\u00010/2\u0006\u00107\u001a\u00020#2\u0006\u00108\u001a\u000209H\u0016J\u0006\u0010:\u001a\u00020(J\u0006\u0010;\u001a\u00020(J\u0016\u0010<\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0019\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u001e\u00a2\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0019\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u001e\u00a2\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%\u00a8\u0006>"}, d2 = {"Lcom/acexams/aceexam/activity/DashBoardActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "Landroid/widget/AdapterView$OnItemClickListener;", "()V", "currentFag", "Landroidx/fragment/app/Fragment;", "getCurrentFag", "()Landroidx/fragment/app/Fragment;", "setCurrentFag", "(Landroidx/fragment/app/Fragment;)V", "dialog", "Landroid/app/Dialog;", "getDialog", "()Landroid/app/Dialog;", "setDialog", "(Landroid/app/Dialog;)V", "doubleBackToExitPressedOnce", "", "getDoubleBackToExitPressedOnce$app_debug", "()Z", "setDoubleBackToExitPressedOnce$app_debug", "(Z)V", "fragment", "", "getFragment", "()Ljava/lang/String;", "setFragment", "(Ljava/lang/String;)V", "titles", "", "getTitles", "()[Ljava/lang/String;", "[Ljava/lang/String;", "titlesImages", "", "getTitlesImages", "()[Ljava/lang/Integer;", "[Ljava/lang/Integer;", "exitlogout", "", "listImplement", "loadFragment", "logout", "onBackPressed", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "parent", "Landroid/widget/AdapterView;", "view", "position", "id", "", "openDrawer", "opendialog", "switchfragment", "isBack", "app_debug"})
public final class DashBoardActivity extends androidx.appcompat.app.AppCompatActivity implements android.view.View.OnClickListener, android.widget.AdapterView.OnItemClickListener {
    private boolean doubleBackToExitPressedOnce = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String fragment = "";
    @org.jetbrains.annotations.NotNull()
    public android.app.Dialog dialog;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String[] titles = {"Home", "Explore Acexam", "Enroll Now", "Study Metarial", "Acexam Faculty", "FAQ", "Share", "About Us", "Contact US", "T&C", "Log Out"};
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Integer[] titlesImages = {2131165640, 2131165695, 2131165309, 2131165722, 2131165373, 2131165374, 2131165756, 2131165277, 2131165340, 2131165760, 2131165700};
    @org.jetbrains.annotations.Nullable()
    private androidx.fragment.app.Fragment currentFag;
    private java.util.HashMap _$_findViewCache;
    
    public final boolean getDoubleBackToExitPressedOnce$app_debug() {
        return false;
    }
    
    public final void setDoubleBackToExitPressedOnce$app_debug(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFragment() {
        return null;
    }
    
    public final void setFragment(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Dialog getDialog() {
        return null;
    }
    
    public final void setDialog(@org.jetbrains.annotations.NotNull()
    android.app.Dialog p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getTitles() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Integer[] getTitlesImages() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
    
    private final void loadFragment(androidx.fragment.app.Fragment fragment) {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    public final void exitlogout() {
    }
    
    private final void listImplement() {
    }
    
    public final void openDrawer() {
    }
    
    @java.lang.Override()
    public void onItemClick(@org.jetbrains.annotations.Nullable()
    android.widget.AdapterView<?> parent, @org.jetbrains.annotations.Nullable()
    android.view.View view, int position, long id) {
    }
    
    public final void logout() {
    }
    
    public final void opendialog() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.fragment.app.Fragment getCurrentFag() {
        return null;
    }
    
    public final void setCurrentFag(@org.jetbrains.annotations.Nullable()
    androidx.fragment.app.Fragment p0) {
    }
    
    public final void switchfragment(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment, boolean isBack) {
    }
    
    public DashBoardActivity() {
        super();
    }
}