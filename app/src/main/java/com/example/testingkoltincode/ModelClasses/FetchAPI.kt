package com.example.testingkoltincode.ModelClasses

import android.content.Context
import android.util.Log
import android.view.View
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

import com.example.testingkoltincode.Fragments.FirstFragment
import com.example.testingkoltincode.Fragments.SecondFragment
import com.example.testingkoltincode.Fragments.ThirdFragment
import com.google.gson.GsonBuilder


interface main {





    fun getApi(url: String, queue: RequestQueue, view: View) {



      val searchRequestVine = object : StringRequest(Method.GET, url,
          Response.Listener { response ->

              val resultRes = response.toString()


              var gson = GsonBuilder().create()



              val wineList: List<GetWineClass> =
                  gson.fromJson(resultRes, Array<GetWineClass>::class.java).toList()


              val grapeList : List<GetWineGrapesClass> = gson.fromJson(resultRes,Array<GetWineGrapesClass>::class.java).toList()


             // var wineFirst = FirstFragment.Wine(wineList,view)


             // var wineSecond = SecondFragment.Wine(wineList,view)

              var wineThird = ThirdFragment.Wine(wineList,view)


              val make : (List<GetWineClass>) -> List<GetWineClass> = { wineList ->  wineList }
              val grapes : (List<GetWineGrapesClass>) -> List<GetWineGrapesClass> = { grapesList ->  grapesList }
              FirstFragment().makeMyHero(view,wineList, make)
              SecondFragment().getGrapes(view,grapeList, grapes)
              FirstFragment().getGrapes(view,grapeList,grapes)





              Log.w("TYDALCLASS", " WINELIST  ======>>>>>> " + wineList)



          }, Response.ErrorListener { error ->
              Log.w("Error", "Error Get Wines" + error.toString())

          }) {


          override fun getParams(): MutableMap<String, String> {
              val params: MutableMap<String, String> = HashMap()
              //   params["startsWith"] = "wine"
              return params
          }

      }
      queue.add(searchRequestVine)





    }


}








class URL(){

    var allwineList: String ="allwinelist?"
    var userId : String= "userid=FsOzZAQB95aLv8uqaTtIzmvxMKG3"
    var BASEURL: String = "http://54.72.51.80:5000/api/"
    var metadata : String = "metadata"
    var grapesUrl :String ="/grapes"
    var shelvesUrl : String = "/shelves"



}
















/*


interface apiFetching {

fun onTouch(url: String, queue: RequestQueue,view: View){


}

}

 class FetchAPI (): apiFetching{


    // var adddddee = "Addroama"
//     var marie = "Mariesssss"

    var name : List<TestTydal>? = null


    override fun onTouch(url: String, queue: RequestQueue,view: View) {



        val searchRequestVine = object : StringRequest(Method.GET, url,
            Response.Listener { response ->

                val resultRes = response.toString()


                //    Log.w("Result", "== " + resultRes)







                var gson = GsonBuilder().create()



                val wineList: List<TestTydal> =
                    gson.fromJson(resultRes, Array<TestTydal>::class.java).toList()

                name = wineList







                //  testwineListGlobal = wineList

                //showWineNameAutoComplete(view)


                // setUpAdapterRecyclerview(view)

                Log.w("TYDALCLASS", " WINELIST  ======>>>>>> " + name)



            }, Response.ErrorListener { error ->
                Log.w("Error", "Error Get Wines" + error.toString())

            }) {


            override fun getParams(): MutableMap<String, String> {
                val params: MutableMap<String, String> = HashMap()
                //   params["startsWith"] = "wine"
                return params
            }

        }
        queue.add(searchRequestVine)


    }
*/


/*     fun copyFetchApi(api: FetchAPI): FetchAPI{

         val result = FetchAPI()
         result.adddddee

         Log.w("copyFetchApi" ," "+  result.adddddee)
         return  FetchAPI()

     }*/

/* inner class getVaribales(){

     var hej = TestTydal(name.toString())





     fun take(): TestTydal{

         Log.w("NAMENAME", "fbjhdf" + hej)

         return hej
     }

 }*/



/*



fun getWines(view: View, context: Context?) {


    var queue = Volley.newRequestQueue(context)


    val url = "http://54.72.51.80:5000/api/allwinelist?userid=6"


    val searchRequestVine = object : StringRequest(Method.GET, url,
        com.android.volley.Response.Listener { response ->

            val result = response.toString()

            Log.w("Result", "== Null" + result)


            if (result == "[]") {
                Log.w("Result", "== Null" + result + "new winename " + postWineName)

            } else {

                var gson = GsonBuilder().create()

                val wineList: List<GetUserWineListClass> =
                    gson.fromJson(result, Array<GetUserWineListClass>::class.java).toList()


                testwineListGlobal = wineList


                //  VineListFragment().setUpAdapterRecyclerview(view)


                Log.w("GETWINENAME", " WINELIST  ======>>>>>> " + wineList)
            }


        }, com.android.volley.Response.ErrorListener { error ->
            Log.w("Error", "Error Get Wines" + error.toString())

        }) {
        override fun getBody(): ByteArray {
            return super.getBody()
        }

        override fun getBodyContentType(): String {
            return super.getBodyContentType()
        }

        override fun getParams(): MutableMap<String, String> {
            val params: MutableMap<String, String> = java.util.HashMap()
            //   params["startsWith"] = "wine"
            return params
        }

    }
    queue.add(searchRequestVine)


}

*/





