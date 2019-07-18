package com.dome.mvp.Page1


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.dome.mvp.R
import com.dome.mvp.RecycleviewAdapter.RecycleViewPage1Adapter
import com.example.promptnow.testkotlin.DataModel
import kotlinx.android.synthetic.main.fragment_page1.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Page1Fragment : Fragment(), Page1Interface.View {

    private var presenter: Page1Interface.Presenter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page1, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        presenter = Page1Presenter(this)
        presenter?.callWebService()


    }

    @SuppressLint("WrongConstant")
    override fun initRecycleview(response: DataModel) {
        progressBar?.visibility = View.GONE
     //   recycleView?.visibility = View.VISIBLE
        tvFails?.visibility = View.GONE
        swipe_container?.isRefreshing = false
        recycleView?.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        val adapter = RecycleViewPage1Adapter(response, context!!)
        recycleView?.adapter = adapter
        adapter.setOnItemClickListener(object : RecycleViewPage1Adapter.OnItemClickListener {
            override fun onClick(text: String) {
                Toast.makeText(context, text, Toast.LENGTH_LONG).show()
            }

        })
    }

    override fun serviceError() {
        progressBar?.visibility = View.GONE
        swipe_container?.visibility = View.GONE
        tvFails?.visibility = View.VISIBLE

    }

    private fun init(){
        swipe_container?.setOnRefreshListener {
           // progressBar.visibility = View.VISIBLE
            //recycleView?.visibility = View.GONE
            tvFails?.visibility = View.GONE
            presenter?.callWebService()
        }
    }
}
