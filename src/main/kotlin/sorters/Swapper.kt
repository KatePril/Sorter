package sorters

interface Swapper {
    fun swap(arr: Array<Int>, i: Int, j: Int) {
        val tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp
    }
}