package com.recloak.localstoragemigrate;

import android.content.Context;
import org.iq80.leveldb.*;
import static org.iq80.leveldb.impl.Iq80DBFactory.*;
import android.util.Log;
import java.io.File;
import java.io.IOException;

public class LocalStorageMigrator {
    public String read(Context context, String key) {
        Log.i("read key=", key);

        String dataDir = context.getApplicationInfo().dataDir;
        String dbDir = dataDir + "/app_webview/Local Storage/leveldb";
        Log.i("db directory=", dbDir);

        try {
            return readLevelDbKey(dbDir, key);
        } catch (IOException exception) {
            Log.e("ioexception", exception.getMessage());
            return null;
        }
    }

    private String readLevelDbKey(String folder, String key) throws IOException {
        Options options = new Options();
        options.createIfMissing(false);
        DB db = factory.open(new File(folder), options);
        try {
            String value = asString(db.get(bytes(key)));
            Log.i("value=", value);
            return value;
        } finally {
            db.close();
        }
    }
}
