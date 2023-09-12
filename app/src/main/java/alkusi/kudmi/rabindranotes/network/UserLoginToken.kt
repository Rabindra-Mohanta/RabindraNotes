package alkusi.kudmi.rabindranotes.network

import alkusi.kudmi.rabindranotes.shardPreference.MyToken
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
class UserLoginToken @Inject constructor():Interceptor
{
    @Inject
    lateinit var token: MyToken;
    override fun intercept(chain: Interceptor.Chain): Response {
        val tok = token.getToken()
         val request = chain.request().newBuilder()
        request.addHeader("Aurthorization","Barer $tok")
        return chain.proceed(request.build())

    }

}