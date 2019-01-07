package wilderpereira.com.smsretrieverapisample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.auth.api.phone.SmsRetriever
import kotlinx.android.synthetic.main.activity_code_verification.*


class CodeVerificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_verification)

        startSmsRetriever()

    }

    private fun startSmsRetriever() {
        val client = SmsRetriever.getClient(this)

        val task = client.startSmsRetriever()

        task.addOnSuccessListener { _ ->
            Log.d("CodeActivity", "Sms listener started!")
            listenSms()
        }

        task.addOnFailureListener { e ->
            Log.e("CodeActivity", "Failed to start sms retriever: ${e.message}")
        }

    }

    private fun listenSms() {
        SmsReceiver.bindListener(object : SmsListener {
            override fun onSuccess(code: String) {
                etCode.setText(code)
                // TODO: Send the one-time code to the server
            }

            override fun onError() {
                // TODO: Display error message
            }
        })
    }
}
