package io.pronab.mvvmscratch.model


data class Business(val id: String, val name: String,val location: Location  , val review_count: String) {



}

data class Businesses (val businesses :List<Business>)