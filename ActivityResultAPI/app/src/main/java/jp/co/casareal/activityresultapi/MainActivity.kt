package jp.co.casareal.activityresultapi

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import jp.co.casareal.activityresultapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 遷移先から返ってきたときの契約を登録する
    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

            // 遷移先からの情報を取得してTextViewに表示
            if (it.resultCode == Activity.RESULT_OK) {
                it.data?.let { intent ->
                    val reply = intent.getStringExtra("replyMessage")
                    binding.resultText = reply

                }
            }
        }

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        binding.resultText = "ここに遷移先で入力した文字列が表示される。"
        binding.lifecycleOwner = this

        binding.button.setOnClickListener {
            // 契約した内容で実行する
            // 引数はstartActivityForResultメソッドと同じでもOK
            launcher.launch(Intent(this, InputActivity::class.java))
        }
    }
}