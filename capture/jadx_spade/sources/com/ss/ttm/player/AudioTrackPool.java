package com.ss.ttm.player;

import android.media.AudioTrack;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ss.ttm.utils.AVLogger;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class AudioTrackPool {
    private static volatile AudioTrackPool instance;
    private int mCheckIntervalMs;
    private boolean mEnableFrameSamplesCheck;
    private AtomicInteger trackPoolSizeLimit = new AtomicInteger(3);
    private Queue<AudioTrackBuffer> trackPool = new LinkedBlockingQueue();
    private int mMaxUsedCount = TTPlayerConfiger.getValue(50, 20);

    static {
        Covode.recordClassIndex(652091);
    }

    public synchronized int getAudioTrackPoolSize() {
        return this.trackPool.size();
    }

    public static AudioTrackPool getInstance() {
        if (instance == null) {
            synchronized (AudioTrackPool.class) {
                if (instance == null) {
                    instance = new AudioTrackPool();
                }
            }
        }
        return instance;
    }

    public void preBuild() {
        AVLogger.InfoTrackLife("AudioTrackPool", this, "AudioTrackPool log: start pre build audioTrack");
        AudioTrack audioTrack = new AudioTrack(3, 44100, 12, 2, AudioTrack.getMinBufferSize(44100, 12, 2), 1);
        if (audioTrack.getState() == 1) {
            pushAudioTrackBack(new AudioTrackBuffer(audioTrack, 3, 44100, 12, 2, 2048, 0), 1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkExpireThreadPeriod() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (AudioTrackPool.class) {
            while (!this.trackPool.isEmpty() && currentTimeMillis - this.trackPool.peek().mFreeTimePoint > this.mCheckIntervalMs) {
                linkedBlockingQueue.offer(this.trackPool.peek());
                this.trackPool.poll();
            }
        }
        AVLogger.InfoTrackLife("AudioTrackPool", this, "AudioTrackPool log: exist audioTrack after check expire:" + this.trackPool.size() + ", clean size:" + linkedBlockingQueue.size());
        while (!linkedBlockingQueue.isEmpty()) {
            AudioTrack audioTrack = ((AudioTrackBuffer) linkedBlockingQueue.poll()).AudioTrack;
            if (audioTrack != null) {
                releaseAudioTrack(audioTrack);
            }
        }
    }

    public void resetQueue() {
        AVLogger.InfoTrackLife("AudioTrackPool", this, "AudioTrackPool log: reset queue, size:" + this.trackPool.size());
        if (this.trackPool.isEmpty()) {
            return;
        }
        synchronized (this) {
            this.trackPool.size();
            while (!this.trackPool.isEmpty()) {
                AudioTrack audioTrack = this.trackPool.poll().AudioTrack;
                if (audioTrack != null) {
                    releaseAudioTrack(audioTrack);
                }
            }
        }
    }

    private AudioTrackPool() {
        boolean z;
        this.mCheckIntervalMs = 30000;
        if (TTPlayerConfiger.getValue(51, 0) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.mEnableFrameSamplesCheck = z;
        setAudioTrackPoolSize(TTPlayerConfiger.getValue(47, 3));
        boolean z2 = TTPlayerConfiger.getValue(81, 0) != 0;
        int value = TTPlayerConfiger.getValue(82, 30000);
        this.mCheckIntervalMs = value;
        if (z2 && value > 0) {
            ScheduledExecutorService newScheduledThreadPool = PThreadExecutorsUtils.newScheduledThreadPool(1, new DefaultThreadFactory("udioTrackPool"), "com.ss.ttm.player.AudioTrackPool");
            Runnable runnable = new Runnable() { // from class: com.ss.ttm.player.b
                @Override // java.lang.Runnable
                public final void run() {
                    AudioTrackPool.this.checkExpireThreadPeriod();
                }
            };
            int i = this.mCheckIntervalMs;
            newScheduledThreadPool.scheduleWithFixedDelay(runnable, i, i, TimeUnit.MILLISECONDS);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("AudioTrackPool log: maxUsedCount:");
        sb.append(this.mMaxUsedCount);
        sb.append(", poolSize:");
        sb.append(this.trackPoolSizeLimit.get());
        sb.append(", needCheckExpire:");
        sb.append(z2);
        sb.append(", checkIntervalMs:");
        sb.append(this.mCheckIntervalMs);
    }

    public void setAudioTrackPoolSize(int i) {
        AVLogger.InfoTrackLife("AudioTrackPool", this, "AudioTrackPool log: set audioTrack pool size:" + i);
        this.trackPoolSizeLimit.set(i);
    }

    public void releaseAudioTrack(final AudioTrack audioTrack) {
        if (audioTrack != null) {
            AVLogger.InfoTrackLife("AudioTrackPool", this, "AudioTrackPool log: release AudioTrack task:" + audioTrack);
            try {
                AVThreadPool.addTask(new Runnable() { // from class: com.ss.ttm.player.AudioTrackPool.1
                    @Override // java.lang.Runnable
                    public void run() {
                        audioTrack.flush();
                        audioTrack.release();
                    }
                });
            } catch (Throwable th) {
                AVLogger.InfoTrackLife("AudioTrackPool", this, "AudioTrackPool log: create close thread fail: " + th);
                audioTrack.flush();
                audioTrack.release();
            }
        }
    }

    public int pushAudioTrackBack(AudioTrackBuffer audioTrackBuffer, float f) {
        AudioTrack audioTrack;
        AudioTrack audioTrack2;
        if (audioTrackBuffer != null && (audioTrack = audioTrackBuffer.AudioTrack) != null) {
            int i = audioTrackBuffer.usedCount + 1;
            audioTrackBuffer.usedCount = i;
            if (i > this.mMaxUsedCount) {
                AVLogger.InfoTrackLife("AudioTrackPool", this, "AudioTrackPool log: usedCount > maxUsedCount.");
                return -1;
            }
            if (audioTrack.getPlayState() != 2) {
                audioTrackBuffer.AudioTrack.pause();
            }
            audioTrackBuffer.AudioTrack.flush();
            if (f != 1.0f) {
                AVLogger.InfoTrackLife("AudioTrackPool", this, "AudioTrackPool log: reset volume, before: " + f);
                audioTrackBuffer.AudioTrack.setVolume(1.0f);
            }
            setAudioTrackPoolSize(TTPlayerConfiger.getValue(47, 3));
            synchronized (this) {
                for (AudioTrackBuffer audioTrackBuffer2 : this.trackPool) {
                    if (audioTrackBuffer2.streamType == audioTrackBuffer.streamType && audioTrackBuffer2.sampleRate == audioTrackBuffer.sampleRate && audioTrackBuffer2.channelsLayout == audioTrackBuffer.channelsLayout && audioTrackBuffer2.audioFormat == audioTrackBuffer.audioFormat && audioTrackBuffer2.frameSamples == audioTrackBuffer.frameSamples) {
                        AVLogger.InfoTrackLife("AudioTrackPool", this, "AudioTrackPool log: pool has similarity audioTrack.");
                        return -1;
                    }
                }
                if (this.trackPool.size() < this.trackPoolSizeLimit.get()) {
                    if (this.trackPool.offer(audioTrackBuffer)) {
                        audioTrackBuffer.resetFreeTimePoint();
                        AVLogger.InfoTrackLife("AudioTrackPool", this, "AudioTrackPool log: pushback AudioTrack success! AudioTrack: " + audioTrackBuffer.AudioTrack + ", poolSize: " + this.trackPool.size() + ", usedCount:" + audioTrackBuffer.usedCount);
                    }
                    audioTrack2 = null;
                } else {
                    AudioTrack audioTrack3 = this.trackPool.poll().AudioTrack;
                    if (this.trackPool.offer(audioTrackBuffer)) {
                        audioTrackBuffer.resetFreeTimePoint();
                        AVLogger.InfoTrackLife("AudioTrackPool", this, "AudioTrackPool log: pushback AudioTrack success after poll! AudioTrack: " + audioTrackBuffer.AudioTrack + ", poolSize: " + this.trackPool.size() + ", usedCount:" + audioTrackBuffer.usedCount);
                    }
                    audioTrack2 = audioTrack3;
                }
                if (audioTrack2 != null) {
                    releaseAudioTrack(audioTrack2);
                }
                return 0;
            }
        }
        AVLogger.InfoTrackLife("AudioTrackPool", this, "AudioTrackPool log: audioTrack is null!");
        return 0;
    }

    public AudioTrackBuffer getReuseAudioTrack(int i, int i2, int i3, int i4, int i5) {
        AudioTrackBuffer audioTrackBuffer;
        AudioTrackBuffer audioTrackBuffer2;
        if (this.trackPool.isEmpty()) {
            AVLogger.InfoTrackLife("AudioTrackPool", this, "AudioTrackPool log: trackPool is empty!");
            return null;
        }
        synchronized (this) {
            Iterator<AudioTrackBuffer> it2 = this.trackPool.iterator();
            audioTrackBuffer = null;
            while (true) {
                if (it2.hasNext()) {
                    audioTrackBuffer2 = it2.next();
                    if (audioTrackBuffer2.streamType == i && audioTrackBuffer2.sampleRate == i2 && audioTrackBuffer2.channelsLayout == i3 && audioTrackBuffer2.audioFormat == i4) {
                        if (audioTrackBuffer2.frameSamples == i5) {
                            this.trackPool.remove(audioTrackBuffer2);
                            AVLogger.InfoTrackLife("AudioTrackPool", this, "AudioTrackPool log: find best-matched AudioTrack:" + audioTrackBuffer2.AudioTrack);
                            break;
                        }
                        audioTrackBuffer = audioTrackBuffer2;
                    }
                } else {
                    audioTrackBuffer2 = null;
                    break;
                }
            }
            if (audioTrackBuffer2 == null && audioTrackBuffer != null) {
                this.trackPool.remove(audioTrackBuffer);
                AVLogger.InfoTrackLife("AudioTrackPool", this, "AudioTrackPool log: find find sampleNumber-unmatched AudioTrack:" + audioTrackBuffer.AudioTrack);
            } else {
                audioTrackBuffer = audioTrackBuffer2;
            }
        }
        if (audioTrackBuffer != null) {
            if (audioTrackBuffer.AudioTrack.getPlayState() == 2) {
                return audioTrackBuffer;
            }
            releaseAudioTrack(audioTrackBuffer.AudioTrack);
        }
        AVLogger.InfoTrackLife("AudioTrackPool", this, "AudioTrackPool log: find best-matched AudioTrack fail");
        return null;
    }
}
