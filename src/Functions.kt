fun main() {

    greeting("Rune")
    // Hello Rune!

    exampleTopLevelFunction()
    // I am a top-level function

    ExampleClass("Rune").exampleMemberFunction()
    // I am a member function

    repeatLocalFunction(3)
    // I am a local function
    // I am a local function
    // I am a local function

    namedArgumentFunction(third=3, first=1, second=2)
    // 1, 2, 3

    defaultParametersFunction()
    // Hi Rune, What is up?

    variableArgumentFunction(1, 2, 3, 4)
    // 1
    // 2
    // 3
    // 4

    println(genericFunction(1, 2, 3, 4).toString())
    // [1, 2, 3, 4]

    println(genericFunction("one", "two", "three", "four").toString())
    // [one, two, three, four]



}

/* The overall syntax for functions is:

fun <function name>(<parameters>): <return type>  { // Function header
    // Function body
}
 */

fun greeting(name: String) {
    println("Hello $name!")
}

/* Note that if a function does not have a return type, the compiler will default to "Unit" a type which is similar to
Null
 */

/* There a three overall types of functions, top-level, member and local.

A top-level function is declared outside of any class, object or interface. They are functions which are called
directly without the need to create any object or call any class

A member function is declared inside a class or object. Member functions are called with the dot notation on an instance
of the the class of which it is a member.

A local function is a function which is declared inside of another function.
 */

fun exampleTopLevelFunction () {
    println("I am a top-level function")
}

class ExampleClass(val name: String) {
    fun exampleMemberFunction() {
        println("I am a member-function of the instance of exampleClass with the name '$name'")
    }
}

fun repeatLocalFunction(number: Int) {
    fun exampleLocalFunction() = println("I am a local function")
    for (i in 1..number) exampleLocalFunction()
}

/* When a function returns a single expression we can write them like exampleLocalFunction(), this is called a
single-expression function.
 */

/* In Kotlin it is possible to use both named arguments and default arguments. Normally the ordering of variables matter
when they are passed as arguments to a function, however, when they are passed as named argument this does not matter.
If a function has default parameters, they can be omitted altogether.
 */

fun namedArgumentFunction(first: Int, second: Int, third: Int) {
    println("$first, $second, $third")
}

// namedArgumentFunction(third=3, first=1, second=2)
// 1, 2, 3

fun defaultParametersFunction(name: String = "Rune", greeting: String = "What is up?") {
    println("Hi $name, $greeting")
}

// defaultParametersFunction("Maria")
// Hi Maria, What is up?

// defaultParametersFunction(greeting="How's it going?")
// Hi Rune, How's it going?

// It should be noted that named parameters must be placed after non-named parameters

/* Note that all of the functions above does not have an explicit return type. When not specified the default return
type is Unit, which is similar to null. The Unit return type can be explicitly specified.
 */

/* To specify an unknown number of arguments the varargs modifier can be used. It makes it possible to pass any number
of arguments to the function. The varargs argument is usually passed as the last argument to avoid confusion, but it
can also be passed earlier is subsequent arguments are referred to by name.

Arguments can be passed one-by-one to the function, of if they are already in a list which we pass them using the spread
operator - prefixing the array with "*" which is the spread operator.
 */

fun variableArgumentFunction(vararg numbers: Int) {
    for (number in numbers) println(number)
}

fun <T> genericFunction(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) result.add(t)
    return result
}

/* The above function is a generic function, which means that multiple types can be passed to the function. To
make a generic function the generic type parameter <T> must be placed before the name of the function. Generics are
usually given a single letter name.
 */