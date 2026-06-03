package com.ss.ttvideoengine.log;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.utils.EngineThreadPool;
import com.ss.ttvideoengine.utils.FileUtils;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class EventSaver {
    private static boolean checkedOnce;
    private static volatile EventSaver sInstance;
    private final File mDirectory;
    private final Set<String> mEventIdList = new HashSet();

    static {
        Covode.recordClassIndex(652465);
    }

    public void saveAllPlayEvent() {
        Iterator<Map.Entry<Integer, WeakReference<TTVideoEngine>>> it2 = EngineInstanceHolder.getInstance().get().entrySet().iterator();
        while (it2.hasNext()) {
            TTVideoEngine tTVideoEngine = it2.next().getValue().get();
            if (tTVideoEngine != null) {
                tTVideoEngine.saveEvent();
            }
        }
    }

    private EventSaver(Context context) {
        this.mDirectory = new PolarisFileWrapper(context.getCacheDir(), "saved_events");
    }

    public static EventSaver getInstance(Context context) {
        if (sInstance == null) {
            synchronized (EventSaver.class) {
                if (sInstance == null) {
                    sInstance = new EventSaver(context);
                }
            }
        }
        return sInstance;
    }

    public synchronized void remove(final String str) {
        if (!this.mEventIdList.contains(str)) {
            return;
        }
        this.mEventIdList.remove(str);
        EngineThreadPool.addExecuteTask(new Runnable() { // from class: com.ss.ttvideoengine.log.c
            @Override // java.lang.Runnable
            public final void run() {
                EventSaver.this.lambda$remove$0(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$remove$0(String str) {
        try {
            new PolarisFileWrapper(this.mDirectory, str).delete();
            TTVideoEngineLog.i("EventSaver", "saved event deleted: " + str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void uploadIfExits(boolean z) {
        if (checkedOnce) {
            return;
        }
        checkedOnce = true;
        if (!this.mDirectory.exists()) {
            TTVideoEngineLog.w("EventSaver", "dir does not exist");
            return;
        }
        File[] listFiles = this.mDirectory.listFiles();
        if (listFiles == null) {
            TTVideoEngineLog.i("EventSaver", "no file in directory");
            return;
        }
        for (File file : listFiles) {
            if (file != null && !file.isDirectory()) {
                uploadFile(file, z);
            }
        }
    }

    private void uploadFile(File file, boolean z) {
        try {
            VideoEventManager.instance.addEvent(z, new JSONObject(FileUtils.readString(file)));
            TTVideoEngineLog.i("EventSaver", "saved event uploaded: " + file.getName());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        file.delete();
    }

    public synchronized void save(VideoEventOnePlay videoEventOnePlay, VideoEventBase videoEventBase) {
        if (videoEventOnePlay != null && videoEventBase != null) {
            String str = videoEventOnePlay.mSessionID;
            if (TextUtils.isEmpty(str)) {
                TTVideoEngineLog.w("EventSaver", "invalid sessionId");
                return;
            }
            this.mEventIdList.add(str);
            FileUtils.checkAndMkdir(this.mDirectory);
            try {
                try {
                    PolarisFileOutputStreamWrapper polarisFileOutputStreamWrapper = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(this.mDirectory, str));
                    try {
                        JSONObject jsonObject = videoEventOnePlay.toJsonObject(videoEventBase);
                        jsonObject.put("manual_save", 1);
                        polarisFileOutputStreamWrapper.write(jsonObject.toString().getBytes());
                        TTVideoEngineLog.d("EventSaver", "save event with name: " + str);
                        polarisFileOutputStreamWrapper.close();
                    } finally {
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
