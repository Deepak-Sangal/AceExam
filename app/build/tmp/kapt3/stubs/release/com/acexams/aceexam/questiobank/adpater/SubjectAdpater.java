package com.acexams.aceexam.questiobank.adpater;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002()B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u001c\u0010 \u001a\u00020!2\n\u0010\"\u001a\u00060\u0002R\u00020\u00002\u0006\u0010#\u001a\u00020\u001fH\u0016J\u001c\u0010$\u001a\u00060\u0002R\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\u001fH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R*\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\n`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0015\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006*"}, d2 = {"Lcom/acexams/aceexam/questiobank/adpater/SubjectAdpater;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/acexams/aceexam/questiobank/adpater/SubjectAdpater$SubjectHolder;", "context", "Landroid/content/Context;", "subjectList", "Ljava/util/ArrayList;", "Lcom/acexams/aceexam/questiobank/modal/SubjectListModal$Data;", "Lkotlin/collections/ArrayList;", "value", "", "subServicelistner", "Lcom/acexams/aceexam/questiobank/adpater/SubjectAdpater$Sub_serviceListner;", "(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;Lcom/acexams/aceexam/questiobank/adpater/SubjectAdpater$Sub_serviceListner;)V", "getContext", "()Landroid/content/Context;", "getSubServicelistner", "()Lcom/acexams/aceexam/questiobank/adpater/SubjectAdpater$Sub_serviceListner;", "setSubServicelistner", "(Lcom/acexams/aceexam/questiobank/adpater/SubjectAdpater$Sub_serviceListner;)V", "getSubjectList", "()Ljava/util/ArrayList;", "subjectidList", "getSubjectidList", "setSubjectidList", "(Ljava/util/ArrayList;)V", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Sub_serviceListner", "SubjectHolder", "app_release"})
public final class SubjectAdpater extends androidx.recyclerview.widget.RecyclerView.Adapter<com.acexams.aceexam.questiobank.adpater.SubjectAdpater.SubjectHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> subjectidList;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.acexams.aceexam.questiobank.modal.SubjectListModal.Data> subjectList = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String value;
    @org.jetbrains.annotations.NotNull()
    private com.acexams.aceexam.questiobank.adpater.SubjectAdpater.Sub_serviceListner subServicelistner;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getSubjectidList() {
        return null;
    }
    
    public final void setSubjectidList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.acexams.aceexam.questiobank.adpater.SubjectAdpater.SubjectHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.acexams.aceexam.questiobank.adpater.SubjectAdpater.SubjectHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.acexams.aceexam.questiobank.modal.SubjectListModal.Data> getSubjectList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getValue() {
        return null;
    }
    
    public final void setValue(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.acexams.aceexam.questiobank.adpater.SubjectAdpater.Sub_serviceListner getSubServicelistner() {
        return null;
    }
    
    public final void setSubServicelistner(@org.jetbrains.annotations.NotNull()
    com.acexams.aceexam.questiobank.adpater.SubjectAdpater.Sub_serviceListner p0) {
    }
    
    public SubjectAdpater(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.acexams.aceexam.questiobank.modal.SubjectListModal.Data> subjectList, @org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    com.acexams.aceexam.questiobank.adpater.SubjectAdpater.Sub_serviceListner subServicelistner) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/acexams/aceexam/questiobank/adpater/SubjectAdpater$SubjectHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/acexams/aceexam/questiobank/adpater/SubjectAdpater;Landroid/view/View;)V", "app_release"})
    public final class SubjectHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public SubjectHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/acexams/aceexam/questiobank/adpater/SubjectAdpater$Sub_serviceListner;", "", "onClickListner", "", "subjectidList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "app_release"})
    public static abstract interface Sub_serviceListner {
        
        public abstract void onClickListner(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<java.lang.String> subjectidList);
    }
}