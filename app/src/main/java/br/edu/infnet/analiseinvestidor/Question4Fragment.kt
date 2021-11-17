package br.edu.infnet.analiseinvestidor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import br.edu.infnet.analiseinvestidor.databinding.FragmentQuestion4Binding

class Question4Fragment : Fragment() {
    private var _binding: FragmentQuestion4Binding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestion4Binding.inflate(inflater, container, false)

        val view = binding.root

        binding.avancarButton4.setOnClickListener {
            val pontos = onRadioButtonSelected()
            if (pontos >= 0) {
                pontoQ4 = pontos
                Navigation.findNavController(view).navigate(R.id.action_question4Fragment_to_question5Fragment)
            }
        }

        return view
    }

    private fun onRadioButtonSelected(): Int {
        var pontos = 0

        val checkedId = binding.radioGroup4.checkedRadioButtonId

        when (checkedId) {
            binding.rb4a.id -> pontos = 0
            binding.rb4b.id -> pontos = 2
            binding.rb4c.id -> pontos = 4
            else -> {
                Toast.makeText(requireContext(), "Você deve selecionar uma resposta!", Toast.LENGTH_SHORT).show()
                return checkedId
            }
        }
        return pontos
    }
}