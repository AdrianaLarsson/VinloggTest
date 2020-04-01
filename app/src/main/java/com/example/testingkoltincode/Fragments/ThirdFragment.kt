package com.example.testingkoltincode.Fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.android.volley.toolbox.Volley
import com.example.testingkoltincode.ModelClasses.GetWineClass
import com.example.testingkoltincode.ModelClasses.TydalClass
import com.example.testingkoltincode.ModelClasses.URL
import com.example.testingkoltincode.ModelClasses.main


import com.example.testingkoltincode.R

/**
 * A simple [Fragment] subclass.
 */
class ThirdFragment : Fragment(),main {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_third, container, false)



             jag(view)
        return view
    }


    fun jag(view: View){

        var url = URL().BASEURL + URL().allwineList + URL().userId

        var queue = Volley.newRequestQueue(this.context?.applicationContext)
        getApi(url, queue, view)

    }


    class Wine(wineList: List<GetWineClass>, view: View) : GetWineClass(wineList) {


        init {
            Log.w("trainList", "trainList" + wineList)


            var arraOflist = wineList
            var arrasy = ArrayList<String>()

            if (arraOflist != null) {

                for (t in arraOflist) {

                    arrasy.add(t.wineName.toString())
                }

            }

            var autoC = view?.rootView?.findViewById(R.id.serach) as? AutoCompleteTextView

            var adapterC =
                ArrayAdapter<String>(
                    view.context,
                    R.layout.spinner_layout,
                    R.id.spinnertextview,
                    arrasy
                )



            autoC?.setAdapter(adapterC)
        }
    }

}






/* //get data api grapes

 fun getGrapes(view: View) {
     Log.w("getGrapes", "     fun getGrapes() RUNNS")
     var responseStringGrapes: String?
     val queue = com.android.volley.toolbox.Volley.newRequestQueue(activity)
     val url = "http://54.72.51.80:5000/api/metadata/grapes"

     var stringRequest = StringRequest(
         Request.Method.GET, url,
         Response.Listener<String> { response ->

             responseStringGrapes = response.substring(0, response.length)

             var gson = GsonBuilder().create()
             val grapelist: List<GetGrapes> =
                 gson.fromJson(responseStringGrapes, Array<GetGrapes>::class.java).toList()

             Log.w("getGrapes", " GRAPELIST ======>>>>>> " + grapelist)

             listGrapesName = grapelist
             Log.w(
                 "getGrapes",
                 " GLOBAL VARIABLE listGrapesName ======>>>>>> " + listGrapesName
             )
             showGrapes(view)

         }, Response.ErrorListener {

             Log.w("EEERRROOORRR", " ======>>>>>> Grapes : It didnt work!")
         })
     queue.add(stringRequest)

 }


 //show grapes in spinnerTextviewAutocomplete
 fun showGrapes(view: View) {
     Log.w(
         "showGrapes",
         " GLOBAL VARIABLE listGrapesName ======>>>>>> " + listGrapesName
     )

     var grapesId = ArrayList<Long>()
     var grapesName = ArrayList<String>()
     var idGrapes: Long? = null


   //  testArray.add("Adriana")
    // testArray.add("Marie")
     //testArray.add("Kristoffersson")
     //testArray.add("Larsson")

     var arraOfGrapesName = listGrapesName

     if (arraOfGrapesName != null) {
         for (g in arraOfGrapesName) {


             Log.w("Id", "hgxsjhs ==>> " + g.grapeId)


             grapesId.add(g.grapeId!!)
             grapesName.add(g.grapeName.toString())


         }
     }


     Log.w("showGrapes", "ArrayNames " + grapesName)


     var autoCompleteTextGrapesname =
         view?.findViewById<AutoCompleteTextView>(R.id.autoCompleteTextViewGrapes)

     autoCompleteTextViewGrapes?.threshold = 1
     var adapterAutoComplete = activity?.let {


         ArrayAdapter<String>(
             it,
             R.layout.spinner_grapes_layout,
             R.id.textViewGrapes,
             grapesName

         )
     }

     autoCompleteTextGrapesname?.setAdapter(adapterAutoComplete)

     autoCompleteTextGrapesname.setOnItemClickListener { parent, view, position, id ->

         var userSelectedGrapeId = grapesId.get(id.toLong().toInt())
         var userSelecyedNameGrape = grapesName.get(position)
         Log.w(
             "showGrapes",
             " Id of User Selection Grape => " + userSelectedGrapeId + "|| Name of user Selection grape => " + userSelecyedNameGrape
         )
     }


 }


}*/


/*
     fun getCountriesRegionsDistrict(view: View) {




     }

    class countriesRegionsDistrict(countriesRegionsDistrictClass: List<GetCountriesRegionsDistrictClass>, view: View) :
        GetCountriesRegionsDistrictClass(countriesRegionsDistrictClass) {

        init {
            Log.w("listCountrieRegionsDis", "regions countries district" + countriesRegionsDistrictClass)

         listCountriesRegionsDistrictClass = countriesRegionsDistrictClass

        }
    }*/


/* fun countriesRegionsDistrictfunc() {
  Log.w("showCountries", " listCountriesName  ======>>>>>> " + listCountriesRegionsDistrictClass)
        var countriesName = ArrayList<String>()
        var regionsName = ArrayList<String>()
        var districtsName = ArrayList<String>()




       countriesName.add(0, "Välj land")
        regionsName.add(0, "Välj region")
        districtsName.add(0, "Välj district")


        var arrayOfCountriesname = listCountriesRegionsDistrictClass

        if (arrayOfCountriesname != null) {

            for (c in arrayOfCountriesname) {
                countriesName.add(c.countryName.toString())


                var arrayOfRegionsName = c.regions

                if (arrayOfRegionsName != null) {
                    for (r in arrayOfRegionsName) {

                        regionsName.add(r?.regionName.toString())
                        var arrayOfDistricts = r?.districts

                        if (arrayOfDistricts != null) {

                            for (d in arrayOfDistricts) {
                                districtsName.add(d?.districtName.toString())


                            }
                        }

                    }

                }
            }
        }

     Log.w("CRD", "only districts " + districtsName)
     Log.w("CRD", "only regions " + regionsName)


     globalVaribleCountries = countriesName
     globalVaribleRegions = regionsName
     globalVaribleDistricts = districtsName

     Log.w("CRD", "only Countries " + countriesName)*/
