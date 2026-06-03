package com.ss.ttm.player;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ss.ttm.utils.AVLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class MediacodecBlockManager {
    private static final String TAG;
    private static boolean mCodecCached;
    private static final Object mCodecCachedLock;
    private static final ArrayList<MediaCodecInfo> mCodecs;
    private static CodecGetter sCodecGetterInstance;

    private static class MediacodecCall implements Callable<MediaCodec> {
        private static final List<MediacodecCall> mediacodecCallList;
        private String mCodecName;
        private boolean mSyncRelease;
        private boolean needRelease = false;
        private final Object resultLock = new Object();
        private MediaCodec mediaCodecResult = null;

        static {
            Covode.recordClassIndex(652142);
            mediacodecCallList = new ArrayList();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public MediaCodec call() throws Exception {
            MediaCodec mediaCodec;
            MediaCodec createByCodecNameMayBlock = MediacodecBlockManager.createByCodecNameMayBlock(this.mCodecName);
            synchronized (this.resultLock) {
                this.mediaCodecResult = createByCodecNameMayBlock;
                if (this.needRelease) {
                    MediacodecBlockManager.releaseMediaCodec(createByCodecNameMayBlock, this.mSyncRelease);
                    this.mediaCodecResult = null;
                }
                mediacodecCallList.remove(this);
                mediaCodec = this.mediaCodecResult;
            }
            return mediaCodec;
        }

        public void releaseResult(boolean z) {
            synchronized (this.resultLock) {
                this.needRelease = z;
                if (z) {
                    MediacodecBlockManager.releaseMediaCodec(this.mediaCodecResult, this.mSyncRelease);
                    this.mediaCodecResult = null;
                }
            }
        }

        public MediacodecCall(String str, boolean z) {
            this.mCodecName = str;
            this.mSyncRelease = z;
            mediacodecCallList.add(this);
        }
    }

    static {
        Covode.recordClassIndex(652140);
        TAG = "JAJMediaCodec_" + MediacodecBlockManager.class.getSimpleName();
        mCodecs = new ArrayList<>();
        mCodecCachedLock = new Object();
        mCodecCached = false;
        sCodecGetterInstance = null;
    }

    private static class CodecGetter {
        static {
            Covode.recordClassIndex(652141);
        }

        public CodecGetter(final boolean z) {
            AVThreadPool.addTask(new Runnable() { // from class: com.ss.ttm.player.MediacodecBlockManager.CodecGetter.1
                @Override // java.lang.Runnable
                public void run() {
                    MediacodecBlockManager.getCodecsMayBlock(z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MediaCodec createByCodecNameMayBlock(String str) {
        try {
            return MediaCodec.createByCodecName(str);
        } catch (Exception e) {
            AVLogger.w(TAG, e.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void releaseCodecSync(MediaCodec mediaCodec) {
        if (mediaCodec != null) {
            try {
                mediaCodec.release();
            } catch (Exception e) {
                AVLogger.w(TAG, mediaCodec + " release failed : " + e.getMessage());
            }
        }
    }

    public static synchronized ArrayList<MediaCodecInfo> getCodecsMayBlock(boolean z) {
        ArrayList arrayList;
        ArrayList<MediaCodecInfo> arrayList2;
        synchronized (MediacodecBlockManager.class) {
            synchronized (mCodecCachedLock) {
                StringBuilder sb = new StringBuilder();
                sb.append("mCodecCached : ");
                sb.append(mCodecCached);
                sb.append(" , mCodecs size:");
                ArrayList<MediaCodecInfo> arrayList3 = mCodecs;
                sb.append(arrayList3.size());
                if (mCodecCached) {
                    return arrayList3;
                }
                if (z) {
                    try {
                        arrayList = new ArrayList(Arrays.asList(new MediaCodecList(1).getCodecInfos()));
                    } catch (Exception unused) {
                        return null;
                    }
                } else {
                    try {
                        int codecCount = MediaCodecList.getCodecCount();
                        arrayList = new ArrayList();
                        for (int i = 0; i < codecCount; i++) {
                            arrayList.add(MediaCodecList.getCodecInfoAt(i));
                        }
                    } catch (Exception unused2) {
                        AVLogger.w(TAG, "mediaserver died");
                        return null;
                    }
                }
                synchronized (mCodecCachedLock) {
                    arrayList2 = mCodecs;
                    arrayList2.addAll(arrayList);
                    mCodecCached = true;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("cache complete, mCodecCached : ");
                sb2.append(mCodecCached);
                sb2.append(" , mCodecs size:");
                sb2.append(arrayList2.size());
                return arrayList2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void releaseMediaCodec(final MediaCodec mediaCodec, boolean z) {
        if (z) {
            releaseCodecSync(mediaCodec);
            return;
        }
        try {
            AVThreadPool.addTask(new Runnable() { // from class: com.ss.ttm.player.MediacodecBlockManager.1
                @Override // java.lang.Runnable
                public void run() {
                    String unused = MediacodecBlockManager.TAG;
                    MediacodecBlockManager.releaseCodecSync(mediaCodec);
                }
            });
        } catch (Throwable unused) {
            AVLogger.w(TAG, "new thread failed");
            releaseCodecSync(mediaCodec);
        }
    }

    public static ArrayList<MediaCodecInfo> getCodecs(boolean z, boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append("getCodecs async : ");
        sb.append(z);
        if (!z) {
            return getCodecsMayBlock(z2);
        }
        if (sCodecGetterInstance == null) {
            synchronized (CodecGetter.class) {
                if (sCodecGetterInstance == null) {
                    sCodecGetterInstance = new CodecGetter(z2);
                }
            }
        }
        synchronized (mCodecCachedLock) {
            if (mCodecCached) {
                return mCodecs;
            }
            return null;
        }
    }

    public static MediaCodec createByCodecName(String str, long j, boolean z) {
        MediaCodec mediaCodec;
        StringBuilder sb = new StringBuilder();
        sb.append("createByCodecName timeoutMs : ");
        sb.append(j);
        sb.append(" , syncRelease ");
        sb.append(z);
        if (j <= 0) {
            return createByCodecNameMayBlock(str);
        }
        ExecutorService newSingleThreadExecutor = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("MediacodecBlockManager"), "com.ss.ttm.player.MediacodecBlockManager");
        MediacodecCall mediacodecCall = new MediacodecCall(str, z);
        try {
            try {
                mediaCodec = (MediaCodec) newSingleThreadExecutor.submit(mediacodecCall).get(j, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                AVLogger.w(TAG, e.toString());
                mediacodecCall.releaseResult(true);
                newSingleThreadExecutor.shutdown();
                mediaCodec = null;
            }
            return mediaCodec;
        } finally {
            mediacodecCall.releaseResult(false);
            newSingleThreadExecutor.shutdown();
        }
    }
}
