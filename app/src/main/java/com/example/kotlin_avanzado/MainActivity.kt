package com.example.kotlin_avanzado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Funcion de extension

        //Cogemos de un objeto existente "String" y le añadimos un método (no a la clase String) para que nos reemplace
        // los espacios por no espacios
        fun String.noSpaces(): String {
            return this.replace(" ", "")

        }
        //Cogemos de un objeto existente "IntArray" y le añadimos un método que nos muestra todos los elementos del IntArray
        fun IntArray.show() {
            for (i in this) {
                println(i)
            }
        }

        var usuario: String = " Soy   yo "
        println("Usuario: $usuario")
        println("Longitud: ${usuario.length}")
        println("Usuario sin espacios: ${usuario.noSpaces()}")
        println("Longitud usuario sin espacios: ${usuario.noSpaces().length}")

        var array1: Array<Int> = arrayOf(5, 4, 3, 2, 1)
        var array2 = IntArray(3)
        array2[0] = 10
        array2[1] = 20
        array2[2] = 30
        var array3: IntArray = intArrayOf(6, 7, 8, 9)

        array2.show()
        array3.show()


    }
}