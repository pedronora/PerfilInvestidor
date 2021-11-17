package br.edu.infnet.analiseinvestidor

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.infnet.analiseinvestidor.databinding.ActivityResultadoBinding

class ResultadoActivity : AppCompatActivity() {

    lateinit var binding: ActivityResultadoBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nomeInvestidor.text = "Olá, $nome!"
        binding.perfilInvestidor.text = "O seu perfil de investidor é ${resultadoPerfil()}!"

        binding.reiniciarButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun resultadoPerfil(): String {
        val pontuacao: Int = pontoQ1 + pontoQ2 + pontoQ3 + pontoQ4 + pontoQ5 + pontoQ6 + pontoQ7 + pontoQ10 + pontoQ11
        if (pontuacao >= 30) {
            return "ARROJADO"
        } else if (pontuacao >= 13) {
            return "MODERADO" }
        return "CONSERVADOR"
    }
}