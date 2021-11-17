package br.edu.infnet.analiseinvestidor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import br.edu.infnet.analiseinvestidor.databinding.FragmentQuestion3Binding

class Question3Fragment : Fragment() {
    private var _binding: FragmentQuestion3Binding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestion3Binding.inflate(inflater, container, false)

        val view = binding.root

        binding.avancarButton3.setOnClickListener {
            val pontos = onRadioButtonSelected()
            if (pontos >= 0) {
                pontoQ3 = pontos
                Navigation.findNavController(view).navigate(R.id.action_question3Fragment_to_question4Fragment) }
        }

        return view
    }

    private fun onRadioButtonSelected(): Int {
        var pontos = 0

        val checkedId = binding.radioGroup3.checkedRadioButtonId

        when (checkedId) {
            binding.rb3a.id -> pontos = 0
            binding.rb3b.id -> pontos = 1
            binding.rb3c.id -> pontos = 2
            binding.rb3d.id -> pontos = 4
            else -> {
                Toast.makeText(requireContext(), "Você deve selecionar uma resposta!", Toast.LENGTH_SHORT).show()
                return checkedId
            }
        }
        return pontos
    }
}