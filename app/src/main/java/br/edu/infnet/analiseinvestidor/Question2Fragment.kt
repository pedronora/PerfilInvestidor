package br.edu.infnet.analiseinvestidor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import br.edu.infnet.analiseinvestidor.databinding.FragmentQuestion2Binding

class Question2Fragment : Fragment() {
    private var _binding: FragmentQuestion2Binding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestion2Binding.inflate(inflater, container, false)

        val view = binding.root

        binding.avancarButton2.setOnClickListener {
            val pontos = onRadioButtonSelected()
            if (pontos >= 0) {
                pontoQ2 = pontos
                Navigation.findNavController(view).navigate(R.id.action_question2Fragment_to_question3Fragment) }
            }

        return view
    }

    private fun onRadioButtonSelected(): Int {
        var pontos = 0

        val checkedId = binding.radioGroup2.checkedRadioButtonId

        when (checkedId) {
            binding.rb2a.id -> pontos = 0
            binding.rb2b.id -> pontos = 2
            binding.rb2c.id -> pontos = 4
            binding.rb2d.id -> pontos = 5
            else -> {
                Toast.makeText(requireContext(), "Você deve selecionar uma resposta!", Toast.LENGTH_SHORT).show()
                return checkedId
            }
        }
        return pontos
    }
}