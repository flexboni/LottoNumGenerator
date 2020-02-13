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

            // intent 의 결과 데이터를 전달한다.
            // int 의 리스트를 전달하므로 'putIntegerArrayListExtra' 를 사용한다.
            intent.putIntegerArrayListExtra("result", ArrayList(getRandomLottoNumders()))

            startActivity(intent)
        }

        constellationCard.setOnClickListener {
            startActivity(Intent(this@MainActivity, ConstellationActivity::class.java))
        }

        nameCard.setOnClickListener {
            startActivity(Intent(this@MainActivity, NameActivity::class.java))
        }

    }

    // 랜덤으로 1~46 번호 중 하나의 번호를 생성하는 함수
    fun getRandomLottoNumber(): Int {
        // Random.nextLine 는 0 부터 전달받은 파라미터 값 미만의 번호를 생성
        // ex) Random().nextInt(10)은 0~9 까지의 무작위 수를 반환
        // 1~45 까지의 번호를 생성하려면 파라미터에 45를 넣고 결과값의 1을 더한다.
        return Random.nextInt(45) + 1
    }

    // 랜덤으로 추출하여 6개의 로또 번호를 만드는 함수
    fun getRandomLottoNumders(): MutableList<Int> {
        // 무작위로 생성된 로또 번호를 저장할 가변 리스트 생성
        val lottoNumbers = mutableListOf<Int>()

        // 6번 반복하는 for 문
        for (i in 1..6) {
            // 랜덤한 번호를 임시로 저장할 변수를 생성
            var number: Int

            do {
                // 랜덤한 번호를 추출해 number 변수에 저장
                number = getRandomLottoNumber()

                // lottoNumbers 에 number 변수의 값이 없을 때까지 반복
            } while (lottoNumbers.contains(number))

            // 리스트에 무작위로 생성된 번호를 추가한다.
            lottoNumbers.add(number)
        }

        return lottoNumbers
    }
}
