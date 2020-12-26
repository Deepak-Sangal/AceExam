package com.acexams.aceexam.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010&\u001a\u00020\'J\"\u0010(\u001a\u00020\'2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010+H\u0014J\u0012\u0010,\u001a\u00020\'2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\b\u0010/\u001a\u00020\'H\u0002J\u000e\u00100\u001a\u00020\'2\u0006\u00101\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\nR\u001a\u0010\u001d\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\b\"\u0004\b\u001f\u0010\nR\u001a\u0010 \u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\b\"\u0004\b\"\u0010\nR\u001a\u0010#\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\b\"\u0004\b%\u0010\n\u00a8\u00062"}, d2 = {"Lcom/acexams/aceexam/activity/PlandeatilsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "ActivityRequestCode", "", "OrderIdString", "", "getOrderIdString", "()Ljava/lang/String;", "setOrderIdString", "(Ljava/lang/String;)V", "TAG", "getTAG", "setTAG", "amount", "getAmount", "setAmount", "checksum", "getChecksum", "setChecksum", "data", "Lcom/acexams/aceexam/activity/modal/PlanResponse$Data;", "getData", "()Lcom/acexams/aceexam/activity/modal/PlanResponse$Data;", "setData", "(Lcom/acexams/aceexam/activity/modal/PlanResponse$Data;)V", "midString", "getMidString", "setMidString", "orderid", "getOrderid", "setOrderid", "txnAmountString", "getTxnAmountString", "setTxnAmountString", "txnTokenString", "getTxnTokenString", "setTxnTokenString", "getToken", "", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setdata", "startPaytmPayment", "token", "app_release"})
public final class PlandeatilsActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public com.acexams.aceexam.activity.modal.PlanResponse.Data data;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String checksum = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String orderid = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String TAG = "Main Activity";
    @org.jetbrains.annotations.NotNull()
    public java.lang.String amount;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String midString = "Teqtis50366959612907";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String txnAmountString = "200";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String OrderIdString = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String txnTokenString = "";
    private final int ActivityRequestCode = 2;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.acexams.aceexam.activity.modal.PlanResponse.Data getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    com.acexams.aceexam.activity.modal.PlanResponse.Data p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getChecksum() {
        return null;
    }
    
    public final void setChecksum(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOrderid() {
        return null;
    }
    
    public final void setOrderid(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTAG() {
        return null;
    }
    
    public final void setTAG(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAmount() {
        return null;
    }
    
    public final void setAmount(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMidString() {
        return null;
    }
    
    public final void setMidString(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTxnAmountString() {
        return null;
    }
    
    public final void setTxnAmountString(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOrderIdString() {
        return null;
    }
    
    public final void setOrderIdString(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTxnTokenString() {
        return null;
    }
    
    public final void setTxnTokenString(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setdata() {
    }
    
    public final void getToken() {
    }
    
    public final void startPaytmPayment(@org.jetbrains.annotations.NotNull()
    java.lang.String token) {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    public PlandeatilsActivity() {
        super();
    }
}