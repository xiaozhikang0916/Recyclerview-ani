package site.xiaozk.demo.rv_ani.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import site.xiaozk.demo.rv_ani.R
import site.xiaozk.demo.rv_ani.databinding.MainFragmentBinding
import site.xiaozk.demo.rv_ani.ui.main.rv.Adapter

open class BaseFragment : Fragment(R.layout.main_fragment) {
    protected lateinit var binding: MainFragmentBinding
    protected val dataList = ArrayList<Data>()

    private val adapter = Adapter()
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.data.observe(this, this::update)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MainFragmentBinding.bind(view)
        binding.recycler.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        binding.recycler.adapter = adapter

        binding.buttonAdd.setOnClickListener {
            viewModel.addData()
        }

        binding.buttonRemove.setOnClickListener {
            viewModel.removeRandom()
        }
    }

    private fun update(list: List<Data>) {
        dataList.clear()
        dataList.addAll(list)
        adapter.update(list)
    }
}

