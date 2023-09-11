package alkusi.kudmi.rabindranotes

import alkusi.kudmi.rabindranotes.databinding.FragmentLoginBinding
import alkusi.kudmi.rabindranotes.model.LoginRes
import alkusi.kudmi.rabindranotes.viewModel.LoginViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
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
        return binding.root
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
         loginViewMode.loginUser(loginRes)
//         findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
     }

 })
}
    override fun onDestroyView() {
        super.onDestroyView()
        binding_ = null;
    }

}