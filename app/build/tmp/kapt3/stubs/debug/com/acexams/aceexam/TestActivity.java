package com.acexams.aceexam;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010W\u001a\u00020XJ\u0006\u0010Y\u001a\u00020XJ\u0006\u0010Z\u001a\u00020XJ\u0006\u0010[\u001a\u00020XJ\u0012\u0010\\\u001a\u00020X2\b\u0010]\u001a\u0004\u0018\u00010^H\u0014J\u0006\u0010_\u001a\u00020XJ\u0016\u0010`\u001a\u00020X2\u0006\u0010a\u001a\u00020#2\u0006\u0010b\u001a\u00020cJ\u0006\u0010d\u001a\u00020XR*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001a\u0010(\u001a\u00020)X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R6\u0010.\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050/j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`0X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001f\"\u0004\b7\u0010!R\u001a\u00108\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000fR\u001a\u0010;\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001f\"\u0004\b=\u0010!R\u001a\u0010>\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\r\"\u0004\b@\u0010\u000fR*\u0010A\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\b\"\u0004\bC\u0010\nR\u001a\u0010D\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\r\"\u0004\bF\u0010\u000fR\u001a\u0010G\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\r\"\u0004\bI\u0010\u000fR*\u0010J\u001a\u0012\u0012\u0004\u0012\u00020K0\u0004j\b\u0012\u0004\u0012\u00020K`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\b\"\u0004\bM\u0010\nR\u001a\u0010N\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\r\"\u0004\bP\u0010\u000fR\u001a\u0010Q\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\r\"\u0004\bS\u0010\u000fR\u001a\u0010T\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\r\"\u0004\bV\u0010\u000f\u00a8\u0006e"}, d2 = {"Lcom/acexams/aceexam/TestActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "answerArrayList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getAnswerArrayList", "()Ljava/util/ArrayList;", "setAnswerArrayList", "(Ljava/util/ArrayList;)V", "answerfinal", "getAnswerfinal", "()Ljava/lang/String;", "setAnswerfinal", "(Ljava/lang/String;)V", "answerfour", "getAnswerfour", "setAnswerfour", "answerone", "getAnswerone", "setAnswerone", "answerthree", "getAnswerthree", "setAnswerthree", "answertwo", "getAnswertwo", "setAnswertwo", "bookmark", "", "getBookmark", "()I", "setBookmark", "(I)V", "currentFag", "Landroidx/fragment/app/Fragment;", "getCurrentFag", "()Landroidx/fragment/app/Fragment;", "setCurrentFag", "(Landroidx/fragment/app/Fragment;)V", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "hashMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getHashMap", "()Ljava/util/HashMap;", "setHashMap", "(Ljava/util/HashMap;)V", "i", "getI", "setI", "id", "getId", "setId", "j", "getJ", "setJ", "numberofquestion", "getNumberofquestion", "setNumberofquestion", "questionArrayList", "getQuestionArrayList", "setQuestionArrayList", "questiondata", "getQuestiondata", "setQuestiondata", "questionid_default", "getQuestionid_default", "setQuestionid_default", "questionlist", "Lcom/acexams/aceexam/activity/modal/QuestionModals$Data$Questionlist;", "getQuestionlist", "setQuestionlist", "questionsetid", "getQuestionsetid", "setQuestionsetid", "testid", "getTestid", "setTestid", "userId", "getUserId", "setUserId", "UnbookMark", "", "bookMark", "customsumit", "getSubmit", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plan", "switchfragment", "fragment", "isBack", "", "test", "app_debug"})
public final class TestActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String id = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String testid = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String numberofquestion = "";
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.acexams.aceexam.activity.modal.QuestionModals.Data.Questionlist> questionlist;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> questionArrayList;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> answerArrayList;
    @org.jetbrains.annotations.NotNull()
    private java.util.HashMap<java.lang.String, java.lang.String> hashMap;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String questiondata = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String answerone = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String answertwo = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String answerthree = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String questionsetid = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String answerfinal = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String answerfour = "";
    private int bookmark = 0;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String userId = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String questionid_default = "";
    private int i = 0;
    private int j = 0;
    private long duration = 0L;
    @org.jetbrains.annotations.Nullable()
    private androidx.fragment.app.Fragment currentFag;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTestid() {
        return null;
    }
    
    public final void setTestid(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNumberofquestion() {
        return null;
    }
    
    public final void setNumberofquestion(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.acexams.aceexam.activity.modal.QuestionModals.Data.Questionlist> getQuestionlist() {
        return null;
    }
    
    public final void setQuestionlist(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.acexams.aceexam.activity.modal.QuestionModals.Data.Questionlist> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getQuestionArrayList() {
        return null;
    }
    
    public final void setQuestionArrayList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getAnswerArrayList() {
        return null;
    }
    
    public final void setAnswerArrayList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.HashMap<java.lang.String, java.lang.String> getHashMap() {
        return null;
    }
    
    public final void setHashMap(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getQuestiondata() {
        return null;
    }
    
    public final void setQuestiondata(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAnswerone() {
        return null;
    }
    
    public final void setAnswerone(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAnswertwo() {
        return null;
    }
    
    public final void setAnswertwo(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAnswerthree() {
        return null;
    }
    
    public final void setAnswerthree(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getQuestionsetid() {
        return null;
    }
    
    public final void setQuestionsetid(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAnswerfinal() {
        return null;
    }
    
    public final void setAnswerfinal(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAnswerfour() {
        return null;
    }
    
    public final void setAnswerfour(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getBookmark() {
        return 0;
    }
    
    public final void setBookmark(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserId() {
        return null;
    }
    
    public final void setUserId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getQuestionid_default() {
        return null;
    }
    
    public final void setQuestionid_default(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getI() {
        return 0;
    }
    
    public final void setI(int p0) {
    }
    
    public final int getJ() {
        return 0;
    }
    
    public final void setJ(int p0) {
    }
    
    public final long getDuration() {
        return 0L;
    }
    
    public final void setDuration(long p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void test() {
    }
    
    public final void plan() {
    }
    
    public final void getSubmit() {
    }
    
    public final void customsumit() {
    }
    
    public final void bookMark() {
    }
    
    public final void UnbookMark() {
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
    
    public TestActivity() {
        super();
    }
}