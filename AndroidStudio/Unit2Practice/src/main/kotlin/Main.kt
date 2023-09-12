fun main() {

    // Problem 2
    val child = 5
    val adult = 28
    val senior = 87
    val invalid1 = 102
    val invalid2 = -4

    val isMonday = true

    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
    println("The movie ticket price for a person aged $invalid1 is \$${ticketPrice(invalid1, isMonday)}.")
    println("The movie ticket price for a person aged $invalid2 is \$${ticketPrice(invalid2, isMonday)}.")

    /*

    // Problem 1
    val morningNotification = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)

     */
}


fun ticketPrice(age: Int, isMonday: Boolean): Int {
    val price1 = 15
    val price2 = 30
    val price3 = 20

    val discount1 = 5

    if (age > 0 && age <= 12) {
        return price1
    } else if (age >= 13 && age <=60) {
        if (isMonday) {
            return price2 - discount1
        }
        return price2
    } else if (age >= 61 && age <= 100) {
        return price3
    }

    return -1
}

fun printNotificationSummary(numberOfMessages: Int) {
    if (numberOfMessages >= 100) {
        println("Your phone is blowing up! You have 99+ notifications.")
    } else println("You have $numberOfMessages notifications.")
}

