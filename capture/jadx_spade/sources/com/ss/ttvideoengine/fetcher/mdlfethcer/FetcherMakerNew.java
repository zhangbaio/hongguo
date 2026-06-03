package com.ss.ttvideoengine.fetcher.mdlfethcer;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.mediakit.fetcher.AVMDLNewFetcherMakerInterface;
import com.ss.mediakit.fetcher.AVMDLURLFetcherInterface;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class FetcherMakerNew implements AVMDLNewFetcherMakerInterface {
    private static FetcherMakerNew mInst;
    private static final List<WeakReference<MDLFetcherListener>> sFetcherListenerList;

    private FetcherMakerNew() {
    }

    static {
        Covode.recordClassIndex(652447);
        mInst = null;
        sFetcherListenerList = new ArrayList();
    }

    public static FetcherMakerNew getInstance() {
        if (mInst == null) {
            synchronized (FetcherMakerNew.class) {
                if (mInst == null) {
                    mInst = new FetcherMakerNew();
                }
            }
        }
        return mInst;
    }

    private static synchronized MDLFetcherListener getMDLFetchListener(String str) {
        synchronized (FetcherMakerNew.class) {
            Iterator<WeakReference<MDLFetcherListener>> it2 = sFetcherListenerList.iterator();
            while (it2.hasNext()) {
                MDLFetcherListener mDLFetcherListener = it2.next().get();
                if (mDLFetcherListener != null && TextUtils.equals(str, mDLFetcherListener.getId())) {
                    return mDLFetcherListener;
                }
            }
            return null;
        }
    }

    public static synchronized void storeListener(MDLFetcherListener mDLFetcherListener) {
        synchronized (FetcherMakerNew.class) {
            if (mDLFetcherListener == null) {
                TTVideoEngineLog.i("FetcherMakerNew", "storeListener fetcherListener is null");
                return;
            }
            TTVideoEngineLog.i("FetcherMakerNew", "storeListener " + mDLFetcherListener);
            sFetcherListenerList.add(new WeakReference<>(mDLFetcherListener));
        }
    }

    public static synchronized void removeListener(MDLFetcherListener mDLFetcherListener) {
        synchronized (FetcherMakerNew.class) {
            if (mDLFetcherListener == null) {
                TTVideoEngineLog.i("FetcherMakerNew", "removeListener fetcherListener is null");
                return;
            }
            TTVideoEngineLog.i("FetcherMakerNew", "removeListener " + mDLFetcherListener);
            Iterator<WeakReference<MDLFetcherListener>> it2 = sFetcherListenerList.iterator();
            while (it2.hasNext()) {
                WeakReference<MDLFetcherListener> next = it2.next();
                if (next != null && next.get() != null) {
                    if (next.get() == mDLFetcherListener) {
                        it2.remove();
                    }
                }
                it2.remove();
            }
        }
    }

    public AVMDLURLFetcherInterface getFetcher(String str, String str2, String str3, String str4) {
        TTVideoEngineLog.i("FetcherMakerNew", "getFetcher rawKey " + str + ", fileKey " + str2 + ", engineId " + str4);
        MDLFetcherListener mDLFetchListener = getMDLFetchListener(str4);
        if (mDLFetchListener == null) {
            TTVideoEngineLog.e("FetcherMakerNew", "getFetcher MDLFetcherListener is null");
            return null;
        }
        MDLFetcherNew mDLFetcherNew = new MDLFetcherNew(mDLFetchListener);
        TTVideoEngineLog.i("FetcherMakerNew", "return fetcher to mdl " + mDLFetcherNew);
        return mDLFetcherNew;
    }
}
