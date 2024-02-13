fun main(args: Array<String>) {

    //Prova de baralla espanyola
    val b : BarallaEspanyola = BarallaEspanyola()
    mostrarCartes(b)

    val c: BarallaEspanyola = BarallaEspanyola()
    println("Eliminar 8s i 9s")
    c.eliminar8i9()

    mostrarCartes(c)

    //No és possible crear una carta des de l'exterior de les classes
    val f :Carta = Carta("MELOCOTONES", 18)


}

fun mostrarCartes(b:Baralla) {
    //Imprimeix totes les cartes de la baralla
    var i:Int = 1
    while (b.cartesDisponibles() >= 0 ) {
        val c:Carta = b.seguentCarta()!!
        print("$i :: ")
        println(c)
        i++
    }
}