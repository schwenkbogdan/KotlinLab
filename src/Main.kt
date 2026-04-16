import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream

fun main() {
    // --- Vector demo ---
    val v1 = Vector(3.0, 4.0)
    val v2 = Vector(1.0, 2.0)

    println("v1 = $v1")
    println("v2 = $v2")
    println("v1.length = ${v1.length()}")

    // --- Calc demo ---
    val calc = Calc()

    val sum = calc.sum(v1, v2)
    println("v1 + v2 = $sum")

    val sub = calc.sub(v1, v2)
    println("v1 - v2 = $sub")

    val mul = calc.mul(v1, 2.5)
    println("v1 * 2.5 = $mul")

    val scalMul = calc.scalMul(v1, v2, 0.5)
    println("scalar product (angle=0.5) = $scalMul")

    // --- I/O demo ---
    println("\n--- I/O ---")
    val outStream = ByteArrayOutputStream()
    v1.outToText(outStream)
    v1.outToBinary(outStream)

    val inStream = ByteArrayInputStream(outStream.toByteArray())
    val v3 = Vector()
    v3.inFromText(inStream)
    println("v3 after text read = $v3")
}
