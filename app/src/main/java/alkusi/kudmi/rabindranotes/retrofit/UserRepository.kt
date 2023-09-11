package alkusi.kudmi.rabindranotes.retrofit

import alkusi.kudmi.rabindranotes.model.GetLogonData
import alkusi.kudmi.rabindranotes.model.LoginRes
import alkusi.kudmi.rabindranotes.network.MyApi
import android.util.Log
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class UserRepository @Inject constructor(private val myApi: MyApi) {
    val mutableLoginData = MutableLiveData<GetLogonData>();
    val liveLoginData
        get() = mutableLoginData;

    suspend fun loginUser(category:String,appName:String,loginRes: LoginRes)
    {
      val res =   myApi.loginUser(category,appName,loginRes)
        Log.e("rabi","url->"+res.raw().request.url)
        mutableLoginData.postValue(res.body())
    }
}