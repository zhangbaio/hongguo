package vj6;

import android.net.Uri;
import android.os.storage.StorageManager;
import com.bytedance.covode.number.Covode;
import java.io.File;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f {
    static {
        Covode.recordClassIndex(654316);
    }

    public static File a(StorageManager storageManager, Uri uri) {
        return storageManager.getStorageVolume(uri).getDirectory();
    }
}
