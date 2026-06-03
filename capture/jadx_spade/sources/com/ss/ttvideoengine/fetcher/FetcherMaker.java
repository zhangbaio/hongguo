package com.ss.ttvideoengine.fetcher;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.mediakit.fetcher.AVMDLFetcherMakerInterface;
import com.ss.mediakit.fetcher.AVMDLURLFetcherInterface;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.Hashtable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class FetcherMaker implements AVMDLFetcherMakerInterface {
    private static Hashtable<String, FetcherBase> sFallbackCenter;
    private final Context mContext;

    public FetcherMaker() {
        this.mContext = null;
    }

    static {
        Covode.recordClassIndex(652438);
        sFallbackCenter = new Hashtable<>();
    }

    public FetcherMaker(Context context) {
        this.mContext = context;
    }

    public static void remove(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sFallbackCenter.remove(str);
    }

    public AVMDLURLFetcherInterface getFetcher(String str, String str2, String str3) {
        TTVideoEngineLog.i("FetcherMaker", "getFetcher rawKey " + str + ", fileKey " + str2 + ", oldURL " + str3);
        FetcherBase fetcherBase = sFallbackCenter.get(str);
        if (fetcherBase == null) {
            TTVideoEngineLog.i("FetcherMaker", "getFetcher FetcherBase is null");
            return null;
        }
        String keyseed = fetcherBase.getKeyseed();
        String fallbackAPI = fetcherBase.getFallbackAPI();
        int videoModelVersion = fetcherBase.getVideoModelVersion();
        if (!TextUtils.isEmpty(fallbackAPI) && (videoModelVersion == 3 || !TextUtils.isEmpty(keyseed))) {
            MDLFetcher mDLFetcher = new MDLFetcher(this.mContext, fallbackAPI, keyseed);
            TTVideoEngineLog.i("FetcherMaker", "return fetcher to mdl " + mDLFetcher);
            return mDLFetcher;
        }
        TTVideoEngineLog.i("FetcherMaker", "getFetcher FetcherBase is error " + fetcherBase);
        return null;
    }

    public static void store(String str, String str2, String str3, int i) {
        TTVideoEngineLog.i("FetcherMaker", "store videoId " + str + ", keyseed " + str2 + ", fallbackAPI " + str3 + ", version " + i);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && (i == 3 || !TextUtils.isEmpty(str2))) {
            sFallbackCenter.put(str, new FetcherBase(str2, str3, i));
        } else {
            TTVideoEngineLog.i("FetcherMaker", "mdlFetch store fail");
        }
    }
}
