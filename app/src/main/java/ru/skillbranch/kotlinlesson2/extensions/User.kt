package ru.skillbranch.kotlinlesson2.extensions

import ru.skillbranch.kotlinlesson2.models.User
import ru.skillbranch.kotlinlesson2.models.UserView
import ru.skillbranch.kotlinlesson2.utils.Utils

fun User.toUserView(): UserView {

    val nickName = Utils.transliteration("$firstName $lastName")
    val initials = Utils.toInitials(firstName, lastName)
    val status =
        if (lastVisit == null) "Еще не разу не был" else if (isOnline) "online" else "Последний раз был ${lastVisit.humanizeDiff()}"

    return UserView(
        id,
        fullName = "$firstName $lastName",
        nickName = nickName,
        initials = initials,
        avatar = avatar,
        status = status
    )
}
