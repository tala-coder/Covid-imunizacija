package pmf.unsa.imunizacija.onboarding.screens


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_view_pager.*
import pmf.unsa.imunizacija.R
import pmf.unsa.imunizacija.databinding.FragmentFirstScreenBinding


class FirstScreen : Fragment() {
    private lateinit var binding: FragmentFirstScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first_screen, container, false)

        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(false)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as AppCompatActivity).supportActionBar?.title = "Budimo odgovorni"

       val viewPager =  activity?.viewPager

        binding.next1.setOnClickListener {
            viewPager?.currentItem = 1
        }

        return binding.root
    }
}