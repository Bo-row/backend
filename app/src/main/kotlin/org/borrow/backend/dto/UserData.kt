package org.borrow.backend.dto

interface UserData: UserAuthData {
    val firstName: String
    val lastName: String
    val phoneNumber: Int?
    val avatar: String?
}