// showCountries()
// showRegions()
// showDistricts()
/*   }

fun showCountries() {
     Log.w("showCountries", "only Countries " + globalVaribleCountries)
     var userSelectionC: String? = null
     var countrySpinner = view?.findViewById<Spinner>(R.id.spinneCountries)

     countrySpinner?.adapter = activity?.let {
         globalVaribleCountries?.let { it1 ->
             ArrayAdapter<String>(
                 it,
                 R.layout.spinner_layout,
                 R.id.textViewSpinner,
                 it1
             )
         }
     }


     countrySpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
         override fun onNothingSelected(parent: AdapterView<*>?) {
             textViewSpinner.text = "Välj ett land"
         }

         override fun onItemSelected(
             parent: AdapterView<*>?,
             view: View?,
             position: Int,
             id: Long
         ) {
             userSelectionC = globalVaribleCountries?.get(position)
             Log.w("showCountries", " userSelectionC" + userSelectionC)

         }
     }
 }


 fun showRegions() {

     Log.w("showRegions", "only regions " + globalVaribleRegions)
     var userSelectionR: String? = null
     var spinnerRegions = view?.findViewById<Spinner>(R.id.regionSpinner)

     spinnerRegions?.adapter = activity?.let {
         globalVaribleRegions?.let { it1 ->
             ArrayAdapter<String>(
                 it,
                 R.layout.spinner_layout_regions,
                 R.id.textViewSpinnerRegions,
                 it1
             )
         }
     }


     spinnerRegions?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
         override fun onNothingSelected(parent: AdapterView<*>?) {
             textViewSpinner.text = "Välj ett land"
         }

         override fun onItemSelected(
             parent: AdapterView<*>?,
             view: View?,
             position: Int,
             id: Long
         ) {


             userSelectionR = globalVaribleRegions?.get(position)
             Log.w("showRegions", " uuserSelectionR" + userSelectionR)
         }
     }

 }


 fun showDistricts() {

     var c: Long? = null
     var userSelectionC: String? = null
     Log.w("showRegions", "only regions " + globalVaribleDistricts)

     var spinnerDistrict = view?.findViewById<Spinner>(R.id.districtSpinner)

     spinnerDistrict?.adapter = activity?.let {
         globalVaribleDistricts?.let { it1 ->
             ArrayAdapter<String>(
                 it,
                 R.layout.spinner_layout_regions,
                 R.id.textViewSpinnerRegions,
                 it1
             )
         }
     }


     spinnerDistrict?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
         override fun onNothingSelected(parent: AdapterView<*>?) {
             textViewSpinner.text = "Välj ett land"
         }

         override fun onItemSelected(
             parent: AdapterView<*>?,
             view: View?,
             position: Int,
             id: Long
         ) {
             if (parent != null) {
                 c = parent.getItemIdAtPosition(position)
             }

             if (parent != null) {
                 userSelectionC = globalVaribleDistricts?.get(position)
             }


             Log.w("USERC", "globalVaribleCountries?.get(id.toInt()) =>>" + c)
             Log.w("USERC", " userSelectionC = parent.id.toString()" + userSelectionC)
         }

     }

 }
*/


/*    fun volleyeGetCountries(view: View, optionC: String, optionR: String) {

        var responseString: String = ""
        var arrayCountries = ArrayList<String>()
        var arrayRegions = ArrayList<String>()
        var arrayDestricts = ArrayList<String>()
        var countryName: Any = ""
        var regionsArray: JSONArray
        var regionName: Any = ""
        var districtName: Any = ""
        var districtArray: JSONArray
        var jsonObjectDistricts: JSONObject
        var jsonObjectRegions: JSONObject
        var jsonObject: JSONObject

        var countryID: String = ""

        val queue = com.android.volley.toolbox.Volley.newRequestQueue(activity)

        val url = "http://10.110.108.182:5000/api/metadata/countries"


        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->

                //json stringArray in response
                responseString = response.substring(0, response.length)
                var jsonArray = JSONArray(responseString)


                // Log.w("START ", "<<<<<<-------------------------------------------------------------------------------------------->>>>>" )

                // FOR LOOP ---> ------- GET ALL COUNTRY NAMES -----------
                for (c in 0 until jsonArray.length()) {
                    jsonObject = jsonArray.getJSONObject(c)
                    countryName = jsonObject.getString("countryName")
                    regionsArray = jsonObject.getJSONArray("regions")
                    arrayCountries.add(countryName.toString())
                    //show all countries in spinner, in array
                    var c = countrySpinner(view, countries = arrayCountries)
                    // Log.w("IN VOLLEY ", "--------- ******** Option User COUNTRY =>>" + optionC)
                    //Log.w("END ", "<<<<<<-------------------------------------------------------------------------------------------->>>>>")


                    // FOR LOOP ---> ------- GET ALL REGIONS NAMES -----------
                    for (r in 0 until regionsArray.length()) {
                        jsonObjectRegions = regionsArray.getJSONObject(r)
                        regionName = jsonObjectRegions.getString("regionName")
                        countryID = jsonObjectRegions.getString("countryId")
                        districtArray = jsonObjectRegions.getJSONArray("districts")

                        //if statement if user option == country name show the regions
                        if (optionC == countryName) {

                            Log.w(
                                "Region",
                                "Region name --->>>> " + regionName + " IN country ===>>" + countryName
                            )
                            arrayRegions.add(regionName.toString())
                            spinnerRegion(view, regions = arrayRegions)

                        }


                        Log.w("FOR", "FOR LOOP ---> ------- GET ALL DISTRICT NAMES -----------" )


                        //  Log.w("IN VOLLEY ", "--------- ******** Option User REGION =>>" + optionR)
                        for (d in 0 until districtArray.length()) {
                            jsonObjectDistricts = districtArray.getJSONObject(d)
                            districtName = jsonObjectDistricts.getString("districtName")

                            Log.w("IN District", "Districts -->>>>>>>>>" + districtName)
                            //   Log.w("IN VOLLEY ", "--------- ******** Option User District =>>" + optionD)

                            Log.w("OptionR", "Region option" + optionR)

                            if (optionR == regionName){


                                arrayDestricts.add(districtName.toString())
                                spinnerDistrict(district = arrayDestricts)

                                Log.w("ArraYD", "Districts -->>>>>>>>>" + districtName)


                            }



                        }

                    }


                }
            },
            Response.ErrorListener {

                Log.w("Error", "Countries : It didnt work!")


            })


        queue.add(stringRequest)



    }*/


