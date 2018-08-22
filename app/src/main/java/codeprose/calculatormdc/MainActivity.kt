package codeprose.calculatormdc

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton


class MainActivity : AppCompatActivity() {

    private var mInput: EditText? = null

    private var divideButton: MaterialButton?= null
    private var mulitplyButton: MaterialButton?= null
    private var minusButton: MaterialButton?= null
    private var plusButton: MaterialButton?= null

    private var buttonListener: View.OnClickListener = View.OnClickListener {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mInput = findViewById(R.id.input)
    }

}