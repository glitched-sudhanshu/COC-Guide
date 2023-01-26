package com.example.cocguide.model.network

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {

    companion object {
        fun <T> success(data: T?) = Resource(Status.SUCCESS, data, null)

        fun <T> error(message: String, data: T?) = Resource(Status.ERROR, data, message)

        fun <T> loading(data: T?) = Resource(Status.LOADING, data, null)
    }
}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}

//sealed class Resource<out R>
//{
//    data class Success<out R>(val result : R) : Resource<R>()
//    data class Failure(val exception : Exception) : Resource<Nothing>()
//    object Loading : Resource<Nothing>()
//}