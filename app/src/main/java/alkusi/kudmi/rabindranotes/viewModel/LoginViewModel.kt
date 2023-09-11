package alkusi.kudmi.rabindranotes.viewModel

import alkusi.kudmi.rabindranotes.model.LoginRes
import alkusi.kudmi.rabindranotes.retrofit.UserRepository
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val userRepository: UserRepository) :ViewModel() {

    fun loginUser(loginRes: LoginRes)
    {
        viewModelScope.launch {
            userRepository.loginUser("cooperative","TSS",loginRes)
            Log.e("rabi","data"+Gson().toJson(userRepository.liveLoginData))
        }
    }

}