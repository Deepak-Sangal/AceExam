package com.acexams.aceexam.questiobank;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010W\u001a\u00020XJ\u0006\u0010Y\u001a\u00020XJ\u0006\u0010Z\u001a\u00020XJ\b\u0010[\u001a\u00020XH\u0016J\u0012\u0010\\\u001a\u00020X2\b\u0010]\u001a\u0004\u0018\u00010^H\u0014R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR6\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001dj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u001eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001a\u0010)\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\u000fR\u001a\u0010,\u001a\u00020$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010&\"\u0004\b.\u0010(R\u001a\u0010/\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\r\"\u0004\b1\u0010\u000fR\u001a\u00102\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\r\"\u0004\b4\u0010\u000fR*\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\b\"\u0004\b7\u0010\nR\u001a\u00108\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000fR\u001a\u0010;\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\r\"\u0004\b=\u0010\u000fR*\u0010>\u001a\u0012\u0012\u0004\u0012\u00020?0\u0004j\b\u0012\u0004\u0012\u00020?`\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\b\"\u0004\bA\u0010\nR\u001a\u0010B\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\r\"\u0004\bD\u0010\u000fR*\u0010E\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\b\"\u0004\bG\u0010\nR\u001a\u0010H\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\r\"\u0004\bJ\u0010\u000fR\u001a\u0010K\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\r\"\u0004\bM\u0010\u000fR\u001a\u0010N\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\r\"\u0004\bP\u0010\u000fR\u001a\u0010Q\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\r\"\u0004\bS\u0010\u000fR\u001a\u0010T\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\r\"\u0004\bV\u0010\u000f\u00a8\u0006_"}, d2 = {"Lcom/acexams/aceexam/questiobank/QuestionBankTestActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "answerArrayList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getAnswerArrayList", "()Ljava/util/ArrayList;", "setAnswerArrayList", "(Ljava/util/ArrayList;)V", "answerfinal", "getAnswerfinal", "()Ljava/lang/String;", "setAnswerfinal", "(Ljava/lang/String;)V", "answerfour", "getAnswerfour", "setAnswerfour", "answerone", "getAnswerone", "setAnswerone", "answerthree", "getAnswerthree", "setAnswerthree", "answertwo", "getAnswertwo", "setAnswertwo", "hashMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getHashMap", "()Ljava/util/HashMap;", "setHashMap", "(Ljava/util/HashMap;)V", "i", "", "getI", "()I", "setI", "(I)V", "id", "getId", "setId", "j", "getJ", "setJ", "lang", "getLang", "setLang", "no_question", "getNo_question", "setNo_question", "questionArrayList", "getQuestionArrayList", "setQuestionArrayList", "questiondata", "getQuestiondata", "setQuestiondata", "questionid_default", "getQuestionid_default", "setQuestionid_default", "questionlist", "Lcom/acexams/aceexam/questiobank/modal/QuestionBankTestListModal$Data$Questionlist;", "getQuestionlist", "setQuestionlist", "str", "getStr", "setStr", "subjectidTest", "getSubjectidTest", "setSubjectidTest", "team_id", "getTeam_id", "setTeam_id", "testid", "getTestid", "setTestid", "token", "getToken", "setToken", "user_id", "getUser_id", "setUser_id", "value", "getValue", "setValue", "customsumit", "", "getTest", "init", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class QuestionBankTestActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String id = "";
    @org.jetbrains.annotations.NotNull()
    public java.lang.String token;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String testid = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String value = "1";
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> subjectidTest;
    @org.jetbrains.annotations.NotNull()
    public java.lang.String user_id;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String no_question = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String lang = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String team_id = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String questiondata = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String answerone = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String answertwo = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String answerthree = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String answerfour = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String questionid_default = "";
    private int i = 0;
    private int j = 0;
    @org.jetbrains.annotations.NotNull()
    public java.lang.String str;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String answerfinal = "";
    @org.jetbrains.annotations.NotNull()
    public java.util.ArrayList<com.acexams.aceexam.questiobank.modal.QuestionBankTestListModal.Data.Questionlist> questionlist;
    @org.jetbrains.annotations.NotNull()
    public java.util.ArrayList<java.lang.String> questionArrayList;
    @org.jetbrains.annotations.NotNull()
    public java.util.ArrayList<java.lang.String> answerArrayList;
    @org.jetbrains.annotations.NotNull()
    public java.util.HashMap<java.lang.String, java.lang.String> hashMap;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getToken() {
        return null;
    }
    
    public final void setToken(@org.jetbrains.annotations.NotNull()
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
    public final java.lang.String getValue() {
        return null;
    }
    
    public final void setValue(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getSubjectidTest() {
        return null;
    }
    
    public final void setSubjectidTest(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUser_id() {
        return null;
    }
    
    public final void setUser_id(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNo_question() {
        return null;
    }
    
    public final void setNo_question(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLang() {
        return null;
    }
    
    public final void setLang(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTeam_id() {
        return null;
    }
    
    public final void setTeam_id(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
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
    public final java.lang.String getAnswerfour() {
        return null;
    }
    
    public final void setAnswerfour(@org.jetbrains.annotations.NotNull()
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStr() {
        return null;
    }
    
    public final void setStr(@org.jetbrains.annotations.NotNull()
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
    public final java.util.ArrayList<com.acexams.aceexam.questiobank.modal.QuestionBankTestListModal.Data.Questionlist> getQuestionlist() {
        return null;
    }
    
    public final void setQuestionlist(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.acexams.aceexam.questiobank.modal.QuestionBankTestListModal.Data.Questionlist> p0) {
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
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void init() {
    }
    
    public final void getTest() {
    }
    
    public final void customsumit() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    public QuestionBankTestActivity() {
        super();
    }
}