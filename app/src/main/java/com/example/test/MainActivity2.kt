package com.example.test

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.test.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            val nama = intent.getStringExtra("Username")
            val jam = intent.getStringExtra("Jam")
            val tanggal = intent.getStringExtra("tanggal")
            val tujuan = intent.getStringExtra("tujuan")

            binding.tvNama.text = "Nama : " + nama
            binding.tvJam.text = "Jam : " + jam
            binding.tvTgl.text = "Tanggal : " + tanggal
            binding.tvTujuan.text = "Tujuan : " + tujuan
        }
    }
}