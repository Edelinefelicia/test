import android.app.Dialog
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.test.MainActivity
import com.example.test.databinding.ActivitySetelWaktuBinding


class CustomTimePickerDialog() : DialogFragment() {
//
//    private lateinit var timePicker: TimePicker
//    private lateinit var confirmButton: Button
//
//    interface TimePickerListener {
//        fun onTimeSet(hour: Int, minute: Int)
//    }

//    interface OnDataPassListener {
//        fun onDataPass(data: String)
//    }
//
//
//
//    private lateinit var dataPassListener: OnDataPassListener
//
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        // Ensure that the hosting activity implements the OnDataPassListener interface
//        dataPassListener = context as OnDataPassListener
//    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val binding = ActivitySetelWaktuBinding.inflate(inflater)
        // Inflate the custom layout
//        val view = inflater.inflate(R.layout.activity_setel_waktu, null)

//        timePicker = view.findViewById(R.id.timePicker)
//        confirmButton = view.findViewById(R.id.btn_confirm)

        with(binding){

            btnConfirm.setOnClickListener {
                val a = etHour.text.toString()
                val b = etMinute.text.toString()
                if (a.toInt() <= 12 && b.toInt() <= 59) {

                    val jam = MainActivity.getdatapemesanan().setjam(a.toInt())
                    val minute = MainActivity.getdatapemesanan().setminute(b.toInt())
                    dismiss()

//                    dataPassListener.onDataPass(jam.toString())
//                    dataPassListener.onDataPass(minute.toString())
//                    val result = Bundle()
//                    result.putString("inputKey", jam.toString())
//                    setFragmentResult("requestKey", result)
//                    val intent = Intent(requireActivity(), MainActivity::class.java)
//                    intent.putExtra(MainActivity.getdatapemesanan().getJam().toString(), jam.toString())
//                    intent.putExtra(MainActivity.getdatapemesanan().getminute().toString(), minute.toString())
//                    startActivity(intent)// For API level 23 and above

//                    val resultIntent = Intent()
//                    // Memasukkan alamat ke Intent
//                    resultIntent.putExtra(jam, a)
//                    resultIntent.putExtra(minute, b)
//
//                }
////                listener.onTimeSet(hour, minute) // Pass the selected time back to the listener
//            }
                }
            }
            }
//        // Set confirm button click listener

        builder.setView(binding.root)
        return builder.create()
    }

}

