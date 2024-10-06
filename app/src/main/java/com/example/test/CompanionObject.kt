package com.example.test

import java.io.Serializable

class CompanionObject: Serializable{
    private var jam: Int=0
    private var minute :Int=0
    private var tanggal :String=""
    private var tujuan :String=""
    private var harga :Int=0
    private var nama :String=""

    fun setharga(harga: Int){
        this.harga = harga
    }

    fun getHarga():Int{
        return harga
    }

    fun setnama(nama: String){
        this.nama = nama
    }

    fun getNama():String{
        return nama
    }

    fun setjam(jamberangkat: Int){
        this.jam = jamberangkat
    }

    fun getJam():Int{
        return jam
    }

    fun setminute(menitberangkat: Int){
        this.minute = menitberangkat
    }

    fun getminute():Int{
        return minute
    }
    fun settanggal(tglberangkat: String){
        this.tanggal = tglberangkat
    }

    fun gettanggal():String{
        return tanggal
    }
    fun settujuan(tujuan: String){
        this.tujuan = tujuan
    }

    fun getTujuan():String{
        return tujuan
    }
}