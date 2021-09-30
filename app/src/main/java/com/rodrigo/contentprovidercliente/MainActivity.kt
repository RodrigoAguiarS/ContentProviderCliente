package com.rodrigo.contentprovidercliente

import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var noteRecycler: RecyclerView
    lateinit var noteRefreshButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteRefreshButton = findViewById(R.id.cliente_button_refresh)
        noteRecycler = findViewById(R.id.cliente_list)
        getContentProvider()

        noteRefreshButton.setOnClickListener{ getContentProvider()}
    }
    private fun getContentProvider(){
        try {
            val url = "content://com.rodrigo.contentprovider.provider/notes"
            val data = Uri.parse(url)
            val cursor: Cursor? = contentResolver.query(data, null, null, null, "title")
            noteRecycler.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = ClienteAdpater(cursor as Cursor)
            }
        }catch (ex: Exception){
            ex.printStackTrace()
        }
    }
}