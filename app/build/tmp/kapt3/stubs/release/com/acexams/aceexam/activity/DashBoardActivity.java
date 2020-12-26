package com.acexams.aceexam.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010\u001b\u001a\u00020\u0017J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\u0012\u0010\u001d\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J0\u0010#\u001a\u00020\u00172\f\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)H\u0016J\u0006\u0010*\u001a\u00020\u0017R\u001a\u0010\u0005\u001a\u00020\u0006X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\f\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006+"}, d2 = {"Lcom/acexams/aceexam/activity/DashBoardActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "Landroid/widget/AdapterView$OnItemClickListener;", "()V", "doubleBackToExitPressedOnce", "", "getDoubleBackToExitPressedOnce$app_release", "()Z", "setDoubleBackToExitPressedOnce$app_release", "(Z)V", "titles", "", "", "getTitles", "()[Ljava/lang/String;", "[Ljava/lang/String;", "titlesImages", "", "getTitlesImages", "()[Ljava/lang/Integer;", "[Ljava/lang/Integer;", "listImplement", "", "loadFragment", "fragment", "Landroidx/fragment/app/Fragment;", "logout", "onBackPressed", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "parent", "Landroid/widget/AdapterView;", "view", "position", "id", "", "openDrawer", "app_release"})
public final class DashBoardActivity extends androidx.appcompat.app.AppCompatActivity implements android.view.View.OnClickListener, android.widget.AdapterView.OnItemClickListener {
    private boolean doubleBackToExitPressedOnce = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String[] titles = {"Home", "Know More", "Buy Now", "Acexam Notes", "Acexam Faculty", "FAQ", "Share", "About Us", "Contact US", "T&C", "Log Out"};
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Integer[] titlesImages = {2131165631, 2131165685, 2131165308, 2131165712, 2131165366, 2131165367, 2131165744, 2131165277, 2131165338, 2131165748, 2131165690};
    private java.util.HashMap _$_findViewCache;
    
    public final boolean getDoubleBackToExitPressedOnce$app_release() {
        return false;
    }
    
    public final void setDoubleBackToExitPressedOnce$app_release(boolean p0) {
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
    
    public DashBoardActivity() {
        super();
    }
}