package com.example.gyn_app_asj_2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    var data: MutableList<Task> = mutableListOf(
        Task(
            "Gym",
            "My daily gym routine",
            icon = R.drawable.ic_food,
            true
        ),
        Task(
            "Gym",
            "My daily gym routine",
            icon = R.drawable.ic_icon_1,
            false
        ),
        Task(
            "Gym",
            "My daily gym routine",
            icon = R.drawable.ic_icon_2,
            false
        ),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler_view: RecyclerView = findViewById(R.id.recycler_view_tasks)
        recycler_view.adapter = com.example.listview_demo.Adapter(data)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)

        val addFloatingButton: FloatingActionButton = findViewById(R.id.add_fab)

        addFloatingButton.setOnClickListener {
            data.add(
                Task(
                    "Gym",
                    "My daily gym routine",
                    icon = R.drawable.ic_icon_1,
                    false
                )
            )

            recycler_view.adapter!!.notifyDataSetChanged()
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
        }

        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)

        toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            R.string.open,
            R.string.close
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        findViewById<NavigationView>(R.id.navView).setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item1 -> Toast.makeText(this, "Item1", Toast.LENGTH_SHORT).show()
                R.id.item2 -> Toast.makeText(this, "Item2", Toast.LENGTH_SHORT).show()
                R.id.item3 -> Toast.makeText(this, "Item3", Toast.LENGTH_SHORT).show()
                R.id.item4 -> Toast.makeText(this, "Item4", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}