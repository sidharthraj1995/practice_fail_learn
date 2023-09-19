import java.lang.foreign.SymbolLookup
import kotlin.math.min

fun main() {

    /*
    Android Developer Course - Unit 2 - Kotlin Practice
    https://developer.android.com/codelabs/basic-android-kotlin-compose-kotlin-fundamentals-practice-problems?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-2-pathway-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-kotlin-fundamentals-practice-problems#1
    */
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
    printFinalTemperature(28.0, "Celsius", "Fahrenheit") { 9 / 5 * it + 32 }
    printFinalTemperature(60.0, "Celsius", "Kelvin") { it - 273.15 }
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin") { 5.0 / 9.0 * (it - 32) + 273.15 }

    // Problem 4
    val song1 = Song("Deli", "Ice Spice", 2023)
    song1.printInfo()
    println(song1.isPopular)

    // Problem 5
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()

    // Problem 6
    val newFoldablePhone = FoldablePhone()

    newFoldablePhone.switchOn()
    newFoldablePhone.checkPhoneScreenLight()
    newFoldablePhone.unfold()
    newFoldablePhone.switchOn()
    newFoldablePhone.checkPhoneScreenLight()


    // Problem 7
    val winningBid = Bid(5000, "Private Collector")

    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")
    println("Item B is sold at ${auctionPrice(null, 3000)}.")
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

class Song( val title : String, val artist : String, val year : Int ) {
//    val title = _title
//    val artist = _artist
//    val year = _year
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
}

open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(var isFolded : Boolean = true) : Phone() {

    override fun switchOn() {
        if(!isFolded) {
            isScreenLightOn = true
        }
        else println("Phone is currently folded, cannot turn the screen ON")
    }

    fun fold() {
        isFolded = true
    }

    fun unfold() {
        isFolded = false
    }
}


class Bid(val amount: Int, val bidder: String)

fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
    return if (bid != null && bid.amount > minimumPrice) {
        bid.amount
    }
    else minimumPrice
}