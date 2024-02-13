class BarallaEspanyola : Baralla {
    override var cartes: MutableList<Carta>
    private val palos: List<String> = listOf<String>("ORS","COPES","ESPADES","BASTOS")
    private val MAX_NUMERO: Int = 12
    constructor() {
        cartes = mutableListOf<Carta>()
        generarCartes()
    }

    override protected fun generarCartes() {
        for (palo in palos)
            for (numero in 1..MAX_NUMERO) {
                when (numero) {
                    1 -> this.cartes.add(Carta(palo, numero, "AS"))
                    10 -> this.cartes.add(Carta(palo, numero, "SOTA"))
                    11 -> this.cartes.add(Carta(palo, numero, "CAVALL"))
                    12 -> this.cartes.add(Carta(palo, numero, "REI"))
                    else -> this.cartes.add(Carta(palo, numero))
                }
            }

    }

    override fun iterator(): Iterator<Carta> {
        TODO("Not yet implemented")
    }

    fun eliminar8i9() {
        for (i in this.cartes.size-1 downTo  0 ) {
            val c:Carta = this.cartes[i]
            if (c.getNumero() in 8..9)
                this.cartes.removeAt(i)
        }
    }
}