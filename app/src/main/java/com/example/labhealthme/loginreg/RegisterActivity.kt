package com.example.labhealthme.loginreg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.labhealthme.User
import com.example.labhealthme.databinding.ActivityRegisterBinding
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            //Todo: Form Validate
            btnRegister.setOnClickListener {
                //Todo: saveData
            }
            tvTerms.setOnClickListener {

            }
            tvLogin.setOnClickListener {
                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }
    private fun saveData(){
        val name = binding.etNamaLengkap.text.toString().trim()
        val email = binding.etEmail.text.toString().trim()

        if(name.isEmpty()){
            binding.etNamaLengkap.error = "Masukkan nama lengkap"
        }
        if(email.isEmpty()){
            binding.etNamaLengkap.error = "Masukkan email"
        }

        val ref = FirebaseDatabase.getInstance().getReference("Users")
        val userID = ref.push().key

        val user = User(userID,name,email)

        if (userID != null) {
            ref.child(userID).setValue(user).addOnCompleteListener{
                Toast.makeText(applicationContext,"Berhasil !",Toast.LENGTH_SHORT).show()
            }
        }
    }
}