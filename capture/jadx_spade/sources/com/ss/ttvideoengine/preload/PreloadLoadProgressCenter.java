package com.ss.ttvideoengine.preload;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PreloadLoadProgressCenter {
    private ConcurrentHashMap<String, DataLoaderHelper.DataLoaderTaskLoadProgress> mLoadProgress;

    static {
        Covode.recordClassIndex(652630);
    }

    private static class SingleBuilder {
        private static PreloadLoadProgressCenter center;

        private SingleBuilder() {
        }

        static {
            Covode.recordClassIndex(652631);
            center = new PreloadLoadProgressCenter();
        }
    }

    public static PreloadLoadProgressCenter center() {
        return SingleBuilder.center;
    }

    private PreloadLoadProgressCenter() {
        this.mLoadProgress = null;
        this.mLoadProgress = new ConcurrentHashMap<>();
    }

    public DataLoaderHelper.DataLoaderTaskLoadProgress getLoadProgressByRawKey(String str) {
        if (TextUtils.isEmpty(str)) {
            TTVideoEngineLog.e("MediaTaskCenter", "[preload] get, param is invalid key is null");
            return null;
        }
        return this.mLoadProgress.get(str);
    }

    public void removeLoadProgressByRawKey(String str) {
        if (TextUtils.isEmpty(str)) {
            TTVideoEngineLog.e("MediaTaskCenter", "[preload] remove, param is invalid key is null");
        } else {
            this.mLoadProgress.remove(str);
        }
    }

    public void putByRawKey(String str, DataLoaderHelper.DataLoaderTaskLoadProgress dataLoaderTaskLoadProgress) {
        if (!TextUtils.isEmpty(str) && dataLoaderTaskLoadProgress != null) {
            this.mLoadProgress.put(str, dataLoaderTaskLoadProgress);
        } else {
            TTVideoEngineLog.e("MediaTaskCenter", "[preload] param is invalid");
        }
    }
}
