package br.edu.infnet.analiseinvestidor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import br.edu.infnet.analiseinvestidor.databinding.FragmentQuestion5Binding

class Question5Fragment : Fragment() {
    private var _binding: FragmentQuestion5Binding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestion5Binding.inflate(inflater, container, false)

        val view = binding.root

        binding.avancarButton5.setOnClickListener {
            val pontos = onRadioButtonSelected()
            if (pontos >= 0) {
                pontoQ5 += pontos
                Navigation.findNavController(view).navigate(R.id.action_question5Fragment_to_question6Fragment) }
            }

        return view
    }

    private fun onRadioButtonSelected(): Int {
        var pontos = 0

        val checkedId = binding.radioGroup5.checkedRadioButtonId

        when (checkedId) {
            binding.rb5a.id -> pontos = 0
            binding.rb5b.id -> pontos = 2
            binding.rb5c.id -> pontos = 4
            else -> {
                Toast.makeText(requireContext(), "Você deve selecionar uma resposta!", Toast.LENGTH_SHORT).show()
                return checkedId
            }
        }
        return pontos
    }
}