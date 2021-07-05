package pmf.unsa.imunizacija.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import pmf.unsa.imunizacija.R
import pmf.unsa.imunizacija.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_nav_home_to_registration1)
        }
        binding.button2.setOnClickListener {
            findNavController().navigate(R.id.action_nav_home_to_nav_question)
        }
        binding.button3.setOnClickListener {
            findNavController().navigate(R.id.action_nav_home_to_nav_about_apk)
        }

        return binding.root
    }
}


