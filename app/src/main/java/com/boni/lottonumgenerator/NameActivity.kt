package com.boni.lottonumgenerator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
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
            // 입력된 이름이 없으면 토스트 메세지 출력 후 리턴
            if (TextUtils.isEmpty(etActName.text.toString())) {
                // 입력된 이름이 없으면 토스트 메세지 출력 후 리턴
                Toast.makeText(applicationContext, "이름을 입력하세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val name = etActName.text.toString()

            val intent = Intent(this@NameActivity, ResultActivity::class.java)

            // intent 의 결과 데이터를 전달한다.
            // int 의 리스트를 전달하므로 putIntegerArrayListExtra 를 사용한다.
            // 전달하는 리스트는 이름의 해시코드로 생성한 로또 번호
            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getLottoNumbersFromHash(name)))

            // 입력받은 이름을 추가로 전달한다.
            intent.putExtra("name", name)

            startActivity(intent)
        }

        btnActNameBack.setOnClickListener {
            finish()
        }
    }
}
