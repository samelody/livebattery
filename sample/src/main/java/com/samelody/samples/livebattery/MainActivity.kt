package com.samelody.samples.livebattery

import android.os.*
import androidx.appcompat.app.*
import androidx.lifecycle.*
import com.samelody.livebattery.*

class MainActivity : AppCompatActivity() {

    private lateinit var liveBattery: BatteryLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        liveBattery = BatteryLiveData(this)
        liveBattery.observe(this, Observer {
            println(it)
        })
    }
}
