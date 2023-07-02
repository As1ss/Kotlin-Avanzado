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
        println(
            "Multiplicación de los elementos $num1 * $num2 = ${
                calculadora(
                    num1,
                    num2,
                    ::multiplicar
                )
            }"
        )
        println("División de los elementos $num1 / $num2 = ${calculadora(num1, num2, ::dividir)}")


        //Creamos un objeto de tipo Person para comprobar las funciones de orden superior en objetos con los métodos creados de
        // comprobar altura para ser policiía

        var persona1: Person = Person("Antonio", "B123451", 1.60f)
        println("Puede ser policía ${persona1.name} en Colombia? ${persona1.checkPolice(::alturaColombia)}")
        println("Puede ser policía ${persona1.name} en España? ${persona1.checkPolice(::alturaSpain)}")


        //EXPRESIONES LAMBDA

        //Creamos una variable que guarde una expresión o función Lambda
        var funcionLambda = { x: Int, y: Int -> x + y }

        //Operamos sobre el ejemplo anterior de suma de dos ints pero pasando como parámetro esta variable
        println("Suma de los elementos $num1 + $num2 = ${calculadora(num1, num2, funcionLambda)}")

        //Estas funciones/expresiones nos permiten actualizar el bloque de código para que se adapten según nuestras necesidades, por ejemplo
        // esta variable ha pasado de sumar dos valores enteros con un valor predefinido a restear dos valores que le acabamos de pasar ahora
        funcionLambda = { x: Int, y: Int -> x - y }
        println("Resta de los elementos 35 - 22 = ${calculadora(35, 22, funcionLambda)}")

        //Ahora podemos realizar operaciones sin necesidad de tener estas expresiones almacenadas en ninguna variable
        println(
            "Multiplicación de los elementos $num1 * $num2 = ${
                calculadora(
                    num1,
                    num2
                ) { x: Int, y: Int -> x * y }
            }"
        )
        println(
            "División de los elementos $num1 / $num2 = ${
                calculadora(
                    num1,
                    num2
                ) { num1, num2 -> num1 / num2 }
            }"
        )

        //Podemos extender estas expresiones para operaciones mas complejas, con variables
        // anonimas, grupos de instrucciones y se pueden poner fuera del parentesis entre dos llaves
        println(
            "La potencia de  $num1 elevado a $num2 = ${
                calculadora(num1, num2) { x, y ->
                    var valor = 1
                    for (i in 1..y) valor *= x

                    valor
                }
            }"
        )

        //MANIPULACIÓN DEL CÓDIGO DE LAMBDAS

        //Declaramos un array de 10 elementos con el valor 5 en todas sus posiciones con una expresion lambda
        var array4: IntArray = IntArray(10) { 5 }
        println("Array4: "); array4.show();

        var array5: IntArray =
            IntArray(10) { it } //it es el parámetro que tienen las lambdas de este tipo Array para iterar
        // y rellenar todas las posiciones de un Array con el valor que le hayamos indicado. Al estar asignando el valor del iterador,
        // todas las posiciones del Array tendrán el valor del iterador
        println("Array5: "); array5.show();


        //Otro ejemplo con el que interaccionamos con el iterador para asignar un valor a las posiciones del IntArray
        var array6: IntArray = IntArray(10) { it * 2 }
        println("Array6: "); array6.show();

        //Este ejemplo renombramos la variable del iterador, pero no podemos manipular su valor
        var array7: IntArray = IntArray(10) { i -> i * 3 }
        println("Array7: "); array7.show();

        var suma = 0

        recorrerArray(array7) {
            suma += it
        }
        println("Suma del array7 : $suma")

        //Ejemplo práctico de un array de tipo Char para formar una frase

        var letras: Array<Char> = arrayOf('H', 'o', 'l', 'a', ' ', 'M', 'u', 'n', 'd', 'o')
        var frase: String = ""

        recorrerArray2(letras) {
            frase += it
        }
        println(frase)


    }

    private fun recorrerArray2(letras: Array<Char>, function: (Char) -> Unit) {
        for (i in letras) {
            function(i)
        }
    }


    private fun recorrerArray(array: IntArray, function: (Int) -> Unit) {

        for (i in array) {
            function(i)
        }
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

    //FUNCIONES DE ORDEN SUPERIOR EN OBJETOS


    /*Creación de una función de extension de (Person) donde devolveremos los siguientes métodos para evaluar
    nuestra altura, es un ejemplo para ver como se utilizan, lo ideal es mantenerlo en nuestras clases, solo operar este tipo
    de funciones de extensión en clases ya definidas por Kotlin

    fun Person.checkPolice(fn: (Float?) -> Boolean): Boolean {
        return fn(this.height)
    }

     */

    //Creación de los métodos que determinaran si podemos ser o no policías según nuestra altura y el País al que apliquemos
    private fun alturaColombia(altura: Float?): Boolean {
        return altura!! >= 1.60f
    }

    private fun alturaSpain(altura: Float?): Boolean {
        return altura!! >= 1.65f
    }

}