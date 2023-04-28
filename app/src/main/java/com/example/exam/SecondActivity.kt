package com.example.exam

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var tvAmount: TextView
    private lateinit var tvTime: TextView
    private lateinit var tvPrice: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initView()
        initData()
    }

    /**
     * 初始化数据
     */
    private fun initData() {
        val amount = intent.getIntExtra("amount", -1)
        tvAmount.text = "amount:$amount"
        val time = intent.getIntExtra("time", -1)
        tvTime.text = "time:$time"
        val price = amount * time
        tvPrice.text = "price:$price"
    }

    /**
     * 初始化控件
     */
    private fun initView() {
        tvAmount = findViewById(R.id.tv_amount)
        tvTime = findViewById(R.id.tv_time)
        tvPrice = findViewById(R.id.tv_price)
    }
}