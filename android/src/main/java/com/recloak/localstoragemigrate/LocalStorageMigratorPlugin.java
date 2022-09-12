package com.recloak.localstoragemigrate;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import android.content.Context;


@CapacitorPlugin(name = "LocalStorageMigrator")
public class LocalStorageMigratorPlugin extends Plugin {

    private LocalStorageMigrator implementation = new LocalStorageMigrator();

    @PluginMethod
    public void read(PluginCall call) {
        Context appctx = getContext().getApplicationContext();
        String key = call.getString("key");

        JSObject ret = new JSObject();
        ret.put("value", implementation.read(appctx, key));
        call.resolve(ret);
    }
}
