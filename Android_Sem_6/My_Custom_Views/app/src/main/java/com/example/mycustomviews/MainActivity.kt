

package com.example.mycustomviews
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
class MainActivity : AppCompatActivity() {
    lateinit var customViewFan: CustomViewFan
    lateinit var customViewDrawing: CustomViewDrawing
    lateinit var customDrawing: CustomDrawing
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //    customViewFan =  CustomViewFan(this)
    //   setContentView(customViewFan)

//            customDrawing = CustomDrawing(this)
//             setContentView(customDrawing)

//            customViewDrawing = CustomViewDrawing(this)
//             setContentView(customViewDrawing)

            val cb = findViewById<Button>(R.id.clear)
            customViewDrawing = findViewById<View>(R.id.cd) as CustomViewDrawing

            cb.setOnClickListener {
                customViewDrawing.clear()
            }
        }
    }
