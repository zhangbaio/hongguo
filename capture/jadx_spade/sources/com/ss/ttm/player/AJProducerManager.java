package com.ss.ttm.player;

import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import com.bytedance.covode.number.Covode;
import com.ss.ttm.utils.AVLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AJProducerManager {
    private static int MaxImages;
    private static ArrayList<AJImageReaderProducer> mFreeIRProducerList;
    private static HashMap<Long, ImageReaderListenerWrapper> mIRLWrapperMap;
    private static ArrayList<AJImageReaderProducer> mUsingIRProducerList;

    public static class AJImageReaderProducer {
        private int mApiType;
        private ImageReader mImageReader;
        private ImageReader.OnImageAvailableListener mListener;
        private long mUsingPlayerId;

        static {
            Covode.recordClassIndex(652072);
        }

        public Surface getSurface() {
            ImageReader imageReader = this.mImageReader;
            if (imageReader == null) {
                return null;
            }
            return imageReader.getSurface();
        }

        public void release() {
            ImageReader imageReader = this.mImageReader;
            if (imageReader != null) {
                imageReader.close();
                this.mImageReader = null;
            }
        }

        public String toString() {
            return "[" + super.toString() + ",pid:" + this.mUsingPlayerId + ",reader:" + this.mImageReader + "]";
        }

        public void setOnImageAvailableListener(ImageReader.OnImageAvailableListener onImageAvailableListener, Handler handler) {
            ImageReader imageReader = this.mImageReader;
            if (imageReader != null) {
                imageReader.setOnImageAvailableListener(onImageAvailableListener, handler);
                StringBuilder sb = new StringBuilder();
                sb.append("setOnImageAvailableListener:");
                sb.append(this);
                sb.append(",handler:");
                sb.append(handler);
                if (onImageAvailableListener != null) {
                    AJProducerManager.notifyImageReaderStatus(onImageAvailableListener, 2);
                } else {
                    AJProducerManager.notifyImageReaderStatus(this.mListener, 1);
                }
                this.mListener = onImageAvailableListener;
            }
        }

        public AJImageReaderProducer(long j, int i, int i2) {
            int i3;
            this.mApiType = 0;
            this.mUsingPlayerId = 0L;
            if (Build.VERSION.SDK_INT >= 29) {
                if (i <= 0) {
                    i3 = 2;
                } else {
                    i3 = i;
                }
                this.mImageReader = ImageReader.newInstance(1, 1, 35, i3, 304L);
            } else {
                this.mImageReader = ImageReader.newInstance(1, 1, 35, i <= 0 ? 2 : i);
            }
            this.mApiType = i2;
            this.mUsingPlayerId = j;
            StringBuilder sb = new StringBuilder();
            sb.append("new:");
            sb.append(this);
        }
    }

    static {
        Covode.recordClassIndex(652071);
        MaxImages = 2;
        mIRLWrapperMap = new HashMap<>();
        mFreeIRProducerList = new ArrayList<>();
        mUsingIRProducerList = new ArrayList<>();
    }

    public static void setMaxImages(int i) {
        if (i <= 0) {
            i = 2;
        }
        MaxImages = i;
    }

    private static class ImageReaderListenerWrapper {
        public Handler handler;
        public ImageReader.OnImageAvailableListener listener;

        static {
            Covode.recordClassIndex(652073);
        }

        public ImageReaderListenerWrapper(ImageReader.OnImageAvailableListener onImageAvailableListener, Handler handler) {
            this.listener = onImageAvailableListener;
            this.handler = handler;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyImageReaderStatus(ImageReader.OnImageAvailableListener onImageAvailableListener, int i) {
        if (onImageAvailableListener != null) {
            try {
                Class<?> cls = onImageAvailableListener.getClass();
                Class<?> cls2 = Integer.TYPE;
                cls.getDeclaredMethod("setIntOption", cls2, cls2).invoke(onImageAvailableListener, 1, Integer.valueOf(i));
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void releaseSurface(long j, int i) {
        synchronized (AJProducerManager.class) {
            Iterator<AJImageReaderProducer> it2 = mUsingIRProducerList.iterator();
            while (it2.hasNext()) {
                AJImageReaderProducer next = it2.next();
                if (next.mUsingPlayerId == j && next.mApiType == i) {
                    it2.remove();
                    next.setOnImageAvailableListener(null, null);
                    next.mUsingPlayerId = 0L;
                    if (mFreeIRProducerList.size() >= 2) {
                        mFreeIRProducerList.remove(0).release();
                    }
                    mFreeIRProducerList.add(next);
                }
            }
        }
    }

    public static synchronized void setOnImageAvailableListener(long j, ImageReader.OnImageAvailableListener onImageAvailableListener, Handler handler) {
        synchronized (AJProducerManager.class) {
            StringBuilder sb = new StringBuilder();
            sb.append("setOnImageAvailableListener,playerId:");
            sb.append(j);
            sb.append(",listener:");
            sb.append(onImageAvailableListener);
            sb.append(",handler:");
            sb.append(handler);
            if (j == 0) {
                return;
            }
            if (onImageAvailableListener == null) {
                mIRLWrapperMap.remove(Long.valueOf(j));
            } else {
                mIRLWrapperMap.put(Long.valueOf(j), new ImageReaderListenerWrapper(onImageAvailableListener, handler));
            }
            Iterator<AJImageReaderProducer> it2 = mUsingIRProducerList.iterator();
            while (it2.hasNext()) {
                AJImageReaderProducer next = it2.next();
                if (next.mUsingPlayerId == j) {
                    next.setOnImageAvailableListener(onImageAvailableListener, handler);
                }
            }
        }
    }

    public static synchronized Surface getAvailableSurface(long j, int i, int i2) {
        synchronized (AJProducerManager.class) {
            if (j == 0) {
                return null;
            }
            ImageReaderListenerWrapper imageReaderListenerWrapper = mIRLWrapperMap.get(Long.valueOf(j));
            if (imageReaderListenerWrapper == null) {
                AVLogger.w("AJProducerManager", "no listener,playerId:" + j);
                return null;
            }
            Iterator<AJImageReaderProducer> it2 = mUsingIRProducerList.iterator();
            while (it2.hasNext()) {
                AJImageReaderProducer next = it2.next();
                if (next.mUsingPlayerId == j && next.mApiType == i) {
                    return next.getSurface();
                }
            }
            Iterator<AJImageReaderProducer> it4 = mFreeIRProducerList.iterator();
            while (it4.hasNext()) {
                AJImageReaderProducer next2 = it4.next();
                if ((i == 2 && next2.mApiType == 2) || (i != 2 && next2.mApiType != 2)) {
                    it4.remove();
                    next2.mUsingPlayerId = j;
                    mUsingIRProducerList.add(next2);
                    next2.setOnImageAvailableListener(imageReaderListenerWrapper.listener, imageReaderListenerWrapper.handler);
                    return next2.getSurface();
                }
            }
            AJImageReaderProducer aJImageReaderProducer = new AJImageReaderProducer(j, MaxImages, i);
            mUsingIRProducerList.add(aJImageReaderProducer);
            aJImageReaderProducer.setOnImageAvailableListener(imageReaderListenerWrapper.listener, imageReaderListenerWrapper.handler);
            return aJImageReaderProducer.getSurface();
        }
    }
}
