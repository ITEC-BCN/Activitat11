abstract class Baralla : Iterator<Carta>, IPuntuable {
    protected abstract var cartes : MutableList<Carta>
    private var cartesRetornades: MutableList<Carta>
    protected var position:Int
    private var posIterator: Int = 0

    constructor() {
        cartesRetornades = mutableListOf<Carta>()
        position = 0
    }

    protected abstract fun generarCartes()

    /* Opció 1 per implementar el Iterator si es fa servir Iterable
* només cal implementar la funció iterator() que retorna un Iterator<Carta>

override fun iterator(): Iterator<Carta> {
    return this.cartes.iterator()
}

*/

    /* Opció 2 per implementar el Iterator si es fa servir Iterator
    * cal implementar les funcions hasNext() i next() de la interfície Iterator<Carta>
    */
    override fun hasNext(): Boolean {
        var result:Boolean = posIterator <= cartes.lastIndex
        if (!result) posIterator = 0
        return result
    }
    override fun next(): Carta {
        return cartes[posIterator++]
    }

    fun barrejar() {
        cartes.shuffle()
        cartesRetornades.clear()
        position = 0
    }

    fun seguentCarta(): Carta? {
        var result:Carta? = null
        if (position <= cartes.lastIndex)
        result = cartes[position++]
        return result
    }

    fun cartesDisponibles():Int {
        return cartes.lastIndex - position
    }

    fun demanarCartes(retornades:List<Carta>) : List<Carta> {
        val result:List<Carta>

        //Comprovar que hi hagin prou cartes, sino retornarem les mateixes
        if (cartesDisponibles() >= retornades.size ) {
            //Comprovar que les cartes realment son de la baralla
            var correctes: Boolean = true
            for (c in retornades)
                if (!cartes.contains(c)) correctes = false
            //Si son correctes, les retornem
            if (correctes)
                cartesRetornades.addAll(cartesRetornades.lastIndex+1, retornades)
            //Demanem les cartes
            result = repartirCartes(retornades.size)
        }
        else {
            result = retornades
        }

        return result
    }

    fun repartirCartes(quantes:Int):List<Carta> {
        val result:MutableList<Carta> = mutableListOf<Carta>()
        if (cartesDisponibles() >= quantes) {
            repeat(quantes) {
                result.add(seguentCarta()!!)
            }
        }
        return result
    }

    fun veureMunt():List<Carta> {
        return cartesRetornades
    }

}