package com.ss.ttvideoengine.abr;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.vcloud.abrmodule.DefaultABRModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import rs1.g;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ABRPool {
    private static boolean mEnabled;
    private static ABRPool singleton;
    private int mCreated = 0;
    private final Lock mLock = new ReentrantLock();
    private final List<g> mListCache = new ArrayList();
    private final Map<String, g> mMapCache = new HashMap();
    private final List<String> mMapOrder = new ArrayList();

    public static void clear() {
        getInstance().clearPool();
    }

    static {
        Covode.recordClassIndex(652396);
        mEnabled = false;
    }

    public static ABRPool getInstance() {
        if (singleton == null) {
            synchronized (ABRPool.class) {
                if (singleton == null) {
                    singleton = new ABRPool();
                }
            }
        }
        return singleton;
    }

    private ABRPool() {
    }

    private void clearPool() {
        ArrayList arrayList = new ArrayList();
        this.mLock.lock();
        arrayList.addAll(this.mListCache);
        arrayList.addAll(this.mMapCache.values());
        this.mListCache.clear();
        this.mMapCache.clear();
        this.mMapOrder.clear();
        this.mLock.unlock();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((g) it2.next()).release();
        }
        arrayList.clear();
    }

    public g getFromCache() {
        g gVar = null;
        if (!mEnabled) {
            return null;
        }
        this.mLock.lock();
        if (this.mListCache.size() > 0) {
            gVar = this.mListCache.remove(0);
        } else if (this.mCreated < 8) {
            gVar = new DefaultABRModule();
            this.mCreated++;
        } else if (this.mMapOrder.size() >= 6) {
            gVar = this.mMapCache.remove(this.mMapOrder.remove(0));
        }
        this.mLock.unlock();
        return gVar;
    }

    public static void setEnabled(boolean z) {
        mEnabled = z;
    }

    public void giveBack(g gVar) {
        this.mLock.lock();
        gVar.stop();
        this.mListCache.add(gVar);
        this.mLock.unlock();
    }

    public g getFromPreloaded(String str) {
        if (!mEnabled || TextUtils.isEmpty(str)) {
            return null;
        }
        this.mLock.lock();
        g remove = this.mMapCache.remove(str);
        this.mMapOrder.remove(str);
        this.mLock.unlock();
        return remove;
    }

    public void preloadDone(String str, g gVar) {
        this.mLock.lock();
        gVar.stop();
        this.mMapCache.put(str, gVar);
        this.mMapOrder.remove(str);
        this.mMapOrder.add(str);
        this.mLock.unlock();
    }
}
