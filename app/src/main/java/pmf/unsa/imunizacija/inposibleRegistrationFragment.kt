package pmf.unsa.imunizacija

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_inposible_registration.*
import pmf.unsa.imunizacija.databinding.FragmentInposibleRegistrationBinding


class inposibleRegistrationFragment : Fragment() {
    private lateinit var binding: FragmentInposibleRegistrationBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_inposible_registration, container, false)


        val args = inposibleRegistrationFragmentArgs.fromBundle(requireArguments())

        val textstring = "ime: ${args.firstName}," +
                " prezime: ${args.lastName}, " +
                "jmbg: ${args.jmbg}, " +
                "tel: ${args.tel}, " +
                "mail: ${args.mail}," +
                " grad: ${args.city}," +
                " godina rodenja: ${args.year}, "+
                " kanton: ${args.canton}, "+
                " prepreka: ${args.barrier}, "

        binding.btnBackToHome.setOnClickListener {
            findNavController().navigate(R.id.action_inposibleRegistrationFragment_to_nav_home)
        }

        binding.btnTranslate.setOnClickListener {
            translateText()
        }

        return binding.root
    }

    private fun translateText() {
        if(btn_translate.text.equals("EN")){

            inposible_info.setText (R.string.barrier_info_eng)
            btnBackToHome.setText  (R.string.back_to_home_eng)
            btn_translate.text = "BiH"
        }
        else if(btn_translate.text.equals("BiH")){
            inposible_info.setText (R.string.barrier_info)
            btnBackToHome.setText  (R.string.back_to_home)
            btn_translate.text = "EN"

        }
    }

    override fun onStart() {
        super.onStart()
        (activity as AppCompatActivity).supportActionBar?.title = "Prijava za vakcinaciju"
    }
}


