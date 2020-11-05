package jp.co.casareal.activityresultapi

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import jp.co.casareal.activityresultapi.databinding.ActivityInputBinding

class InputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = setContentView<ActivityInputBinding>(this, R.layout.activity_input)
        binding.lifecycleOwner = this

        binding.buttonReply.setOnClickListener {
            val result = Intent()
            result.putExtra("replyMessage", binding.editTextInputText.text.toString())

            setResult(Activity.RESULT_OK, result)
            finish()
        }
    }

}