/*   fun countrySpinner(view: View, countries: ArrayList<String>) {

       var c: String? = null
       var countriesNames = arrayOf(countries)

       for (i in 0 until countriesNames.size) {

           var countrySpinner = view.findViewById<Spinner>(R.id.spinneCountries)

           countrySpinner?.adapter = activity?.let {
               ArrayAdapter<String>(
                   it,
                   R.layout.spinner_layout,
                   R.id.textViewSpinner,
                   countriesNames[i]
               )
           }


           countrySpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
               override fun onNothingSelected(parent: AdapterView<*>?) {


                   textViewSpinner.text = "Välj ett land"

               }

               override fun onItemSelected(
                   parent: AdapterView<*>?,
                   view: View?,
                   position: Int,
                   id: Long
               ) {
                   c = countries.get(position)



                   volleyeGetCountries(view!!, optionC = c!!, optionR = String())


               }


           }


       }


   }*/
/*   fun spinnerRegion(view: View, regions: ArrayList<String>): String {
       var regionNames = arrayOf(regions)
       var r: String = ""
       for (i in 0 until regionNames.size) {


           Log.w("TAG IN SPINNER", "REGIONAMES =>>" + regionNames[i])

           //var spinnerRegion = view.findViewById<Spinner>(R.id.regionSpinner)

           regionSpinner?.adapter = ArrayAdapter<String>(
               context!!,
               R.layout.spinner_layout_regions,
               R.id.textViewSpinnerRegions,
               regionNames[i]
           )
           regionSpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
               override fun onNothingSelected(parent: AdapterView<*>?) {

                   textViewSpinnerRegions.text = "Välj ett region"

               }

               override fun onItemSelected(
                   parent: AdapterView<*>?,
                   view: View?,
                   position: Int,
                   id: Long
               ) {
                   r = regions.get(position)

                   volleyeGetCountries(view!!, optionC = String(), optionR = r)

               }


           }

       }

       return r

   }*/

/*
    fun spinnerDistrict(district: ArrayList<String>): String {
        var d: String = ""


        var districtNames = arrayOf(district)



        for (i in 0 until districtNames.size ) {


            Log.w("TAG IN SPINNER", "DISTICT NAME =>>" + districtNames[i])
            i

            districtSpinner?.adapter = ArrayAdapter<String>(
                context!!,
                R.layout.spinner_layout_districts,
                R.id.textViewSpinnerDistricts,
                districtNames[i]
            )
            districtSpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {

                    textViewSpinnerDistricts.text = "Välj ett region"

                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    d = district.get(position)
                    var districtId = districtSpinner.getItemIdAtPosition(id.toInt())

                    Log.w("spinnnerDistrict", " districtId =======>>>>>>>>" + districtId)



                   postDistrictId = districtId
                }

            }

        }

        return d

    }
*/


/*

    //get from api countries, regions, district
    fun getCountriesRegionsDistrict(view: View) {

        Log.w("getCRD", " getCountriesRegionsDistrict")
        var responseStringGrapes: String?
        val queue = com.android.volley.toolbox.Volley.newRequestQueue(activity)
        val url = "http://10.110.108.182:5000/api/metadata/countries"

        var stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->

                responseStringGrapes = response.substring(0, response.length)

                var gson = GsonBuilder().create()
                val countriesList: List<GetCountriesClass> =
                    gson.fromJson(responseStringGrapes, Array<GetCountriesClass>::class.java)
                        .toList()


                Log.w("getCRD", "CountriesList ======>>>>>> " + countriesList)


                listCountriesClass = countriesList
                Log.w(
                    "getCRD",
                    " GLOBAL VARIABLE listGrapesName ======>>>>>> " + listCountriesClass
                )



            }, Response.ErrorListener {
                Log.w("ERROR", " ======>>>>>> Countries : It didnt work!")

            })

        queue.add(stringRequest)



    }
*/


/*

    fun testSpinnerautocomplete(view: View){



        Log.w("showGrapeNames", "listGrapesName" + listGrapesName)

        var autpCompleteTextGrapesname = view?.findViewById<AutoCompleteTextView>(R.id.autoCompleteTextViewGrapes)



        var testArray = arrayOf("Adriana", "Erik","Tobias", "Marie", "Jenny", "Jonas","Alexander","Emil","Mattias")

        Log.w("showGrapeNames", "testArray" + testArray.toString())


        var adapter = ArrayAdapter(context!!, R.layout.spinner_grapes_layout, R.id.textViewGrapes, testArray)


        autpCompleteTextGrapesname?.threshold = 0

        autpCompleteTextGrapesname?.setAdapter(adapter)



    }

*/


/*

 fun showGrapeNames(view: View) {
        var editText = view.findViewById<EditText>(R.id.procent)
        var arrayOfResultUserGrapeNameProcent = ArrayList<String>()
        var userSelectionG : String? = null
        var  positionUserSelection : Long? = null


     Log.w("showGrapeNames", "listGrape" + listGrapesName)

     var testArray = arrayOf("Adriana", "Erik","Tobias", "Marie", "Jenny", "Jonas","Alexander","Emil","Mattias")





        var autoCompleteTextViewGrapes: AutoCompleteTextView? = null

        autoCompleteTextViewGrapes = view.findViewById(R.id.autoCompleteTextViewGrapes) as? AutoCompleteTextView


        autoCompleteTextViewGrapes?.threshold = 1
        var adapterAutoComplete = activity?.let {


            ArrayAdapter<String>(
                it,
                R.layout.spinner_grapes_layout,
                R.id.textViewGrapes,
                testArray

            )



        }



        autoCompleteTextViewGrapes?.setAdapter(adapterAutoComplete)


        autoCompleteTextViewGrapes?.setOnItemClickListener { parent, view, position, id ->


            userSelectionG = autoCompleteTextViewGrapes.text.toString()
            Log.w("TAG USER SEL", "userSelectionG ==========>" + userSelectionG)

            // positionUserSelection = adapterAutoComplete?.getPosition(userSelectionG)!!.toInt()

            positionUserSelection = adapterAutoComplete?.getItemId(position)!!
            Log.w(
                "TAG USER SEL",
                "positionUserSelection ==========>" + positionUserSelection
            )



            resultGrapesAndProcent.text = "Namn: " + userSelectionG

            editText.setOnClickListener {


                Log.w(
                    "TAG USER SEL",
                    "positionUserSelection ==========>" + positionUserSelection
                )

                var resultOfGrapeNameAndprocentFromUser =
                    "Namn: " + userSelectionG + " " + editText.text.toString().toInt() + "%"

                postIdGrape = positionUserSelection
                postGrapeProcent = editText.text.toString().toInt()




                arrayOfResultUserGrapeNameProcent.add(
                    resultOfGrapeNameAndprocentFromUser
                )
                var selectedItemsGrapes =
                    Arrays.toString(arrayOfResultUserGrapeNameProcent.toArray())
                        .replace('[', ' ').replace(']', ' ').trim()

                Log.w(
                    "TAG USER SEL",
                    "positionUserSelection ==========>" + positionUserSelection.toString()
                )


                resultGrapesAndProcent.text = selectedItemsGrapes


            }
        }


        //textwatcher

        autoCompleteTextViewGrapes?.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {

                Log.w(
                    "TAG afterTextChanged",
                    "afterTextChanged ====>>> " + autoCompleteTextViewGrapes?.text
                )
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {

            }

        })

    }





*/


