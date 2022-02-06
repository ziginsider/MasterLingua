package io.github.ziginsider.masterlingua.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.github.ziginsider.masterlingua.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.appComponent.inject(this)

        setContentView(R.layout.activity_main)
    }

    override fun onDestroy() {
        Log.i(TAG, "onDestroy")
        super.onDestroy()
    }

    private companion object {

        private const val TAG = "MainActivity"
    }
}