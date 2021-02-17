package dev.kevinlucas.androidactivityforresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class Tela1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela1)

        val intent = intent
        if (intent != null) {

            val params = intent.extras

            if (params != null) {
                val nome = params.getString("nome")
                val email = params.getString("email")

                val nomeTexto = findViewById<TextView>(R.id.textoNomeTela1)
                val emailTexto = findViewById<TextView>(R.id.textoEmailTela1)

                nomeTexto.text = "Nome: $nome"
                emailTexto.text = "Email: $email"
            }

        }
    }

    fun aceitou(view: View?) {
        val intent = Intent()
        intent.putExtra("msg", "Aceitou")

        setResult(1, intent)

        finish()
    }

    fun rejeitou(view: View?) {
        val intent = Intent()
        intent.putExtra("msg", "Rejeitou")

        setResult(2, intent)

        finish()
    }
}