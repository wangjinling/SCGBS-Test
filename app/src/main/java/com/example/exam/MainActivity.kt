package com.example.exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var tvAmount: TextView
    lateinit var tvTime: TextView
    private lateinit var etTime: EditText
    private lateinit var etAmount: EditText
    private lateinit var btSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initListener()
    }

    /**
     * 初始化监听
     */
    private fun initListener() {
        etAmount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                tvAmount.text = "Amount:$s"
            }
        })
        etTime.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                tvTime.text = "Time:$s"
            }
        })
        btSubmit.setOnClickListener {
            if (TextUtils.isEmpty(etAmount.text.trim())) {
                Toast.makeText(
                    MainActivity@ this,
                    "amount is null, please input",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(etTime.text.trim())) {
                Toast.makeText(MainActivity@ this, "time is null, please input", Toast.LENGTH_LONG)
                    .show()
                return@setOnClickListener
            }
            val intent = Intent(MainActivity@ this, SecondActivity::class.java)
            intent.putExtra("amount", Integer.parseInt(etAmount.text.toString()))
            intent.putExtra("time", Integer.parseInt(etTime.text.toString()))

            etAmount.setText("")
            etTime.setText("")
            startActivity(intent)
        }
    }

    /**
     * 初始化控件
     */
    private fun initView() {
        tvAmount = findViewById(R.id.tv_amount)
        tvTime = findViewById(R.id.tv_time)
        etTime = findViewById(R.id.et_time)
        etAmount = findViewById(R.id.et_amount)
        btSubmit = findViewById(R.id.bt_submit)
    }
}