
fun main() {
    var input = readLine()!!
    var Parking: Park? = null

    while (input != "exit") {
        val keys = input.split(" ")

        when (keys[0]) {
            "create" -> {
                Parking = Park(keys[1].toInt())
                println("Created a parking lot with ${keys[1].toInt()} spots.")
            }
            "park" -> Parking?.add(keys[1], keys[2]) ?: println("Sorry, a parking lot has not been created.")
            "leave" -> Parking?.leave(keys[1].toInt())
                ?: println("Sorry, a parking lot has not been created.") //TODO: rizicno sta ako nije int, resi to
            "status" -> Parking?.status() ?: println("Sorry, a parking lot has not been created.")
            "reg_by_color" -> Parking?.reg_by_color(keys[1])
                ?: println("Sorry, a parking lot has not been created.")
            "spot_by_color" -> Parking?.spot_by_color(keys[1])
                ?: println("Sorry, a parking lot has not been created.")
            "spot_by_reg" -> Parking?.spot_by_reg(keys[1])
                ?: println("Sorry, a parking lot has not been created.")

            else -> println("Wrong input!!")
        }
        input = readLine()!!
    }

}








