package site.xiaozk.demo.rv_ani.ui.main.rv

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import site.xiaozk.demo.rv_ani.ui.main.Data

/**
 * @author: xiaozhikang
 * @mail: xiaozhikang0916@gmail.com
 * @create: 3/8/21
 */

class Adapter : RecyclerView.Adapter<ViewHolder>() {
    private val dataList = ArrayList<Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun update(list: List<Data>) {
        val diff = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun getOldListSize(): Int {
                return dataList.size
            }

            override fun getNewListSize(): Int {
                return list.size
            }

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return dataList[oldItemPosition].content == list[newItemPosition].content
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return dataList[oldItemPosition] == list[newItemPosition]
            }

        })
        dataList.clear()
        dataList.addAll(list)
        diff.dispatchUpdatesTo(this)
    }

}