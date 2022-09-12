package com.recloak.localstoragemigrate;

import android.content.Context;
import org.iq80.leveldb.*;
import static org.iq80.leveldb.impl.Iq80DBFactory.*;
import android.util.Log;
import java.io.File;
import java.io.IOException;

import com.getcapacitor.JSObject;

public class LocalStorageMigrator {
    final String TAG = "LocalStorageMigrator";
    final String SEPARATOR = "\u0000\u0001";

    public String read(Context context, String key) {
        Log.i(TAG, "read key=" + key);

        String dataDir = context.getApplicationInfo().dataDir;
        String dbDir = dataDir + "/app_webview/Default/Local Storage/leveldb";

        DB db = initDb(dbDir);
        if (db == null) return null;

        String value;
        value = readLevelDbKey(db, "_https://localhost" + SEPARATOR + key);
        if (value == null) {
            value = readLevelDbKey(db, "_http://localhost" + SEPARATOR + key);
        }
        if (value == null) {
            value = readLevelDbKey(db, "_file://" + SEPARATOR + key);
        }
        if (value == null) {
            value = readLevelDbKey(db, key);
        }

        try {
            db.close();
        } catch (Exception ex) {
            // PASS
        }
        return value;
    }

    private DB initDb(String folder) {
        try {
            Options options = new Options();
            options.createIfMissing(false);
            DB db = factory.open(new File(folder), options);
            return db;
        } catch (IOException exception) {
            Log.e(TAG, "ioexception: " + exception.getMessage());
            return null;
        } catch (Exception exception) {
            Log.e(TAG, "exception");
            return null;
        }
    }

    private String readLevelDbKey(DB db, String key) {
        Log.i(TAG, "reading key=" + key);

        try {
            String value = asString(db.get(bytes(key)));
            if (value != null) {
                value = value.replace("\u0001", "");
            }
            Log.i(TAG, "value=" + value);
            return value;
        } catch (Exception ex) {
            return null;
        }
    }
}
