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

    private val TAG = "MainActivity"

    private fun isOperator(string: String): Boolean {
        if ("+,-,/,*".contains(string)) {
            return true
        }
        return false
    }

    private var buttonListener: View.OnClickListener = View.OnClickListener { view ->

        val temp = input?.text

        if (view is MaterialButton) {
            var finalResult = temp.toString()

            if (isOperator(view.text.toString())) {
                finalResult += " "
            }

            finalResult += view.text.toString()

            if (isOperator(view.text.toString())) {
                finalResult += " "
            }
            input?.setText(finalResult)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setClickListener()

        equal_to_button.setOnClickListener {
            val inputExpression = input.text.toString()
            if (inputExpression.isNotEmpty()) {
                val answer: Double = Calculator.solve(inputExpression)
                input.setText(answer.toString())
            }
        }

        del_button.setOnClickListener {
            input.setText(input?.text?.slice(IntRange(0, -1)))
        }
    }

    private fun setClickListener() {
        val buttonsArray = listOf(divide_button, multiply_button, minus_button, plus_button, one_button, two_button, three_button, four_button, five_button, six_button, seven_button, eight_button, nine_button, zero_button, dot_button)

        for (button in buttonsArray) {
            button.setOnClickListener(buttonListener)
        }

    }

}