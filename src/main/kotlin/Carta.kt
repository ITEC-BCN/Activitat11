open class Carta {
    @JvmField protected val palo: String
    @JvmField protected val num: Int
    @JvmField protected var nom: String

    internal constructor(palo:String, num: Int, nom: String) {
        this.palo = palo
        this.num = num
        this.nom = "$nom de $palo"
    }
    internal constructor(palo:String, num: Int) : this(palo, num, "") {
        this.nom = "$num de $palo"
    }

    public fun getNumero() : Int {
        return this.num
    }

    public fun getPalo() : String {
        return this.palo
    }

    override fun toString() : String {
        return "Carta: $nom"
    }
}