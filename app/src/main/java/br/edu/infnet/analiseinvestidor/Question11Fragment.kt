package br.edu.infnet.analiseinvestidor

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.edu.infnet.analiseinvestidor.databinding.FragmentQuestion11Binding

class Question11Fragment : Fragment() {
    private var _binding: FragmentQuestion11Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestion11Binding.inflate(inflater, container, false)

        val view = binding.root

        binding.avancarButton11.setOnClickListener {
            val pontos = onRadioButtonSelected()
            if (pontos >= 0) {
                pontoQ11 = pontos

                val intent = Intent(requireContext(), ResultadoActivity::class.java)
                startActivity(intent)
            }
        }

        return view
    }

    private fun onRadioButtonSelected(): Int {
        var pontos = 0

        val checkedId = binding.radioGroup11.checkedRadioButtonId

        when (checkedId) {
            R.id.rb11a -> pontos = 0
            R.id.rb11b -> pontos = 1
            R.id.rb11c -> pontos = 2
            R.id.rb11d -> pontos = 4
            R.id.rb11e -> pontos = 5
            else -> {
                Toast.makeText(requireContext(), "Você deve selecionar uma resposta!", Toast.LENGTH_SHORT).show()
                return checkedId
            }
        }
        return pontos
    }
}