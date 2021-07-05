package pmf.unsa.imunizacija
import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import pmf.unsa.imunizacija.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_splash, container, false)

        Handler().postDelayed({
            if(onBoardingFinished()){
                findNavController().navigate(R.id.action_splashFragment_to_nav_home)
            }else{
                findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
            }
        }, 3000)

        return binding.root
    }
    private fun onBoardingFinished(): Boolean{
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished", false)
    }
}