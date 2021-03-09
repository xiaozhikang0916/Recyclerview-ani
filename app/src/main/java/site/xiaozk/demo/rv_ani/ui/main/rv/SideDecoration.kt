package site.xiaozk.demo.rv_ani.ui.main.rv

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.util.Log
import android.view.View
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import site.xiaozk.demo.rv_ani.R
import site.xiaozk.demo.rv_ani.ui.main.Data

/**
 * @author: xiaozhikang
 * @mail: xiaozhikang0916@gmail.com
 * @create: 3/8/21
 */

class SideDecoration(context: Context, private val dataGetter: ((Int) -> Data?)) : RecyclerView.ItemDecoration() {
    private val paint = Paint()
    private val padding = context.resources.getDimensionPixelSize(R.dimen.item_side_padding)

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        parent.children.map {
            it to parent.getChildAdapterPosition(it)
        }.map { (view, index) ->
            Log.d("SideDecoration", "getting data to draw of index $index")
            view to dataGetter(index)
        }.map { (view, data) ->
            RectF(
                0f,
                view.top + view.translationY,
                padding.toFloat(),
                view.bottom + view.translationY
            ) to data
        }.forEach { (rect, data) ->
            paint.color = data?.color ?: return@forEach
            c.drawRect(rect, paint)
        }
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val index = parent.getChildAdapterPosition(view)
        Log.d("SideDecoration", "getting offset of index $index")
        val data = dataGetter(index)
        data?.let {
            outRect.left = padding
        }
    }
}