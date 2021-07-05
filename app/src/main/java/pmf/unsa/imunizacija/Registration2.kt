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
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.fragment_registration2.*
import pmf.unsa.imunizacija.databinding.FragmentRegistration2Binding
import java.util.*

const val KEY_CANTON = ""

class Registration2 : Fragment() {
    lateinit var year: String
    var dateCheck=false

    private lateinit var binding: FragmentRegistration2Binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_registration2, container, false)

        (activity as AppCompatActivity).supportActionBar?.title = "Prijava za vakcinaciju"

        if (savedInstanceState != null) {
            binding.tvCantons.text = savedInstanceState.getString(KEY_CANTON, "")
        }


        val args = Registration2Args.fromBundle(requireArguments())
        val datePicker = binding.dob
        val today = Calendar.getInstance()

        datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH)) { view, year, month, day ->
            dateCheck=true

            val month = month + 1
            this.year = "$day/$month/$year"

            Toast.makeText(this.context, this.year, Toast.LENGTH_SHORT).show()
        }

        binding.forwardToCheckingPoss.setOnClickListener {view : View ->
            if(validationGender() && validationDate()&& validationCity() && validationCanton()){
                val city = binding.city.text
                val canton = binding.tvCantons.text.toString()

                view.findNavController().navigate(Registration2Directions.actionRegistration2ToCheckingPossibilities(
                    args.firstName,
                    args.lastName,
                    args.jmbg,
                    args.tel,
                    args.mail,
                    city.toString(),
                    year,
                    canton
                ))
            }
        }


        val arrItems= arrayOf("Unsko-sanski kanton","Posavski kanton","Tuzlanski kanton","Zeničko-dobojski kanton","Bosansko-podrinjski kanton","Srednjobosanski kanton","Hercegovačko-neretvanski kanton","Zapadnohercegovački kanton","Kanton Sarajevo","Kanton 10")
        binding.tvCantons.setOnClickListener{
            this.context?.let { it1 ->
                MaterialAlertDialogBuilder(it1)
                    .setItems(arrItems){_,which ->
                        when(which){
                            0-> view?.let { it2 -> list(it2,"${arrItems[0]}") }
                            1-> view?.let { it2 -> list(it2,"${arrItems[1]}") }
                            2-> view?.let { it2 -> list(it2,"${arrItems[2]}") }
                            3-> view?.let { it2 -> list(it2,"${arrItems[3]}") }
                            4-> view?.let { it2 -> list(it2,"${arrItems[4]}") }
                            5-> view?.let { it2 -> list(it2,"${arrItems[5]}") }
                            6-> view?.let { it2 -> list(it2,"${arrItems[6]}") }
                            7-> view?.let { it2 -> list(it2,"${arrItems[7]}") }
                            8-> view?.let { it2 -> list(it2,"${arrItems[8]}") }
                            9-> view?.let { it2 -> list(it2,"${arrItems[9]}") }
                        }
                    }.show()
            }
        }
        return binding.root
    }

    fun validationDate(): Boolean{
        if(!dateCheck){
            Toast.makeText(this.context, "Morate odabrati datum", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    fun validationCanton(): Boolean{
        if(binding.tvCantons.text.equals("Lista kantona")){
            binding.tvCantons.setError("Morate izabrati kanton")
            return false
        }
        return true
    }

    fun validationGender(): Boolean {
        if(binding.rbMale.isChecked || binding.rbFemale.isChecked){
            binding.hideField.visibility=View.GONE
            return true
        }
        else{
            binding.hideField.visibility=View.VISIBLE
            binding.hideField.setError("")
            binding.hideField.text="Morate odabrati spol"
            return false
        }
    }

    fun validationCity(): Boolean {
        if(binding.city.text.isEmpty()){
            binding.city.setError("Unesite ime grada")
            return false
        }
        return true
    }

    private fun list(view: View,msg: String){
        binding.tvCantons.setText(msg)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString(KEY_CANTON, binding.tvCantons.text.toString())
    }

}