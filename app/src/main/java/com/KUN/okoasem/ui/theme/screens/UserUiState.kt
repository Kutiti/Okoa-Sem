package com.KUN.okoasem.ui.theme.screens

data class UserUiState(
    val currentUserFirstName: String = "",
    val currentUserLastName: String = "",
    val currentUserID: Int = 0,
    val isUserTutor: Boolean = false,
    val selectedSubjects: Boolean = false
)