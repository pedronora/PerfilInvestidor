package br.edu.infnet.analiseinvestidor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import br.edu.infnet.analiseinvestidor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//      Desabilita o modo noturno
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.avancarButton.setOnClickListener() {
            nome = binding.inputEditedText.text.toString().trim()

            if (nome.isEmpty()) {
                Toast.makeText(applicationContext, "Informe o seu nome para continuar!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, QuestionsActivity::class.java)
                startActivity(intent)
            }
        }
    }
}