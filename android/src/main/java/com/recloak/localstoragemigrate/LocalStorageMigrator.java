package com.recloak.localstoragemigrate;

import android.content.Context;
import org.iq80.leveldb.*;
import static org.iq80.leveldb.impl.Iq80DBFactory.*;
import android.util.Log;
import java.io.File;
import java.io.IOException;

import com.getcapacitor.JSObject;

public class LocalStorageMigrator {
    public JSObject read(Context context, String key) {
        Log.i("CAP", "read key=" + key);

        String dataDir = context.getApplicationInfo().dataDir;
        String dbDir = dataDir + "/app_webview/Default/Local Storage/leveldb";

        DB db = initDb(dbDir);
        if (db == null) return null;

        String value;
        value = readLevelDbKey(db, "_https://localhost" + key);
        if (value == null) {
            value = readLevelDbKey(db, "_http://localhost" + key);
        }
        if (value == null) {
            value = readLevelDbKey(db, "_file://" + key);
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
            Log.e("CAP", "ioexception: " + exception.getMessage());
            return null;
        } catch (Exception exception) {
            Log.e("CAP", "exception");
            return null;
        }
    }

    private String readLevelDbKey(DB db, String key) {
        Log.i("CAP", "reading key=" + key);

        try {
            String value = asString(db.get(bytes(key)));
            Log.i("CAP", "value=" + value);
            return value;
        } catch (Exception ex) {
            return null;
        }
    }
}
