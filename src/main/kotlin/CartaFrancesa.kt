class CartaFrancesa : Carta {
    private var color:String

    constructor(palo:String, num:Int, color:String) : this (palo, num, color,"") {
        this.color = color
        this.nom = "$num de $palo - $color"
    }

    constructor(palo:String, num:Int, color:String, nom:String) : super (palo, num, nom) {
        this.color = color
    }

    override fun toString(): String {
        return "CartaFrancesa - " + super.toString()
    }



}