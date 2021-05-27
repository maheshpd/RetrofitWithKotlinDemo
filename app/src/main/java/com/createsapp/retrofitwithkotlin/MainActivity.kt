package com.createsapp.retrofitwithkotlin

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.createsapp.retrofitwithkotlin.response.DataResponse
import com.createsapp.retrofitwithkotlin.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var progressDialog: ProgressDialog
    var dataList = ArrayList<DataResponse>()
    lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)

        //setting up the adapter
        adapter = DataAdapter(dataList, this)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Loading")
        progressDialog.setCanceledOnTouchOutside(false)
        progressDialog.show()

        getData()

    }

    private fun getData() {
        val call: Call<List<DataResponse>> = ApiClient.getClient.getPhotos()
        call.enqueue(object : Callback<List<DataResponse>> {
            override fun onResponse(
                call: Call<List<DataResponse>>,
                response: Response<List<DataResponse>>
            ) {
                progressDialog.dismiss()
                dataList.addAll(response!!.body()!!)
                adapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<DataResponse>>, t: Throwable) {
                progressDialog.dismiss()
            }

        })
    }
}