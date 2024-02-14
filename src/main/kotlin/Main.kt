fun main() {
    //Prova de baralla espanyola
    val b : BarallaEspanyola = BarallaEspanyola()
    mostrarCartes(b)

    val c: BarallaEspanyola = BarallaEspanyola()
    println("Eliminar 8s i 9s")
    c.eliminar8i9()

    mostrarCartes(c)

    //No és possible crear una carta des de l'exterior de les classes
    //val f :Carta = Carta("MELOCOTONES", 18)

    //Recorrer la baralla
    println("Recórrer la baralla amb un iterador")
    for (carta in c) {
        println(carta)
    }

    //Prova de baralla francesa
    println("Prova de baralla francesa")
    val bf : BarallaFrancesa = BarallaFrancesa()
    println("Punts inicials d'una baralla francesa: ${bf.punts()}")
    mostrarCartes(bf)
    println("Punts finals d'una baralla francesa: ${bf.punts()}")

    //Barrejar la baralla
    bf.barrejar()
    println("Punts després de barrejar la baralla francesa: ${bf.punts()}")
    mostrarCartes(bf)


    //Repartir cartes
    bf.barrejar()
    val cartesRepartides:List<Carta> = bf.repartirCartes(5)
    mostrarLlistaCartes(cartesRepartides)

    //Demanar cartes
    val cartesDemanades = bf.demanarCartes(cartesRepartides)
    mostrarLlistaCartes(cartesDemanades)

    //Veure munt
    val muntCartes = bf.veureMunt()
    mostrarLlistaCartes(muntCartes)

    //Intent de retornar a una BarallaEspanyola cartes d'una BarallaFrancesa
    println("Intent de retornar a una BarallaEspanyola cartes d'una BarallaFrancesa")
    b.barrejar()
    var cartesBarallaEspanyola: List<Carta> = b.demanarCartes(cartesDemanades)
    mostrarLlistaCartes(cartesBarallaEspanyola)

    //Repartir cartes de la baralla espanyola
    println("Repartir cartes de la baralla espanyola")
    cartesBarallaEspanyola = b.repartirCartes(7)
    mostrarLlistaCartes(cartesBarallaEspanyola)

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

fun mostrarLlistaCartes(cartes:List<Carta>) {
    //Imprimeix totes les cartes de la llista
    var i:Int = 1
    for (c in cartes) {
        print("Carta en Llista $i :: ")
        println(c)
        i++
    }
}
