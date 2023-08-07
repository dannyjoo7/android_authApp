package com.example.loginsignupproject.activity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.loginsignupproject.R

class HomeActivity : ComponentActivity() {
    private var idTxt: TextView? = null
    private var pwTxt: TextView? = null
    private var finishBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        // id로 요소 찾기...
        idTxt = findViewById(R.id.idTxt)
        pwTxt = findViewById(R.id.pwTxt)
        finishBtn = findViewById(R.id.finishBtn)

        val intent = intent
        if (intent != null) {
            val id = intent.getStringExtra("USER_ID")
            val name = intent.getStringExtra("USER_NAME")

            idTxt?.text = "ID : $id"
            pwTxt?.text = "이름 : $name"
        }

        // 종료 버튼 클릭 시...
        finishBtn!!.setOnClickListener {
            finish()
        }
    }
}
