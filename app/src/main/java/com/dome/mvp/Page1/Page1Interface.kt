package com.dome.mvp.Page1

import com.example.promptnow.testkotlin.DataModel

interface Page1Interface {
    interface View {
        fun initRecycleview(response: DataModel)

        fun serviceError()
    }

    interface Presenter {
        fun callWebService()
    }
}