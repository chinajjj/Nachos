package io.navendra.nachos.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import io.navendra.nachos.R
import io.navendra.nachos.viewmodels.MultiFoodController
import io.navendra.nachos.viewmodels.SingleFoodController

class MainActivity : AppCompatActivity() {

    private val recyclerView : RecyclerView by lazy { findViewById<RecyclerView>(R.id.recycler_view) }
    private val singleFoodController : SingleFoodController by lazy { SingleFoodController() }
    private val multiFoodController : MultiFoodController by lazy { MultiFoodController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycler()
    }

    private fun initRecycler(){
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.apply {
            layoutManager = linearLayoutManager
            setHasFixedSize(true)
//            adapter = singleFoodController.adapter
            adapter = multiFoodController.adapter
        }

        //This statement builds model and add it to the recycler view
//        singleFoodController.requestModelBuild()
        multiFoodController.requestModelBuild()
    }
}
