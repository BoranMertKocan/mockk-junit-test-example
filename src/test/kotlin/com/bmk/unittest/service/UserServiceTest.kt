package com.bmk.unittest.service

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class UserServiceTest {

    private val userTransferService = mockk<UserTransferService>()
    private val userService = UserService(userTransferService)

    @Test
    fun testCombineNames() {
        // Given
        val firstName = "John"
        val lastName = "Doe"
        val expected = "John Doe"

        every { userTransferService.transferUser(firstName, lastName) } returns Unit

        // When
        val actual = userService.combineNames(firstName, lastName)

        // Then
        assertEquals(expected, actual)
        verify(exactly = 1) { userTransferService.transferUser(firstName, lastName) }
    }

    @Test
    fun testCombineNames_WithEmptyName() {
        // Given
        val firstName = ""
        val lastName = "Doe"

        // When - Then
        assertThrows(IllegalArgumentException::class.java) {
            userService.combineNames(firstName, lastName)
        }
    }
}