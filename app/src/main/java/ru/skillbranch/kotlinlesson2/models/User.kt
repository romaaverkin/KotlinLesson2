package ru.skillbranch.kotlinlesson2.models

import java.util.*

class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    val respect: Int = 0,
    val lastVisit: Date? = null,
    val isOnline: Boolean = false
) {

    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    constructor(id: String) : this(id, "John", "Doe")

    init {
        println(
            "It's Alive!!!\n" +
                    "${if (lastName === "Doe") "His name is $firstName $lastName" else "And his name is $firstName $lastName!!!"}\n"
        )
    }

    companion object Factory {
        private var lastId: Int = -1

        fun makeUser(fullName: String?): User {
            lastId++
            val fullName1: String? = fullName?.replace("  ", " ", true)

            val parts: List<String>? = fullName1?.split(" ")

            val firstName: String? = parts?.getOrNull(0)
            val lastName: String? = parts?.getOrNull(1)

            return User(id = "$lastId", firstName = "$firstName", lastName = "$lastName")
        }
    }
}
