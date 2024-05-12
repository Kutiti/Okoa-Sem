package com.KUN.okoasem.ui.theme.screens.Login

import androidx.compose.runtime.mutableStateOf
import com.KUN.okoasem.Model.Service.AccountService
import com.KUN.okoasem.ui.theme.screens.TutorFinderViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val accountService: AccountService
) : TutorFinderViewModel(){
    var uiState = mutableStateOf(LoginUiState())
        private set

    private val email
        get() = uiState.value.email
    private val password
        get() = uiState.value.password

    fun onEmailChange(valueChange: String) {
        uiState.value = uiState.value.copy(email = valueChange)
    }

    fun onPasswordChange(valueChange: String) {
        uiState.value = uiState.value.copy(password = valueChange)
    }

    fun onSignInClick(openAndPopUp: (String, String) -> Unit) {
        if (!email.isValidEmail()) {
            SnackbarManager.showMessage(AppText.email_error)
            return
        }

        if (password.isBlank()) {
            SnackbarManager.showMessage(AppText.empty_password_error)
            return
        }

        launchCatching {
            accountService.authenticate(email, password)
            // TODO: openAndPopUp( <!-- add locations here -->)
        }
    }

    fun onForgotPasswordClick() {
        // TODO: Add composable button for forgotten password

        if (!email.isValidEmail()) {
            SnackbarManager.showMessage(AppText.email_error)
            return
        }

        launchCatching {
            accountService.sendRecoveryEmail(email)
            SnackbarManager.showMessage(AppText.recovery_email_sent)
        }
    }
}