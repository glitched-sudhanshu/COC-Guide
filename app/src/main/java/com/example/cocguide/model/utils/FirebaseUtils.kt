package com.example.cocguide.model.utils

import com.google.android.gms.tasks.Task
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resumeWithException

//the firebase 'signInWithEmailAndPassword' function returns a TASK. due to which we will have to use a callback function. To avoid using call back function again and again we prepared this generic task extension function.
suspend fun <T> Task<T>.await() : T {
    return suspendCancellableCoroutine { cont -> addOnCompleteListener {
        if(it.exception != null){
            cont.resumeWithException(it.exception!!)
        }
        else {
            cont.resume(it.result, null)
        }
    } }
}