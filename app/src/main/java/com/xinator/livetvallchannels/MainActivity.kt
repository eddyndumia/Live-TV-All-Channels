package com.xinator.livetvallchannels


import android.app.Activity
import android.content.ContentValues.TAG
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.xinator.livetvallchannels.adapters.AlphaAdapter
import com.xinator.livetvallchannels.model.AlphaChar
import com.xinator.livetvallchannels.repository.Repository



class MainActivity() : AppCompatActivity() {
    private var RecyclerView: RecyclerView? = null
    private var GridLayoutManager: GridLayoutManager? = null
    private var arrayLists: ArrayList<AlphaChar>? = null
    private var AlphaAdapter: AlphaAdapter? = null
    private lateinit var viewModel: MainViewModel
    private  var rewardedAd: RewardedAd? = null
    private  var AD_UNIT_ID:String = "ca-app-pub-3940256099942544/5224354917"
    override fun onCreate(savedInstanceState: Bundle?) {
        rewardedAd = RewardedAd(this@MainActivity,AD_UNIT_ID)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //rewarded ads
        MobileAds.initialize(this)

        //setting toolbar
        setSupportActionBar(findViewById(R.id.toolbar))
        //home navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(false)


        RecyclerView = findViewById(R.id.myrecyclerview)
        GridLayoutManager =
            GridLayoutManager(applicationContext, 3, LinearLayoutManager.VERTICAL, false)
        RecyclerView?.layoutManager = GridLayoutManager
        arrayLists = ArrayList()
        arrayLists = setDataInList()
        AlphaAdapter = AlphaAdapter(applicationContext, arrayLists!!)
        RecyclerView?.adapter = AlphaAdapter!!

        //Retrofit logics

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory)[MainViewModel::class.java]
        viewModel.getChannel()
        viewModel.myResponse.observe(this, { response->
            android.util.Log.d("response",response.body)
        })


    }


    private fun setDataInList(): ArrayList<AlphaChar> {
        val items: ArrayList<AlphaChar> = ArrayList()
        items.add(AlphaChar(R.drawable.cn, "Cartoon Network"))
        items.add(AlphaChar(R.drawable.innoro, "Inooro TV"))
        items.add(AlphaChar(R.drawable.discovery, "Discovery Channel"))
        items.add(AlphaChar(R.drawable.natgeo, "Nat Geo Wild"))
        items.add(AlphaChar(R.drawable.citizen, "Citizen"))
        items.add(AlphaChar(R.drawable.mtvbase, "Mtv Base"))
        items.add(AlphaChar(R.drawable.disney, "Disney Channel"))
        items.add(AlphaChar(R.drawable.nick, "Nickelodeon"))
        items.add(AlphaChar(R.drawable.africamagic, "Africa Magic"))
        items.add(AlphaChar(R.drawable.blitz, "Supersport Blitz"))
        items.add(AlphaChar(R.drawable.s7, "Supersport 7 HD"))
        items.add(AlphaChar(R.drawable.s2, "Supersport 2"))
        items.add(AlphaChar(R.drawable.cn, "Cartoon Network"))
        items.add(AlphaChar(R.drawable.cn, "Cartoon Network"))
        items.add(AlphaChar(R.drawable.cn, "Cartoon Network"))
        items.add(AlphaChar(R.drawable.cn, "Cartoon Network"))
        items.add(AlphaChar(R.drawable.cn, "Cartoon Network"))
        items.add(AlphaChar(R.drawable.cn, "Cartoon Network"))
        items.add(AlphaChar(R.drawable.cn, "Cartoon Network"))
        return items
    }
    //setting menu in action bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // actions on click menu items
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.profile -> {
            // User chose the "Print" item
            Toast.makeText(this, "Profile", Toast.LENGTH_LONG).show()
            true
        }
        android.R.id.home -> {
            Toast.makeText(this, "Home action", Toast.LENGTH_LONG).show()
            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }
}