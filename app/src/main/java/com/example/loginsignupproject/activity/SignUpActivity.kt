package com.example.loginsignupproject.activity

import Account
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.loginsignupproject.R

class SignUpActivity : ComponentActivity() {
    private var inputId: EditText? = null
    private var inputPW: EditText? = null
    private var inputName: EditText? = null
    private lateinit var myApplication: MyApplication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up)

        myApplication = application as MyApplication
        val am = myApplication.accountManager

        // user list 호출...
        var list = am!!.list;

        // id로 요소 찾기...
        val signupBtn = findViewById<Button>(R.id.signupBtn)

        inputId = findViewById(R.id.input_id)
        inputPW = findViewById(R.id.input_pw)
        inputName = findViewById(R.id.input_name)


        // 회원 가입 버튼 클릭 시...
        signupBtn.setOnClickListener {
            val id = inputId!!.text.toString().trim { it <= ' ' }
            val pw = inputPW!!.text.toString().trim { it <= ' ' }
            val name = inputName!!.text.toString().trim { it <= ' ' }

            if (id.isEmpty() || pw.isEmpty() || name.isEmpty()) {
                Toast.makeText(this@SignUpActivity, "빈 칸이 존재합니다.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@SignUpActivity, "회원 가입 성공!", Toast.LENGTH_SHORT).show()
                am.list.add(Account(id, pw, name))
                finish()
            }
        }
    }
}