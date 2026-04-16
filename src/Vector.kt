import java.io.*
import java.util.Locale

class Vector(var x: Double = 0.0, var y: Double = 0.0) {

    fun length(): Double = kotlin.math.sqrt(x * x + y * y)

    fun print() {
        println("(%.2f;%.2f)".format(Locale.US, x, y))
    }

    fun outToText(out: OutputStream) {
        PrintWriter(OutputStreamWriter(out)).use {
            it.println("$x $y")
        }
    }

    fun outToBinary(out: OutputStream) {
        DataOutputStream(out).use { dataOut ->
            dataOut.writeDouble(x)
            dataOut.writeDouble(y)
        }
    }

    fun inFromText(input: InputStream) {
        BufferedReader(InputStreamReader(input)).use { reader ->
            val line = reader.readLine()
            val halves = line?.split(Regex("\\s+"))
                ?: throw IOException("Empty input")
            x = halves[0].toDouble()
            y = halves[1].toDouble()
        }
    }

    fun inFromBinary(input: InputStream) {
        DataInputStream(input).use { dataIn ->
            x = dataIn.readDouble()
            y = dataIn.readDouble()
        }
    }

    override fun toString(): String = "(%.2f;%.2f)".format(Locale.US, x, y)
}
