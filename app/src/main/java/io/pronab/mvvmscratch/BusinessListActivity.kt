package io.pronab.mvvmscratch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.pronab.mvvmscratch.ui.business.BusinessListAdapter
import io.pronab.mvvmscratch.ui.business.BusinessListViewModel


class BusinessListActivity : AppCompatActivity() {
    private lateinit var viewModel: BusinessListViewModel
    var adapter: BusinessListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.business_list)
        viewModel = ViewModelProviders.of(this).get(BusinessListViewModel::class.java)

        adapter = BusinessListAdapter(viewModel);

        // set up the RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.allBusiness)
        val layoutManager = LinearLayoutManager(this)

        recyclerView.setLayoutManager(layoutManager as RecyclerView.LayoutManager?)
        recyclerView?.setAdapter(adapter)
        recyclerView.setHasFixedSize(false)
        adapter!!.setAdapterForChange(this)


    }

    override fun onResume() {
        super.onResume();


    }

}
