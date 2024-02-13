open class Carta {
    protected val palo: String
    protected val num: Integer
    protected var nom: String

    constructor(palo:String, num: Integer, nom: String) {
        this.palo = palo
        this.num = num
        this.nom = nom
    }
    constructor(palo:String, num: Integer) : this(palo, num, "") {
        this.nom = "$num de $palo"
    }

    override fun toString() : String {
        return "Carta: $nom"
    }
}