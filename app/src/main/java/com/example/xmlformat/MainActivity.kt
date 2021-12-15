package com.example.xmlformat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xmlformat.databinding.ActivityMainBinding
import java.io.IOException

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var studentList: List<Student>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        try {
            val parser = XmlParserHandler()
            val xmlFile = assets.open("StudentDetails.xml")
            studentList = parser.parse(xmlFile)

            binding.recycle.layoutManager = LinearLayoutManager(this)
            binding.recycle.adapter = RecycleAdpter(studentList)

        } catch (e: IOException) {
            println("ISSUE: $e")
        }
    }
}