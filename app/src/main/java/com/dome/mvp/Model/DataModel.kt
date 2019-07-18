package com.example.promptnow.testkotlin

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by PromptNow on 1/9/2019.
 */
class DataModel {
    @SerializedName("status")
    var status: String? = null

    @SerializedName("count")
    var count: Int = 0

    @SerializedName("categories")
    var categories: ArrayList<Category>? = null

}