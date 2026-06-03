package com.ss.ttvideoengine.selector;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.model.IVideoInfo;
import com.ss.ttvideoengine.utils.Error;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SelectedInfo {
    private double calcBitRate;
    private final Error err;
    private Map<String, Object> gearResult;
    private final IVideoInfo selected;

    static {
        Covode.recordClassIndex(652642);
    }

    public Error getError() {
        return this.err;
    }

    public Map<String, Object> getGearResult() {
        return this.gearResult;
    }

    public IVideoInfo getSelected() {
        return this.selected;
    }

    public IVideoInfo getVideoInfo() {
        return this.selected;
    }

    public boolean hasError() {
        if (this.err != null) {
            return true;
        }
        return false;
    }

    public void setGearResult(Map<String, Object> map) {
        this.gearResult = map;
    }

    public SelectedInfo(IVideoInfo iVideoInfo) {
        this.calcBitRate = 0.0d;
        this.selected = iVideoInfo;
        this.err = null;
    }

    public SelectedInfo(Error error) {
        this.calcBitRate = 0.0d;
        this.selected = null;
        this.err = error;
    }

    public double getDoubleValue(int i, double d) {
        if (i == 0) {
            return this.calcBitRate;
        }
        return d;
    }

    public void setDoubleValue(int i, double d) {
        if (i == 0) {
            this.calcBitRate = d;
        }
    }

    public SelectedInfo(IVideoInfo iVideoInfo, Error error) {
        this.calcBitRate = 0.0d;
        this.selected = iVideoInfo;
        this.err = error;
    }
}
