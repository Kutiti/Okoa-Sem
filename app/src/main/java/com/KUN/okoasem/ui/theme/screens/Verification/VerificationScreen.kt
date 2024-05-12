package com.KUN.okoasem.ui.theme.screens.Verification

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.KUN.okoasem.R

@Composable
fun VerificationScreen(
    modifier: Modifier = Modifier,
    emailInput: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.verification_text),
            color = colorResource(id = R.color.black)
        )
        Row(
            modifier = Modifier
                .padding(top = dimensionResource(id = androidx.appcompat.R.dimen.abc_switch_padding)),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = stringResource(R.string.verification_email_lead) +" ",
                color = colorResource(id = R.color.black)
            )
            Text(text = emailInput,
                color = colorResource(id = R.color.white)) // User email address from signup
        }
        Button(
            modifier = Modifier
                .padding(bottom = dimensionResource(id = androidx.appcompat.R.dimen.abc_switch_padding),
                    top = dimensionResource(id = androidx.appcompat.R.dimen.abc_switch_padding)),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.white),
            ),
            onClick = { /*TODO: Send verification email using Firebase*/ }
        ) {
            Text(text = stringResource(R.string.button_verification_email))
        }
    }
}

@Preview
@Composable
fun VerificationScreenPreview() {
    VerificationScreen(emailInput = "brianlui36@gmail.com.com")
}