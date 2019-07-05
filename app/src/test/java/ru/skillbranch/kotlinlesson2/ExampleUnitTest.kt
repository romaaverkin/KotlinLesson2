package ru.skillbranch.kotlinlesson2

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.kotlinlesson2.models.User
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        val user2 = User("2", "John", "Cena")
    }

    @Test
    fun test_factory() {
        val user = User.makeUser("")
        val user2 = User.makeUser(" ")
        val user3 = User.makeUser(null)
        val user4 = User.makeUser("John")
        val user5 = User.makeUser("   John      gfg")
        val user6 = User.makeUser("Roman Averkin")
    }
}
