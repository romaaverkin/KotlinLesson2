package ru.skillbranch.kotlinlesson2.utils

object Utils {
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
}
