package com.example.customarrayadaptor
//
//import android.app.Activity
//import android.content.Context
//import android.view.View
//import android.view.ViewGroup
//import android.widget.BaseAdapter
//import android.widget.ImageView
//import android.widget.TextView
//
//class CustomGridAdapter(context: Context, arrayListImage: ArrayList<Int>, name: Array<String>) :
//    BaseAdapter() {
//    var context = context
//    var arrayListImage = arrayListImage
//    var name = name
//    override fun getCount(): Int {
//        return arrayListImage.size
//    }
//
//    override fun getItem(position: Int): Any {
//        return arrayListImage.get(position)
//    }
//
//    override fun getItemId(position: Int): Long {
//        return 0
//    }
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        var myView = convertView
//        var holder: ViewHolder
//        if (myView == null) {
//            val mInflater = (context as Activity).layoutInflater
//            myView = mInflater.inflate(R.layout.grid_item, parent, false)
//            holder = ViewHolder()
//
//            holder.mImageView = myView!!.findViewById(R.id.imageView) as ImageView
//            holder.mTextView = myView!!.findViewById(R.id.textView) as TextView
//            myView.tag = holder
//        } else {
//            holder = myView.tag as ViewHolder
//        }
//
//        holder.mImageView!!.setImageResource(arrayListImage.get(position))
//        holder.mTextView!!.setImageResource(arrayListImage.get(position))
//
//        return myView
//    }
//    class ViewHolder{
//        var
//    }
//}