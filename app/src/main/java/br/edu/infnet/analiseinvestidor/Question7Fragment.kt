package br.edu.infnet.analiseinvestidor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import br.edu.infnet.analiseinvestidor.databinding.FragmentQuestion7Binding

class Question7Fragment : Fragment() {
    private var _binding: FragmentQuestion7Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestion7Binding.inflate(inflater, container, false)

        val view = binding.root

        binding.avancarButton7.setOnClickListener {
            val pontos = onRadioButtonSelected()
            if (pontos >= 0) {
                pontoQ7 = pontos
                Navigation.findNavController(view).navigate(R.id.action_Question7Fragment_to_question10Fragment)
            }
        }

        return view
    }

    private fun onRadioButtonSelected(): Int {
        var pontos = 0

        val checkedId = binding.radioGroup7.checkedRadioButtonId

        when (checkedId) {
            binding.rb7a.id -> pontos = 0
            binding.rb7b.id -> pontos = 1
            binding.rb7c.id -> pontos = 2
            binding.rb7d.id -> pontos = 4
            else -> {
                Toast.makeText(requireContext(), "Você deve selecionar uma resposta!", Toast.LENGTH_SHORT).show()
                return checkedId
            }
        }
        return pontos
    }
}