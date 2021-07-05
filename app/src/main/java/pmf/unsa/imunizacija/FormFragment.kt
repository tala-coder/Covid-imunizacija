package pmf.unsa.imunizacija

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import pmf.unsa.imunizacija.databinding.FragmentFormBinding

class FormFragment : Fragment() {

    private lateinit var binding: FragmentFormBinding
    lateinit var registeredUsers: RegisteredUsers
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_form, container, false)
        registeredUsers = RegisteredUsers(this.lifecycle)


        (activity as AppCompatActivity).supportActionBar?.title = ""

        val h = Handler()
        val r: Runnable = object : Runnable{
            override fun run() {

                var CounterNum = Integer.parseInt(binding.idCounter.getText().toString());
                CounterNum=CounterNum+1
//                binding.idCounter.setText(CounterNum.toString())
                binding.idCounter.setText(CounterNum.toString())
                h.postDelayed(this, 5000)
            }
        }
        h.postDelayed(r, 1000)


        val args = FormFragmentArgs.fromBundle(requireArguments())


        location(args.canton.toString())
        term()
        day()

        binding.idFirstName.setText(args.firstName).toString()
        binding.idLastName.setText(args.lastName)
        binding.idJmbg.setText(args.jmbg)
        binding.idNumber.setText(args.tel).toString()
        binding.idEmail.setText(args.mail)
        binding.idCity.setText(args.city)
        binding.idDob.setText(args.year)
        binding.idVacc.setText(args.vaccine)

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun day() {
        val randomInt = (3..8).random()

        binding.idDay.setText(""+randomInt+" dana u")
    }

    private fun term() {
        val randomInt = (0..10).random()

        val arrItems= arrayOf("10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30","14:00","14:30","15:00")

        binding.idTerm.text=arrItems[randomInt]
    }

    private fun location(canton: String) {
        if (canton=="Unsko-sanski kanton")
            binding.idLocation.text="Opća bolnica Sanski Most"
        else if (canton=="Posavski kanton")
            binding.idLocation.text="Županijska Bolnica Orašje"
        else if (canton=="Tuzlanski kanton")
            binding.idLocation.text="Klinički centar Tuzla"
        else if (canton=="Zeničko-dobojski kanton")
            binding.idLocation.text="Gradska arena Zenica"
        else if (canton=="Bosansko-podrinjski kanton")
            binding.idLocation.text="Kantonalna bolnica Goražde"
        else if (canton=="Srednjobosanski kanton")
            binding.idLocation.text="Kantonalna bolnica Travnik"
        else if (canton=="Hercegovačko-neretvanski kanton")
            binding.idLocation.text="Opća bolnica Konjic"
        else if (canton=="Zapadnohercegovački kanton")
            binding.idLocation.text="Dom zdravlja Široki Brijeg"
        else if (canton=="Kanton Sarajevo")
            binding.idLocation.text="Olimpijska dvorana Zetra"
        else if (canton=="Kanton 10")
            binding.idLocation.text="Županijska bolnica Livno"
    }


    private fun getShareIntent() : Intent {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.share_text))
        return shareIntent
    }

    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.share_menu, menu)

        if (null == getShareIntent().resolveActivity(requireActivity().packageManager)) {
            menu.findItem(R.id.share)?.isVisible = false
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }

}