/*fun getImageUri(context: Context, bitmap: Bitmap): Uri {
                var bytes =  ByteArrayOutputStream()
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
              var path = MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap, "Title", null)

    Log.w("selectedImageUri", "selectedImageUri ==>> " + path)
    return Uri.parse(path)


}*/


//spinner for countries, regions and district
/*

    fun countrySpinner(view: View, countries: ArrayList<String>) {


        var c: String? = null


        var countriesNames = arrayOf(countries)



        for (i in 0 until countriesNames.size) {

            var countrySpinner = view.findViewById<Spinner>(R.id.spinneCountries)

            countrySpinner?.adapter = activity?.let {
                ArrayAdapter<String>(
                    it,
                    R.layout.spinner_layout,
                    R.id.textViewSpinner,
                    countriesNames[i]
                )

            }


            countrySpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {


                    textViewSpinner.text = "Välj ett land"

                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    c = countries.get(position)



                    volleyeGetCountries(view!!, optionC = c!!, optionR = String())


                }


            }


        }


    }


    fun volleyeGetCountries(view: View, optionC: String, optionR: String) {

        var responseString: String = ""
        var arrayCountries = ArrayList<String>()
        var arrayRegions = ArrayList<String>()
        var arrayDestricts = ArrayList<String>()
        var countryName: Any = ""
        var regionsArray: JSONArray
        var regionName: Any = ""
        var districtName: Any = ""
        var districtArray: JSONArray
        var jsonObjectDistricts: JSONObject
        var jsonObjectRegions: JSONObject
        var jsonObject: JSONObject

        var countryID: String = ""

        val queue = com.android.volley.toolbox.Volley.newRequestQueue(activity)

        val url = "http://10.110.108.182:5000/api/me/countries"


        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->

                //json stringArray in response
                responseString = response.substring(0, response.length)
                var jsonArray = JSONArray(responseString)

                // Log.w("START ", "<<<<<<-------------------------------------------------------------------------------------------->>>>>" )

                // FOR LOOP ---> ------- GET ALL COUNTRY NAMES -----------
                for (c in 0 until jsonArray.length()) {
                    jsonObject = jsonArray.getJSONObject(c)
                    countryName = jsonObject.getString("countryName")
                    regionsArray = jsonObject.getJSONArray("regions")
                    arrayCountries.add(countryName.toString())
                    //show all countries in spinner, in array
                    var c = countrySpinner(view, countries = arrayCountries)
                    // Log.w("IN VOLLEY ", "--------- ******** Option User COUNTRY =>>" + optionC)
                    //Log.w("END ", "<<<<<<-------------------------------------------------------------------------------------------->>>>>")


                    // FOR LOOP ---> ------- GET ALL REGIONS NAMES -----------
                    for (r in 0 until regionsArray.length()) {
                        jsonObjectRegions = regionsArray.getJSONObject(r)
                        regionName = jsonObjectRegions.getString("regionName")
                        countryID = jsonObjectRegions.getString("countryId")
                        districtArray = jsonObjectRegions.getJSONArray("districts")

                        //if statement if user option == country name show the regions
                        if (optionC == countryName) {

                            Log.w(
                                "Region",
                                "Region name --->>>> " + regionName + " IN country ===>>" + countryName
                            )
                            arrayRegions.add(regionName.toString())
                            spinnerRegion(view, regions = arrayRegions)

                        }


                        // FOR LOOP ---> ------- GET ALL DISTRICT NAMES -----------


                        //  Log.w("IN VOLLEY ", "--------- ******** Option User REGION =>>" + optionR)
                        for (d in 0 until districtArray.length()) {
                            jsonObjectDistricts = districtArray.getJSONObject(d)
                            districtName = jsonObjectDistricts.getString("districtName")


                            //   Log.w("IN VOLLEY ", "--------- ******** Option User District =>>" + optionD)


                            if (optionR == regionName) {


                                arrayDestricts.add(districtName.toString())
                                spinnerDistrict(district = arrayDestricts)
                                // Log.w("IN VOLLEY", "Districts -->>>>>>>>>" + districtName)


                            }


                        }

                    }


                }
            },
            Response.ErrorListener {

                Log.w("Error", "Countries : It didnt work!")


            })


        queue.add(stringRequest)


    }


*/


/*fun spinnerRegion(view: View, regions: ArrayList<String>): String {
    var regionNames = arrayOf(regions)
    var r: String = ""
    for (i in 0 until regionNames.size) {


        Log.w("TAG IN SPINNER", "REGIONAMES =>>" + regionNames[i])

        //var spinnerRegion = view.findViewById<Spinner>(R.id.regionSpinner)

        regionSpinner?.adapter = ArrayAdapter<String>(
            context!!,
            R.layout.spinner_layout_regions,
            R.id.textViewSpinnerRegions,
            regionNames[i]
        )
        regionSpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

                textViewSpinnerRegions.text = "Välj ett region"

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                r = regions.get(position)

//  Log.w("TAG In Spinner:", "------USER OPTION REGIONS------- " + r  )


                //volleyeGetCountries(view!!, optionC = String(), optionR = r)


            }


        }

    }

    return r

}
*/

