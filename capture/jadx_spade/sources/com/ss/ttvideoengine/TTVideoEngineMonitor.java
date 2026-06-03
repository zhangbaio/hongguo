package com.ss.ttvideoengine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class TTVideoEngineMonitor {
    private static volatile boolean enableCheck;
    private static volatile TTVideoEngineMonitor instance;
    private final Context mContext;
    private CrosstalkReceiver mCrosstalkReceiver;
    private Handler mainHandler;
    private HashMap<String, TTVideoEngineStateWrapper> allEngineWrapper = new HashMap<>();
    private int playingCount = 0;
    private HashMap<String, TTVideoEngineLivePlayerInfo> playingLivePLayerInfos = new HashMap<>();

    public void stop() {
        unregisterBroadcastReceiver(this.mContext);
    }

    static {
        Covode.recordClassIndex(652361);
        enableCheck = false;
    }

    public void start() {
        if (enableCheck && this.mCrosstalkReceiver == null) {
            registerBroadcastReceiver(this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void postRunCrosstalkCheck() {
        if (this.mainHandler == null) {
            this.mainHandler = new HandlerDelegate(Looper.getMainLooper());
        }
        this.mainHandler.postDelayed(new Runnable() { // from class: com.ss.ttvideoengine.m
            @Override // java.lang.Runnable
            public final void run() {
                TTVideoEngineMonitor.this.crosstalkCheck();
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crosstalkCheck() {
        ArrayList<TTVideoEngine> arrayList;
        boolean z;
        HashMap<String, TTVideoEngineLivePlayerInfo> hashMap;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        int i2;
        ArrayList<TTVideoEngine> arrayList2;
        synchronized (this) {
            int size = this.playingLivePLayerInfos.size();
            int i3 = this.playingCount;
            arrayList = null;
            z = false;
            if (i3 + size >= 2) {
                if (i3 > 0) {
                    arrayList2 = new ArrayList<>();
                    ArrayList arrayList3 = new ArrayList();
                    for (String str : this.allEngineWrapper.keySet()) {
                        TTVideoEngineStateWrapper tTVideoEngineStateWrapper = this.allEngineWrapper.get(str);
                        if (tTVideoEngineStateWrapper != null) {
                            TTVideoEngine tTVideoEngine = (TTVideoEngine) tTVideoEngineStateWrapper.weakVideoEngine.get();
                            if (tTVideoEngine != null) {
                                if (tTVideoEngineStateWrapper.hasSetPlaying) {
                                    arrayList2.add(tTVideoEngine);
                                }
                            } else {
                                arrayList3.add(str);
                            }
                        }
                    }
                    if (arrayList3.size() > 0) {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            this.allEngineWrapper.remove((String) it2.next());
                        }
                    }
                    z3 = true;
                } else {
                    arrayList2 = null;
                    z3 = false;
                }
                if (size > 0) {
                    hashMap = new HashMap<>(this.playingLivePLayerInfos);
                    z4 = true;
                } else {
                    hashMap = null;
                    z4 = false;
                }
                arrayList = arrayList2;
                z2 = true;
            } else {
                hashMap = null;
                z2 = false;
                z3 = false;
                z4 = false;
            }
        }
        if (!z2) {
            return;
        }
        if (arrayList != null) {
            i = arrayList.size();
        } else {
            i = 0;
        }
        if (hashMap != null) {
            i2 = hashMap.size();
        } else {
            i2 = 0;
        }
        if (i + i2 < 2) {
            return;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            z3 = false;
        }
        if (hashMap == null || hashMap.size() <= 0) {
            z4 = false;
        }
        ArrayList arrayList4 = new ArrayList();
        if (z3 && arrayList != null && arrayList.size() > 0) {
            Iterator<TTVideoEngine> it4 = arrayList.iterator();
            while (it4.hasNext()) {
                ArrayList<HashMap<String, Object>> crosstalkHappen = it4.next().crosstalkHappen(arrayList, hashMap);
                if (z4 && !z && crosstalkHappen != null && crosstalkHappen.size() > 0) {
                    arrayList4.addAll(crosstalkHappen);
                    z = true;
                }
            }
        }
        if (z4 && hashMap != null && hashMap.size() > 0) {
            for (String str2 : hashMap.keySet()) {
                TTVideoEngineLivePlayerInfo tTVideoEngineLivePlayerInfo = hashMap.get(str2);
                if (tTVideoEngineLivePlayerInfo != null) {
                    arrayList4.add(generateCrosstalkMap(tTVideoEngineLivePlayerInfo.mTag, tTVideoEngineLivePlayerInfo.mSubTag, 1, str2));
                }
            }
            String generateCrosstalkCallbackStr = generateCrosstalkCallbackStr(arrayList4);
            if (!TextUtils.isEmpty(generateCrosstalkCallbackStr)) {
                Intent intent = new Intent("com.bytedance.android.vodsdk.player.monitor.ACTION_CROSSTALK_DIDHAPPEN");
                intent.putExtra("crosstalk_info_list", generateCrosstalkCallbackStr);
                try {
                    LocalBroadcastManager.getInstance(this.mContext).sendBroadcast(intent);
                } catch (Exception e) {
                    TTVideoEngineLog.w("TTVideoEngineMonitor", e.getMessage());
                }
            }
        }
    }

    private final class TTVideoEngineStateWrapper {
        private boolean hasSetPlaying = false;
        private WeakReference<TTVideoEngine> weakVideoEngine;

        static {
            Covode.recordClassIndex(652364);
        }

        public TTVideoEngineStateWrapper(TTVideoEngine tTVideoEngine) {
            this.weakVideoEngine = null;
            this.weakVideoEngine = new WeakReference<>(tTVideoEngine);
        }
    }

    private class CrosstalkReceiver extends BroadcastReceiver {
        static {
            Covode.recordClassIndex(652362);
        }

        private CrosstalkReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            TTVideoEngineLivePlayerInfo tTVideoEngineLivePlayerInfo;
            boolean z;
            if (TTVideoEngineMonitor.enableCheck && intent != null && !TextUtils.isEmpty(intent.getAction())) {
                intent.getAction();
                String stringExtra = intent.getStringExtra("enginehash");
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                String action = intent.getAction();
                action.hashCode();
                if (!action.equals("com.bytedance.android.livesdk.player.monitor.ACTION_LIVE_PLAYER_STOP_OR_RELEASE")) {
                    if (action.equals("com.bytedance.android.livesdk.player.monitor.ACTION_LIVE_PLAYER_PLAYING")) {
                        synchronized (this) {
                            tTVideoEngineLivePlayerInfo = (TTVideoEngineLivePlayerInfo) TTVideoEngineMonitor.this.playingLivePLayerInfos.get(stringExtra);
                        }
                        if (tTVideoEngineLivePlayerInfo != null) {
                            return;
                        }
                        String stringExtra2 = intent.getStringExtra("tag");
                        String stringExtra3 = intent.getStringExtra("subtag");
                        TTVideoEngineLivePlayerInfo tTVideoEngineLivePlayerInfo2 = TTVideoEngineMonitor.this.new TTVideoEngineLivePlayerInfo();
                        if (!TextUtils.isEmpty(stringExtra2)) {
                            tTVideoEngineLivePlayerInfo2.mTag = stringExtra2;
                        }
                        if (!TextUtils.isEmpty(stringExtra3)) {
                            tTVideoEngineLivePlayerInfo2.mSubTag = stringExtra3;
                        }
                        synchronized (this) {
                            TTVideoEngineMonitor.this.playingLivePLayerInfos.put(stringExtra, tTVideoEngineLivePlayerInfo2);
                            if (TTVideoEngineMonitor.this.playingCount + TTVideoEngineMonitor.this.playingLivePLayerInfos.size() >= 2) {
                                z = true;
                            } else {
                                z = false;
                            }
                        }
                        if (z) {
                            TTVideoEngineMonitor.this.postRunCrosstalkCheck();
                            return;
                        }
                        return;
                    }
                    return;
                }
                synchronized (this) {
                    TTVideoEngineMonitor.this.playingLivePLayerInfos.remove(stringExtra);
                }
            }
        }
    }

    public final class TTVideoEngineLivePlayerInfo {
        public String mTag = "";
        public String mSubTag = "";

        static {
            Covode.recordClassIndex(652363);
        }

        public TTVideoEngineLivePlayerInfo() {
        }
    }

    private TTVideoEngineMonitor(Context context) {
        this.mContext = context.getApplicationContext();
        start();
    }

    private static String generateCrosstalkCallbackStr(ArrayList<HashMap<String, Object>> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            try {
                return new JSONArray((Collection) arrayList).toString();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private void registerBroadcastReceiver(Context context) {
        IntentFilter intentFilter = new IntentFilter("com.bytedance.android.livesdk.player.monitor.ACTION_LIVE_PLAYER_PLAYING");
        intentFilter.addAction("com.bytedance.android.livesdk.player.monitor.ACTION_LIVE_PLAYER_STOP_OR_RELEASE");
        this.mCrosstalkReceiver = new CrosstalkReceiver();
        LocalBroadcastManager.getInstance(context).registerReceiver(this.mCrosstalkReceiver, intentFilter);
    }

    private void unregisterBroadcastReceiver(Context context) {
        if (this.mCrosstalkReceiver != null) {
            try {
                LocalBroadcastManager.getInstance(context).unregisterReceiver(this.mCrosstalkReceiver);
            } catch (Exception e) {
                TTVideoEngineLog.w("TTVideoEngineMonitor", e.getMessage());
            }
            this.mCrosstalkReceiver = null;
        }
    }

    public void stopObserve(int i) {
        synchronized (this) {
            this.allEngineWrapper.remove(i + "");
        }
    }

    public static TTVideoEngineMonitor getInstance(Context context) {
        if (instance == null) {
            synchronized (TTVideoEngineMonitor.class) {
                if (instance == null) {
                    instance = new TTVideoEngineMonitor(context);
                    TTVideoEngineLog.i("TTVideoEngineMonitor", "Construct TTVideoEngineMonitor");
                }
            }
        }
        return instance;
    }

    public static void enableCrosstalkCheck(Context context, boolean z) {
        enableCheck = z;
        getInstance(context);
    }

    public void startObserve(int i, TTVideoEngine tTVideoEngine) {
        if (tTVideoEngine == null) {
            return;
        }
        TTVideoEngineStateWrapper tTVideoEngineStateWrapper = new TTVideoEngineStateWrapper(tTVideoEngine);
        synchronized (this) {
            this.allEngineWrapper.put(i + "", tTVideoEngineStateWrapper);
        }
    }

    public void engineStateChange(int i, boolean z) {
        if (!TTVideoEngine.sEngineCrosstalkCheck) {
            return;
        }
        boolean z2 = false;
        if (!z) {
            synchronized (this) {
                TTVideoEngineStateWrapper tTVideoEngineStateWrapper = this.allEngineWrapper.get(i + "");
                if (tTVideoEngineStateWrapper != null && tTVideoEngineStateWrapper.hasSetPlaying) {
                    tTVideoEngineStateWrapper.hasSetPlaying = false;
                    this.playingCount--;
                }
            }
            return;
        }
        synchronized (this) {
            TTVideoEngineStateWrapper tTVideoEngineStateWrapper2 = this.allEngineWrapper.get(i + "");
            if (tTVideoEngineStateWrapper2 != null && !tTVideoEngineStateWrapper2.hasSetPlaying) {
                tTVideoEngineStateWrapper2.hasSetPlaying = true;
                this.playingCount++;
                if (this.playingCount + this.playingLivePLayerInfos.size() >= 2) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            postRunCrosstalkCheck();
        }
    }

    private static HashMap<String, Object> generateCrosstalkMap(String str, String str2, int i, String str3) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("tag", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("subtag", str2);
        }
        hashMap.put("islive", Integer.valueOf(i));
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("enginehash", str3);
        }
        return hashMap;
    }
}
