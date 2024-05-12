package com.KUN.okoasem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.KUN.okoasem.ui.theme.OkoaSemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OkoaSemTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.white)
                ) {
                    OkoaSem()
                }
            }
        }
    }
}

@Composable
fun TutorlyAppBar(

) {

}

@Composable
fun OkoaSem(

) {

}

@Preview(showBackground = true)
@Composable
fun TutorlyPreview() {
    OkoaSem()
}