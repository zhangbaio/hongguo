package com.ss.ttvideoengine.cache;

import com.ss.ttvideoengine.DataLoaderHelper;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface CopyCacheListener {

    /* renamed from: com.ss.ttvideoengine.cache.CopyCacheListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onFileInfo(CopyCacheListener copyCacheListener, DataLoaderHelper.DataLoaderCacheInfo dataLoaderCacheInfo) {
        }
    }

    void onCopyComplete(boolean z, int i, String str);

    void onFileInfo(DataLoaderHelper.DataLoaderCacheInfo dataLoaderCacheInfo);
}