/*  fun spinnerDistrict(district: ArrayList<String>): String {
      var d: String = ""

      var s : Editable? = null
      var districtNames = arrayOf(district)

      for (i in 0 until districtNames.size) {


          Log.w("TAG IN SPINNER", "DISTICT NAME =>>" + districtNames[i])
          i

          districtSpinner?.adapter = ArrayAdapter<String>(
              context!!,
              R.layout.spinner_layout_districts,
              R.id.textViewSpinnerDistricts,
              districtNames[i]
          )
          districtSpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
              override fun onNothingSelected(parent: AdapterView<*>?) {

                  textViewSpinnerDistricts.text = "Välj ett region"

              }

              override fun onItemSelected(
                  parent: AdapterView<*>?,
                  view: View?,
                  position: Int,
                  id: Long
              ) {
                  d = district.get(position)
                  var districtId = districtSpinner.getItemIdAtPosition(id.toInt())

                  Log.w("spinnnerDistrict", " districtId =======>>>>>>>>" + districtId)

                  postDistrictId = districtId


                  //postAddNewWine()



              }


          }

      }


      return d

  }



  fun getWineNamesApiVolley(view: View) {

      var responseStringWines: String = ""
      val queue = com.android.volley.toolbox.Volley.newRequestQueue(activity)
      val url = "http://10.110.108.182:5000/api/wines"

      var stringRequest = StringRequest(
          Request.Method.GET, url,
          Response.Listener<String> { response ->

              responseStringWines = response.substring(0, response.length)

              var gson = GsonBuilder().create()
              val wineList: List<GetWineClass> = gson.fromJson(responseStringWines, Array<GetWineClass>::class.java).toList()

              Log.w("GET WiNE CLASS", " WINELIST  ======>>>>>> " + wineList)

              listWinessName = wineList
              showWineNameAutoComplete(view)
          }, Response.ErrorListener {

              Log.w("EEERRROOORRR", " ======>>>>>> WINELIST : It didnt work!")


          })


      queue.add(stringRequest)


  }


  fun showWineNameAutoComplete(view: View){

      var  wineNameUserSelection : String = ""
      var wineNameUserSelectionId : Int = 0


      var arraOfWineNames = listWinessName?.let {
          ArrayList<GetWineClass>(it)

      }
      var nameWines = ArrayList<String>()

      for (i in arraOfWineNames!!){

          nameWines.add(i.name.toString())

         // Log.d("adeee", "list " +    nameWines.add(i.name.toString()))
      }

      var autoCompleteTextViewWineNames: AutoCompleteTextView? = null
      autoCompleteTextViewWineNames?.threshold = 0
      autoCompleteTextViewWineNames = view.findViewById(R.id.autoCompleteTextViewaddVineName) as AutoCompleteTextView

      var testArray = arrayOf("Adriana", "Erik","Tobias", "Marie", "Jenny", "Jonas","Alexander","Emil","Mattias")
      var adapterWineNameAutoCompleteTextView = activity?.let {

          ArrayAdapter<String>(
              it,
              R.layout.spinner_layout_winenames,
              R.id.textViewWineNames,
              nameWines
          )


      }





      autoCompleteTextViewWineNames?.setAdapter(adapterWineNameAutoCompleteTextView)
      autoCompleteTextViewWineNames.setOnItemClickListener { parent, view, position, id ->


          wineNameUserSelection = autoCompleteTextViewWineNames.text.toString()
          wineNameUserSelectionId = parent.adapter.getItemId(position).toInt()


          Log.w(
              "UserSelction Name", " wineNameUserSelection ==>>>>> " + wineNameUserSelection

          )





          Log.w(
              "UserSelction id", " wineNameUserSelectionId ==>>>>> " + wineNameUserSelectionId

          )
      }



      autoCompleteTextViewWineNames?.addTextChangedListener(object : TextWatcher {

          override fun afterTextChanged(s: Editable?) {

              Log.w(
                  "Text Watcher WineNames",
                  "afterTextChanged ====>>> " + autoCompleteTextViewWineNames?.text
              )

              postAddNewWineName = autoCompleteTextViewWineNames.text.toString()
              //postAddNewWine()
          }

          override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

          }

          override fun beforeTextChanged(
              s: CharSequence?,
              start: Int,
              count: Int,
              after: Int
          ) {

          }

      })




  }



  fun wineProcent(view: View){

      var wineProcent : EditText
      var changeToDouble : Double
      wineProcent = view.findViewById(R.id.vineProcent)


      wineProcent.addTextChangedListener(object : TextWatcher {

          override fun afterTextChanged(s: Editable?) {

              Log.w(
                  "wineProcent",
                  "afterTextChanged ====>>> " + wineProcent?.text
              )



              try {
                  changeToDouble = wineProcent.text.toString().toDouble()

                  Log.w(


                      "wineProcent",
                      "try  ====>>> " +  changeToDouble


                  )

                  postWineProcent = changeToDouble

                  //postAddNewWine()


              }catch (e:Exception){


                  Log.w(
                      "wineProcent",
                      "E Exception  error  ====>>> " + e
                  )

              }



          }

          override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

          }

          override fun beforeTextChanged(
              s: CharSequence?,
              start: Int,
              count: Int,
              after: Int
          ) {

          }

      })



  }
*/
/*

    fun getData(url: String, view: View){


        // var url = "http://10.110.108.182:5000/api/grapes"
        val request = okhttp3.Request.Builder()
            .get()
            .url(url)
            .build()
        val client = OkHttpClient()

        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: okhttp3.Response) {

                var reseponseBody = response.body?.string()
                Log.w("Success!!", "Response " + reseponseBody)


                var gson = GsonBuilder().create()
                var grapeList = gson.fromJson(reseponseBody, Array<GetGrapes>::class.java).toList()
                Log.w("In get Grapes", "grapelist " + grapeList)

                listOfGrapes = grapeList
                Log.w("In get Grapes", "Global variable listOfTest " + listOfGrapes)
                //  AddVineFragment().showGrapes(view = view)

                              showGrapes(view)
            }



            override fun onFailure(call: Call, e: IOException) {
                Log.w(
                    "ERROR",
                    "Failed Getgrapes " + call.hashCode() + e.message + e.localizedMessage + e.cause
                )
            }

        }

        )




    }



    fun showGrapes(view: View){

        var testArray = arrayOf("Adriana", "Erik","Tobias", "Marie", "Jenny", "Jonas","Alexander","Emil","Mattias")
        var autoCompleteTextViewGrapes: AutoCompleteTextView?
        autoCompleteTextViewGrapes = view.findViewById(R.id.autoCompleteTextViewGrapes) as? AutoCompleteTextView
        var show = view.findViewById<TextView>(R.id.resultGrapesAndProcent)
        Log.w(" In showGrapes", "listOfTest " + listOfGrapes)



        var grapesName = ArrayList<String>()
        var arrayOfGrapensName = listOfGrapes?.let {

            ArrayList<GetGrapes>(it)
        }

        if (arrayOfGrapensName != null) {
            for(g in arrayOfGrapensName){


                grapesName.add(g.grapeName.toString())}
        }


        Log.w("InShowGrapes", "only Names " + grapesName)

        show.text = grapesName.toString()


        autoCompleteTextViewGrapes?.threshold = 1
        var adapterAutoComplete = activity?.let {

            ArrayAdapter<String>(
                it,
                R.layout.spinner_grapes_layout,
                R.id.textViewGrapes,
                grapesName
            )

        }
        autoCompleteTextViewGrapes?.setAdapter(adapterAutoComplete)





    }







    }*/

