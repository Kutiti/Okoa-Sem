package com.KUN.okoasem.ui.theme.screens.SubjectSelection

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SubjectSelectionViewModel : ViewModel() {
    var uiState = mutableStateOf(SubjectSelectionUiState())
        private set


}