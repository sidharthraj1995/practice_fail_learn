
fun main(args: Array<String> ) {
    println("Hello, Mr. World!\n")

    val arr = intArrayOf(1,3,2,4,2,7,6,5,4,3,2,1,5,4,3,2,1)
    twoSum(arr, 5)


//    println("Program arguments: ${args.joinToString()}")
}


fun twoSum(nums: IntArray, target: Int) {
    var total : Int = 0
//    val wow1 = IntArray(2)
//    println("$nums")
    for (i in nums.indices) {
        if (i < nums.size - 1) {
            total = nums[i] + nums[i + 1]
            if (target == total) println("[$i:${nums[i]}\t ,\t ${i+1}:${nums[i+1]}]\t = $target")
        }
    }
}
