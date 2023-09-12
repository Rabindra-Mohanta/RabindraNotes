package alkusi.kudmi.rabindranotes.shardPreference

import alkusi.kudmi.rabindranotes.utils.Constants.SHARED_PREF_NAME
import alkusi.kudmi.rabindranotes.utils.Constants.TOKEN_SHARED
import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class MyToken @Inject constructor(@ApplicationContext val context:Context) {
    val sPref = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE)
    val edit:SharedPreferences.Editor = sPref.edit()

    fun setToken(token:String)
    {
        edit.putString(TOKEN_SHARED,token).apply()

    }
    fun getToken():String?
    {
      return  sPref.getString(TOKEN_SHARED,"")
    }
}