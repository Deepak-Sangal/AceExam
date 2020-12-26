package com.card.visitingcardscanner.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/card/visitingcardscanner/utils/AppUtils;", "", "()V", "DATE_OUTPUT_FORMAT", "", "getDATE_OUTPUT_FORMAT", "()Ljava/lang/String;", "suffixes", "", "getSuffixes", "()[Ljava/lang/String;", "setSuffixes", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "Companion", "app_release"})
public final class AppUtils {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String DATE_OUTPUT_FORMAT = "dd-MMM-yyyy";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String[] suffixes = {"th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th", "th", "th", "th", "th", "th", "th", "th", "th", "th", "th", "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th", "th", "st"};
    public static final com.card.visitingcardscanner.utils.AppUtils.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDATE_OUTPUT_FORMAT() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getSuffixes() {
        return null;
    }
    
    public final void setSuffixes(@org.jetbrains.annotations.NotNull()
    java.lang.String[] p0) {
    }
    
    public AppUtils() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\nJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\nJ\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0004J\u0016\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0004\u00a8\u0006\u0017"}, d2 = {"Lcom/card/visitingcardscanner/utils/AppUtils$Companion;", "", "()V", "Utctodate", "", "date", "Utctodatewithyyyymmdd", "Utctodatewithyyyymmdd1", "Utctodatewithyyyymmdd5", "datetomilisecond", "", "getDate", "milliSeconds", "getDate1", "getFormattedDate", "context", "Landroid/content/Context;", "smsTimeInMilis", "getssid", "showToast", "", "msg", "showToastShort", "app_release"})
    public static final class Companion {
        
        public final void showToast(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.lang.String msg) {
        }
        
        public final void showToastShort(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.lang.String msg) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String Utctodate(@org.jetbrains.annotations.NotNull()
        java.lang.String date) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String Utctodatewithyyyymmdd(@org.jetbrains.annotations.NotNull()
        java.lang.String date) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String Utctodatewithyyyymmdd5(@org.jetbrains.annotations.NotNull()
        java.lang.String date) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String Utctodatewithyyyymmdd1(@org.jetbrains.annotations.NotNull()
        java.lang.String date) {
            return null;
        }
        
        public final long datetomilisecond(@org.jetbrains.annotations.NotNull()
        java.lang.String date) {
            return 0L;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getDate(long milliSeconds) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getDate1(long milliSeconds) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getssid(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getFormattedDate(@org.jetbrains.annotations.Nullable()
        android.content.Context context, long smsTimeInMilis) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}