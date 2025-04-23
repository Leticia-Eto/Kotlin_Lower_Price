package com.example.produtomaisbarato12300241

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.produtomaisbarato12300241.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fun calcularPrecos(){
            val arrayPrecos = (arrayOf((binding.edtNt1.text).toString().toInt(), (binding.edtNt2.text).toString().toInt(), (binding.edtNt3.text).toString().toInt()))
            val arrayID = arrayPrecos.copyOf()
            arrayPrecos.sort()
            binding.txvResult.setText("Compre o Produto ${arrayID.indexOf(arrayPrecos[0])+1} por R$ ${arrayPrecos[0]}")
        }

        binding.btnCalc.setOnClickListener {
            calcularPrecos()
        }
    }
}