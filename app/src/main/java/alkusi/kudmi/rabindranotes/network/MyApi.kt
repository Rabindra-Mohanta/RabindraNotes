package alkusi.kudmi.rabindranotes.network

import alkusi.kudmi.rabindranotes.model.GetLogonData
import alkusi.kudmi.rabindranotes.model.LoginRes
import alkusi.kudmi.rabindranotes.model.StaffRes
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface MyApi {
    @POST("api/v1/login/category/app")
    suspend fun loginUser(@Query("category") category:String,@Query("appName") appName:String,@Body loginRes: LoginRes):Response<GetLogonData>

    @GET("api/v1/groups/{group_id}/today/staff/plan")
    suspend fun getStaff(@Query("date") date:String,@Query("userId") userId:String):Response<StaffRes>

}
