package com.acexams.aceexam.activity.adpater;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0017B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u001c\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/acexams/aceexam/activity/adpater/StateAdpater;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/acexams/aceexam/activity/adpater/StateAdpater$StateHolder;", "context", "Landroid/content/Context;", "stateList", "", "Lcom/acexams/aceexam/activity/modal/StateResponse$Data;", "(Landroid/content/Context;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "getStateList", "()Ljava/util/List;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "StateHolder", "app_release"})
public final class StateAdpater extends androidx.recyclerview.widget.RecyclerView.Adapter<com.acexams.aceexam.activity.adpater.StateAdpater.StateHolder> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.acexams.aceexam.activity.modal.StateResponse.Data> stateList = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.acexams.aceexam.activity.adpater.StateAdpater.StateHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.acexams.aceexam.activity.adpater.StateAdpater.StateHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.acexams.aceexam.activity.modal.StateResponse.Data> getStateList() {
        return null;
    }
    
    public StateAdpater(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.List<com.acexams.aceexam.activity.modal.StateResponse.Data> stateList) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/acexams/aceexam/activity/adpater/StateAdpater$StateHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/acexams/aceexam/activity/adpater/StateAdpater;Landroid/view/View;)V", "lnr_state", "Landroid/widget/LinearLayout;", "getLnr_state", "()Landroid/widget/LinearLayout;", "setLnr_state", "(Landroid/widget/LinearLayout;)V", "txt_state", "Landroid/widget/TextView;", "getTxt_state", "()Landroid/widget/TextView;", "setTxt_state", "(Landroid/widget/TextView;)V", "app_release"})
    public final class StateHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView txt_state;
        @org.jetbrains.annotations.NotNull()
        private android.widget.LinearLayout lnr_state;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTxt_state() {
            return null;
        }
        
        public final void setTxt_state(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.LinearLayout getLnr_state() {
            return null;
        }
        
        public final void setLnr_state(@org.jetbrains.annotations.NotNull()
        android.widget.LinearLayout p0) {
        }
        
        public StateHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
}