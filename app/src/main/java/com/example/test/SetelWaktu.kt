package com.example.test

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.DialogFragment
import com.example.test.databinding.ActivitySetelWaktuBinding
import com.google.android.material.dialog.MaterialDialogs
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat

class SetelWaktu : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState)

        val builder = MaterialTimePicker.Builder()
        val inflater = requireActivity().layoutInflater
        val binding = ActivitySetelWaktuBinding.inflate(inflater)

        builder.setTimeFormat(TimeFormat.CLOCK_12H)

    }
}