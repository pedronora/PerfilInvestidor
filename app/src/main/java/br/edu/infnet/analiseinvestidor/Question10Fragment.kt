package br.edu.infnet.analiseinvestidor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import br.edu.infnet.analiseinvestidor.databinding.FragmentQuestion10Binding

class Question10Fragment : Fragment() {
    private var _binding: FragmentQuestion10Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestion10Binding.inflate(inflater, container, false)

        val view = binding.root

        binding.avancarButton10.setOnClickListener {
            val pontos = onRadioButtonSelected()
            if (pontos >= 0) {
                pontoQ10 = pontos
                Navigation.findNavController(view).navigate(R.id.action_question10Fragment_to_question11Fragment)
            }
        }

        return view
    }

    private fun onRadioButtonSelected(): Int {
        var pontos = 0

        val checkedId = binding.radioGroup10.checkedRadioButtonId

        when (checkedId) {
            binding.rb10a.id -> pontos = 0
            binding.rb10b.id -> pontos = 1
            binding.rb10c.id -> pontos = 2
            binding.rb10d.id -> pontos = 4
            else -> {
                Toast.makeText(requireContext(), "Você deve selecionar uma resposta!", Toast.LENGTH_SHORT).show()
                return checkedId
            }
        }
        return pontos
    }
}