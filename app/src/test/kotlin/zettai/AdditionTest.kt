package zettai

import strikt.api.*
import strikt.assertions.*

import kotlin.test.Test
import kotlin.test.assertNotNull

class AdditionTest {
    @Test fun `add two numbers`() {
        expectThat(5 + 6).isEqualTo(11)
        expectThat(7 + 42).isEqualTo(49)
    }

    fun randomNatural() = java.util.Random().nextInt(1, 100_000_000)

    @Test
    fun `zero identity`() {
      repeat(100) {
        val x = randomNatural()

        expectThat(x + 0).isEqualTo(x)
      } 
    }

    @Test
    fun `commutative`() {
      repeat(100) {
        val x = randomNatural()
        val y = randomNatural()

        expectThat(x + y).isEqualTo(y + x)
      } 
    }

    @Test
    fun `associtive`() {
      repeat(100) {
        val x = randomNatural()
        val y = randomNatural()
        val z = randomNatural()

        expectThat((x + y) + z).isEqualTo(x + (y + z))
        expectThat((y + z) + x).isEqualTo(y + (z + x))
        expectThat((z + x) + y).isEqualTo(z + (x + y))
      } 
    }
}