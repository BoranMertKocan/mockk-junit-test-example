package com.bmk.unittest.service

import org.springframework.stereotype.Service

@Service
class UserService(private val userTransferService: UserTransferService) {

    fun combineNames(firstName: String, lastName: String): String {
        if (firstName.isBlank() || lastName.isBlank()) {
            throw IllegalArgumentException("Kullanıcının adı ve soyadı boş olamaz.")
        }
        val fullName = "$firstName $lastName"
        userTransferService.transferUser(firstName, lastName)
        return fullName
    }
}