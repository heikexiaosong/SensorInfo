package com.example.echo.sensorinfo

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import android.widget.ArrayAdapter





class DisplayMessageActivity : AppCompatActivity() {

    private lateinit var mSensorManager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

//        // Get the Intent that started this activity and extract the string
//        var message:String = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
//
//        // Capture the layout's TextView and set the string as its text
//        val textView = findViewById<TextView>(R.id.textView)
//        textView.text = message


        val adapter = ArrayAdapter<String>(this, R.layout.activity_listview)
        val listView:ListView = findViewById<ListView>(R.id.nameList)
        listView.adapter = adapter;

        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL).iterator()
        deviceSensors.forEach {
            var sensor:Sensor = it
            adapter.add(sensor.stringType + ": " + sensor.name)
        }
    }
}
