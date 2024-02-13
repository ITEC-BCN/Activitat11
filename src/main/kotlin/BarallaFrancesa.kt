class BarallaFrancesa: Baralla {
    override var cartes: MutableList<Carta>
    private val palos= arrayOf(Pair("CORS","VERMELL"),
                                Pair("PIQUES","NEGRE"),
                                Pair("TREBOLS","NEGRE"),
                                Pair("DIAMANTS","VERMELL"))
    private val MAX_NUMERO: Int = 13
    constructor() {
        cartes = mutableListOf<Carta>()
        generarCartes()
    }

    override fun generarCartes() {
        for (palo in palos) {
            for (numero in 1..MAX_NUMERO) {
                when (numero) {
                    1 -> this.cartes.add(CartaFrancesa(palo.first, numero, palo.second, "A"))
                    11 -> this.cartes.add(CartaFrancesa(palo.first, numero, palo.second,"J"))
                    12 -> this.cartes.add(CartaFrancesa(palo.first, numero, palo.second,"Q"))
                    13 -> this.cartes.add(CartaFrancesa(palo.first, numero, palo.second,"K"))
                    else -> this.cartes.add(CartaFrancesa(palo.first, numero, palo.second))
                }
            }
        }

    }

    override fun iterator(): Iterator<Carta> {
        TODO("Not yet implemented")
    }


}