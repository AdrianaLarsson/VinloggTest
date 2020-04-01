package com.example.testingkoltincode.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.android.volley.toolbox.Volley
import com.example.testingkoltincode.Fragments.FirstFragment
import com.example.testingkoltincode.Fragments.SecondFragment
import com.example.testingkoltincode.Fragments.ThirdFragment

import com.example.testingkoltincode.R
import com.example.testingkoltincode.ModelClasses.main
import com.google.android.material.bottomnavigation.BottomNavigationView

//var result : List<TestTydal>? = null
class MainActivity : AppCompatActivity(), main {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)







        onNavigationBarBottom()


    }






    fun onNavigationBarBottom(){


        var bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){


                R.id.list ->{
                    println("List")
                    // Toast.makeText(this, "List", Toast.LENGTH_SHORT).show()
                    replaceFagment(FirstFragment())




                    return@setOnNavigationItemSelectedListener true
                }
                R.id.vine ->{
                    println("Add vine")
                    // Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show()
                    replaceFagment(SecondFragment())

                    return@setOnNavigationItemSelectedListener true
                }
                R.id.settings ->{
                    println("Setting")
                    // Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                    replaceFagment(ThirdFragment())
                    return@setOnNavigationItemSelectedListener true

                }
            }
            false
        }

        replaceFagment(FirstFragment())


    }






    fun replaceFagment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }






}








