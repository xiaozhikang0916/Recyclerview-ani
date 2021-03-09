package site.xiaozk.demo.rv_ani.ui.main.rv

import android.content.Context
import android.graphics.*
import android.view.View
import androidx.annotation.ColorInt
import androidx.core.graphics.ColorUtils
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import site.xiaozk.demo.rv_ani.R

/**
 * @author: xiaozhikang
 * @mail: xiaozhikang0916@gmail.com
 * @create: 3/8/21
 */
class SideTagDecoration(context: Context) : RecyclerView.ItemDecoration() {
    private val paint = Paint()
    private val padding = context.resources.getDimensionPixelSize(R.dimen.item_side_padding)

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        parent.children.map {
            it to it.getTag(R.id.tag_color) as Int
        }.map { (view, color) ->
            RectF(
                0f,
                view.top + view.translationY,
                padding.toFloat(),
                view.bottom + view.translationY
            ) to ColorUtils.setAlphaComponent(color, (view.alpha * 255).toInt())
        }.forEach { (rect, color) ->
            paint.color = color
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
        val content = view.getTag(R.id.tag_content) as String
        if (content.isNotBlank()) {
            outRect.left = padding
        }
    }
}