// RncarrotquestModule.java

package com.rncarrotquest;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import io.carrotquest_sdk.android.Carrot;
import io.carrotquest_sdk.android.core.main.CarrotSDK;
import io.carrotquest_sdk.android.presentation.mvp.dialog.view.DialogActivity;

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
    public void init() {
        String apiKey = "41187-6baa7e0857a3f5fc899e2109d3";
        String appId = "41187";
        Carrot.setDebug(true);
        Carrot.setup(this.reactContext, apiKey, appId);
    }

    @ReactMethod
    public void openChat(){
        try{
            Context context = this.reactContext.getApplicationContext();
            Intent intent = new Intent(context, DialogActivity.class);
            intent.putExtra("CONVERSATION_ID_ARG", "last_conversation");
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }catch (Error e){
            Log.d("openChat", e.toString());
        }
    }

}
