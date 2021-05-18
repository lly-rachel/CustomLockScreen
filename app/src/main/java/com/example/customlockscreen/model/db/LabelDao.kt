package com.example.customlockscreen.model.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.customlockscreen.model.bean.Label

@Dao
interface LabelDao {

    @Insert
    fun insertLabel(label: Label)

    @Delete
    fun deleteLabel(label: Label)

    @Query("SELECT * FROM label_table")
    fun getAllLabels():List<Label>

    @Query("SELECT text FROM label_table")
    fun getAllLabelsName():List<String>


    @Query("SELECT * FROM label_table WHERE sortNote =:sortNoteName ")
    fun getSameSortNoteLabelList(sortNoteName:String):List<Label>

    @Query("SELECT * FROM label_table WHERE text =:text")
    fun getLabelByName(text:String):Label

}