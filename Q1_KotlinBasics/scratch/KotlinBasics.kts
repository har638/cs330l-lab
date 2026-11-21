// Question 1 - Kotlin Basics (Scratch File)

fun main() {
    // 1. two integer variables
    val a = 24
    val b = 6

    // 2. arithmetic operations
    println("Addition = " + (a + b))
    println("Subtraction = " + (a - b))
    println("Multiplication = " + (a * b))
    println("Division = " + (a / b))
    println()

    // 3. if else for pass / fail
    val marks = 72
    if (marks >= 50) {
        println("Marks = $marks  Result = Pass")
    } else {
        println("Marks = $marks  Result = Fail")
    }
    println()

    // 4. loop from 1 to 10
    print("Numbers: ")
    for (i in 1..10) {
        print("$i ")
    }
}

main()
