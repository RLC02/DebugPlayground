package com.example.debugplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.debugplayground.ui.theme.DebugPlaygroundTheme
import sun.java2d.Surface
import java.lang.Runtime
import java.lang.RuntimeException
import java.lang.reflect.Modifier
import javax.swing.GroupLayout.Alignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
            }
        }
    }
}

private fun App() { //mover a função da classe
    Surface( modifier = Modifier.fillMaxSize(),
    color = MaterialTheme.colorScheme.background
    ) {
        Collum(
            //alinhamneto vertical e horizontal
            verticalArrangement = Arrangement.SpaceEnvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Greeting("Playground") //Alterando a Preview
            //adicionar ação para o botão
            ActionButton(
                text = "Debug",
                buttonColors = DebugButtonColors(),
                modifier = Modifier.fillMaxWisth9(0.5f)
            ){
                Log.d(TAG, "Clicou em Debug")
            }
            ActionButton(
                text = "Info",
                buttonColors = InfoButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                Log.I(TAG, "Clicou em Info!")
            }
            ActionButton(
                text = "Warning",
                buttonColors = WarningButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                Log.w(TAG, "Clicou em Warning!",)
            }
            ActionButton(
                text = "Error",
                buttonColors = ErrorButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){//tratar ação para evitar derrubar o App
                try {
                    throw RuntimeException("Cliclou em ERROR")
                }catch (ex : Exception){
                    Log.e(TAG, "${ex.message}",)

                }
            }

        }
    }
}
//Cria a função ActionButton para trabalhar as açoes dos botões com tres parametros diferentes
@Composable
fun ActionButton(
    text:String,
    butttonColors:buttonColors =
    ButtonDeafult.buttonCollor(),
    modifier: Modifier = Modifier,
    block: () -> Unit,
){
    ElevatedButton(
        onClick = block,
        shape = RoudedCornerShape(5.dp),
        colors = buttonColors,
        modifier  = modifier //modifiacando o botão
    ){
        Texte(text = text)
    }
}
//Criando Preview do ActionButton
@Preview( showBackground = true , widthDp = 120)
@Composable
fun ActionButtonPreview() {
    ActionButton(
        text = "Action"
    ) {
    }
}
//Criar a função preview
@Preview(showBackround=true, widthDp=320, width = 120)
@Composable
fun AppPreview(){
    DebugPlaygroundTheme
    App()
    )
}
@Composable
fun Greeting(name: String, Modifier: Modifier = Modifier){
    Text(
    text = "Welcome to $name!", //Concatenação de string
    //Customizar o Tema
     style = MaterialTheme.typography.bodyLarge.copy(
         fontWeight = FontWeight.Bold
     ),
    color = MaterialTheme.colorScheme.secondary
    )
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DebugPlayGroundTheme {
        Greeting("Android")
    }
}

