package com.example.kotlin_avanzado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Declaramos una variable de tipo String con un valor con espacios
        var usuario: String = " Soy   yo "

        //Mostramos el valor de la variable y su longitud antes y despues de aplicarle la función de reemplazo de espacios
        println("Usuario: $usuario")
        println("Longitud: ${usuario.length}")
        println("Usuario sin espacios: ${usuario.noSpaces()}")
        println("Longitud usuario sin espacios: ${usuario.noSpaces().length}")


        //Declaramos diferentes colecciones de datos de tipo Int
        var array1: Array<Int> = arrayOf(5, 4, 3, 2, 1)
        var array2 = IntArray(3)
        array2[0] = 10
        array2[1] = 20
        array2[2] = 30
        var array3: IntArray = intArrayOf(6, 7, 8, 9)

        //Mostramos el valor de todos los elementos de las colleciones de tipo IntArray,
        // no pudiendo operar con la primera al ser una colección de tipo Array
        array2.show()
        array3.show()


        //Declaramos diferentes variables para operar con ellas con las funciones de orden superior
        var num1: Int = 10
        var num2: Int = 5
        var resultado: Int? = null

        println("Suma de los elementos $num1 + $num2 = ${calculadora(num1, num2, ::sumar)}")
        println("Resta de los elementos $num1 - $num2 = ${calculadora(num1, num2, ::restar)}")
        println("Multiplicación de los elementos $num1 * $num2 = ${calculadora(num1, num2, ::multiplicar)}")
        println("División de los elementos $num1 / $num2 = ${calculadora(num1, num2, ::dividir)}")

    }
    //FUNCIONES DE EXTENSIÓN

    //Cogemos de un objeto existente "String" y le añadimos un método (no a la clase String) para que nos reemplace
    // los espacios por no espacios
    private fun String.noSpaces(): String {
        return this.replace(" ", "")

    }

    //Cogemos de un objeto existente "IntArray" y le añadimos un método que nos muestra todos los elementos del IntArray
    private fun IntArray.show() {
        for (i in this) {
            println(i)
        }
    }


    //FUNCIONES DE ORDEN SUPERIOR

    //Son funciones que aceptan funciones como parámetros mediante expresiones Lambda
    private fun calculadora(n1: Int, n2: Int, funct: (Int, Int) -> Int): Int {

        return funct(n1, n2)
    }

    private fun sumar(x: Int, y: Int): Int {
        return x + y
    }

    private fun restar(x: Int, y: Int): Int {
        return x - y
    }

    private fun multiplicar(x: Int, y: Int) = x * y

    private fun dividir(x: Int, y: Int) = x / y

}