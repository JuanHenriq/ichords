package com.example.ichords

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class BibliotecaActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private lateinit var bottomNavigation: BottomNavigationView
    private var mList = ArrayList<BibliotecaData>()
    private lateinit var adapter: BibliotecaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biblioteca)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)
        bottomNavigation = findViewById(R.id.bottom_navigation)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()
        adapter = BibliotecaAdapter(mList)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    true
                }
                R.id.menu_favorites -> {
                    // startActivity(Intent(this, FavoritosActivity::class.java))
                    true
                }
                R.id.menu_profile -> {
                    // Redirecionar para a tela de Perfil
                   startActivity(Intent(this, ProfileActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }

    private fun filterList(query: String?) {
        if (query != null) {
            val filteredList = ArrayList<BibliotecaData>()
            for (i in mList) {
                if (i.title.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(this, "No Data found", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filteredList)
            }
        }
    }

    private fun addDataToList() {
        mList.add(BibliotecaData("MusicaA", R.drawable.music_a))
        mList.add(BibliotecaData("MusicaB", R.drawable.music_b))
        mList.add(BibliotecaData("MusicaC", R.drawable.music_c))
        mList.add(BibliotecaData("MusicaD", R.drawable.music_d))
        mList.add(BibliotecaData("MusicaE", R.drawable.music_e))
        mList.add(BibliotecaData("MusicaF", R.drawable.music_f))
        mList.add(BibliotecaData("MusicaG", R.drawable.music_g))
    }
}
