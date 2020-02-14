package com.boni.lottonumgenerator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        randomCard.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)

//            // intent 의 결과 데이터를 전달한다.
//            // int 의 리스트를 전달하므로 'putIntegerArrayListExtra' 를 사용한다.
//            intent.putIntegerArrayListExtra("result", ArrayList(getRandomLottoNumders()))

            // Shuffle 로 섞은 숫자 집합을 전달 한다.
            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getShuffleLottoNumbers()))

            startActivity(intent)
        }

        constellationCard.setOnClickListener {
            startActivity(Intent(this@MainActivity, ConstellationActivity::class.java))
        }

        nameCard.setOnClickListener {
            startActivity(Intent(this@MainActivity, NameActivity::class.java))
        }

    }
}
