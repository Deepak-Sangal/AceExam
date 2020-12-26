package com.acexams.aceexam.questiobank;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0003J \u0010\u0010\u001a\u00020\u00112\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0013j\b\u0012\u0004\u0012\u00020\u0005`\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0006\u0010\u0018\u001a\u00020\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t\u00a8\u0006\u001a"}, d2 = {"Lcom/acexams/aceexam/questiobank/SubjectTopicActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/acexams/aceexam/questiobank/adpater/SubjectTopicAdpater$SubjectTopic_Listner;", "()V", "token", "", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "topic_id", "getTopic_id", "setTopic_id", "value", "getValue", "setValue", "onClickListner", "", "subject_topic_id_list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "subjectTopicList", "Companion", "app_debug"})
public final class SubjectTopicActivity extends androidx.appcompat.app.AppCompatActivity implements com.acexams.aceexam.questiobank.adpater.SubjectTopicAdpater.SubjectTopic_Listner {
    @org.jetbrains.annotations.NotNull()
    public java.lang.String token;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String value = "1";
    @org.jetbrains.annotations.NotNull()
    public java.lang.String topic_id;
    @org.jetbrains.annotations.NotNull()
    private static java.util.ArrayList<java.lang.String> subjectid_topic_ListData;
    public static final com.acexams.aceexam.questiobank.SubjectTopicActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getToken() {
        return null;
    }
    
    public final void setToken(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getValue() {
        return null;
    }
    
    public final void setValue(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTopic_id() {
        return null;
    }
    
    public final void setTopic_id(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void subjectTopicList() {
    }
    
    @java.lang.Override()
    public void onClickListner(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> subject_topic_id_list) {
    }
    
    public SubjectTopicActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/acexams/aceexam/questiobank/SubjectTopicActivity$Companion;", "", "()V", "subjectid_topic_ListData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getSubjectid_topic_ListData", "()Ljava/util/ArrayList;", "setSubjectid_topic_ListData", "(Ljava/util/ArrayList;)V", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.ArrayList<java.lang.String> getSubjectid_topic_ListData() {
            return null;
        }
        
        public final void setSubjectid_topic_ListData(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<java.lang.String> p0) {
        }
        
        private Companion() {
            super();
        }
    }
}