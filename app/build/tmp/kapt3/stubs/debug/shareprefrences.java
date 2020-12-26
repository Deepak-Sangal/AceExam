
import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lshareprefrences;", "", "()V", "Companion", "app_debug"})
public final class shareprefrences {
    private static final java.lang.String PREF_NAME = "SHARED_PREFERENCE";
    private static android.content.SharedPreferences preferences;
    public static final shareprefrences.Companion Companion = null;
    
    public shareprefrences() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004J\u001e\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010J$\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015J\u001e\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J\u0016\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lshareprefrences$Companion;", "", "()V", "PREF_NAME", "", "preferences", "Landroid/content/SharedPreferences;", "clearAllPreferences", "", "context", "Landroid/content/Context;", "getStringPreference", "KEY", "getlanguage", "isFlag", "value", "", "isGetFlag", "isGetSession", "isSession", "setSetPrefrence", "", "setStringPreference", "setlanguagesetting", "app_debug"})
    public static final class Companion {
        
        public final void setStringPreference(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.lang.String KEY, @org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        public final void setSetPrefrence(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.lang.String KEY, @org.jetbrains.annotations.NotNull()
        java.util.Set<java.lang.String> value) {
        }
        
        public final void isSession(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.lang.String KEY, boolean value) {
        }
        
        public final void isFlag(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.lang.String KEY, boolean value) {
        }
        
        public final boolean isGetFlag(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.lang.String KEY) {
            return false;
        }
        
        public final boolean isGetSession(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.lang.String KEY) {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getStringPreference(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.lang.String KEY) {
            return null;
        }
        
        public final void clearAllPreferences(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        public final void setlanguagesetting(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getlanguage(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}