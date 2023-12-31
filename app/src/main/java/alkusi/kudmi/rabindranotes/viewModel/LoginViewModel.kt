package alkusi.kudmi.rabindranotes.viewModel

import alkusi.kudmi.rabindranotes.model.GetLogonData
import alkusi.kudmi.rabindranotes.model.LoginRes
import alkusi.kudmi.rabindranotes.retrofit.UserRepository
import alkusi.kudmi.rabindranotes.utils.NetworkResult
import android.text.TextUtils
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val userRepository: UserRepository) :ViewModel() {
val loginLiveData:LiveData<NetworkResult<GetLogonData>>
    get () = userRepository.liveLoginData
    fun loginUser(loginRes: LoginRes)
    {
        viewModelScope.launch {
            userRepository.loginUser("school","GC2",loginRes)

        }
    }
fun isValid(userName:String,password:String):Pair<Boolean,String>
{
    var valid = Pair(true,"")
    if(TextUtils.isEmpty(userName))
    {
        valid = Pair(false,"plz enter valid username")
    }
   else if(TextUtils.isEmpty(password))
    {
        valid = Pair(false,"Plz enter valid password")
    }

    return valid
}
}