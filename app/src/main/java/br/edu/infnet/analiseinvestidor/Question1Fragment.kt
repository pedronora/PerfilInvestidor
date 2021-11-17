package br.edu.infnet.analiseinvestidor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import br.edu.infnet.analiseinvestidor.databinding.FragmentQuestion1Binding

class Question1Fragment : Fragment() {

    private var _binding: FragmentQuestion1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestion1Binding.inflate(inflater, container, false)

        val view = binding.root

        binding.avancarButton1.setOnClickListener {
            val pontos = onRadioButtonSelected()
            if (pontos >= 0) {
                pontoQ1 = pontos

                Navigation.findNavController(view)
                    .navigate(R.id.action_question1Fragment_to_question2Fragment)
            }
        }

        return view
    }

    private fun onRadioButtonSelected(): Int {
        var pontos = 0

        val checkedId = binding.radioGroup1.checkedRadioButtonId

        when (checkedId) {
            binding.rb1a.id -> pontos = 0
            binding.rb1b.id -> pontos = 2
            binding.rb1c.id -> pontos = 3
            binding.rb1d.id -> pontos = 4
            else -> {
                Toast.makeText(requireContext(), "Você deve selecionar uma resposta!", Toast.LENGTH_SHORT).show()
                return checkedId
            }
        }
        return pontos
    }
}