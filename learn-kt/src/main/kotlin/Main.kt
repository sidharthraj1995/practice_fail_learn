fun main() {
    println("Hello, Mr. World!\n")
/*
    // merge list
    val list1 = listOf(1, 2, 3)
    val list2 = listOf(9, 8, 7, 6)
    println(mergeList(list1, list2))


    // twoSum
    val arr = intArrayOf(1, 3, 2, 4, 2, 7, 6, 5, 4, 3, 2, 1, 5, 4, 3, 2, 1)
    twoSum(arr, 5)
*/

    // Remove duplicates from an array
    val dupArray : IntArray = intArrayOf(1,1,1,2,2,2,3,4,4,4)
    println(removeDuplicates(dupArray))

}


fun twoSum(nums: IntArray, target: Int) {
    var total: Int
//    val wow1 = IntArray(2)
//    println("$nums")
    for (i in nums.indices) {
        if (i < nums.size - 1) {
            total = nums[i] + nums[i + 1]
            if (target == total) println("[$i:${nums[i]}\t ,\t ${i + 1}:${nums[i + 1]}]\t = $target")
            // The printed message has the format:
            // [index1:value1	 ,	 index2:value2]	 = target
        }
    }
}


// Remove duplicates from an array
fun removeDuplicates(nums: IntArray): IntArray {
    var currentNum: Int
    val placeHolder : Int = -1

    //just to be sure
//    nums.sortedArray()

    for (i in nums.indices) {
        if (i < (nums.size-1)) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = placeHolder
            }
        }
    }
    return nums
}


//fun mergeList(list1: List<Int>?, list2: List<Int>?): List<Int>? {
//    val mergedList : MutableList<Int>?
//    if (list1?.isNotEmpty()!! || list2?.isNotEmpty()!!) {
//        mergedList = (list1.plus(list2)).toMutableList()
//        return mergedList.sorted()
//    }
//    return null
//}