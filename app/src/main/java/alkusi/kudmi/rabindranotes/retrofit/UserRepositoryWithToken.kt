package alkusi.kudmi.rabindranotes.retrofit

import alkusi.kudmi.rabindranotes.model.StaffRes
import alkusi.kudmi.rabindranotes.network.ApiWithToken
import alkusi.kudmi.rabindranotes.utils.NetworkResultForTokenApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Response
import javax.inject.Inject

class UserRepositoryWithToken @Inject constructor(val apiWithToken: ApiWithToken) {


          val mutableData = MutableLiveData<NetworkResultForTokenApi<StaffRes>>()
          val liveData
           get () = mutableData

    suspend fun getStaffDetails(date:String,userId:String)
    {
            val res = apiWithToken.getStaff(date,userId)
        Handle(res)
    }

   private fun Handle(res1:Response<StaffRes>)
    {
        mutableData.postValue(NetworkResultForTokenApi.OnProgress<StaffRes>())
        if(res1.isSuccessful&&res1.body()!=null)
        {
            mutableData.postValue(NetworkResultForTokenApi.OnSuccess<StaffRes>(res1.body()))
        }
        if(res1.message()!=null)
        {
            mutableData.postValue(NetworkResultForTokenApi.OnError<StaffRes>("Somthing went wrong"))
        }
        else
        {

        }
    }
}