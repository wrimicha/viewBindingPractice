package sheridan.wrimicha.viewbindingpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import sheridan.wrimicha.viewbindingpractice.model.InputModel
import androidx.navigation.fragment.findNavController
import sheridan.wrimicha.viewbindingpractice.OutputFragment.Companion.INPUT_INFO
import sheridan.wrimicha.viewbindingpractice.databinding.FragmentInputBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class InputFragment : Fragment() {

    private lateinit var binding: FragmentInputBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInputBinding.inflate(inflater, container, false)
        binding.submitButton.setOnClickListener { showOutput() }
        return binding.root
    }

    private fun showOutput() {
        val petName = binding.petInput.text.toString().trim()
        val ownerName = binding.ownerInput.text.toString().trim()
        if(petName.isEmpty() || ownerName.isEmpty()){
            val required = getString(R.string.required)  //required is a string resource
            binding.petInput.error = required  //shows error message if isEmpty
        }else{
            val vaccinated = binding.vaccinatedCheck.isChecked
            val inputInfo = InputModel(petName, ownerName, vaccinated)
            val arguments = Bundle()
            arguments.putSerializable(INPUT_INFO, inputInfo)
            findNavController().navigate(R.id.action_input_to_output, arguments)
        }
    }
}