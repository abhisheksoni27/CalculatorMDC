package codeprose.calculatormdc

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.line_0.*
import kotlinx.android.synthetic.main.line_123.*
import kotlinx.android.synthetic.main.line_456.*
import kotlinx.android.synthetic.main.line_789.*
import kotlinx.android.synthetic.main.line_operators.*


class MainActivity : AppCompatActivity() {

    private var buttonListener: View.OnClickListener = View.OnClickListener { view ->

        var temp = input?.text

        if (view is MaterialButton) {
            input?.setText(temp.toString() + " " + view.text.toString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setClickListener()
    }

    private fun setClickListener() {
        val buttonsArray = listOf(divide_button, multiply_button, minus_button, plus_button, one_button, two_button, three_button, four_button, five_button, six_button, seven_button, eight_button, nine_button, zero_button)

        for (button in buttonsArray) {
            button.setOnClickListener(buttonListener)
        }

    }

}