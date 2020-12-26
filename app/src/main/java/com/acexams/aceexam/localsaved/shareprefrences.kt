

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences



class shareprefrences() {
    companion object {



        private val PREF_NAME = "SHARED_PREFERENCE"
        private var preferences: SharedPreferences? = null

        fun setStringPreference( context: Context,KEY: String,
                                value: String) {
            preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            val editor = preferences!!.edit()
            editor.putString(KEY, "" + value)
            editor.apply()
        }


        fun setSetPrefrence( context: Context,KEY: String,
                            value: Set<String>) {
            preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            val editor = preferences!!.edit()
            editor.putStringSet(KEY, value)
            editor.apply()
        }

        fun isSession(context: Context,KEY: String,
                      value: Boolean) {
            preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            val editor = preferences!!.edit()
            editor.putBoolean(KEY, value)
            editor.apply()
        }

        fun isFlag(context: Context, KEY: String, value: Boolean) {
            preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            val editor = preferences!!.edit()
            editor.putBoolean(KEY, value)
            editor.apply()
        }

        fun isGetFlag(context: Context, KEY: String): Boolean {
            preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            return preferences!!.getBoolean(KEY, false)
        }

        fun isGetSession(context: Context,KEY: String): Boolean {
            preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            return preferences!!.getBoolean(KEY, false)
        }

        fun getStringPreference(context: Context,KEY: String): String? {
            preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            return preferences!!.getString(KEY, "")
        }


        fun clearAllPreferences(context: Context) {
            preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            preferences!!.edit().clear().apply()
            /* context.startActivity(Intent(context,LogInActivity::class.java))*/


        }

        fun setlanguagesetting(context: Context,value: String) {
            preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            val editor = preferences!!.edit()
            editor.putString("Language", value)
            editor.apply()

        }

        fun getlanguage(context: Context): String? {
            preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            return preferences!!.getString("Language", "EN")

        }

    }
}



