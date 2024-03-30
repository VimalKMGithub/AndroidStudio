package com.example.mycustomviews
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
class CustomDrawing @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val paint = Paint()
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.BLUE)
        paint.color = Color.RED
        canvas.drawRect(100f, 100f, 500f, 500f, paint)
        paint.color = Color.GREEN // Change color for arc
        val startAngle = 0f
        val sweepAngle = 60f
        val useCenter = true // Draw the arc with a center
        canvas.drawArc(600f, 600f, 900f, 900f, startAngle, sweepAngle, useCenter, paint)
    }
}
