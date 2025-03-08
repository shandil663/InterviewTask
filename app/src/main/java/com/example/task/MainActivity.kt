package com.example.task

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task.Adapter.UserAdapter
import com.example.task.api.RetrofitAPI
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var rec: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rec = findViewById(R.id.recycle)
        rec.layoutManager = LinearLayoutManager(this)

        fetchData()
    }

    fun fetchData() {
        lifecycleScope.launch {
            try {
                val Items = RetrofitAPI.service.getdetails()
                Log.d("heloooooooooo", Items.body()?.total_results.toString())
                rec.adapter = Items.body()?.let { UserAdapter(it) }
            } catch (exeption: Exception) {
                Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }

}