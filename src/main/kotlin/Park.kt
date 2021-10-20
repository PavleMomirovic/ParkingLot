data class Spot(var color: String = "free", var plate: String = "")

class Park(val size: Int = 0, var niz: MutableList<Spot> = MutableList(size) { Spot() }) {
    var nextFree = 0

    fun add(reg: String, clr: String) {
        if (nextFree > size - 1) println("Sorry, the parking lot is full.")
        else {
            niz[nextFree] = Spot(clr.lowercase(), reg)
            println("$clr car parked in spot ${nextFree + 1}.")
            do {
                nextFree++
            } while (nextFree < size - 1 && niz[nextFree].color != "free")    //TODO: ovo moze bolje, rizicno ovako
        }
    }

    fun leave(num: Int) {
        if (niz[num - 1].color == "free") {
            println("There is no car in spot $num.")
        } else {
            niz[num - 1].color = "free"
            niz[num - 1].plate = ""

            println("Spot $num is free.")
            if (num - 1 < nextFree) nextFree = num - 1
        }

    }

    fun status() {
        var empty = true
        for (i in 0..size - 1) {
            if (niz[i].color != "free") {
                println("${i + 1} ${niz[i].plate} ${niz[i].color}")
                empty = false
            }
        }
        if (empty) println("Parking lot is empty.")

    }
    //do sad sta nam treba

    // TODO: za sve 3: sta ako nema, ispis lep, NE RADI, velika mala slova ono sranje

    fun reg_by_color(clr: String) {
        val clrr = clr.lowercase()
        var first = true
        var ima = false
        for (car in niz) {
            if (car.color == clrr) {
                ima = true
                if (!first) print(", ")
                print(car.plate)
                first = false
            }
        }
        if (ima) println() else println("No cars with color $clr were found.")

    }

    fun spot_by_color(clr: String) {
        var clrr = clr.lowercase()
        var ima = false
        var first = true
        for (ind in niz.indices) {
            if (niz[ind].color == clrr) {
                ima = true
                if (!first) print(", ")
                print(ind + 1)
                first = false
            }
        }
        if (ima) println() else println("No cars with color $clr were found.")
    }

    fun spot_by_reg(reg: String) {
        var ima = false
        var first = true
        for (ind in niz.indices) {
            if (niz[ind].plate == reg) {
                ima = true
                if (!first) print(", ")
                print(ind + 1)
                first = false
            }
        }
        if (ima) println() else println("No cars with registration number $reg were found.")
    }

}