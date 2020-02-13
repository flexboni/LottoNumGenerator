package com.boni.lottonumgenerator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_name.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class NameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        btnActNameGenerateNum.setOnClickListener {
            val intent = Intent(this@NameActivity, ResultActivity::class.java)

            // intent 의 결과 데이터를 전달한다.
            // int 의 리스트를 전달하므로 putIntegerArrayListExtra 를 사용한다.
            // 전달하는 리스트는 이름의 해시코드로 생성한 로또 번호
            intent.putIntegerArrayListExtra("result", ArrayList(getLottoNumbersFromHash(etActName.text.toString())))

            startActivity(intent)
        }

        btnActNameBack.setOnClickListener {
            finish()
        }
    }

    /**
     * 입력받은 이름에 대한 해시코드를 사용하여 로또 번호를 섞고 결과를 반환한다.
     */
    fun getLottoNumbersFromHash(name: String): MutableList<Int> {
        // 1~45번에 로또 번호를 저장할 리스트 생성
        val list = mutableListOf<Int>()

        // 1~45까지 for 문을 돌면서 리스트에 로또 번호 저장
        for (number in 1..45){
            list.add(number)
        }

        // SimapleDateFormat 은 날짜의 시간값을 포맷화된 텍스트 형태로 바꿔주는 클래스
        // 현재 Date 의 'yyyy-MM-dd' 문자열과 이름 문자열을 합친다
        val targetString = SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(Date()) + name

//        // 리스트를 무작위로 섞는다. 이때 섞는 기준으로 Random(SEED) 를 사용한다.
//        // SEED 값은 전달받은 이름의 해시코드를 사용한다.
//        list.shuffle(Random(name.hashCode().toLong()))

        // 리스트를 무작위로 섞는다. 이때 섞는 기준으로 Random(SEED) 를 사용한다.
        // SEED 값은 전달받은 이름의 해시코드를 사용한다.
        list.shuffle(Random(targetString.hashCode().toLong()))

        // 리스트를 앞에서 부터 순서대로 6개를 짤라 결과 반환
        return list.subList(0, 6)
    }
}
