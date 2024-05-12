package com.KUN.okoasem.ui.theme.screens.SignUp

import androidx.compose.runtime.mutableStateOf
import com.KUN.okoasem.Model.Service.AccountService
import com.KUN.okoasem.ui.theme.screens.TutorFinderViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val accountService: AccountService
) : TutorFinderViewModel() {
    var uiState = mutableStateOf(SignUpUiState())
        private set

    private val editTextArray = arrayListOf(email, password, repeatPassword, firstName, lastName,
        address)

    private val email
        get() = uiState.value.email
    private val password
        get() = uiState.value.password
    private val repeatPassword
        get() = uiState.value.repeatPassword
    private val firstName
        get() = uiState.value.firstName
    private val lastName
        get() = uiState.value.lastName
    private val address
        get() = uiState.value.address
    private val isTutor
        get() = uiState.value.isTutor

    fun onEmailChange(valueChange: String) {
        uiState.value = uiState.value.copy(email = valueChange)
    }

    fun onPasswordChange(valueChange: String) {
        uiState.value = uiState.value.copy(password = valueChange)
    }

    fun onRepeatPasswordChange(valueChange: String) {
        uiState.value = uiState.value.copy(repeatPassword = valueChange)
    }

    fun onFirstNamechange(valueChange: String) {
        uiState.value = uiState.value.copy(firstName = valueChange)
    }

    fun onLastNameChange(valueChange: String) {
        uiState.value = uiState.value.copy(lastName = valueChange)
    }

    fun onAddressChange(valueChange: String) {
        uiState.value = uiState.value.copy(address = valueChange)
    }

    fun onIsTutorChange(valueChange: Boolean) {
        uiState.value = uiState.value.copy(isTutor = valueChange)
    }

    fun onSignUpClick(openAndPopUp: (String, String) -> Unit) {
        if (!email.isValidEmail()) {
            SnackbarManager.showMessage(AppText.email_error)
            return
        }

        if (!password.isValidPassword()) {
            SnackbarManager.showMessage(AppText.password_error)
            return
        }

        if (!password.passwordMatches(uiState.value.repeatPassword)) {
            SnackbarManager.showMessage(AppText.password_match_error)
            return
        }

        if (checkIsEmpty(editTextArray).equals(true)) {
            SnackbarManager.showMessage(AppText.empty_fields)
            return
        }

        launchCatching {
            accountService.signUpUser(email, password)
            // TODO: add logic to complete signup and send user to home subject selection screen
        }
    }

    /**
     * Function to validate that an input has been put into each sign up editText field. Is called
     * in onSignUpClick().
     */
    private fun checkIsEmpty(textFields: ArrayList<String>) {
        for (item in textFields)
            if (item.isEmpty())
                return
    }
}