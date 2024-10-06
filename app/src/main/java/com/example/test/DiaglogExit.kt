package com.example.test

import android.app.Dialog
import android.content.Intent

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.DialogFragment
import com.example.test.databinding.ActivityDiaglogExitBinding
import com.example.test.databinding.ActivityMainBinding

class DiaglogExit : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val binding = ActivityDiaglogExitBinding.inflate(inflater)
        with(binding) {
            binding.tvHarganya.text = MainActivity.getdatapemesanan().getHarga().toString()
            btnBatal.setOnClickListener {
                dismiss()
            }
            btnBeli.setOnClickListener {
                val editTextusername = MainActivity.getdatapemesanan().getNama()
                val jamhasil = MainActivity.getdatapemesanan().getJam()
                val tanggalhasil = MainActivity.getdatapemesanan().gettanggal()
                val tujuanhasil = MainActivity.getdatapemesanan().getTujuan()
                val intent = Intent(requireActivity(), MainActivity2::class.java)
                intent.putExtra("Username", editTextusername)
                intent.putExtra("Jam", jamhasil)
                intent.putExtra("tanggal", tanggalhasil)
                intent.putExtra("tujuan", tujuanhasil)
                startActivity(intent)
            }
        }
        builder.setView(binding.root)
        return builder.create()
    }
}