package pmf.unsa.imunizacija

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import pmf.unsa.imunizacija.databinding.FragmentRegistration1Binding

class Registration1 : Fragment() {
    private lateinit var binding: FragmentRegistration1Binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_registration1, container, false)

        (activity as AppCompatActivity).supportActionBar?.title = "Prijava za vakcinaciju"

        val firstName = binding.etFirstName.text
        val lastName = binding.etLastName.text
        val jmbg = binding.etJmbg.text
        val tel = binding.etNumber.text
        val mail = binding.etEmail.text

        binding.forwardToRegistration2.setOnClickListener {view : View ->
               if(validation()){
                view.findNavController().navigate(Registration1Directions.actionRegistration1ToRegistration2(
                    firstName.toString(),
                    lastName.toString(),
                    jmbg.toString(),
                    tel.toString(),
                    mail.toString()
                ))
            }
        }

        return binding.root
    }



    fun validation(): Boolean {
        if(binding.etFirstName.text.isEmpty()){
            binding.etFirstName.setError("Polje ne može biti prazno")
            return false
        }
        else if (binding.etLastName.text.isEmpty()){
            binding.etLastName.setError("Polje ne može biti prazno")
            return false
        }
        else if (binding.etJmbg.text.isEmpty()){
            binding.etJmbg.setError("Polje ne može biti prazno")
            return false
        }
        else if (binding.etJmbg.text.length<13 || binding.etJmbg.text.length>13){
            binding.etJmbg.setError("JMBG mora sadržavati 13 znakova")
            return false
        }
        else if (binding.etNumber.text.isEmpty()){
            binding.etNumber.setError("Polje ne može biti prazno")
            return false
        }
        else if (binding.etEmail.text.isEmpty()){
            binding.etEmail.setError("Polje ne može biti prazno")
            return false
        }
        else if (!(android.util.Patterns.EMAIL_ADDRESS.matcher(binding.etEmail.text.toString()).matches())){
            binding.etEmail.setError("Neispravan format email adrese")
            return false
        }
        else if (!(binding.etEmailCheck.text.toString().equals(binding.etEmail.text.toString())) ){
            binding.etEmailCheck.setError("Niste unijeli identičnu email adresu")
            return false
        }
        else{
            return true
        }
    }

}