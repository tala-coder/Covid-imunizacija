package pmf.unsa.imunizacija

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import pmf.unsa.imunizacija.databinding.FragmentPfizerBinding

class Pfizer : Fragment() {

    private lateinit var binding: FragmentPfizerBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pfizer, container, false)

        (activity as AppCompatActivity).supportActionBar?.title = "Pfizer"

        return binding.root
    }
}