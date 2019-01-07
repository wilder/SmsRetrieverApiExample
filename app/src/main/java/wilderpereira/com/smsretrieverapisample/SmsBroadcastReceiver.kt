package wilderpereira.com.smsretrieverapisample

import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.auth.api.phone.SmsRetriever
import android.content.Intent
import android.content.BroadcastReceiver
import android.content.Context
import com.google.android.gms.common.api.Status

class SmsReceiver : BroadcastReceiver() {
    private val codePattern = "(\\d{6})".toRegex()

    override fun onReceive(context: Context, intent: Intent) {
        if (SmsRetriever.SMS_RETRIEVED_ACTION == intent.action) {
            val extras = intent.extras
            val status = extras!!.get(SmsRetriever.EXTRA_STATUS) as Status

            when (status.statusCode) {
                CommonStatusCodes.SUCCESS -> {

                    // Get SMS message contents
                    val message = extras.get(SmsRetriever.EXTRA_SMS_MESSAGE) as String
                    val code: MatchResult? = codePattern.find(message)
                    if (code?.value != null) {
                        smsListener.onSuccess(code.value)
                    } else {
                        smsListener.onError()
                    }
                }
                CommonStatusCodes.TIMEOUT -> {
                    smsListener.onError()
                }
            }

        }
    }

    companion object {
        private lateinit var smsListener: SmsListener

        fun bindListener(smsListener: SmsListener) {
            this.smsListener = smsListener
        }
    }

}