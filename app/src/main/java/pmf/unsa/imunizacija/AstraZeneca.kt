package pmf.unsa.imunizacija

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import pmf.unsa.imunizacija.databinding.FragmentAstraZenecaBinding

class AstraZeneca : Fragment() {

    private lateinit var binding: FragmentAstraZenecaBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_astra_zeneca, container, false)

        (activity as AppCompatActivity).supportActionBar?.title = "AstraZeneca"

        return binding.root
    }
}
