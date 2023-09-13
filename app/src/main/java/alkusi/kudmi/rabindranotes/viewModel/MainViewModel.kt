package alkusi.kudmi.rabindranotes.viewModel

import alkusi.kudmi.rabindranotes.retrofit.UserRepositoryWithToken
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repositoryWithToken: UserRepositoryWithToken): ViewModel() {
    val staffLiveData
        get() = repositoryWithToken.liveData
    fun getStaffData(date:String,userId:String)
    {
        viewModelScope.launch {
            repositoryWithToken.getStaffDetails(date,userId)
        }

    }
}