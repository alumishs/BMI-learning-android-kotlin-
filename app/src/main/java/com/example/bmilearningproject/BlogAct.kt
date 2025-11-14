package com.example.bmilearningproject

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bmilearningproject.adapter.BlogGridAdapter
import com.example.bmilearningproject.adapter.BlogTopAdapter
import com.example.bmilearningproject.callback.BlogTopMenuListener
import com.example.bmilearningproject.databinding.ActivityBlogBinding
import com.example.bmilearningproject.model.BlogGridModel
import com.example.bmilearningproject.model.BlogTopModel

class BlogAct : AppCompatActivity(), BlogTopMenuListener {
    val TAG = "BlogAct"
    private  lateinit var blogGridAdapter : BlogGridAdapter
    private  lateinit var blogGridList : ArrayList<BlogGridModel>
    private lateinit var blogTopAdapter : BlogTopAdapter
    private lateinit var menuList : ArrayList<BlogTopModel>
    private lateinit var binding: ActivityBlogBinding
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBlogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.apply {
            backIc.setOnClickListener {
                finish()
            }
            menuList = ArrayList<BlogTopModel>()
            menuList.add(BlogTopModel(R.drawable.bmi_logo,  "BMI"))
            menuList.add(BlogTopModel(R.drawable.admin_panel_settings_ic,  "BMR"))
            topBlogRV.layoutManager = LinearLayoutManager(this@BlogAct, LinearLayoutManager.HORIZONTAL, false)
//            topBlogRV.layoutManager = GridLayoutManager(this@BlogAct, 3)
            blogTopAdapter = BlogTopAdapter(menuList,this@BlogAct)
            topBlogRV.adapter = BlogTopAdapter(menuList,this@BlogAct)


//            blogTopAdapter  = BlogTopAdapter(menuList)
//            topBlogRV.layoutManager = LinearLayoutManager(this@BlogAct, LinearLayoutManager.HORIZONTAL, false)
//            topBlogRV.adapter = blogTopAdapter
            blogGridList = ArrayList<BlogGridModel>()
            blogGridList.add(BlogGridModel("This is main heading from blogAct lkjdklfjsd jklsdjf lkasdjfl",R.drawable.bmi_logo))
            blogGridList.add(BlogGridModel("This is main heading 1",R.drawable.bmi_without_bg_ic))
//            blogGridList.add(BlogGridModel("This is main heading 2",findViewById(R.drawable.bmi_logo)))
//            blogGridList.add(BlogGridModel("This is main heading 3",findViewById(R.drawable.bmi_logo)))
//            blogGridList.add(BlogGridModel("This is main heading 4",findViewById(R.drawable.bmi_logo)))
//            blogGridList.add(BlogGridModel("This is main heading 5",findViewById(R.drawable.bmi_logo)))
            blogGridRV.layoutManager = LinearLayoutManager(this@BlogAct, LinearLayoutManager.VERTICAL, false)
            blogGridAdapter = BlogGridAdapter(blogGridList)
            blogGridRV.adapter = BlogGridAdapter(blogGridList)
        }
    }

    override fun onMenuClick(model: BlogTopModel, text: TextView) {
//      val blogItemTxt = findViewById<TextView>(R.id.blogItemText)
//        blogItemTxt.setBackgroundResource(R.color.common_color)
       text.setBackgroundColor(Color.BLACK)
        text.setTextColor(Color.WHITE)

    }
}