package com.acexams.aceexam.questiobank.adpater;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002+,B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\b\u0010!\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\"H\u0016J\u0018\u0010\'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\"H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R*\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\n`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006-"}, d2 = {"Lcom/acexams/aceexam/questiobank/adpater/SubjectTopicAdpater;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/acexams/aceexam/questiobank/adpater/SubjectTopicAdpater$TopicHolder;", "context", "Landroid/content/Context;", "topicList", "Ljava/util/ArrayList;", "Lcom/acexams/aceexam/questiobank/modal/SubjectTopicModal$Data;", "Lkotlin/collections/ArrayList;", "value", "", "subjecttopicListner", "Lcom/acexams/aceexam/questiobank/adpater/SubjectTopicAdpater$SubjectTopic_Listner;", "(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;Lcom/acexams/aceexam/questiobank/adpater/SubjectTopicAdpater$SubjectTopic_Listner;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "subjectidList", "getSubjectidList", "()Ljava/util/ArrayList;", "setSubjectidList", "(Ljava/util/ArrayList;)V", "getSubjecttopicListner", "()Lcom/acexams/aceexam/questiobank/adpater/SubjectTopicAdpater$SubjectTopic_Listner;", "setSubjecttopicListner", "(Lcom/acexams/aceexam/questiobank/adpater/SubjectTopicAdpater$SubjectTopic_Listner;)V", "getTopicList", "setTopicList", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "SubjectTopic_Listner", "TopicHolder", "app_debug"})
public final class SubjectTopicAdpater extends androidx.recyclerview.widget.RecyclerView.Adapter<com.acexams.aceexam.questiobank.adpater.SubjectTopicAdpater.TopicHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> subjectidList;
    @org.jetbrains.annotations.NotNull()
    private android.content.Context context;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.acexams.aceexam.questiobank.modal.SubjectTopicModal.Data> topicList;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String value;
    @org.jetbrains.annotations.NotNull()
    private com.acexams.aceexam.questiobank.adpater.SubjectTopicAdpater.SubjectTopic_Listner subjecttopicListner;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getSubjectidList() {
        return null;
    }
    
    public final void setSubjectidList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.acexams.aceexam.questiobank.adpater.SubjectTopicAdpater.TopicHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.acexams.aceexam.questiobank.adpater.SubjectTopicAdpater.TopicHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    public final void setContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.acexams.aceexam.questiobank.modal.SubjectTopicModal.Data> getTopicList() {
        return null;
    }
    
    public final void setTopicList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.acexams.aceexam.questiobank.modal.SubjectTopicModal.Data> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getValue() {
        return null;
    }
    
    public final void setValue(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.acexams.aceexam.questiobank.adpater.SubjectTopicAdpater.SubjectTopic_Listner getSubjecttopicListner() {
        return null;
    }
    
    public final void setSubjecttopicListner(@org.jetbrains.annotations.NotNull()
    com.acexams.aceexam.questiobank.adpater.SubjectTopicAdpater.SubjectTopic_Listner p0) {
    }
    
    public SubjectTopicAdpater(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.acexams.aceexam.questiobank.modal.SubjectTopicModal.Data> topicList, @org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    com.acexams.aceexam.questiobank.adpater.SubjectTopicAdpater.SubjectTopic_Listner subjecttopicListner) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/acexams/aceexam/questiobank/adpater/SubjectTopicAdpater$TopicHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "app_debug"})
    public static final class TopicHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public TopicHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/acexams/aceexam/questiobank/adpater/SubjectTopicAdpater$SubjectTopic_Listner;", "", "onClickListner", "", "subject_topic_id_list", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "app_debug"})
    public static abstract interface SubjectTopic_Listner {
        
        public abstract void onClickListner(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<java.lang.String> subject_topic_id_list);
    }
}