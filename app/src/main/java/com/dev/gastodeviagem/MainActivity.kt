package com.dev.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.logging.Logger

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonCalculate.setOnClickListener(this)


    }

    override fun onClick(view: View) {

        val id = view.id
        if (id == R.id.buttonCalculate) {
            calculate()
        }
    }

    private fun calculate() {
        if (validationOk())
            try {
                val distance = editDistance.text.toString().toFloat()
                val price = editPrice.text.toString().toFloat()
                val autonomy = editAutonomy.text.toString().toFloat()

                val totalValue = (distance * price) / autonomy

                textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"
            } catch (e: Exception) {
                Toast.makeText(this, "Informe valores válidos", Toast.LENGTH_LONG).show()
            } else {
            Toast.makeText(this, "Preencha todos os campos corretamente", Toast.LENGTH_LONG).show()
        }

    }

    private fun validationOk(): Boolean {
        return (editDistance.text.toString() != ""
                && editPrice.text.toString() != ""
                && editAutonomy.text.toString() != ""
                && editAutonomy.text.toString() != "0"
                && editDistance.text.toString() != "0"
                && editPrice.text.toString() != "0")
    }


}
