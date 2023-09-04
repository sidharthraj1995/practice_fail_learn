import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice(val name: String, val category: String) {

    var deviceStatus = "online"
        protected set

    open val deviceType = "unknown"

    open fun turnOn(): Boolean {
        when (deviceStatus) {
            "online", "off" -> {
                deviceStatus = "on"
                return true
            }

            else -> {
                println("Device currently $deviceStatus, cannot turn it ON")
            }
        }
        return false
    }


    open fun turnOff(): Boolean {
        when (deviceStatus) {
            "on" -> {
                deviceStatus = "off"
                return true
            }

            else -> println("Device currently $deviceStatus, cannot turn it OFF")
        }
        return false
    }

    open fun printDeviceInfo() {
        println("Device name: $name")
        println("Device category: $category")
        println("Device Type: $deviceType")
        println()
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)
    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    override fun turnOn(): Boolean {
        if (super.turnOn()) {
            println(
                "$name is turned on. Speaker volume set to $speakerVolume and channel number is " +
                        "set to $channelNumber."
            )
            return true
        }
        return false
    }

    override fun turnOff(): Boolean {
        if (super.turnOff()) {
            println("$name turned off")
            return true
        }
        return false
    }

    override fun printDeviceInfo() {
        super.printDeviceInfo()
    }

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun decreaseSpeakerVolume() {
        speakerVolume--
        println("Speaker volume decreased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    fun previousChannel() {
        channelNumber--
        println("Channel number decreased to $channelNumber.")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"
    private var brightnessLevel by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    override fun turnOn(): Boolean {
        return if (!super.turnOn()) {
            false
        } else {
            brightnessLevel = 2
            println("$name is turned on. The brightness level is $brightnessLevel.")
            true
        }
    }

    override fun turnOff(): Boolean {
        return if (!super.turnOff()) {
            false
        } else {
            brightnessLevel = 0
            println("$name turned off")
            true
        }
    }

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    fun decreaseBrightness() {
        brightnessLevel--
        println("Brightness decreased to $brightnessLevel.")
    }
}

class SmartHome(val smartTvDevice: SmartTvDevice, val smartLightDevice: SmartLightDevice) {

    var deviceTurnOnCount = 0
        private set

    fun turnOnTv() {
        if (smartTvDevice.turnOn()) {
            deviceTurnOnCount++
        } else println("TV already ON")
    }

    fun turnOffTv() {
        if (smartTvDevice.turnOff()) {
            deviceTurnOnCount--
        } else println("TV already OFF")
    }

    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    fun decreaseTvVolume() {
        smartTvDevice.decreaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }

    fun changeTvChannelToPrevious() {
        smartTvDevice.previousChannel()
    }

    fun turnOnLight() {
        if (smartLightDevice.turnOn()) {
            deviceTurnOnCount++
        } else println("Light already ON")
    }

    fun turnOffLight() {
        if (smartLightDevice.turnOff()) {
            deviceTurnOnCount--
        } else println("Light already OFF")
    }

    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }

    fun decreaseLightBrightness() {
        smartLightDevice.decreaseBrightness()
    }

    fun printSmartTvInfo() {
        smartTvDevice.printDeviceInfo()
    }

    fun printSmartLightInfo() {
        smartLightDevice.printDeviceInfo()
    }

    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}

class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    private var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

fun main() {
    val smartHome = SmartHome(
        SmartTvDevice(deviceName = "Android TV", deviceCategory = "Entertainment"),
        SmartLightDevice(deviceName = "Google light", deviceCategory = "Utility")
    )

    smartHome.printSmartTvInfo()
    smartHome.printSmartLightInfo()

    smartHome.turnOnTv()
    smartHome.turnOnLight()
    smartHome.turnOnTv()
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}")
    println()

    smartHome.increaseTvVolume()
    smartHome.increaseTvVolume()
    smartHome.decreaseTvVolume()
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}")
    println()

    smartHome.changeTvChannelToNext()
    smartHome.changeTvChannelToNext()
    smartHome.changeTvChannelToPrevious()
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}")
    println()

    smartHome.increaseLightBrightness()
    smartHome.increaseLightBrightness()
    smartHome.decreaseLightBrightness()
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}")
    println()

    smartHome.printSmartTvInfo()
    smartHome.printSmartLightInfo()


    smartHome.turnOffAllDevices()
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}.")
}