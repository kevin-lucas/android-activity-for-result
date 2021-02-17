package dev.kevinlucas.androidactivityforresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    companion object CONSTANTES {
        val TELA1 = 1
        val TELA2 = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun enviarDadosTela1(view: View?) {
        val nome = findViewById<EditText>(R.id.nome)
        val email = findViewById<EditText>(R.id.email)

        val intent = Intent(this, Tela1::class.java)

        val params = Bundle()
        params.putString("nome", nome.text.toString())
        params.putString("email", email.text.toString())

        intent.putExtras(params)

        startActivityForResult(intent, TELA1)
    }

    fun enviarDadosTela2(view: View?) {
        val nome = findViewById<EditText>(R.id.nome)
        val email = findViewById<EditText>(R.id.email)

        val params = Bundle()
        params.putString("nome", nome.text.toString())
        params.putString("email", email.text.toString())

        val intent = Intent(this, Tela2::class.java)

        intent.putExtras(params)

        startActivityForResult(intent, TELA2)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == TELA1) {
            val params = data?.extras
            if (params != null) {
                val msg = params.getString("msg")
                Toast.makeText(
                    this,
                    "Tela 1 -> Resultado $resultCode | Msg: $msg",
                    Toast.LENGTH_LONG
                ).show()
            }
        } else if (requestCode == TELA2) {
            val params = data?.extras
            if (params != null) {
                val msg = params.getString("msg")
                Toast.makeText(
                    this,
                    "Tela 2 -> Resultado $resultCode | Msg: $msg",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}