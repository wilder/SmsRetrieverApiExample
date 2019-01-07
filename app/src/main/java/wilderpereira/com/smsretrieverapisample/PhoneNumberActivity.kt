package wilderpereira.com.smsretrieverapisample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class PhoneNumberActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_number)
    }

    fun verifyPhoneClick(view: View) {
        // TODO: Send the phone number to the backend service
        startActivity(Intent(this, CodeVerificationActivity::class.java))
    }

}
