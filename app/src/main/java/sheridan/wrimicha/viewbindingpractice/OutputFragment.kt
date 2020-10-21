package sheridan.wrimicha.viewbindingpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import sheridan.wrimicha.viewbindingpractice.databinding.FragmentOutputBinding
import sheridan.wrimicha.viewbindingpractice.model.InputModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class OutputFragment : Fragment() {

    companion object{
        const val INPUT_INFO = "input info"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOutputBinding.inflate(inflater, container, false)
        val inputInfo = arguments?.getSerializable(INPUT_INFO) as InputModel
        binding.petOutput.text = inputInfo.petName
        binding.ownerOutput.text = inputInfo.ownerName
        if(inputInfo.vaccinated){
            binding.vaccinatedOutput.text = "Yes"
        } else {
            binding.vaccinatedOutput.text = "No"
        }


        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_output_to_input)
        }
        return binding.root
    }
}