/*        var show = view.findViewById<TextView>(R.id.resultGrapesAndProcent)
        var editText = view.findViewById<EditText>(R.id.procent)
        var arrayOfResultUserGrapeNameProcent = ArrayList<String>()
        var userSelectionG : String?
        var  positionUserSelection : Long?
        var autoCompleteTextViewGrapes: AutoCompleteTextView?
        autoCompleteTextViewGrapes = view.findViewById(R.id.autoCompleteTextViewGrapes) as? AutoCompleteTextView


        Log.w(" In showGrapes", "listOfTest " + listOfGrapes)
        var arraOfGrapesName = listOfGrapes?.let {
            ArrayList<GetGrapes>(it)
        }

        var nameGrapes = ArrayList<String>()
        for (i in arraOfGrapesName!!){
            nameGrapes.add(i.grapeName.toString())
        }
        Log.w("InShowGrapes", "only Names " + nameGrapes)


        var testArray = arrayOf("Adriana", "Erik","Tobias", "Marie", "Jenny", "Jonas","Alexander","Emil","Mattias")



        autoCompleteTextViewGrapes?.threshold = 1
        var adapterAutoComplete = activity?.let {

            ArrayAdapter<String>(
                it,
                R.layout.spinner_grapes_layout,
                R.id.textViewGrapes,
                testArray
            )

        }


        show.text = testArray.toString()

        autoCompleteTextViewGrapes?.setAdapter(adapterAutoComplete)
        autoCompleteTextViewGrapes?.setOnItemClickListener { _, view, position, id ->


            userSelectionG = autoCompleteTextViewGrapes.text.toString()
            Log.w("TAG USER SEL", "userSelectionG ==========>" + userSelectionG)

            // positionUserSelection = adapterAutoComplete?.getPosition(userSelectionG)!!.toInt()

            positionUserSelection = adapterAutoComplete?.getItemId(position)!!
            Log.w(
                "TAG USER SEL",
                "positionUserSelection ==========>" + positionUserSelection
            )



            resultGrapesAndProcent.text = "Namn: " + userSelectionG

            editText?.setOnClickListener {


                Log.w(
                    "TAG USER SEL",
                    "positionUserSelection ==========>" + positionUserSelection
                )

                var resultOfGrapeNameAndprocentFromUser =
                    "Namn: " + userSelectionG + " " + editText?.text.toString().toInt() + "%"

                postIdGrape = positionUserSelection
                postGrapeProcent = editText?.text.toString().toInt()

              //  postAddNewWine()


                arrayOfResultUserGrapeNameProcent.add(
                    resultOfGrapeNameAndprocentFromUser
                )
                var selectedItemsGrapes =
                    Arrays.toString(arrayOfResultUserGrapeNameProcent.toArray())
                        .replace('[', ' ').replace(']', ' ').trim()

                Log.w(
                    "TAG USER SEL",
                    "positionUserSelection ==========>" + positionUserSelection.toString()
                )


                resultGrapesAndProcent.text = selectedItemsGrapes


            }
        }


        //textwatcher

        autoCompleteTextViewGrapes?.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {

                Log.w(
                    "TAG afterTextChanged",
                    "afterTextChanged ====>>> " + autoCompleteTextViewGrapes?.text
                )
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {

            }

        })*/

/*  fun getVolleyGrapesName() {


      var responseStringGrapes: String = ""





      val queue = com.android.volley.toolbox.Volley.newRequestQueue(activity)
      val url = "http://10.110.108.182:5000/api/grapes"



      var stringRequest = StringRequest(
          Request.Method.GET, url,
          Response.Listener<String> { response ->

              responseStringGrapes = response.substring(0, response.length)

              var gson = GsonBuilder().create()
              val grapelist: List<GetGrapes> = gson.fromJson(responseStringGrapes, Array<GetGrapes>::class.java).toList()

              Log.w("GET GRAPE CLASS", " GRAPELIST ======>>>>>> " + grapelist)

              listGrapesName = grapelist


              //  listOfTest = grapelist



              //val oneTest = grapelist[0]

              //val mainActivity = activity!! as MainActivity

              //mainActivity.setTest(oneTest)

              view?.let { showGrapeNames(it) }

          }, Response.ErrorListener {

              Log.w("EEERRROOORRR", " ======>>>>>> Grapes : It didnt work!")


          })


      queue.add(stringRequest)


  }


  private fun showGrapeNames(view: View) {
      var editText = view.findViewById<EditText>(R.id.procent)
      var arrayOfResultUserGrapeNameProcent = ArrayList<String>()
      var userSelectionG : String? = null
      var  positionUserSelection : Long? = null


      var grapesName = ArrayList<String>()
      var arrayOfGrapensName = listGrapesName?.let {

          ArrayList<GetGrapes>(it)
      }

      for(g in arrayOfGrapensName!!){


          grapesName.add(g.grapeName.toString())}





      var autoCompleteTextViewGrapes: AutoCompleteTextView? = null

      autoCompleteTextViewGrapes = view.findViewById(R.id.autoCompleteTextViewGrapes) as? AutoCompleteTextView


      autoCompleteTextViewGrapes?.threshold = 1
      var adapterAutoComplete = activity?.let {

          ArrayAdapter<String>(
              it,
              R.layout.spinner_grapes_layout,
              R.id.textViewGrapes,
              grapesName
          )



      }



      autoCompleteTextViewGrapes?.setAdapter(adapterAutoComplete)
      autoCompleteTextViewGrapes?.setOnItemClickListener { parent, view, position, id ->


          userSelectionG = autoCompleteTextViewGrapes.text.toString()
          Log.w("TAG USER SEL", "userSelectionG ==========>" + userSelectionG)

          // positionUserSelection = adapterAutoComplete?.getPosition(userSelectionG)!!.toInt()

          positionUserSelection = adapterAutoComplete?.getItemId(position)!!
          Log.w(
              "TAG USER SEL",
              "positionUserSelection ==========>" + positionUserSelection
          )



          resultGrapesAndProcent.text = "Namn: " + userSelectionG

          editText.setOnClickListener {


              Log.w(
                  "TAG USER SEL",
                  "positionUserSelection ==========>" + positionUserSelection
              )

              var resultOfGrapeNameAndprocentFromUser =
                  "Namn: " + userSelectionG + " " + editText.text.toString().toInt() + "%"

              postIdGrape = positionUserSelection
              postGrapeProcent = editText.text.toString().toInt()

              postAddNewWine()


              arrayOfResultUserGrapeNameProcent.add(
                  resultOfGrapeNameAndprocentFromUser
              )
              var selectedItemsGrapes =
                  Arrays.toString(arrayOfResultUserGrapeNameProcent.toArray())
                      .replace('[', ' ').replace(']', ' ').trim()

              Log.w(
                  "TAG USER SEL",
                  "positionUserSelection ==========>" + positionUserSelection.toString()
              )


              resultGrapesAndProcent.text = selectedItemsGrapes


          }
      }


      //textwatcher

      autoCompleteTextViewGrapes?.addTextChangedListener(object : TextWatcher {

          override fun afterTextChanged(s: Editable?) {

              Log.w(
                  "TAG afterTextChanged",
                  "afterTextChanged ====>>> " + autoCompleteTextViewGrapes?.text
              )
          }

          override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

          }

          override fun beforeTextChanged(
              s: CharSequence?,
              start: Int,
              count: Int,
              after: Int
          ) {

          }

      })

  }

*/
/*fun postAddNewWine(){



    var btnPostApi : FloatingActionButton

    btnPostApi = view!!.findViewById(R.id.floatingActionButtonAdd)

    btnPostApi.setOnClickListener {

        Log.w("postAddNewWine", "District id from user =>" + postDistrictId)
        Log.w("postAddNewWine", "New Wine Name selection from user =>" + postAddNewWineName)
        Log.w("postAddNewWine", "New Wine Procent selection from user =>" + postWineProcent)
        Log.w("postAddNewWine", "Post grape Procent selection from user =>" + postGrapeProcent)
        Log.w("postAddNewWine", "Grape ID selection from user =>" + postIdGrape)


        val gson = Gson()
        var grapes = listOf((WineGrapesPostClass(postIdGrape, postGrapeProcent )))
        var wine = WinePostClass(postAddNewWineName.toString(), postImage, postDistrictId, postWineProcent, grapes)



        val postSend = gson.toJson(wine)
        Log.w("Tag POST SEND", "POST" + postSend )
        var jsonObjectParams = JSONObject(postSend)


        val queue = com.android.volley.toolbox.Volley.newRequestQueue(activity)
        var url = "http://10.110.108.182:5000/api/wines/"
        Log.w("jsonObject post", "jsonObject " + jsonObjectParams)


        val stringRequest = JsonObjectRequest(
            Request.Method.POST, url, jsonObjectParams,
            Response.Listener { response ->


                Log.w("Successss", "Response" + response)

            }, Response.ErrorListener { error: VolleyError ->
                VolleyLog.d("Error $error.message" + error.cause + error.message + error.localizedMessage)




            }
        )


        try {
            queue.add(stringRequest)
            Log.w("Successss", "Response ")


        } catch (e: Exception) {


            Log.w("Exception", "Exception " + e.localizedMessage)

        }





    }




}*/


