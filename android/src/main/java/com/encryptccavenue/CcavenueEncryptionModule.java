package com.encryptccavenue;

import android.util.Base64;
import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableMap;

import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

public class CcavenueEncryptionModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public CcavenueEncryptionModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "CcavenueEncryption";
    }

    @ReactMethod
    public void sampleMethod(String stringArgument, int numberArgument, Callback callback) {
        // TODO: Implement some actually useful functionality
        callback.invoke("Received numberArgument: " + numberArgument + " stringArgument: " + stringArgument);
    }

    @ReactMethod
    public void encrypt(String plainText, String key, Promise promise){
        try{
            Log.e("encrypting",""+plainText);
            Log.e("encrypting_Key",""+key);
            PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(key, Base64.DEFAULT)));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            String encVal = Base64.encodeToString(cipher.doFinal(plainText.getBytes("UTF-8")),Base64.DEFAULT);
            WritableMap params = Arguments.createMap();
            params.putString("encrypted", encVal);
            promise.resolve(params);
        }catch (Exception e) {
            e.printStackTrace();
            promise.reject("Error", e);
        }

    }

    @ReactMethod
    public void urlEncode(String val, Promise promise){
        String enc = URLEncoder.encode(val);
        WritableMap params = Arguments.createMap();
        params.putString("encoded",enc);
        promise.resolve(params);
    }
}
