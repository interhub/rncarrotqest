// RncarrotquestModule.java

package com.reactlibrary;

import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import io.carrotquest_sdk.android.Carrot;
import io.carrotquest_sdk.android.core.main.CarrotSDK;

public class RncarrotquestModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public RncarrotquestModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "Rncarrotquest";
    }

    @ReactMethod
    public void test(String stringArgument, Callback callback) {
        callback.invoke("Received numberArgument: " + stringArgument);
    }

    @ReactMethod
    public void init(CarrotSDK.Callback<Boolean> callback) {
        String apiKey = "41187-6baa7e0857a3f5fc899e2109d3";
        String appId = "41187";
        Carrot.setup(this.reactContext, apiKey, appId);
    }

    @ReactMethod
    public void openChat(){
        Carrot.openChat(this.reactContext);
        Log.d("RncarrotquestModule", "was call openChat");
    }

}
