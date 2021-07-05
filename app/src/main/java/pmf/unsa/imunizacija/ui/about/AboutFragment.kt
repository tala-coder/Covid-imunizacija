package pmf.unsa.imunizacija.ui.about

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import pmf.unsa.imunizacija.R


class AboutFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_about_apk, container, false)
        val textView: TextView = root.findViewById(R.id.textView16)

        val wordtoSpan: Spannable = SpannableString("Detaljni opis aplikacije možete vidjeti na ovom LINKU.")
        wordtoSpan.setSpan(
            ForegroundColorSpan(Color.BLUE),
            48,
            53,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        wordtoSpan.setSpan(UnderlineSpan(), 48, 53, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.text = wordtoSpan

        textView.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://hackmd.io/@elmedins/SkZFMKg8O"))
            startActivity(i)
        }
        return root
    }

}