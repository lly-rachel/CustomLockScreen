package com.example.customlockscreen.Fragment

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.PopupMenu
import androidx.annotation.MenuRes
import androidx.annotation.RequiresApi
import com.example.customlockscreen.R
import com.example.customlockscreen.activity.BackupDataActivity
import com.example.customlockscreen.activity.TimeRemindActivity
import com.example.customlockscreen.databinding.FragmentSettingBinding


class SettingFragment : Fragment() {

    private lateinit var binding:FragmentSettingBinding



    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentSettingBinding.inflate(layoutInflater)
        
        binding.settingSortLayout.setOnClickListener {
            showMenu(it,R.menu.fragment_setting_sort_style_menu)
        }
        
        binding.settingClockLayout.setOnClickListener {
            val intent = Intent(context,TimeRemindActivity::class.java)
            startActivity(intent)
        }
        
        binding.settingBackupDataLayout.setOnClickListener {
            val intent = Intent(context,BackupDataActivity::class.java)
            startActivity(intent)
        }
        
    }





    @RequiresApi(Build.VERSION_CODES.M)
    private fun showMenu(v:View, @MenuRes menuRes: Int) {
        val popup = PopupMenu(context!!,v)
        popup.menuInflater.inflate(menuRes,popup.menu)
        popup.gravity = Gravity.RIGHT

        popup.setOnMenuItemClickListener (object :PopupMenu.OnMenuItemClickListener{
            override fun onMenuItemClick(menuItem: MenuItem?): Boolean {
                var sortStyle = "按事件时间"
                when(menuItem?.itemId){
                    R.id.sort_by_add_time->{
                        sortStyle = "按添加时间"
                    }


                    R.id.sort_by_event_time->{
                        sortStyle =  "按事件时间"

                    }


                }

                binding.sortStyle.text = sortStyle
                popup.dismiss()

                return true
            }


        })


        popup.show()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return binding.root
    }


}


