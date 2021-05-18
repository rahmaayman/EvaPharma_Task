package com.evaph.network.network

import android.util.Log
import com.evaph.network.model.ErrorModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MultipartBody
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import retrofit2.Retrofit
import java.io.IOException
import java.util.*
import javax.inject.Inject

class NetworkManager @Inject constructor() {

    @Inject
    lateinit var retrofit: Retrofit
    val TAG = "main"

    private val headers: MutableMap<String, String> =
        object : HashMap<String, String>() {
            init {
                put("Accept", "application/json")
            }
        }

    private fun updateHeaders() {

    }

    suspend fun <T> getRequest(
        api: String,
        param: Map<String, Any> = HashMap(),
        parseClass: Class<T>,
    ): T {
        updateHeaders()
        return withContext(Dispatchers.IO) {
            parseResponse(
                retrofit.create(
                    APIService::class.java
                ).getRequest(api, headers, param), parseClass
            )
        }
    }

    suspend fun <T> postRequest(
        api: String,
        body: Map<String, Any> = HashMap(),
        parseClass: Class<T>,
    ): T {
        updateHeaders()
        return withContext(Dispatchers.IO) {
            parseResponse(
                retrofit.create(
                    APIService::class.java
                ).postRequest(api, headers, body), parseClass
            )
        }
    }

    suspend fun <T> putRequest(
        api: String,
        body: Map<String, Any> = HashMap(),
        parseClass: Class<T>,
    ): T {
        updateHeaders()
        return withContext(Dispatchers.IO) {
            parseResponse(
                retrofit.create(
                    APIService::class.java
                ).putRequest(api, headers, body), parseClass
            )
        }
    }

    suspend fun <T> deleteRequest(
        api: String,
        param: Map<String, Any> = HashMap(),
        parseClass: Class<T>,
    ): T {
        updateHeaders()
        return withContext(Dispatchers.IO) {
            parseResponse(
                retrofit.create(
                    APIService::class.java
                ).deleteRequest(api, headers, param), parseClass
            )
        }
    }

    suspend fun <T> postMultiPart(
        api: String,
        body: Map<String, Any> = HashMap(),
        file: MultipartBody.Part,
        parseClass: Class<T>,
    ): T {
        updateHeaders()
        return withContext(Dispatchers.IO) {
            parseResponse(
                retrofit.create(
                    APIService::class.java
                ).postMultiPart(api, headers, body, file), parseClass
            )
        }
    }

    @Throws(
        ErrorModel::class,
        IOException::class,
        InstantiationException::class,
        IllegalAccessException::class,
        JSONException::class
    )
    private fun <T> parseResponse(
        response: Response<JsonElement>,
        parseClass: Class<T>,
    ): T {
        return try {
            val gson = GsonBuilder().serializeNulls().create()

            if (!response.isSuccessful) {
                var errorModel = ErrorModel("")
                if (response.errorBody() != null) {
                    try {
                        val obj = JSONObject(response.errorBody()!!.string())
                        try {
                            val temp = Gson().fromJson(obj.toString(), ErrorModel::class.java)
                            temp?.let { errorModel = it }
                        } catch (e: IllegalStateException) {
                        }
                    } catch (ex: JSONException) {
                    }
                }
                errorModel.code = response.code()
                errorModel.name = response.message()
                throw errorModel
            } else {
                if (response.body()!!.asJsonObject["Data"].isJsonArray)
                    gson.fromJson(response.body()!!.asJsonObject, parseClass)
                else if(!response.body()!!.asJsonObject["Data"].isJsonArray)
                    gson.fromJson(response.body()!!.asJsonObject, parseClass)

                else if (response.body()!!.asJsonObject["Data"].isJsonArray)
                    gson.fromJson(response.body()!!.asJsonObject, parseClass)
                else
                    gson.fromJson(response.body()!!.asJsonObject["Data"], parseClass)
            }
        } catch (e: Exception) {
            throw e
        }
    }
}