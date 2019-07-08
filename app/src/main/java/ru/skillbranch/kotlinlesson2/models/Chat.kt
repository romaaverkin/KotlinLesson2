package ru.skillbranch.kotlinlesson2.models

class Chat(
    val id: String,
    val membrs: MutableList<User> = mutableListOf(),
    val messages: MutableList<BaseMessage> = mutableListOf()
) {
}
