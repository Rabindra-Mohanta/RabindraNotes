package alkusi.kudmi.rabindranotes.retrofit

import alkusi.kudmi.rabindranotes.model.GetLogonData
import alkusi.kudmi.rabindranotes.model.LoginRes
import alkusi.kudmi.rabindranotes.network.MyApi
import alkusi.kudmi.rabindranotes.utils.NetworkResult
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.json.JSONObject
import retrofit2.Response
import java.net.CacheResponse
import javax.inject.Inject

class UserRepository @Inject constructor(private val myApi: MyApi) {
    val mutableLoginData = MutableLiveData<NetworkResult<GetLogonData>>();
    val liveLoginData:LiveData<NetworkResult<GetLogonData>>
        get() = mutableLoginData;

    suspend fun loginUser(category:String,appName:String,loginRes: LoginRes)
    {
         mutableLoginData.postValue(NetworkResult.OnProgress<GetLogonData>())
        val res =   myApi.loginUser(category,appName,loginRes)
        handleResponce(res)

    }
    private fun handleResponce(response: Response<GetLogonData>)
    {
        if(response.isSuccessful && response.body()!=null)
        {
            mutableLoginData.postValue(NetworkResult.OnSuccess<GetLogonData>(response.body()))
        }
        else if(response.errorBody()!=null)
        {
            val errorObject = JSONObject(response.errorBody()!!.charStream().readText())
            mutableLoginData.postValue(NetworkResult.OnError<GetLogonData>(errorObject.getString("message")))
        }

        else
        {

            mutableLoginData.postValue(NetworkResult.OnProgress<GetLogonData>())
        }
    }
}