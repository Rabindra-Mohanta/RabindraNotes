package alkusi.kudmi.rabindranotes.network

import alkusi.kudmi.rabindranotes.model.StaffRes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiWithToken {
    @GET("api/v1/groups/{group_id}/today/staff/plan")
    suspend fun getStaff(@Query("data") date:String,@Query("userId") userId:String):Response<StaffRes>
}
