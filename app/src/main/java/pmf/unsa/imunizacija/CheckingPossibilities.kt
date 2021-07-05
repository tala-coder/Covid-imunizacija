package pmf.unsa.imunizacija

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_checking_possibilities.*
import kotlinx.android.synthetic.main.fragment_inposible_registration.*
import kotlinx.android.synthetic.main.fragment_inposible_registration.btn_translate
import pmf.unsa.imunizacija.databinding.FragmentCheckingPossibilitiesBinding

class CheckingPossibilities : Fragment() {
    private lateinit var barrierstr: String
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentCheckingPossibilitiesBinding>(inflater, R.layout.fragment_checking_possibilities, container, false)

        (activity as AppCompatActivity).supportActionBar?.title = "Postojanje prepreke"

        val args = CheckingPossibilitiesArgs.fromBundle(requireArguments())
        barrierstr=binding.cbNone.text.toString()

        binding.forwardToPriorityGroups.setOnClickListener {view : View ->
            if (binding.cbNone.isChecked){

                view.findNavController().navigate(CheckingPossibilitiesDirections.actionCheckingPossibilitiesToPriorityGroups(
                    args.firstName,
                    args.lastName,
                    args.jmbg,
                    args.tel,
                    args.mail,
                    args.city,
                    args.year,
                    args.canton,
                    barrierstr
                ))
            }else if (binding.cbFirst.isChecked || binding.cbSecond.isChecked || binding.cbThird.isChecked){

                view.findNavController().navigate(CheckingPossibilitiesDirections.actionCheckingPossibilitiesToInposibleRegistrationFragment(
                    args.firstName,
                    args.lastName,
                    args.jmbg,
                    args.tel,
                    args.mail,
                    args.city,
                    args.year,
                    args.canton,
                    barrierstr
                ))
            }

            else{
                binding.cpCheckboxText.text=""
                binding.cpHiddenField.visibility=View.VISIBLE
                binding.cpHiddenField.setError("")
                binding.cpHiddenField.text="Morate označiti neku od ponuđenih opcija."
            }
        }

        binding.cbFirst.setOnCheckedChangeListener{buttonView, isChecked ->
            if (isChecked){
                false.also {
                    binding.cbNone.isChecked = it
                }
                binding.cpCheckboxText.text=binding.cbFirst.text
                binding.cpHiddenField.visibility=View.GONE
            }
        }

        binding.cbSecond.setOnCheckedChangeListener{buttonView, isChecked ->
            if (isChecked){
                false.also {
                    binding.cbNone.isChecked = it
                }
                binding.cpCheckboxText.text=binding.cbSecond.text
                binding.cpHiddenField.visibility=View.GONE
            }
        }

        binding.cbThird.setOnCheckedChangeListener{buttonView, isChecked ->
            if (isChecked){
                false.also {
                    binding.cbNone.isChecked = it
                }
                binding.cpCheckboxText.text=binding.cbThird.text
                binding.cpHiddenField.visibility=View.GONE
            }
        }

        binding.cbNone.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){

                false.also {
                    binding.cbFirst.isChecked = it;
                    binding.cbSecond.isChecked=it;
                    binding.cbThird.isChecked=it;
                    binding.cbNone.isChecked=!it
                }
                binding.cpCheckboxText.text=binding.cbNone.text
                binding.cpHiddenField.visibility=View.GONE
            }
        }

        binding.btnTranslate.setOnClickListener {
            translateText()
        }

        return binding.root
    }

    private fun translateText() {
        if(btn_translate.text.equals("EN")){
            cb_first.setText (R.string.barrier1_eng)
            cb_second.setText  (R.string.barrier2_eng)
            cb_third.setText  (R.string.barrier3_eng)
            cb_none.setText  (R.string.barrier_else_eng)
            btn_translate.text = "BiH"
        }
        else if(btn_translate.text.equals("BiH")){
            cb_first.setText (R.string.barrier1)
            cb_second.setText  (R.string.barrier2)
            cb_third.setText  (R.string.barrier3)
            cb_none.setText  (R.string.barrier_else)
            btn_translate.text = "EN"

        }
    }
}