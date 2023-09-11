package alkusi.kudmi.rabindranotes.retrofit

import alkusi.kudmi.rabindranotes.model.GetLogonData
import alkusi.kudmi.rabindranotes.model.LoginRes
import alkusi.kudmi.rabindranotes.network.MyApi
import alkusi.kudmi.rabindranotes.utils.NetworkResult
import android.util.Log
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class UserRepository @Inject constructor(private val myApi: MyApi) {
    val mutableLoginData = MutableLiveData<NetworkResult<GetLogonData>>();
    val liveLoginData
        get() = mutableLoginData;

    suspend fun loginUser(category:String,appName:String,loginRes: LoginRes)
    {
      val res = myApi.loginUser(category,appName,loginRes)
        mutableLoginData.postValue(NetworkResult.OnProgress<GetLogonData>())
        if(res.isSuccessful && res.body()!=null)
        {
            mutableLoginData.postValue(NetworkResult.OnSuccess<GetLogonData>(res.body()))
        }
        else if(res.message()!=null)
        {
            mutableLoginData.postValue(NetworkResult.OnError<GetLogonData>(res.message()))
        }


    }
}