package site.xiaozk.demo.rv_ani.ui.main

import android.graphics.Color
import androidx.annotation.ColorInt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.collections.ArrayList

class MainViewModel : ViewModel() {
    val data = MutableLiveData<List<Data>>()

    private val dataList = ArrayList<Data>()
    private val random = Random()
    init {
        repeat(10) {
            dataList.add(generateData())
        }
        notifyData()
    }

    private fun generateData(): Data {
        return Data(
            UUID.randomUUID().toString().substring(0, 6),
            colorList[random.nextInt(colorList.size)]
        )
    }

    fun addData() {
        dataList.add(generateData())
        notifyData()
    }

    fun removeRandom() {
        if (dataList.isNotEmpty()) {
            val index = random.nextInt(dataList.size)
            dataList.removeAt(index)
            notifyData()
        }
    }

    private fun notifyData() {
        data.value = ArrayList(dataList)
    }
}

val colorList = arrayOf(
    Color.BLUE,
    Color.CYAN,
    Color.RED,
    Color.YELLOW
)

data class Data(
    val content: String,
    @ColorInt val color: Int
)