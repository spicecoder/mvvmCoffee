package io.pronab.mvvmscratch.ui.business

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.pronab.mvvmscratch.base.BaseViewModel
import io.pronab.mvvmscratch.model.Businesses
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
class BusinessListViewModel:BaseViewModel() {

    @Inject
    lateinit var businessListCaller: Call<Businesses>
    var businessList : Businesses? = null
    var observedlist : MutableLiveData<Businesses> = MutableLiveData()
    init {
      getAllBusiness()
    }


    fun getAllBusiness() {
        businessListCaller.enqueue(object : Callback<Businesses> {
            override fun onResponse(call: Call<Businesses>, response: Response<Businesses>) {
                 businessList  =  response.body();

                observedlist.value = businessList
                Log.v("Tinker_success", ":" +response.body() )
            }

            override fun onFailure(call: Call<Businesses>, t: Throwable) {
                Log.v("Tinker_fail", " "+t.localizedMessage)
            }
        })
    }


    // ...

    override fun onCleared() {
        super.onCleared()

    }
}