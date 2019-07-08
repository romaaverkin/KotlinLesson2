package ru.skillbranch.kotlinlesson2

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.kotlinlesson2.extensions.*
import ru.skillbranch.kotlinlesson2.models.*
import ru.skillbranch.kotlinlesson2.utils.Utils
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
        var user3 = user.copy(lastVisit = Date().add(-2, TimeUnits.SECOND))
        var user4 = user.copy(lastName = "Cena", lastVisit = Date().add(2, TimeUnits.HOUR))

        println(
            """
        ${user.lastVisit?.format()}
        ${user2.lastVisit?.format()}
        ${user3.lastVisit?.format()}         
        ${user4.lastVisit?.format()}         
        """.trimIndent()
        )
    }

    @Test
    fun test_dataq_mapping() {
        val user = User.makeUser("Макеев Михаил")
        val newUser = user.copy(lastVisit = Date().add(-800, TimeUnits.DAY))
        println(newUser)

        val userView = newUser.toUserView()

        userView.printMe()
    }

    @Test
    fun test_to_initial() {
        println(Utils.toInitials("john", "doe")) //JD
        println(Utils.toInitials("John", null)) //J
        println(Utils.toInitials(null, null)) //null
        println(Utils.toInitials(" ", "")) //null
    }

    @Test
    fun test_humanize_diff() {
        println(Date().add(-2, TimeUnits.HOUR).humanizeDiff()) //2 часа назад
        println(Date().add(-5, TimeUnits.DAY).humanizeDiff()) //5 дней назад
        println(Date().add(2, TimeUnits.MINUTE).humanizeDiff()) //через 2 минуты
        println(Date().add(7, TimeUnits.DAY).humanizeDiff()) //через 7 дней
        println(Date().add(-400, TimeUnits.DAY).humanizeDiff()) //более года назад
        println(Date().add(400, TimeUnits.DAY).humanizeDiff()) //более чем через год
    }

    @Test
    fun test_abstract_factory() {
        val user = User.makeUser("Макеев Михаил")
        val txtMessage = BaseMessage.makeUser(user, Chat("0"), payload = "any text message", type = "text")
        val imgMessage = BaseMessage.makeUser(user, Chat("0"), payload = "any image url", type = "image")

        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())
    }
}
