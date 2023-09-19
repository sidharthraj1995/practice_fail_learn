fun main() {

    /*
    Android Developer Course - Unit 2 - Kotlin Practice
    https://developer.android.com/codelabs/basic-android-kotlin-compose-kotlin-fundamentals-practice-problems?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-2-pathway-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-kotlin-fundamentals-practice-problems#1

    // Problem 1
    val morningNotification = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)


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


    // Problem 3
    printFinalTemperature(28.0, "Celcius", "Fahrenheit") { 9 / 5 * it + 32 }
    printFinalTemperature(60.0, "Celcius", "Kelvin") { it - 273.15 }
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin") { 5.0 / 9.0 * (it - 32) + 273.15 }

    // Problem 4
    val song1 = Song("Deli", "Ice Spice", 2023)
    song1.printInfo()
    println(song1.isPopular)
     */

    // Problem 5
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()
}


fun printNotificationSummary(numberOfMessages: Int) {
    if (numberOfMessages >= 100) {
        println("Your phone is blowing up! You have 99+ notifications.")
    } else println("You have $numberOfMessages notifications.")
}

fun ticketPrice(age: Int, isMonday: Boolean): Int {
    val price1 = 15
    val price2 = 30
    val price3 = 20

    val discount1 = 5

//    if (age > 0 && age <= 12) {
//        return price1
//    } else if (age >= 13 && age <= 60) {
//        if (isMonday) {
//            return price2 - discount1
//        }
//        return price2
//    } else if (age >= 61 && age <= 100) {
//        return price3
//    }
//
//    return -1

    return when (age) {
        in 0..12 -> price1
        in 13..60 -> if (isMonday) price2 else price2 - discount1
        in 61..100 -> price3
        else -> -1
    }
}

fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}

class Song( _tite : String, _artist : String, _year : Int ) {
    val title = _tite
    val artist = _artist
    val year = _year
    var playCount : Int = 0
    var isPopular : Boolean = playCount > 1000

    fun printInfo() {
        println("$title, performed by $artist, was released in $year")
    }
}

class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        println("Name: $name")
        println("Age: $age")
        if (hobby != null && hobby.length > 1)
            println("Like to $hobby")
        else println("Doesn't have a hobby.")

        if (referrer != null) {
            print("Has a referrer named ${referrer.name}")
            if (referrer.hobby != null)
                println(", who likes to ${referrer.hobby}.")
        }
        else println("Doesn't have a referrer.")
    }
    /*
    Name: Amanda
    Age: 33
    Likes to play tennis. Doesn't have a referrer.

    Name: Atiqah
    Age: 28
    Likes to climb. Has a referrer named Amanda, who likes to play tennis.
    */
}