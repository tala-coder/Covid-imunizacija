package pmf.unsa.imunizacija

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import pmf.unsa.imunizacija.databinding.FragmentVaccineSelectionBinding

class VaccineSelection : Fragment() {
    private lateinit var binding: FragmentVaccineSelectionBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_vaccine_selection, container, false)

        (activity as AppCompatActivity).supportActionBar?.title = "Izbor vakcine"

        val args = VaccineSelectionArgs.fromBundle(requireArguments())

        binding.forwardToFinalForm.setOnClickListener { view: View ->
            val vaccine = binding.tvVacc.text
            if (validationVac()) {
                view.findNavController().navigate(
                    VaccineSelectionDirections.actionVaccineSelectionToItemFragment(
                        args.firstName,
                        args.lastName,
                        args.jmbg,
                        args.tel,
                        args.mail,
                        args.city,
                        args.year,
                        args.canton,
                        args.barrier,
                        args.priority,
                        vaccine.toString()
                    )
                )
            }

        }

        binding.pfizer.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_vaccineSelection_to_pfizer2)
        }

        binding.astraZeneca.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_vaccineSelection_to_astraZeneca2)
        }

        binding.sputnikV.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_vaccineSelection_to_sputnikV2)
        }


        val arrItems = arrayOf("Pfizer", "AstraZeneca", "SputnikV")
        binding.tvVacc.setOnClickListener {
            this.context?.let { it1 ->
                MaterialAlertDialogBuilder(it1)
                    .setItems(arrItems) { _, which ->
                        when (which) {
                            0 -> view?.let { list(arrItems[0]) }
                            1 -> view?.let { list(arrItems[1]) }
                            2 -> view?.let { list(arrItems[2]) }
                        }
                    }.show()
            }
        }

        return binding.root
    }

    private fun validationVac(): Boolean {

        if (binding.tvVacc.text.equals("Lista vakcina")) {
            binding.tvVacc.error = "Morate izabrati neku od ponuđenih vakcina"
            return false
        }
        return true
    }

    private fun list(msg: String) {
        binding.tvVacc.text = msg
    }

}