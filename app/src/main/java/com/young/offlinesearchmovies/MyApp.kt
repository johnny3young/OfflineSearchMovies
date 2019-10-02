package com.young.offlinesearchmovies

import android.app.Application
import android.content.Context

//Heredamos de la clase Application para que definirá el contexto a nivel de la aplicación
//porque habrá momentos en donde no podremos obtener directamente el conexto porque no nos encontramos
//en un activity y ahí usaremos esta clase para obtener la referencia al contexto de la aplicación
//luego la agregamos al Manifest y al iniciar se instancie este objeto heredado de Application
class MyApp : Application() {

    //Atributo estático que hace referencia a la propia clase para obtenerla en el lugar que necesitemos
    //le colocamos el nombre instance para obtener una instancia de esta clase
    private var instance: MyApp? = null

    //Para recibir un objeto de este tipo "MyApp" que devolvera la instancia del objeto instance que hemos creado
    fun getInstance(): MyApp? {
        return instance
    }

    //Devuelve el contexto es la referencia donde estan alojadas las variables, objetos en momento especifico
    fun getContext(): Context? {
        return instance
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
    }
}