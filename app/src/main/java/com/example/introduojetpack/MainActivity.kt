package com.example.introduojetpack

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.introduojetpack.ui.theme.DebugButtonColor
import com.example.introduojetpack.ui.theme.ErrorButtonColor
import com.example.introduojetpack.ui.theme.InfoButtonColor
import com.example.introduojetpack.ui.theme.IntroduçãoJetPackTheme
import com.example.introduojetpack.ui.theme.Pink40
import com.example.introduojetpack.ui.theme.WarningButtonColor

const val TAG = "TestAndroid"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App(){
    IntroduçãoJetPackTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Greeting("JetPack")
                ActionButton(text = "Debug",
                    buttonColors = DebugButtonColor(),
                    modifier = Modifier.fillMaxWidth(0.8f)) { //
                    Log.d(TAG, "APP, clicou em debug")
                }
                ActionButton(text = "Info",
                    buttonColors = InfoButtonColor(),
                    modifier = Modifier.fillMaxWidth(0.8f)) {
                    Log.i(TAG, "APP, clicou em debug")
                }
                ActionButton(text = "Warning",
                    buttonColors = WarningButtonColor(),
                    modifier = Modifier.fillMaxWidth(0.8f)) {
                    Log.w(TAG, "APP, clicou em debug")
                }
                ActionButton(text = "Error",
                    buttonColors = ErrorButtonColor(),
                    modifier = Modifier.fillMaxWidth(0.8f)) {
                    try{
                        throw RuntimeException("Clicou em error!")
                    }catch (ex: Exception){
                        Log.e(TAG, "${ex.message}")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 150, heightDp = 300)
@Composable
fun appPreview(){
    App()
}

@Composable
fun ActionButton(
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
){
    ElevatedButton(
        onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
        modifier = modifier
    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable()
fun ActionButtonPreview(){
    ActionButton(text = "Cadastrar") {
        
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
