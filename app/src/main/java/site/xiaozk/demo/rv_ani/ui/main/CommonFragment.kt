package site.xiaozk.demo.rv_ani.ui.main

import android.os.Bundle
import android.view.View
import site.xiaozk.demo.rv_ani.ui.main.rv.SideDecoration

class CommonFragment : BaseFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.addItemDecoration(SideDecoration(view.context, dataList::getOrNull))
    }
}