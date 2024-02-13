abstract class Baralla : Iterable<Carta> {
    private lateinit var cartes : MutableList<Carta>
    private var cartesRetornades: MutableList<Carta>
    private var position:Int

    constructor() {
         lazy {
            cartes = mutableListOf<Carta>()
            generarCartes()
        }
        cartesRetornades = mutableListOf<Carta>()
        position = 0
    }

    protected abstract fun generarCartes()

    fun barrejar() {
        cartes.shuffle()
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
        var result:MutableList<Carta> = mutableListOf<Carta>()

        //Comprovar que hi hagin prou cartes, sino retornarem les mateixes
        if (cartesDisponibles() >= retornades.size ) {
            //Comprovar que les cartes realment son de la baralla
            var correctes: Boolean = true
            for (c in retornades)
                if (!cartes.contains(c)) correctes = false
            //Si son correctes, les retornem
            if (correctes)
                cartesRetornades.addAll(cartesRetornades.lastIndex, retornades)
            //Demanem les cartes
            repeat(retornades.size) {
                result.add(seguentCarta()!!)
            }
        }
        else
            result = (retornades as List<Carta>)

        return result
    }
}