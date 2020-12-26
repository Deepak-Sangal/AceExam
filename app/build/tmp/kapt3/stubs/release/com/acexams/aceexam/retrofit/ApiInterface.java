package com.acexams.aceexam.retrofit;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00c2\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\'J.\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u0006H\'J&\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\'J,\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\u0011\u001a\u00020\u0006H\'J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\'J\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\b\b\u0001\u0010\u0016\u001a\u00020\u0006H\'J&\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00032\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\'J2\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u0006H\'J2\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\'J:\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\"2\u0014\b\u0001\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020%0$H\'J0\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0014\b\u0001\u0010\'\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020%0$H\'J\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\n\b\u0001\u0010)\u001a\u0004\u0018\u00010\u0006H\'J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u0003H\'J\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\'J4\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00032$\b\u0001\u00100\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000601j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`2H\'J4\u00103\u001a\b\u0012\u0004\u0012\u00020/0\u00032$\b\u0001\u00100\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000601j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`2H\'J&\u00104\u001a\b\u0012\u0004\u0012\u0002050\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u00106\u001a\u0004\u0018\u00010\u0006H\'Jz\u00107\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\n\b\u0001\u00108\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u00109\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010:\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010;\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010<\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010=\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010>\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010?\u001a\u0004\u0018\u00010\u0006H\'J\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u00032\n\b\u0001\u0010B\u001a\u0004\u0018\u00010\u0006H\'J\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020D0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\'J&\u0010E\u001a\b\u0012\u0004\u0012\u00020F0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\'J4\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032$\b\u0001\u00100\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000601j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`2H\'J,\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\u0011\u001a\u00020\u0006H\'J\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020J0\u00032\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\'J\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020L0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\'J4\u0010M\u001a\b\u0012\u0004\u0012\u00020/0\u00032$\b\u0001\u00100\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000601j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`2H\'J4\u0010N\u001a\b\u0012\u0004\u0012\u00020O0\u00032$\b\u0001\u00100\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000601j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`2H\'J,\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\u0011\u001a\u00020\u0006H\'J\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\'J&\u0010S\u001a\b\u0012\u0004\u0012\u00020T0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\'J2\u0010U\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\'J$\u0010V\u001a\b\u0012\u0004\u0012\u00020W0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\n\u001a\u00020\u0006H\'J0\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0014\b\u0001\u0010\'\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020%0$H\'JB\u0010Y\u001a\b\u0012\u0004\u0012\u00020Z0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010[\u001a\u00020\u00062\b\b\u0001\u0010\\\u001a\u00020\u0006H\'J2\u0010]\u001a\b\u0012\u0004\u0012\u00020^0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\'J$\u0010_\u001a\b\u0012\u0004\u0012\u00020`0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010a\u001a\u00020\u0006H\'J4\u0010b\u001a\b\u0012\u0004\u0012\u00020/0\u00032$\b\u0001\u00100\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000601j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`2H\'J4\u0010c\u001a\b\u0012\u0004\u0012\u00020d0\u00032$\b\u0001\u00100\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000601j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`2H\'J&\u0010e\u001a\b\u0012\u0004\u0012\u00020f0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\'J\u000e\u0010g\u001a\b\u0012\u0004\u0012\u00020h0\u0003H\'J$\u0010i\u001a\b\u0012\u0004\u0012\u00020j0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u0016\u001a\u00020\u0006H\'J$\u0010k\u001a\b\u0012\u0004\u0012\u00020l0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u0016\u001a\u00020\u0006H\'J$\u0010m\u001a\b\u0012\u0004\u0012\u00020n0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u0016\u001a\u00020\u0006H\'J$\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010p\u001a\u00020\u0006H\'J0\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0014\b\u0001\u0010\'\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020%0$H\'J2\u0010r\u001a\b\u0012\u0004\u0012\u00020s0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010t\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\'J$\u0010u\u001a\b\u0012\u0004\u0012\u00020v0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u0006H\'JX\u0010w\u001a\b\u0012\u0004\u0012\u00020x0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u0016\u001a\u00020%2\b\b\u0001\u0010\u0019\u001a\u00020%2\b\b\u0001\u0010\u001a\u001a\u00020%2\b\b\u0001\u0010y\u001a\u00020%2\b\b\u0001\u0010z\u001a\u00020%2\n\b\u0001\u0010{\u001a\u0004\u0018\u00010|H\'J\"\u0010}\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010~\u001a\u00020\u0006H\'J&\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\'J2\u0010\u0080\u0001\u001a\t\u0012\u0005\u0012\u00030\u0081\u00010\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u0016\u001a\u00020\u00062\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\'J.\u0010\u0082\u0001\u001a\t\u0012\u0005\u0012\u00030\u0083\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\u0011\u001a\u00020\u0006H\'J4\u0010\u0084\u0001\u001a\t\u0012\u0005\u0012\u00030\u0085\u00010\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\'J\u001c\u0010\u0086\u0001\u001a\t\u0012\u0005\u0012\u00030\u0087\u00010\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\'\u00a8\u0006\u0088\u0001"}, d2 = {"Lcom/acexams/aceexam/retrofit/ApiInterface;", "", "Notes", "Lretrofit2/Call;", "Lcom/acexams/aceexam/activity/modal/NotesResponse;", "token", "", "video_id", "Questionbank", "Lcom/acexams/aceexam/questiobank/modal/QuestiontestResponse;", "topic_id", "test_id", "allpearls", "Lcom/acexams/aceexam/activity/modal/AllperalResponse;", "user_id", "bookMark", "Lokhttp3/ResponseBody;", "status", "bookmark", "Lcom/acexams/aceexam/activity/modal/BookmarkResponse;", "bookmark_list", "Lcom/acexams/aceexam/mcqbookmark/modal/BookMarkListModal;", "id", "change_password", "Lcom/acexams/aceexam/activity/modal/ChangePasswordResponse;", "name", "email", "contact", "message", "custom", "Lcom/acexams/aceexam/activity/modal/QuestionModals;", "no_question", "customTest", "Lcom/acexams/aceexam/questiobank/modal/QuestionBankTestListModal;", "", "params", "", "Lokhttp3/RequestBody;", "customsumit", "map", "downloadImage", "fileUrl", "examslist", "Lcom/acexams/aceexam/activity/modal/ExamsList;", "faclities", "Lcom/acexams/aceexam/activity/modal/FacalityResponse;", "forgotPasswordSendSms", "Lcom/acexams/aceexam/activity/modal/SendotpRespone;", "hashMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "forgotPasswordValidateOTP", "getTracker", "Lcom/acexams/aceexam/progresstracker/modal/ProgressBarModal;", "date_of_completion", "getcheckSum", "mid", "order_id", "custom_id", "mobileNo", "channel_id", "website", "amount", "indu", "getcollge", "Lcom/acexams/aceexam/activity/modal/CollegeResponse;", "state_id", "getcourse", "Lcom/acexams/aceexam/activity/modal/CourseResponse;", "getprofile", "Lcom/acexams/aceexam/Model/GetProfileResponse;", "login", "makecompeted", "matchemail", "Lcom/acexams/aceexam/activity/modal/EmailVerifiyResponse;", "mqcoftheday", "Lcom/acexams/aceexam/activity/modal/ModResponse;", "otpverified", "paytmchecksum", "Lcom/acexams/aceexam/activity/modal/PaytmResponse;", "perlbookmark", "plan", "Lcom/acexams/aceexam/activity/modal/PlanResponse;", "progresstracker", "Lcom/acexams/aceexam/activity/modal/ProgressTrackerResponse;", "questiion", "questionbankquestio", "Lcom/acexams/aceexam/activity/modal/QbanksubjectResponse;", "questionbanksumit", "reviewandrating", "Lcom/acexams/aceexam/bookmark/ReviewRatingModal;", "rating", "review", "reviewdetails", "Lcom/acexams/aceexam/questiobank/modal/ReviewDetailModal;", "search", "Lcom/acexams/aceexam/activity/modal/SearchResponse;", "keyword", "sendotp", "signup", "Lcom/acexams/aceexam/Model/SignupResponse;", "slides", "Lcom/acexams/aceexam/questiobank/adpater/slideResponse;", "states", "Lcom/acexams/aceexam/activity/modal/StateResponse;", "subject", "Lcom/acexams/aceexam/activity/modal/SubjectResponse;", "subjectList", "Lcom/acexams/aceexam/questiobank/modal/SubjectListModal;", "subjectTopicList", "Lcom/acexams/aceexam/questiobank/modal/SubjectTopicModal;", "subjectwiseperl", "subject_id", "submit", "testexam", "Lcom/acexams/aceexam/activity/modal/TestexamResponse;", "type", "topranikg", "Lcom/example/paytm/RankingResponseModal;", "updateProfile", "Lcom/acexams/aceexam/Model/UpdateProfileResponse;", "mobile", "remove_image", "image", "Lokhttp3/MultipartBody$Part;", "update_exam", "exam_id", "verifyEmail", "video", "Lcom/acexams/aceexam/activity/modal/VideoListResponse;", "videobookmark", "Lcom/acexams/aceexam/activity/modal/VideoBookmarkResponse;", "videodetails", "Lcom/acexams/aceexam/activity/modal/VideoResponse;", "vod", "Lcom/example/aceexam/activity/modal/VodResponse;", "app_release"})
public abstract interface ApiInterface {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "signup")
    public abstract retrofit2.Call<com.acexams.aceexam.Model.SignupResponse> signup(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    java.util.HashMap<java.lang.String, java.lang.String> hashMap);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "sendSms")
    public abstract retrofit2.Call<com.acexams.aceexam.activity.modal.SendotpRespone> sendotp(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    java.util.HashMap<java.lang.String, java.lang.String> hashMap);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "validateOTP")
    public abstract retrofit2.Call<com.acexams.aceexam.activity.modal.SendotpRespone> otpverified(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    java.util.HashMap<java.lang.String, java.lang.String> hashMap);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "generateChecksum.php")
    public abstract retrofit2.Call<com.acexams.aceexam.activity.modal.PaytmResponse> paytmchecksum(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    java.util.HashMap<java.lang.String, java.lang.String> hashMap);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "forgotPasswordValidateOTP")
    public abstract retrofit2.Call<com.acexams.aceexam.activity.modal.SendotpRespone> forgotPasswordValidateOTP(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    java.util.HashMap<java.lang.String, java.lang.String> hashMap);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "forgotPasswordSendSms")
    public abstract retrofit2.Call<com.acexams.aceexam.activity.modal.SendotpRespone> forgotPasswordSendSms(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    java.util.HashMap<java.lang.String, java.lang.String> hashMap);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "signin")
    public abstract retrofit2.Call<okhttp3.ResponseBody> login(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    java.util.HashMap<java.lang.String, java.lang.String> hashMap);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "fetch_subscription")
    public abstract retrofit2.Call<com.acexams.aceexam.activity.modal.PlanResponse> plan(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "search")
    public abstract retrofit2.Call<com.acexams.aceexam.activity.modal.SearchResponse> search(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "keyword")
    java.lang.String keyword);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "all_pearls")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.acexams.aceexam.activity.modal.AllperalResponse> allpearls(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "user_id")
    java.lang.String user_id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "contact-us-email")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.acexams.aceexam.activity.modal.AllperalResponse> contact(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "user_id")
    java.lang.String user_id, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "message")
    java.lang.String message);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "dashboard-percent")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.acexams.aceexam.activity.modal.ProgressTrackerResponse> progresstracker(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "user_id")
    java.lang.String user_id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "examslist")
    public abstract retrofit2.Call<com.acexams.aceexam.activity.modal.ExamsList> examslist();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "all_tests")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.acexams.aceexam.activity.modal.TestexamResponse> testexam(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "type")
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "user_id")
    java.lang.String user_id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "verifyEmail")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<okhttp3.ResponseBody> verifyEmail(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "email")
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "password")
    java.lang.String email);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "test/question")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.acexams.aceexam.activity.modal.QuestionModals> questiion(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "test_id")
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "user_id")
    java.lang.String user_id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "video/detail")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.acexams.aceexam.activity.modal.VideoResponse> videodetails(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "id")
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "user_id")
    java.lang.String user_id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "custom/test")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.acexams.aceexam.activity.modal.QuestionModals> custom(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "no_question")
    java.lang.String no_question, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "user_id")
    java.lang.String user_id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "test/submit")
    @retrofit2.http.Multipart()
    public abstract retrofit2.Call<okhttp3.ResponseBody> submit(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.PartMap()
    java.util.Map<java.lang.String, okhttp3.RequestBody> map);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "submit/topic/exam")
    @retrofit2.http.Multipart()
    public abstract retrofit2.Call<okhttp3.ResponseBody> questionbanksumit(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.PartMap()
    java.util.Map<java.lang.String, okhttp3.RequestBody> map);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "custom/test/submit")
    @retrofit2.http.Multipart()
    public abstract retrofit2.Call<okhttp3.ResponseBody> customsumit(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.PartMap()
    java.util.Map<java.lang.String, okhttp3.RequestBody> map);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "change_password")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.acexams.aceexam.activity.modal.ChangePasswordResponse> change_password(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "email")
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "password")
    java.lang.String email);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "collagelist")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.acexams.aceexam.activity.modal.CollegeResponse> getcollge(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "state_id")
    java.lang.String state_id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "studentCourses")
    public abstract retrofit2.Call<com.acexams.aceexam.activity.modal.CourseResponse> getcourse(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "weekly-tracker")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.acexams.aceexam.progresstracker.modal.ProgressBarModal> getTracker(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "user_id")
    java.lang.String token, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "date_of_completion ")
    java.lang.String date_of_completion);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "question-bookmark-list")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.acexams.aceexam.mcqbookmark.modal.BookMarkListModal> bookmark_list(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "user_id")
    java.lang.String id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "statelist")
    public abstract retrofit2.Call<com.acexams.aceexam.activity.modal.StateResponse> states();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "mcq")
    public abstract retrofit2.Call<com.acexams.aceexam.activity.modal.ModResponse> mqcoftheday(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "courseChapters")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.acexams.aceexam.activity.modal.SubjectResponse> subject(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "id")
    java.lang.String id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "test-ranking")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.example.paytm.RankingResponseModal> topranikg(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "test_id")
    java.lang.String test_id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "question-bookmark")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<okhttp3.ResponseBody> bookMark(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "question_id")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "user_id")
    java.lang.String test_id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "status")
    java.lang.String status);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "video-bookmark")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.acexams.aceexam.activity.modal.VideoBookmarkResponse> videobookmark(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "question_id")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "user_id")
    java.lang.String test_id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "status")
    java.lang.String status);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "pearl-bookmark")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<okhttp3.ResponseBody> perlbookmark(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "video_id")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "user_id")
    java.lang.String test_id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "status")
    java.lang.String status);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "chapterVideos")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.acexams.aceexam.activity.modal.VideoListResponse> video(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "id")
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "user_id")
    java.lang.String user_id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "get/bookmark")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.acexams.aceexam.activity.modal.BookmarkResponse> bookmark(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "video_id")
    java.lang.String video_id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "updateProfile")
    @retrofit2.http.Multipart()
    public abstract retrofit2.Call<com.acexams.aceexam.Model.UpdateProfileResponse> updateProfile(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part(value = "id")
    okhttp3.RequestBody id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part(value = "name")
    okhttp3.RequestBody name, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part(value = "email")
    okhttp3.RequestBody email, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part(value = "mobile")
    okhttp3.RequestBody mobile, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part(value = "remove_image")
    okhttp3.RequestBody remove_image, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Part()
    okhttp3.MultipartBody.Part image);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "getProfile")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.acexams.aceexam.Model.GetProfileResponse> getprofile(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "id")
    java.lang.String id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "update-exam")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<okhttp3.ResponseBody> update_exam(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "user_id")
    java.lang.String user_id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "exam_id")
    java.lang.String exam_id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "findUniqueEmailId")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.acexams.aceexam.activity.modal.EmailVerifiyResponse> matchemail(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "email")
    java.lang.String name);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "notes")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.acexams.aceexam.activity.modal.NotesResponse> Notes(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "video_id")
    java.lang.String video_id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "slides")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.acexams.aceexam.questiobank.adpater.slideResponse> slides(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "video_id")
    java.lang.String video_id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "fetch-video")
    public abstract retrofit2.Call<com.example.aceexam.activity.modal.VodResponse> vod(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "faculty_list")
    public abstract retrofit2.Call<com.acexams.aceexam.activity.modal.FacalityResponse> faclities(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "test/review")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.acexams.aceexam.questiobank.modal.ReviewDetailModal> reviewdetails(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "test_id")
    java.lang.String test_id, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "user_id")
    java.lang.String user_id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "generateChecksum.php")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<okhttp3.ResponseBody> getcheckSum(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "MID")
    java.lang.String mid, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "ORDER_ID")
    java.lang.String order_id, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "CUST_ID")
    java.lang.String custom_id, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "MOBILE_NO")
    java.lang.String mobileNo, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "EMAIL")
    java.lang.String email, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "CHANNEL_ID")
    java.lang.String channel_id, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "WEBSITE")
    java.lang.String website, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "TXN_AMOUNT")
    java.lang.String amount, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Field(value = "INDUSTRY_TYPE_ID")
    java.lang.String indu);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "subject_list")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.acexams.aceexam.questiobank.modal.SubjectListModal> subjectList(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "id")
    java.lang.String id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "topic_list")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.acexams.aceexam.questiobank.modal.SubjectTopicModal> subjectTopicList(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "id")
    java.lang.String id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "custom/test")
    @retrofit2.http.Multipart()
    public abstract retrofit2.Call<com.acexams.aceexam.questiobank.modal.QuestionBankTestListModal> customTest(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.HeaderMap()
    java.util.Map<java.lang.String, java.lang.String> token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.PartMap()
    java.util.Map<java.lang.String, okhttp3.RequestBody> params);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "submit_rating")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.acexams.aceexam.bookmark.ReviewRatingModal> reviewandrating(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "user_id")
    java.lang.String user_id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "video_id")
    java.lang.String video_id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "rating")
    java.lang.String rating, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "review")
    java.lang.String review);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "topic/examlist")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.acexams.aceexam.questiobank.modal.QuestiontestResponse> Questionbank(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "topic_id")
    java.lang.String topic_id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "user_id")
    java.lang.String test_id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "subjects")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.acexams.aceexam.activity.modal.QbanksubjectResponse> questionbankquestio(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "topic_id")
    java.lang.String topic_id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "video-status")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<okhttp3.ResponseBody> makecompeted(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "video_id")
    java.lang.String video_id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "user_id")
    java.lang.String test_id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "status")
    java.lang.String status);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "subject_wise_pearls")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<okhttp3.ResponseBody> subjectwiseperl(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "subject_id")
    java.lang.String subject_id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Streaming()
    @retrofit2.http.GET()
    public abstract retrofit2.Call<okhttp3.ResponseBody> downloadImage(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Url()
    java.lang.String fileUrl);
}