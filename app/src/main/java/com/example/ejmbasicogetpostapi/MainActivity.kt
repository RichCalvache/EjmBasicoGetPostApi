package com.example.ejmbasicogetpostapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejmbasicogetpostapi.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    private lateinit var adapter: InfoAPIAdapter
    private val infoAPI = mutableListOf<PostModelResponse>()

    val urlBase = "https://jsonplaceholder.typicode.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()

        val retrofit = Retrofit.Builder()
            .baseUrl(urlBase)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        //obtener valores basico
        /*val service = retrofit.create(PostAPIService::class.java)
        lifecycleScope.launch {
            val response = service.getUserPost()
            response.forEach {
                println(it)//muestra todos los valores en consola
            }

            runOnUiThread {
                val textView = findViewById<TextView>(R.id.textviewAPIGet)
                textView.text = response.first().title//muestra el primer titulo
            }
        }*/


        //obtener valores con parametro
        val service = retrofit.create(PostAPIService::class.java)
        lifecycleScope.launch {
            val response = service.getUserPostById("99")

            if(response.isSuccessful){
                runOnUiThread {
                    //val textView = findViewById<TextView>(R.id.textviewAPIGet) sin viewbinding
                    //textView.text = "${response.body()?.id} = ${response.body()?.title}" //muestra valores dependiendo el id que asignemos

                    //con viewbinding

                    val textViewGET = binding.textviewAPIGet

                    textViewGET.text = "${response.body()?.id} = ${response.body()?.title}"
                }
            }
            else{ //error
                Log.e("Error Retrofit!!","${response.code()} - ${response.message()}")

            }


        }


        //Ejemplo POST
        val service1p = retrofit.create(PostAPIService::class.java)//service1p otro nombre
        lifecycleScope.launch {

            val objetoRequest = PostModelRequest(
                title = "Nuevo titulo",
                userId = 999,
                body = "Richard es el mejor programador del mundo entero"
            )

            val response = service1p.insertarPublicacion(objetoRequest)

            if(response.isSuccessful){
                runOnUiThread {
                    binding.textviewAPIPost.text = "${response.body()?.id} = ${response.body()?.body}" //muestra valores dependiendo el id que asignemos
                }
            }
            else{//error
                Log.e("Error Retrofit!!","${response.code()} - ${response.message()}")

            }


        }


        //LLENAR RECYCLERVIEW
    binding.buttonGetAll.setOnClickListener {
        //obtener valores basico
        val service = retrofit.create(PostAPIService::class.java)
        lifecycleScope.launch {
            val response = service.getAllUserPost()

            //val call = retrofit.create(PostAPIService::class.java).getAllUserPost()
            //val info = call.addAll(PostModelResponse)


            response.forEach {
                println(it)//muestra todos los valores en consola
            }

            runOnUiThread {
                infoAPI.clear()
                infoAPI.addAll(response)
                adapter.notifyDataSetChanged()
            }
        }
    }


    }

    private fun initRecyclerView() {
        adapter = InfoAPIAdapter(infoAPI)
        binding.recyclerviewAPI.layoutManager = LinearLayoutManager(this)//REcyclerview vertical normal
        //binding.recyclerviewDogs.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)//recyclerview horizontal
        binding.recyclerviewAPI.adapter = adapter

    }

}