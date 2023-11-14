package com.example.tugaspertemuan11_api

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.pertemuan11_retrofitapp.model.Users
import com.example.pertemuan11_retrofitapp.network.ApiClient
import com.example.tugaspertemuan11_api.databinding.ActivityMainBinding
import com.example.tugaspertemuan11_api.model.Data
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val client = ApiClient.getInstance()
        val response = client.getAllUser()
        response.enqueue(object : Callback<List<Data>> {
            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {
                val namaUsers = ArrayList<String>()
                val listUniv = response.body()
                Log.d("AA", listUniv.toString())
                if (listUniv != null) {
                    for (i in listUniv) {
                        namaUsers.add(i.universityName)

                    }
                }

                val listAdapter = ArrayAdapter(
                    this@MainActivity,
                    R.layout.simple_list_item_1,
                    namaUsers
                )

                binding.lsView.adapter = listAdapter
            }

            override fun onFailure(call: Call<List<Data>>, t: Throwable) {
                Toast.makeText(this@MainActivity,t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
}