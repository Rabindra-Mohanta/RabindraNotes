package alkusi.kudmi.rabindranotes

import alkusi.kudmi.rabindranotes.databinding.FragmentLoginBinding
import alkusi.kudmi.rabindranotes.model.GetLogonData
import alkusi.kudmi.rabindranotes.model.LoginRes
import alkusi.kudmi.rabindranotes.utils.NetworkResult
import alkusi.kudmi.rabindranotes.viewModel.LoginViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelLazy
import androidx.navigation.fragment.findNavController
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
        init()
        getData()
        return binding.root
    }
private fun init()
{
 binding.btnSubmit.setOnClickListener(object :View.OnClickListener
 {
     override fun onClick(p0: View?) {
         val userName = binding.edtNumber.text.toString()
         val password = binding.edtPassWord.text.toString()
         val valid = loginViewMode.isValid(userName,password)
         if(valid.first)
         {
             val loginRes = LoginRes();
             loginRes.password = binding.edtPassWord.text.toString()
             loginRes.userName.countryCode = "IN"
             loginRes.userName.phone = binding.edtNumber.text.toString()
             loginViewMode.loginUser(loginRes)
         }
         else
         {
             Toast.makeText(requireContext(),valid.second,Toast.LENGTH_SHORT).show()
         }


     }

 })
}
    private fun getData()
    {
        loginViewMode.loginLiveData.observe(viewLifecycleOwner, Observer {
            binding.progressBar.visibility = View.GONE
            when(it)
            {
                is NetworkResult.OnSuccess<GetLogonData> ->
                {
                    findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
                }
                is NetworkResult.OnError<GetLogonData> ->
                {

                }
                is NetworkResult.OnProgress<GetLogonData> ->
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