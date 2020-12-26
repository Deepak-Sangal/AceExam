package com.acexams.aceexam.questiobank;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\u0005\u00a2\u0006\u0002\u0010\u0003J \u0010\u0013\u001a\u00020\u00142\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\u0006\u0010\u001a\u001a\u00020\u0014R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Lcom/acexams/aceexam/questiobank/SubjectListActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/acexams/aceexam/questiobank/adpater/SubjectAdpater$Sub_serviceListner;", "()V", "subject_topic", "Ljava/util/ArrayList;", "", "getSubject_topic", "()Ljava/util/ArrayList;", "setSubject_topic", "(Ljava/util/ArrayList;)V", "token", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "value", "getValue", "setValue", "onClickListner", "", "subjectidList", "Lkotlin/collections/ArrayList;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "subjectList", "Companion", "app_debug"})
public final class SubjectListActivity extends androidx.appcompat.app.AppCompatActivity implements com.acexams.aceexam.questiobank.adpater.SubjectAdpater.Sub_serviceListner {
    @org.jetbrains.annotations.NotNull()
    public java.lang.String token;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String value = "1";
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> subject_topic;
    @org.jetbrains.annotations.NotNull()
    private static java.util.ArrayList<java.lang.String> subjectidListData;
    public static final com.acexams.aceexam.questiobank.SubjectListActivity.Companion Companion = null;
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
    public final java.util.ArrayList<java.lang.String> getSubject_topic() {
        return null;
    }
    
    public final void setSubject_topic(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void subjectList() {
    }
    
    @java.lang.Override()
    public void onClickListner(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> subjectidList) {
    }
    
    public SubjectListActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/acexams/aceexam/questiobank/SubjectListActivity$Companion;", "", "()V", "subjectidListData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getSubjectidListData", "()Ljava/util/ArrayList;", "setSubjectidListData", "(Ljava/util/ArrayList;)V", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.ArrayList<java.lang.String> getSubjectidListData() {
            return null;
        }
        
        public final void setSubjectidListData(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<java.lang.String> p0) {
        }
        
        private Companion() {
            super();
        }
    }
}