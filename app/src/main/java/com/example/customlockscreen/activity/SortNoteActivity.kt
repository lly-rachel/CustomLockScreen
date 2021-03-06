package com.example.customlockscreen.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.customlockscreen.R
import com.example.customlockscreen.adapter.SortNoteAdapter
import com.example.customlockscreen.databinding.ActivitySortNoteBinding
import com.example.customlockscreen.model.bean.SortNote
import com.example.customlockscreen.model.db.DataBase

class SortNoteActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySortNoteBinding

    private lateinit var list:List<SortNote>

    private lateinit var onClickListener: SortNoteAdapter.ClickListener

    private val sortNoteDao = DataBase.dataBase.sortNoteDao()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySortNoteBinding.inflate(layoutInflater)

        binding.sortNoteToolbar.setNavigationIcon(R.mipmap.back)
        binding.sortNoteToolbar.setNavigationOnClickListener {
            finish()
        }

        list = sortNoteDao.getAllSortNotes()

        onClickListener =object: SortNoteAdapter.ClickListener{
            override fun onClick(sortNoteName: String) {
                val intent = Intent()
                intent.putExtra(SORT_NOTE_TEXT,sortNoteName)
                setResult(RESULT_CODE,intent)
                finish()
            }

        }

        var adapter = SortNoteAdapter(this,list,onClickListener)
        binding.sortNoteRecycleview.adapter = adapter
        binding.sortNoteRecycleview.layoutManager = GridLayoutManager(this,1)




        binding.addNoteSure.setOnClickListener {
            val intent = Intent(this,AddSortNoteActivity::class.java)
            startActivity(intent)
        }

        setContentView(binding.root)
    }
}