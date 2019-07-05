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
//        val user = User.makeUser("")
//        val user2 = User.makeUser(" ")
//        val user3 = User.makeUser(null)
//        val user4 = User.makeUser("John")
//        val user5 = User.makeUser("   John      gfg")
        val user6 = User.makeUser("Roman Averkin")
        val user7 = user6.copy(id = "2", lastName = "Cena", lastVisit = Date())
        print("$user6 \n$user7")
    }

    @Test
    fun test_decomposition() {
        val user = User.makeUser("John Wick")

        fun getUserInfo() = user

        val (id, firstName, lastName) = getUserInfo()

        println("$id $firstName $lastName")
        println("${user.component1()} ${user.component2()} ${user.component3()}")
    }

    @Test
    fun test_copy() {
        val user = User.makeUser("John Wick")
        var user2 = user.copy(lastVisit = Date())
        var user3 = user.copy(lastName = "Cena", lastVisit = Date())

        println(
            """
        $user
        $user2
        $user3            
        """.trimIndent()
        )
    }
}
