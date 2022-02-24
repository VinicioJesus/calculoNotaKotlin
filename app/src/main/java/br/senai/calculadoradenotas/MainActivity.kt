package br.senai.calculadoradenotas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.*

private lateinit var nomeEditText: EditText
private lateinit var nota1EditText:EditText
private lateinit var nota2EditText: EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultado = findViewById<TextView>(R.id.resultado)
        val calcular = findViewById(R.id.calcular) as Button
        val cancelar = findViewById<Button>(R.id.fechar)

        calcular.setOnClickListener {
            nomeEditText = findViewById(R.id.nome)
            nota1EditText = findViewById(R.id.nota1)
            nota2EditText = findViewById(R.id.nota2)

            if (validarCampos()) {
                val nota1 = nota1EditText.text.toString().toInt()
                val nota2 = nota2EditText.text.toString().toInt()

                val media = calcularMedia(nota1, nota2)

                val intent = intent(this, relatorio_activity::class.java)

                intent.putExtra(nome,"nome", nomeEditText.text.toString())
                intent.putExtra(name,"nota1", value"${nota1}" )
                intent.putExtra(name,"nota2", value"${nota2}" )

                intent.putExtra(name,"situacao", situacaoAluno(media) )

                startActivity(intent)

                resultado.text = situacaoAluno(media)
            }
     }

        cancelar.setOnClickListener {
            finish()
        }

    }

    private fun validarCampos(): Boolean {
        var noError = true
        if (nomeEditText.text.isBlank()){
            nomeEditText.setError("Digite seu nome!")
            noError = false
        }
        if (nota1EditText.text.isBlank()){
            nota1EditText.setError("Digite a sua nota 1")
            noError = false
        }
        if (nota2EditText.text.isBlank()){
            nota2EditText.setError("Digite a sua nota 2")
            noError = false
        }

        return noError
    }
}