package com.example.test

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.Calendar

//kelas yang mewarisi dari DialogFragment. DialogFragment adalah komponen Android yang digunakan untuk menampilkan dialog dalam bentuk fragment.
class DatePicker: DialogFragment() {
    //membuat instance dari dialog yang akan ditampilkan.
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //Membuat instance dari kelas Calendar untuk mendapatkan informasi tanggal saat ini
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val monthOfYear = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
        //Mengembalikan instance dari DatePickerDialog yang dibuat menggunakan data tahun, bulan, dan hari yang telah diambil.
        return DatePickerDialog(
            requireActivity(),
            activity as DatePickerDialog.OnDateSetListener, //listener yang menangani aksi ketika pengguna memilih tanggal dan menekan tombol "OK".
            year,
            monthOfYear,
            dayOfMonth
        )
    }
}

