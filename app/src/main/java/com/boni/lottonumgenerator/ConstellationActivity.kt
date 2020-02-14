package com.boni.lottonumgenerator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_constellation.*
import java.util.*

class ConstellationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constellation)

        btnGenerator.setOnClickListener {
            startActivity(Intent(this@ConstellationActivity, ResultActivity::class.java))
        }

        // 현재 DatePicker 의 월, 일 정보로 별자리 텍스트 변경
        tvConstellation.text =
            makeConstellationString(dpConstellation.month, dpConstellation.dayOfMonth)

        // DatePicker 의 날짜가 변화하면 별자리를 보여주는 텍스트 뷰도 변경
        val calender = Calendar.getInstance()
        dpConstellation.init(calender.get(Calendar.YEAR),
            calender.get(Calendar.MONTH),
            calender.get(Calendar.DAY_OF_MONTH),
            object : CalendarView.OnDateChangeListener, DatePicker.OnDateChangedListener {
                override fun onDateChanged(
                    view: DatePicker?,
                    year: Int,
                    monthOfYear: Int,
                    dayOfMonth: Int
                ) {
                    // 변경된 시점의 DatePicker 의 월, 일 정보로 별자리 텍스트 변경
                    tvConstellation.text = makeConstellationString(dpConstellation.month, dpConstellation.dayOfMonth)
                }

                override fun onSelectedDayChange(
                    view: CalendarView,
                    year: Int,
                    month: Int,
                    dayOfMonth: Int
                ) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
    }

    /**
     * 전달받은 월 정보, 일 정보 기준으로 별자리를 변환한다.
     *
     */
    fun makeConstellationString(month: Int, day: Int): String {
        // 전달받은 월 정보와 일 정보를 기반으로 정수 형태의 값을 만든다.
        // ex) 1월 5일 -> 105, 11월 1일 -> 1101
        val target = "${month + 1}${String.format("%02d", day)}".toInt()

        when (target) {
            in 101..119 -> return "염소자리"
            in 120..218 -> return "물병자리"
            in 219..320 -> return "물고기자리"
            in 321..419 -> return "양자리"
            in 420..520 -> return "황소자리"
            in 521..621 -> return "쌍둥이자리"
            in 622..722 -> return "게자리"
            in 723..822 -> return "사자자리"
            in 823..923 -> return "처녀자리"
            in 924..1022 -> return "천칭자리"
            in 1023..1122 -> return "전갈자리"
            in 1123..1224 -> return "사수자리"
            in 1225..1231 -> return "염소자리"
            else -> return "기타별자리"
        }
    }
}
