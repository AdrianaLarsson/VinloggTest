package com.example.testingkoltincode.Fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.android.volley.toolbox.Volley
import com.example.testingkoltincode.ModelClasses.*


import com.example.testingkoltincode.R

/**
 * A simple [Fragment] subclass.
 */
class SecondFragment : Fragment(),main {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        var view = inflater.inflate(R.layout.fragment_second, container, false)



        jag(view)


        return view


    }

    fun jag(view: View) {

        var url = URL().BASEURL + URL().metadata + URL().grapesUrl

        var queue = Volley.newRequestQueue(this.context?.applicationContext)
        getApi(url, queue, view)


    }

    fun getGrapes(view: View, grapeList: List<GetWineGrapesClass>, grapes: (List<GetWineGrapesClass>) -> List<GetWineGrapesClass>
    ) {

        var result = grapes(grapeList)


        Log.w("grapesList", "grapesList" + result)

        var arrayOfTrains = result


        var arrays = ArrayList<String>()
        arrays.add(0, "Välj station")
        for (t in arrayOfTrains) {

            arrays.add(t.grapeName.toString())


        }

        Log.w("GetGrapes","arrays" + arrays)


        var spinnnerTrains = view.rootView?.findViewById<Spinner>(R.id.spinner)


            spinnnerTrains?.adapter=
                ArrayAdapter<String>(
                    view.context,
                    R.layout.spinner_layout,
                    R.id.spinnertextview,
                    arrays
                )

    }
}





/*
    class Wine(wineList: List<GetWineClass>, view: View): GetWineClass(wineList){
        init {
            Log.w("secondfragment", "trainList"  + wineList)

            var arrayOfTrains = wineList


            var arrays = ArrayList<String>()
            arrays.add(0, "Välj station")
            for (t in arrayOfTrains){

                arrays.add(t.wineName.toString())

            }


         *//*   var view: View? = null

            var v = view?.rootView*//*
            var spinnnerTrains = view.rootView?.findViewById<Spinner>(R.id.spinner)


            if (spinnnerTrains != null){

                spinnnerTrains.adapter=
                    ArrayAdapter<String>(
                        view.context,
                        R.layout.spinner_layout,
                        R.id.spinnertextview,
                        arrays
                    )
                }

            }
        }*/



