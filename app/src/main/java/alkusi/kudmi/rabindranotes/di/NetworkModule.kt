package alkusi.kudmi.rabindranotes.di

import alkusi.kudmi.rabindranotes.network.ApiWithToken
import alkusi.kudmi.rabindranotes.network.MyApi
import alkusi.kudmi.rabindranotes.network.UserLoginToken
import alkusi.kudmi.rabindranotes.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun getRetrofit():Retrofit.Builder
    {
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(userLoginToken: UserLoginToken):OkHttpClient
    {
        return OkHttpClient.Builder().addInterceptor(userLoginToken).build()
    }


    @Singleton
    @Provides
    fun getMyApi(retrofitBuilder: Retrofit.Builder):MyApi
    {
        return retrofitBuilder.build().create(MyApi::class.java)
    }
    @Singleton
    @Provides
    fun getApiWithToken(retrofitBuilder: Retrofit.Builder, okHttpClient: OkHttpClient):Retrofit
    {
        return retrofitBuilder.client(okHttpClient).build()
    }
}