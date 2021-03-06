package com.boni.lottonumgenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_result.*
import java.text.SimpleDateFormat
import java.util.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // 전달받은 결과 배열을 가져온다.
        val result = intent.getIntegerArrayListExtra("result")
        // 전달받은 이름을 가져온다.
        val name = intent.getStringExtra("name")
        // 전달받은 별자리를 가져온다.
        val constellation  = intent.getStringExtra("constellation")

        // 결과화면 기본 텍스트
        resultLabel.text = "랜덤으로 생성된\n로또번호입니다"

        // 이름이 전달된 경우 결과화면의 테스트를 변경
        if (!TextUtils.isEmpty(name))
            resultLabel.text = "${name}님의" +
                    "\n${SimpleDateFormat("yyyy년 MM월 dd일").format(Date())}" +
                    "\n로또 번호입니다."

        // 별자리기 전달된 경우 결과화면의 테스트를 변경
        if (!TextUtils.isEmpty(constellation))
            resultLabel.text = "${constellation}의" +
                    "\n${SimpleDateFormat("yyyy년 MM월 dd일").format(Date())}" +
                    "\n로또 번호입니다."

        // 전달받은 결과가 있는 경우에만 실행
        result?.let {
            // 결과에 맞게 로또 공 이미지를 업데이트 한다.
            // 전달받은 결과는 정렬되어 있지 않으므로 정렬해서 전달한다.
            updateLottoBallImage(result.sortedBy { it })
        }
    }

    /**
     * 결과에 따라 로또 공 이미지를 업데이트 한다.
     */
    fun updateLottoBallImage(result: List<Int>) {
        // 결과의 사이즈가 6개 미만인 경우 에러가 발생할 수 있으므로 바로 리턴함.
        if (result.size < 6) return

        // ball_01 이미지 부터 순서대로 이미지 Id가 있기 때문에
        // ball_01 아이디에 결과값 -1 을 하면 목표하는 이미지가 된다.
        // ex) result[0] 이 2번 공인 경우 ball_01 에서 하나 뒤에 이미지가 된다.
        var i = 0
        actvActRsltNum1.text = result[i++].toString()
        actvActRsltNum2.text = result[i++].toString()
        actvActRsltNum3.text = result[i++].toString()
        actvActRsltNum4.text = result[i++].toString()
        actvActRsltNum5.text = result[i++].toString()
        actvActRsltNum6.text = result[i].toString()
    }

}
