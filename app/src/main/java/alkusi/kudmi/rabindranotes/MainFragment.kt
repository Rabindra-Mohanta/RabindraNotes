package alkusi.kudmi.rabindranotes

import alkusi.kudmi.rabindranotes.adapter.MainAdapter
import alkusi.kudmi.rabindranotes.databinding.FragmentMainBinding
import alkusi.kudmi.rabindranotes.model.StaffRes
import alkusi.kudmi.rabindranotes.retrofit.UserRepositoryWithToken
import alkusi.kudmi.rabindranotes.viewModel.MainViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import javax.inject.Inject

class MainFragment : Fragment() {
    var _binding: FragmentMainBinding? = null;
    val binding
        get() = _binding!!;
    var adapter_: MainAdapter? = null;
    val adapter
        get() = adapter_!!;
    @Inject
    lateinit var repositoryWithToken: UserRepositoryWithToken
    val mainViewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun init() {
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

    }

    private fun initRv() {
        adapter_ = MainAdapter(::onItemClicked,requireContext())
        binding.recyclerView.setHasFixedSize(true)
        binding
    }
private fun getData()
{
    mainViewModel.getStaffData()
}
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initRv()
    }

    private fun onItemClicked(res: StaffRes.MyData)
    {
        val bundle = Bundle();
        bundle.putString("data",Gson().toJson(res))
        findNavController().navigate(R.id.action_mainFragment_to_noteFragment,bundle)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null;
    }
}