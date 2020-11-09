fun main() {

    // Declare variable which can be re-assigned using keyword var - variable
    var mutableVariable = 10

    // Declare read-only variable using keyword val - value
    val immutableVariable = 10

    /* Note that a type was note declared for either variable. In many cases the compiler is able to automatically
    infer the type of a variable by looking at the value assigned to the variable during initialization.

    It is possible to explicitly declare the type for a variable using the following syntax:

    var mutableVariable: Int = 10
    val immutableVariable: Int = 10
     */

    println(mutableVariable)
    mutableVariable++
    println(mutableVariable)

    // Won't compile
    //immutableVariable++

    /* It is important to understand that var and val specified whether or not a value can be reassigned, or if it is
    read-only. For example, it is possible to declare a val list which can be modified. Example:

    val myList = mutableListOf()

    It simply means that the variable myList cannot be reassigned.
     */

}