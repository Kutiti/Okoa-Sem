package com.KUN.okoasem.ui.theme.screens.HomeScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
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
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = stringResource(R.string.hello), color = colorResource(id = R.color.black))
        //TODO: Add text composable with current user's name
        Spacer(modifier = Modifier.height(dimensionResource(id = androidx.appcompat.R.dimen.abc_switch_padding)))
        Card(
            modifier = modifier
                .padding(bottom = dimensionResource(id = androidx.appcompat.R.dimen.abc_switch_padding))
        ) {

        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}