/*

fun showAutoCompleteNameWines(view: View, wineN: ArrayList<String>) {
    var wineNameUserSelection: String = ""
    var wineNameUserSelectionId : Int = 0
    Log.w("TAG In show WineNames", "Wine names =============>>>>>>>>>>>>>>>>  " + wineN)
    var autoCompleteTextViewWineNames: AutoCompleteTextView? = null

    var listWineNames = ArrayList<String>(wineN)

    autoCompleteTextViewWineNames?.threshold = 0

    autoCompleteTextViewWineNames =
        view.findViewById(R.id.autoCompleteTextViewaddVineName) as AutoCompleteTextView

    var adapterWineNameAutoCompleteTextView = activity?.let {

        ArrayAdapter<String>(
            it,
            R.layout.spinner_layout_winenames,
            R.id.textViewWineNames,
            listWineNames
        )


    }


    autoCompleteTextViewWineNames?.setAdapter(adapterWineNameAutoCompleteTextView)
    autoCompleteTextViewWineNames.setOnItemClickListener { parent, view, position, id ->

        wineNameUserSelection = autoCompleteTextViewWineNames.text.toString()

        wineNameUserSelectionId = parent.adapter.getItemId(position).toInt()





        if (wineNameUserSelection != null){

            Log.w(
                "TAG USER",
                "USER SELECTION NAMEWINE IS  =======>>>>>>>>>>>> " + wineNameUserSelection + wineNameUserSelectionId
            )

            getItemIdWineNames(userSelectionItemIdWineName = wineNameUserSelectionId)

        }



    }




    autoCompleteTextViewWineNames?.addTextChangedListener(object : TextWatcher {

        override fun afterTextChanged(s: Editable?) {


          var userInputautoCompleteNewWineName = autoCompleteTextViewWineNames.text.toString()



            getNewWineName(userNewWinePost = userInputautoCompleteNewWineName)



        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun beforeTextChanged(
            s: CharSequence?,
            start: Int,
            count: Int,
            after: Int
        ) {

        }

    })


}
*/


