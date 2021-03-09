package site.xiaozk.demo.rv_ani.ui.main.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import site.xiaozk.demo.rv_ani.R
import site.xiaozk.demo.rv_ani.databinding.RvItemLayoutBinding
import site.xiaozk.demo.rv_ani.ui.main.Data

/**
 * @author: xiaozhikang
 * @mail: xiaozhikang0916@gmail.com
 * @create: 3/8/21
 */

class ViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.rv_item_layout, parent, false)
) {
    private val bindings = RvItemLayoutBinding.bind(itemView)

    fun bind(data: Data) {
        bindings.root.setTag(R.id.tag_color, data.color)
        bindings.root.setTag(R.id.tag_content, data.content)
        bindings.title.text = data.content
    }
}