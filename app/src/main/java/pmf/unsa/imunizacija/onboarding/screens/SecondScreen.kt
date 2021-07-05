package pmf.unsa.imunizacija.onboarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_view_pager.*
import pmf.unsa.imunizacija.R
import pmf.unsa.imunizacija.databinding.FragmentSecondScreenBinding


class SecondScreen : Fragment() {
    private lateinit var binding: FragmentSecondScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second_screen, container, false)

        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(false)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as AppCompatActivity).supportActionBar?.title = "Budimo odgovorni"

        val viewPager = activity?.viewPager

        binding.next2.setOnClickListener {
            viewPager?.currentItem = 2
        }
        return binding.root
    }
}