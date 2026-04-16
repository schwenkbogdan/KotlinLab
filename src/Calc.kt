import kotlin.math.cos

class Calc {

    fun sum(a: Vector, b: Vector): Vector =
        Vector(a.x + b.x, a.y + b.y)

    fun sub(a: Vector, b: Vector): Vector =
        Vector(a.x - b.x, a.y - b.y)

    // Kotlin не поддерживает перегрузку по типам Double/Float/Int,
    // поэтому один универсальный метод с Double
    fun mul(a: Vector, b: Double): Vector =
        Vector(a.x * b, a.y * b)

    fun scalMul(a: Vector, b: Vector, angle: Double): Double =
        a.length() * b.length() * cos(angle)
}
