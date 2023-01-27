package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random
import android.media.MediaPlayer


class MainActivity : AppCompatActivity() {

    private var rastgeleSayi=0
    private var hak=3
    var mediaPlayer:MediaPlayer?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    mediaPlayer=MediaPlayer.create(this,R.raw.muzik)

            rastgeleSayi.toString()

            rastgeleSayi=Random.nextInt(1,11)
            println(rastgeleSayi)


            button.setOnClickListener{
                //Edit Text'in boş olup olmadığını kontrol eder
                if(editTextNumber.text.trim().toString().equals("")){
                    textView.text="Lütfen Tahmininizi Girin"}
                try {
                    var tahmin=editTextNumber.text.toString().toInt()


                    if (tahmin==rastgeleSayi){
                        textView.text="Tebrikler Kazandınız"
                        button.isInvisible=true
                        button2.isInvisible=false
                        hak=3
                        editTextNumber.text.clear()
                        mediaPlayer?.start()
                    }
                    else if (tahmin<=rastgeleSayi){
                        hak--
                        textView.text="${hak} Hakkınız Kladı" +
                                " Tahmininizi Arttırın"

                        editTextNumber.text.clear()
                    }
                    else if(tahmin>=rastgeleSayi){
                        hak--
                        textView.text="${hak} Hakkınız Kaldı" +
                                " Tahmininizi Azaltın"

                        editTextNumber.text.clear()
                    }

                    if (hak==0){
                        textView.text="Kaybettiniz"
                        editTextNumber.text.clear()
                        hak=3
                        button.isInvisible=true
                        button2.isInvisible=false

                    }
                }catch (e:Exception){}

            }
        button2.setOnClickListener {
            rastgeleSayi=Random.nextInt(1,11)
            println(rastgeleSayi)
            button2.isInvisible=true
            button.isInvisible=false
            textView.text=""
        }


    }
}