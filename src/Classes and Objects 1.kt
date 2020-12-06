fun main() {

    /* To create an instance of a class we call the constructor as if it was a regular function, Kotlin does not have
     "new". As shown below functions can be initialized without a variable to hold them, in this case the initialization
     is run anyways
     */

    Example3("rune")
    // First property: rune
    // First init block printing name: rune
    // Second property: 4
    // Second init block printing length of name: 4

    Example5(10)
    // The length is: 10

    Example5("rune")
    // The length is: 4

    BaseClass("Base String")
    // BaseClass init, baseProperty: Base String

    DeprivedClass("Base String", "Deprived String")
    // BaseClass init, baseProperty: Base String
    // DeprivedClass init, deprivedProperty: Deprived String

}

/* A class consists of a class header and a class body.
The class contains the type parameters, the primary constructor, visibility modifiers, return type, etc.
The class body contains the members of the class and is surrounded by curly braces.
 */

class Example1 constructor() { // Class header
    // Class body
}

// If a constructor has no visibility modifiers the "constructor" keyword can be omitted, "standard" syntax

class Example2() { // Class header
    // Class body
}

/* Primary constructor cannot contain code, initialization logic is instead placed in init{} blocks, which are placed in
the class body. It is possible to have multiple blocks and these will be called in the order which they appear in the
class body.
*/

class Example3(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First init block printing name: $name")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second init block printing length of name: ${name.length}")
    }
}

/* Note that two properties are also declared and initialized in the class body in the above example. Both constructors
and initializer blocks use the parameter passed in the primary constructor. Note also that all of the print happens in
the order they appear in the class.
 */

// Properties can be declared and initialized in the primary constructor using the following syntax:

class Example4(val firstProperty: String, val secondProperty: String) {}

/* Secondary constructors can also be created inside of the class body, all of which must call the primary constructor
either directly using "this" or through another secondary function, if a primary constructor exists, using the syntax
shown below.
 */

class Example5 constructor(var length: Int) {

    constructor(string: String): this(string.length)

    init {
        println("The length is: $length")
    }

}

/* A class can contain constructors and initializer blocks, functions, properties, nested and inner classes and object
declarations. These are called class members.

By default, Kotlin classes are final and cannot be inherited from. To make a class inheritable it can be marked with the
"open" keyword.

A class which is inherited from is called a "base" class for the inherited class. The class which inherits from another
class is called a deprived class. In Kotlin all classes have a common superclass, i.e. base which is the "Any" class,
which has three methods: equals(), hasCode() and toString() and are thus defined for all Kotlin classes.

If a deprived class has a primary constructor the base class can and must be initialized in the class header, using
parameters from the primary constructor. If not, secondary constructors must initialize base class directly or
indirectly.

The syntax for extending a class is shown below.
 */

open class BaseClass(val baseProperty: String) {
    init {
        println("BaseClass init, baseProperty: $baseProperty")
    }
}

class DeprivedClass(baseProperty: String, val deprivedProperty: String): BaseClass(baseProperty) {
    init {
        println("DeprivedClass init, deprivedProperty: $deprivedProperty")
    }
}

// Note how the DeprivedClass has both a property declared in the primary constructor and simply a parameter.

// When initializing a deprived class, the base class is initialized first, and then the deprived class.

// Similar to functions default parameters can be defined for classes.
