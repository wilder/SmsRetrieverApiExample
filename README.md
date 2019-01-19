# SmsRetrieverApiExample
SMS Retriever API Example for [Medium post](https://medium.com/@wilderpereira/secure-android-otp-account-verification-with-the-sms-retriever-api-c395c1985fbf)


## Computing the hash code for debug mode:
```
keytool -exportcert -alias androiddebugkey -keystore  ~/.android/debug.keystore -storepass android -keypass android | \
xxd -p | tr -d "[:space:]" | echo -n wilderpereira.com.smsretrieverapisample `cat` \
| sha256sum | tr -d "[:space:]-" | xxd -r -p | base64 | cut -c1-11
```
