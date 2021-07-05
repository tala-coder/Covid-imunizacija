package pmf.unsa.imunizacija

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import pmf.unsa.imunizacija.databinding.FragmentPriorityGroupsBinding


class PriorityGroups : Fragment() {
    private lateinit var binding: FragmentPriorityGroupsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_priority_groups, container, false)

        (activity as AppCompatActivity).supportActionBar?.title = "Prioritetne grupe"

        val args = PriorityGroupsArgs.fromBundle(requireArguments())

        val priorityGroupsString = binding.pgCheckboxText.text
        binding.forwardToVaccSelection.setOnClickListener {view : View ->
            if (fieldCheck()){
                view.findNavController().navigate(PriorityGroupsDirections.actionPriorityGroupsToVaccineSelection(
                    args.firstName,
                    args.lastName,
                    args.jmbg,
                    args.tel,
                    args.mail,
                    args.city,
                    args.year,
                    args.canton,
                    args.barrier,
                    priorityGroupsString.toString()
                ))
            }

            else{
                binding.pgHiddenField.text=""
                binding.pgHiddenField.visibility=View.VISIBLE
                binding.pgHiddenField.setError("")
                binding.pgHiddenField.text="Morate označiti neku od ponuđenih opcija."
            }
        }


        binding.rbFirst.setOnCheckedChangeListener{buttonView, isChecked ->
            if (isChecked){
                binding.pgCheckboxText.text=binding.rbFirst.text
            }
        }

        binding.rbSecond.setOnCheckedChangeListener{buttonView, isChecked ->
            if (isChecked){
                binding.pgCheckboxText.text=binding.rbSecond.text
            }
        }

        binding.rbThird.setOnCheckedChangeListener{buttonView, isChecked ->
            if (isChecked){
                binding.pgCheckboxText.text=binding.rbThird.text
            }
        }

        binding.rbFourth.setOnCheckedChangeListener{buttonView, isChecked ->
            if (isChecked){
                binding.pgCheckboxText.text=binding.rbFourth.text
            }
        }

        binding.rbNone.setOnCheckedChangeListener{buttonView, isChecked ->
            if (isChecked){
                binding.pgCheckboxText.text=binding.rbNone.text
            }
        }
        return binding.root
    }

    private fun fieldCheck(): Boolean {
        if (binding.rbFirst.isChecked || binding.rbSecond.isChecked || binding.rbThird.isChecked|| binding.rbFourth.isChecked|| binding.rbNone.isChecked ){
            return true
        }
        return false
    }
}