package alkusi.kudmi.rabindranotes

import alkusi.kudmi.rabindranotes.databinding.FragmentLoginBinding
import alkusi.kudmi.rabindranotes.model.GetLogonData
import alkusi.kudmi.rabindranotes.model.LoginRes
import alkusi.kudmi.rabindranotes.utils.NetworkResult
import alkusi.kudmi.rabindranotes.viewModel.LoginViewModel
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelLazy
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {
    var binding_:FragmentLoginBinding?=null;
    val binding get() = binding_!!;
    val loginViewMode by viewModels<LoginViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding_ = FragmentLoginBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getGetDataOberver()
        init()
    }
private fun init()
{
 binding.btnSubmit.setOnClickListener(object :View.OnClickListener
 {
     override fun onClick(p0: View?) {
         val loginRes = LoginRes();
         loginRes.password = "123456"
         loginRes.userName.countryCode = "IN"
         loginRes.userName.phone = "9538732882"
         Log.e("rabi","sending"+Gson().toJson(loginRes))
         loginViewMode.loginUser(loginRes)




     }

 })
}
    private fun getGetDataOberver()
    {
        loginViewMode.loginData.observe(viewLifecycleOwner, Observer {
            binding.progressBar.visibility = View.GONE
            when(it)
            {
               is NetworkResult.OnSuccess<GetLogonData> ->
                {

                    binding.progressBar.visibility = View.GONE
                }
                is NetworkResult.OnError<GetLogonData> ->
                {

                    binding.progressBar.visibility = View.GONE
                }
                is  NetworkResult.OnProgress<GetLogonData> ->
                {

                    binding.progressBar.visibility = View.VISIBLE
                }
                else ->
                {

                }
            }

        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding_ = null;
    }

}