/*

fun getCountries(url: String, queue: RequestQueue) {

    val searchRequestVine = object : StringRequest(Method.GET, url,
        com.android.volley.Response.Listener { response ->

            val result = response.toString()


            var gson = GsonBuilder().create()

            val countriesList: List<GetCountriesClass> =
                gson.fromJson(result, Array<GetCountriesClass>::class.java).toList()


            // getCountriesGlobal = countriesList


            Log.w("GETCOUNTRIES", " COUNTRIESLIST  ======>>>>>> " + countriesList)


        }, com.android.volley.Response.ErrorListener { error ->
            Log.w(
                "Error",
                "Error Get COUNTRIES " + error.toString() + error.printStackTrace() + error.cause + error.cause
            )

        }) {
        override fun getBody(): ByteArray {
            return super.getBody()
        }

        override fun getBodyContentType(): String {
            return super.getBodyContentType()
        }

        override fun getParams(): MutableMap<String, String> {
            val params: MutableMap<String, String> = java.util.HashMap()

            return params
        }

    }
    queue.add(searchRequestVine)

}*/












/*
fun getGetWines(view: View, context: Context) {


    if (context != null) {


        var queue = Volley.newRequestQueue(context)


        val url = "http://54.72.51.80:5000/api/allwinelist?userid=FsOzZAQB95aLv8uqaTtIzmvxMKG3"


        val searchRequestVine = object : StringRequest(
            Method.GET, url,
            com.android.volley.Response.Listener { response ->

                val result = response.toString()

                Log.w("Result", "== Null" + result)


                if (result == "[]") {


                } else {

                    var gson = GsonBuilder().create()

                    val wineList: List<GetUserWineListClass> =
                        gson.fromJson(result, Array<GetUserWineListClass>::class.java).toList()

                    //  wineListGlobal = wineList


                    Log.w("GETWINENAME", " WINELIST  ======>>>>>> " + wineList)


                }


            }, com.android.volley.Response.ErrorListener { error ->
                Log.w("Error", "Error Get Wines" + error.toString())

            }) {
            override fun getBody(): ByteArray {
                return super.getBody()
            }

            override fun getBodyContentType(): String {
                return super.getBodyContentType()
            }

            override fun getParams(): MutableMap<String, String> {
                val params: MutableMap<String, String> = java.util.HashMap()
                //   params["startsWith"] = "wine"
                return params
            }

            override fun getHeaders(): MutableMap<String, String> {
                val headers = java.util.HashMap<String, String>()
                headers.put("Content-Type", "application/json");

                // Log.w("Token", "Token string => " + stringToken)
                //var testToken = "eyJhbGciOiJSUzI1NiIsImtpZCI6IjFmODhiODE0MjljYzQ1MWEzMzVjMmY1Y2RiM2RmYjM0ZWIzYmJjN2YiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL3NlY3VyZXRva2VuLmdvb2dsZS5jb20vZW50ZWNvbi0yYTBlMyIsImF1ZCI6ImVudGVjb24tMmEwZTMiLCJhdXRoX3RpbWUiOjE1ODUzMTMyOTEsInVzZXJfaWQiOiJBdjRpdk02TE1sUlZ6N1c1WWJnaWxCWFVLNWQyIiwic3ViIjoiQXY0aXZNNkxNbFJWejdXNVliZ2lsQlhVSzVkMiIsImlhdCI6MTU4NTMxMzI5MSwiZXhwIjoxNTg1MzE2ODkxLCJlbWFpbCI6Im15Y29vbGVtYWlsbmFtZUBibGFibGEuY29tIiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJmaXJlYmFzZSI6eyJpZGVudGl0aWVzIjp7ImVtYWlsIjpbIm15Y29vbGVtYWlsbmFtZUBibGFibGEuY29tIl19LCJzaWduX2luX3Byb3ZpZGVyIjoiY3VzdG9tIn19.JguoAUsUsFWx-NPepbQ4jRYwX_Vtte2t4qiKwzhWbFmr5ioogy_3tbXyesDKuKvA5mioU3f2d6oxFMP5STEwqXaQ_enl5NdqrdjbMwnlVS_B8GZ_l6H2qAjJE-kJkEUt2-3DcFl27jbklIqbgJ8SJh56RwsEn9ARCxifRlJalNVd4kudX_QXX6X2ZutXru-of1-4l4w9Tbd5CTQ3994gc9ksey35T2BYT92Aoe74Wk0uXFE9rmSIq0E9SYzWn1FeZkxcGwz0BoGl8qJW465jAOeFIyfbDgzHSdJEoPMgW8-7bGjAjbLkbeyDtsjWJ-tokO-lFs0z3uRCpp2A3f5gNg"
                // headers["Authorization"] = "Bearer ${testToken}"
                return headers
            }

        }


        queue.add(searchRequestVine)


    }


}*/
