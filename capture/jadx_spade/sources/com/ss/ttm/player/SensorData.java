package com.ss.ttm.player;

import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SensorData {
    private long mHandle = 0;
    private SensorManager mSensorManager = null;
    private SensorEventListener mListener = null;
    private float[] magnet = new float[3];
    private float[] accel = new float[3];

    static {
        Covode.recordClassIndex(652160);
    }

    private static final native void _writeData(long j, int i, float f, float f2, float f3);

    protected void finalize() {
        stop();
    }

    public Boolean initListeners() {
        return Boolean.FALSE;
    }

    public int start() {
        if (initListeners().booleanValue()) {
            return 0;
        }
        return -1;
    }

    public void stop() {
        Log.e("ttmn", "stop sensor");
        this.mHandle = 0L;
    }

    public void setHandle(long j, TTPlayer tTPlayer) {
        this.mHandle = j;
        tTPlayer.getContext();
    }
}
