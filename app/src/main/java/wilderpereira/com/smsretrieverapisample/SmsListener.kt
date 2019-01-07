package wilderpereira.com.smsretrieverapisample

interface SmsListener {
    fun onSuccess(code: String)
    fun onError()
}