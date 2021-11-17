package br.edu.infnet.analiseinvestidor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import br.edu.infnet.analiseinvestidor.databinding.FragmentQuestion6Binding

class Question6Fragment : Fragment() {
    private var _binding: FragmentQuestion6Binding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestion6Binding.inflate(inflater, container, false)

        val view = binding.root

        binding.avancarButton6.setOnClickListener {
            val pontos = onRadioButtonSelected()
            if (pontos >= 0) {
                pontoQ6 = pontos
                Navigation.findNavController(view).navigate(R.id.action_question6Fragment_to_question7Fragment) }
            }

        return view
    }

    private fun onRadioButtonSelected(): Int {
        var pontos = 0

        val checkedId = binding.radioGroup6.checkedRadioButtonId

        when (checkedId) {
            binding.rb6a.id -> pontos = 0
            binding.rb6b.id -> pontos = 1
            binding.rb6c.id -> pontos = 2
            binding.rb6d.id -> pontos = 4
            else -> {
                Toast.makeText(requireContext(), "Você deve selecionar uma resposta!", Toast.LENGTH_SHORT).show()
                return checkedId
            }
        }
        return pontos
    }
}
