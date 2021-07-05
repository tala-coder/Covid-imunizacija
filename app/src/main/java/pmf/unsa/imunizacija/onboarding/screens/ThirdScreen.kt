package pmf.unsa.imunizacija.onboarding.screens

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import pmf.unsa.imunizacija.R
import pmf.unsa.imunizacija.databinding.FragmentThirdScreenBinding

class ThirdScreen : Fragment() {
    private lateinit var binding: FragmentThirdScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_third_screen, container, false)

        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(false)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as AppCompatActivity).supportActionBar?.title = "Budimo odgovorni"

        binding.next3.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_nav_home)
            onBoardingFinished()
        }
        boldNumber()
        return binding.root
    }

    private fun boldNumber() {
        val textView = binding.textView5
        val wordtoSpan: Spannable = SpannableString("254.183 Osoba se vakcinisalo, a vi?")

        wordtoSpan.setSpan(ForegroundColorSpan(Color.DKGRAY), 0, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.text = wordtoSpan
    }

    private fun onBoardingFinished() {
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }
}