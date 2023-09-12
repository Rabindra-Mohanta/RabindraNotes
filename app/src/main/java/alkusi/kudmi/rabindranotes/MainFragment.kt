package alkusi.kudmi.rabindranotes

import alkusi.kudmi.rabindranotes.databinding.FragmentMainBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MainFragment : Fragment() {
  var _binding:FragmentMainBinding? = null;
    val binding
        get() = _binding!!;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun init()
    {

    }
    private fun initRv()
    {
        binding.recyclerView.setHasFixedSize(true)
        binding
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null;
    }
}