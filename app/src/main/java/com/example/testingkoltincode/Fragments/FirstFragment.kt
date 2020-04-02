package com.example.testingkoltincode.Fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.Volley
import com.example.testingkoltincode.ModelClasses.*
import com.example.testingkoltincode.R



/**
 * A simple [Fragment] subclass.
 */



var list : List<TestTydal>? = null
class FirstFragment : Fragment(), main {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_first, container, false)


              jag(view)


        var urlGrapes = URL().BASEURL + URL().metadata + URL().grapesUrl
        var queueG = Volley.newRequestQueue(this.context?.applicationContext)
        getApi(urlGrapes,queueG,view)


        return view

    }

    fun jag(view: View){

        var url = URL().BASEURL + URL().allwineList + URL().userId
        var queue = Volley.newRequestQueue(this.context?.applicationContext)
        getApi(url, queue, view)

    }

    fun makeMyHero(view: View, wineList: List<GetWineClass>, make: (List<GetWineClass>) -> List<GetWineClass>){

        var result = make(wineList)
        Log.w("FirstFragment", "Resultlambda " + result)

        var recyclerviewVineList = view?.rootView.findViewById(R.id.recyclerviewId) as? RecyclerView
        recyclerviewVineList?.layoutManager = LinearLayoutManager(view?.context?.applicationContext)
        recyclerviewVineList?.adapter = TrainsAdapter(view?.context, result)

    }

     fun getGrapes(view: View, grapeList: List<GetWineGrapesClass>, grapes: (List<GetWineGrapesClass>) -> List<GetWineGrapesClass>){

         var result = grapes(grapeList)

         Log.w("FirstFragment", "grapesList" + result)

         var arrayOfTrains = result


         var arrays = ArrayList<String>()
         arrays.add(0, "Välj station")
         for (t in arrayOfTrains) {

             arrays.add(t.grapeName.toString())


         }

         var spinnnerTrains = view.rootView?.findViewById<Spinner>(R.id.spinnerG)


         spinnnerTrains?.adapter=
             ArrayAdapter<String>(
                 view.context,
                 R.layout.spinner_layout,
                 R.id.spinnertextview,
                 arrays
             )


    }




    class Wine(wineList: List<GetWineClass>,view: View): GetWineClass(wineList){
        init {


          ///var v = view?.rootView

            Log.w("winelisst", "winelisst"  + wineList)





        }

    }

}
