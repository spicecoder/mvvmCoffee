package io.pronab.mvvmscratch.ui.business


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import io.pronab.mvvmscratch.R
import io.pronab.mvvmscratch.model.Businesses


class BusinessListAdapter(
    var viewModel: BusinessListViewModel

) : RecyclerView.Adapter<BusinessListAdapter.ViewHolder>() {
    private var businessList = viewModel.businessList

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BusinessListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.a_business, parent, false);
        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: BusinessListAdapter.ViewHolder, position: Int) {
        holder.busName.text = businessList?.businesses?.get(position)?.name ?: ""
        val address: String = businessList?.businesses?.get(position)?.location?.address1
            ?: " + businessList?.businesses?.get(position)?.location?.address2?:"+ businessList?.businesses?.get(position)?.location?.address3 ?: " "
        holder.busAddr1.text = address
        holder.busRevs.text = businessList?.businesses?.get(position)?.review_count ?: ""
    }

    override fun getItemCount(): Int {
        return businessList?.businesses?.size ?: 0
    }


    class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        var busName = mView.findViewById<TextView>(R.id.abusiness)
        var busAddr1 = mView.findViewById<TextView>(R.id.abusiness_address_1)
        var busRevs = mView.findViewById<TextView>(R.id.abusiness_review_count)

    }

    fun setAdapterForChange(context: Context) {

        viewModel.observedlist.observe(context as LifecycleOwner, Observer<Businesses> {
            businessList = viewModel.businessList
            notifyDataSetChanged()
        })


    }


}