/*
    fun volleyGetGrapes(view: View, arrayGrapes : ArrayList<String>)
    {


        listOfTest?.let {
            for (i in listOfTest!!) {
                Log.d("volleyGetGrapes", i.tagNr.toString())
            }
        }


        var responseString: String = ""
        var jsonArrayGrapes: JSONArray
        var jsonObjectWines: JSONObject
        var grapeName: Any
        // var arrayGrapes = ArrayList<String>()


        val queue = com.android.volley.toolbox.Volley.newRequestQueue(activity)
        val url = "http://10.110.108.182:5000/api/grapes"
        //val list = ArrayList<GrapesClass>()


        var stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->





                responseString = response.substring(0, response.length)
                jsonArrayGrapes = JSONArray(responseString)
//  Log.w("Grapes Volley Api :", " --------->>> Grapes responsestring ---->>>>>" + responseString)

                for (g in 0 until jsonArrayGrapes.length()) {
                    jsonObjectWines = jsonArrayGrapes.getJSONObject(g)
                    grapeName = jsonObjectWines.getString("grapeName")




                    arrayGrapes.add(grapeName.toString())



                    selectGrapesSpinner(view!!, grapes = arrayGrapes)


                }


            }, Response.ErrorListener {

                Log.w("EEERRROOORRR", " ======>>>>>> Grapes : It didnt work!")


            })


        queue.add(stringRequest)




    }


    fun selectGrapesSpinner(view: View, grapes: ArrayList<String> ) {

        var positionUserSelection : Long = 0
        var autoCompleteTextViewGrapes: AutoCompleteTextView? = null

        var editText = view.findViewById<EditText>(R.id.procent)

        var userSelectionG: String = ""


        var listGrapes = ArrayList<String>(grapes)


        var arrayOfResultUserGrapeNameProcent = ArrayList<String>()


        autoCompleteTextViewGrapes?.threshold = 1

        autoCompleteTextViewGrapes =
            view.findViewById(R.id.autoCompleteTextViewGrapes) as? AutoCompleteTextView


        var adapterAutoComplete = activity?.let {
            ArrayAdapter<String>(
                it,
                R.layout.spinner_grapes_layout,
                R.id.textViewGrapes,
                listGrapes
            )
        }


        autoCompleteTextViewGrapes?.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {

                Log.w(
                    "TAG afterTextChanged",
                    "afterTextChanged ====>>> " + autoCompleteTextViewGrapes?.text
                )
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {

            }

        })


        autoCompleteTextViewGrapes?.setAdapter(adapterAutoComplete)
        autoCompleteTextViewGrapes?.setOnItemClickListener { parent, view, position, id ->

            userSelectionG = autoCompleteTextViewGrapes.text.toString()




            Log.w("TAG USER SEL", "userSelectionG ==========>" + userSelectionG + "" )

                   // " position ===>>>  " + positionUserSelection)


            if (userSelectionG != listGrapes[0]) {


                resultGrapesAndProcent.text = "Namn: " + userSelectionG

                editText.setOnClickListener {

                    positionUserSelection = adapterAutoComplete!!.getItemId(position)!!


                    Log.w("TAG USER SEL", "positionUserSelection ==========>" + positionUserSelection)

                    var resultOfGrapeNameAndprocentFromUser =
                        "Namn: " + userSelectionG + " " + editText.text.toString().toInt() + "%"




                    arrayOfResultUserGrapeNameProcent.add(
                        resultOfGrapeNameAndprocentFromUser
                    )
                    var selectedItemsGrapes =
                        Arrays.toString(arrayOfResultUserGrapeNameProcent.toArray())
                            .replace('[', ' ').replace(']', ' ').trim()

                    Log.w("TAG USER SEL", "positionUserSelection ==========>" + positionUserSelection.toString()
                    )


                    resultGrapesAndProcent.text = selectedItemsGrapes


                }

            }


        }


    }*/


/*

    fun postApiNewWineAll(){


        var btnPostApi : FloatingActionButton

        btnPostApi = view!!.findViewById(R.id.floatingActionButtonAdd)

        btnPostApi.setOnClickListener {




        }

    }
*/


// fun getUserSelectionPost(getUserWineFromAutoComplete : String){

/*
        var btnPostApi : FloatingActionButton

        btnPostApi = view!!.findViewById(R.id.floatingActionButtonAdd)

        btnPostApi.setOnClickListener {


            Log.w("RUNNSSS postApiNewWine", "RUUUUUNNNNSSSS ")



            val gson = Gson()
            var grapes = listOf((WineGrapesPostClass(userIdSelectionGrapes, grapeProcent.toString().toInt())))
            var wine = WineClass("Marie", "iamge.jpg", userSelectionIdDistrict, 70.3, grapes)



            val postSend = gson.toJson(wine)
            Log.w("Tag POST SEND", "POST"+postSend )
            var jsonObjectParams = JSONObject(postSend)


            val queue = com.android.volley.toolbox.Volley.newRequestQueue(activity)
            val url = "http://10.110.108.182:5000/api/wines"
            Log.w("Exception", "jsonObject " + jsonObjectParams)


            val stringRequest = JsonObjectRequest(
                Request.Method.POST, url, jsonObjectParams,
                Response.Listener { response ->


                    Log.w("Exception", "Exception " + response)

                }, Response.ErrorListener { error ->
                    VolleyLog.e("TAG", "/post request fail! Error: ${error.message + error.localizedMessage + error.networkResponse}")

                })


            try {
                queue.add(stringRequest)
                Log.w("Successss", "Response ")


            } catch (e: Exception) {


                Log.w("Exception", "Exception " + e.localizedMessage)

            }


*/


//postApiNewWine(postWineName = userSelectionWineName, postUserIdSelectionGrapes = userIdSelectionGrapes, postGrapeProcent = grapeProcent, postUserSelectionIdDistrict = userSelectionIdDistrict)

//}


//  fun postApiNewWine( ) {

//  Log.w("postApiNewWine BEFORE B", "userSelectionWineName ====>>>> "+ postWineName)
/*
var btnPostApi : FloatingActionButton

btnPostApi = view!!.findViewById(R.id.floatingActionButtonAdd)

btnPostApi.setOnClickListener {
   Log.w("postApiNewWine", "userSelectionWineName ====>>>> "+ postWineName)



              // Log.w("IN postApiNewWine", "userIdSelection "+ userIdSelectionGrapes )
              //Log.w("RUNNSSS postApiNewWine", "RUUUUUNNNNSSSS ")

           *//*   Log.w("getUserGrapesSelection", "userIdSelection =======>>>> "+ postUserIdSelectionGrapes)
   Log.w("getUserGrapesSelection", "grapeProcent ====>>>> "+ postGrapeProcent)
   Log.w("getUserGrapesSelection", "userSelectionIdDistrict ====>>>> "+ postUserSelectionIdDistrict)*//*
    val gson = Gson()
     var grapes = listOf((WineGrapesPostClass(postUserIdSelectionGrapes, postGrapeProcent.toString().toInt())))
     var wine = WineClass("${postWineName}", "iamge.jpg", postUserSelectionIdDistrict, 70.3, grapes)



     val postSend = gson.toJson(wine)
     Log.w("Tag POST SEND", "POST"+postSend )
     var jsonObjectParams = JSONObject(postSend)


     val queue = com.android.volley.toolbox.Volley.newRequestQueue(activity)
     val url = "http://10.110.108.182:5000/api/wines"
     Log.w("Exception", "jsonObject " + jsonObjectParams)


     val stringRequest = JsonObjectRequest(
         Request.Method.POST, url, jsonObjectParams,
         Response.Listener { response ->


             Log.w("Exception", "Exception " + response)

         }, Response.ErrorListener { error ->
             VolleyLog.e("TAG", "/post request fail! Error: ${error.message + error.localizedMessage + error.networkResponse}")

         })


     try {
         queue.add(stringRequest)
         Log.w("Successss", "Response ")


     } catch (e: Exception) {


         Log.w("Exception", "Exception " + e.localizedMessage)

     }



*/


//}


















