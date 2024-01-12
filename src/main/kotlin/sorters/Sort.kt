package sorters

interface Sort {
    fun sort(arr: Array<Int>, reverse: Boolean = false)

    fun compare(el1: Int, el2: Int, reverse: Boolean): Boolean  {
        return if (reverse) el1 >= el2 else el1 <= el2
    }
}