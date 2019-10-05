package com.example.exemplespinner

import adaptateur.Article
import adaptateur.ArticleAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import fragment.ArticlesFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        //Fragment
        //créer une instance du fragment
        val fragment = ArticlesFragment ()
        //créer un transaction sur le fragment manager
        supportFragmentManager.beginTransaction().apply {
         //replacer le précédent fragment, s'il existe
         replace(R.id.fragmentId, fragment)
         //ajouter la transaction dans la stack
          addToBackStack(null)
          }.commit()
        //finalement, on valide la transaction


       //instance du recycler
        val recyclerView : RecyclerView = findViewById(R.id.recycleId)
        //créer une liste d'articles

        val articles = listOf<Article>(

            Article("toto", "tototottoto")

        )

        //créer une instance de l'adapteur
        val adapterRecycler = ArticleAdapter(articles)
        //définir l'orientation des élements (vertical)
        recyclerView.layoutManager = LinearLayoutManager(baseContext)
        //associer l'adapter à la recyclerview
        recyclerView.adapter = adapterRecycler



        //la vue n'est pas initialise a cet moment
        //lateinit var Spinner = findViewById(R.id.spinner>)

        //recupérer une liste de string depuis les ressources
        val planetes = resources.getStringArray(R.array.planetes)

        val spinner: Spinner = findViewById(R.id.spinner)
        //instancier adapteur

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, planetes)

        //associer l'adapter au spinner

        spinner.adapter = adapter

        //Listener quand l'utilisateur selectionne un élément
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(p0: AdapterView<*>?) {

                Toast.makeText(baseContext, "Vous n'avez rien selectionné ", Toast.LENGTH_LONG).show()
            }

            override fun onItemSelected(adapter: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(baseContext, "Vous avez selectionné ${planetes[position]}",
                    Toast.LENGTH_LONG).show()
            }
        }
    }


}
