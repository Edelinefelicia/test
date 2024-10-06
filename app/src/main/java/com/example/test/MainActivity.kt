package com.example.test

import CustomTimePickerDialog
import android.app.Activity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.test.databinding.ActivityMainBinding
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat

//TimePickerDialog.OnTimeSetListener
class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener{
    //activitymainbinding = kelas otomatis terbuat oleh view binding berdasarkan file layout XML activity_main.xml
    private lateinit var binding: ActivityMainBinding
//    private val launcher =
//        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
//        { result ->
//            // Memeriksa result code
//            if (result.resultCode == Activity.RESULT_OK) {
//                // Mengambil data Intent
//                val data = result.data
//                // Mendapatkan alamat dari data Intent
//                val jam = data?.getStringExtra(getdatapemesanan().getJam().toString())
//                val menit = data?.getStringExtra(getdatapemesanan().getminute().toString())
//                // Menetapkan teks di TextView
//                binding.btnJam.text = "$jam:$menit"
//            }
//        }
    private lateinit var tujuanarray: Array<String>
    private val hargaArray = arrayOf(
        1000,
        2000,
        3000,
        4000,
        5000,
        6000,
        7000,
        8000,
        9000,
        10000
    )

    companion object {
        private val datacompanion = CompanionObject()
        public fun getdatapemesanan(): CompanionObject{
            return  datacompanion
        }
        public lateinit var  mainBinding:ActivityMainBinding;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //di bawah ini akan menginisasi variabel binding yang sudah dideklarasikan sbelumnya dengan inflate (mengubah xml jadi ui yang akan ditampilkan) activity_main.xml menggunakan layoutInflater.
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) //menetapkan tampilan yang akan digunakan activity berdasarkan root view yang dihasilkan dari objek binding

        tujuanarray = resources.getStringArray(R.array.tujuan)


        with(binding) {
            //buat kelas yang menghubungkan data (seperti array) ke komponen UI, dalam hal ini ke Spinner.
            val adapterTujuan = ArrayAdapter(
                this@MainActivity,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, tujuanarray
            )
            //mengatur tampilan drop-down untuk item di Spinner menggunakan layout bawaan simple_spinner_dropdown_item.
            adapterTujuan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            //menampilkan data yang ada di tujuanarray menggunakan ArrayAdapter yang telah disiapkan ke spinner
            spinner.adapter = adapterTujuan


            //method untuk menangani peristiwa (events) yang terjadi ketika pengguna berinteraksi dengan Spinner
            spinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>,
                        view: View, position: Int, id: Long
                    ) {
                        if (parent != null) {
                            if (position == 0) {
                                val textView = parent.getChildAt(0) as TextView
                                textView.setTextColor("#828282".toColorInt())

// Set Typeface ke Poppins Medium
                                val typeface =
                                    ResourcesCompat.getFont(this@MainActivity, R.font.poppinsmedium)
                                textView.typeface = typeface

//                           val poppins = Typeface.createFromFile("@font/poppinsbold")
//                                textView.setTypeface(poppins)
                            } else {
                                getdatapemesanan().settujuan(tujuanarray[position])
                                getdatapemesanan().setharga(hargaArray[position])
                            }
                        }
                    }

                    override fun onNothingSelected(parent: AdapterView<*>) {
                    }
                }
            //menampilkan class DatePicker yang telah dibuat sebelumnya.
            //Metode show() akan menampilkan dialog DatePicker di layar
            btntanggal.setOnClickListener {
                val datePicker = DatePicker()
                datePicker.show(supportFragmentManager, "CustomDialog")
            }

//            btnJam.setOnClickListener{
////                val timePicker = TimePicker()
//                val timePicker = SetelWaktu()
//                timePicker.show(supportFragmentManager, "timePicker")
//            }

//            btnJam.setOnClickListener{
//                val picker = MaterialTimePicker.Builder()
//                    .setTimeFormat(TimeFormat.CLOCK_12H)
//                    .setHour(12)
//                    .setMinute(10)
//                    .setTitleText("Select Appointment time")
//                    .build()
//                picker.show(supportFragmentManager, picker.toString())
//            }

            btnJam.setOnClickListener {
                // Show custom time picker dialog
//                val intent = Intent(this@MainActivity, CustomTimePickerDialog::class.java)
//
//                launcher.launch(intent)
                val customTimePickerDialog = CustomTimePickerDialog()
                customTimePickerDialog.show(supportFragmentManager, "customTimePicker")
//                btnJam.text = "${getdatapemesanan().getJam()}:${getdatapemesanan().getminute()}"
            }



            btnPesan.setOnClickListener{
                getdatapemesanan().setnama(etNamapemesan.text.toString())
                val dialog = DiaglogExit()
                dialog.show(supportFragmentManager, "dialogExit")
            }

        }

    }

    //Metode ini akan dipanggil ketika pengguna memilih tanggal dan menekan tombol "OK" pada DatePickerDialog.
    override fun onDateSet(p0: android.widget.DatePicker?, p1: Int, p2: Int, p3: Int) {
        val selectedDate = "$p3/${p2 + 1}/$p1"
        with(binding){
            btntanggal.text = selectedDate
            binding.btntanggal.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.black))
            getdatapemesanan().settanggal(selectedDate)
        }
    }



//    override fun onTimeSet(p0: android.widget.TimePicker?, p1: Int, p2: Int) {
////        gunakan p1 dan p2 untuk mendapatkan jam dan menit
//    val selectedTime = String.format("%02d:%02d", p1, p2)
//    with(binding){
//        btnJam.text = selectedTime
//        binding.btnJam.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.black))
//
//        tanggal = selectedTime
//}
//    }


}







