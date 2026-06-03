package com.ttreader.tthtmlparser;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class Range {
    public final int length;
    public final int location;

    static {
        Covode.recordClassIndex(654722);
    }

    public int start() {
        return this.location;
    }

    public int end() {
        return this.location + this.length;
    }

    public boolean isEmpty() {
        if (this.length == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Range=[" + start() + "," + end() + ")";
    }

    public boolean isIntersect(Range range) {
        if (end() > range.start() && range.end() > start()) {
            return true;
        }
        return false;
    }

    public Range(int i, int i2) {
        this.location = i;
        this.length = i2;
    }

    public static Range create(int i, int i2) {
        return new Range(i, i2 - i);
    }

    public boolean intersect(int i, int i2) {
        if (end() > i && i2 > start()) {
            return true;
        }
        return false;
    }
}
