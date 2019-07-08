package ru.skillbranch.kotlinlesson2.utils

object Utils {
    private val characterDictionaryMap = mapOf(
        'а' to "a", 'б' to "b", 'в' to "v", 'г' to "g", 'д' to "d", 'е' to "e", 'ё' to "e", 'ж' to "zh", 'з' to "z",
        'и' to "i", 'й' to "i", 'к' to "k", 'л' to "l", 'м' to "m", 'н' to "n", 'о' to "o", 'п' to "p", 'р' to "r",
        'с' to "s", 'т' to "t", 'у' to "u", 'ф' to "f", 'х' to "h", 'ц' to "c", 'ч' to "ch", 'ш' to "sh", 'щ' to "sh",
        'ъ' to "", 'ы' to "i", 'ь' to "", 'э' to "e", 'ю' to "yu", 'я' to "ya"
    )

    fun parseFuLLName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.trim()?.replaceAll("  ", " ")?.split(" ")

        val firstName = if (parts?.getOrNull(0) == "") null else parts?.getOrNull(0)
        val lastName = if (parts?.getOrNull(1) == "") null else parts?.getOrNull(1)

        return firstName to lastName
    }

    private fun String.replaceAll(s: String, s1: String): String? {
        var result = this

        while (result.contains(s)) {
            result = result.replace(s, s1)
        }

        return result
    }

    fun transliteration(payload: String, divider: String = " "): String {
        var myString: String = ""

        payload.forEach {
            myString +=
                when {
                    it == ' ' -> divider
                    it.isUpperCase() -> characterDictionaryMap[it.toLowerCase()]?.capitalize() ?: it.toString()
                    else -> characterDictionaryMap[it] ?: it.toString()
                }
        }
        return myString
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        var initialString = ""

        if (firstName != null && firstName.trim() != "") {
            initialString += firstName[0].toUpperCase()
        }

        if (lastName != null && lastName.trim() != "") {
            initialString += lastName[0].toUpperCase()
        }

        return if (initialString != "") initialString else null
    }
}
