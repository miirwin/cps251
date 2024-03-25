package com.example.recycleviewproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleviewproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = generateRandomCardItems()
        adapter = RecyclerAdapter(items)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun generateRandomCardItems(): List<Data> {
        val titles = arrayOf("Chapter One", "Chapter Two", "Chapter Three", "Chapter Four",
            "Chapter Five", "Chapter Six", "Chapter Seven", "Chapter Eight")
        val details = arrayOf("Item one details", "Item two details", "Item three details",
            "Item four details", "Item five details", "Item six details", "Item seven details",
            "Item eight details")
        val images = intArrayOf(
            R.drawable.android_image_1, R.drawable.android_image_2, R.drawable.android_image_3,
            R.drawable.android_image_4, R.drawable.android_image_5, R.drawable.android_image_6,
            R.drawable.android_image_7, R.drawable.android_image_8
        )

        val cardItems = mutableListOf<Data>()
        repeat(titles.size) {
            val randomIndex = (0 until titles.size).random()
            cardItems.add(Data(titles[randomIndex], details[randomIndex], images[randomIndex]))
        }
        return cardItems
    }
}