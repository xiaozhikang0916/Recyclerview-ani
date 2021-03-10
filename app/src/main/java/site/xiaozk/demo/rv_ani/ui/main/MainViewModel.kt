package site.xiaozk.demo.rv_ani.ui.main

import android.graphics.Color
import android.util.Log
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
        val data = generateData()
        dataList.add(data)
        Log.d("MainViewModel", "Adding data $data to last")
        notifyData()
    }

    fun removeRandom() {
        if (dataList.isNotEmpty()) {
            val index = random.nextInt(dataList.size)
            val data = dataList.removeAt(index)
            Log.d("MainViewModel", "Removing data $data at $index")
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
) {
    override fun toString(): String {
        return "Data(content=$content, color=#${String.format("%06x", color)}"
    }
}