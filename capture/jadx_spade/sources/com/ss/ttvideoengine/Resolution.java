package com.ss.ttvideoengine;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.model.VideoRef;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public enum Resolution {
    Undefine("", ""),
    Standard("360p", "medium"),
    High("480p", "higher"),
    SuperHigh("720p", "highest"),
    ExtremelyHigh("1080p", "original"),
    FourK("4k", "lossless"),
    HDR("hdr", ""),
    Auto("auto", ""),
    L_Standard("240p", ""),
    H_High("540p", ""),
    TwoK("2k", ""),
    ExtremelyHigh_50F("1080p 50fps", ""),
    TwoK_50F("2k 50fps", ""),
    FourK_50F("4k 50fps", ""),
    ExtremelyHigh_60F("1080p 60fps", ""),
    TwoK_60F("2k 60fps", ""),
    FourK_60F("4k 60fps", ""),
    ExtremelyHigh_120F("1080p 120fps", ""),
    TwoK_120F("2k 120fps", ""),
    FourK_120F("4k 120fps", ""),
    L_Standard_HDR("240p HDR", ""),
    Standard_HDR("360p HDR", ""),
    High_HDR("480p HDR", ""),
    H_High_HDR("540p HDR", ""),
    SuperHigh_HDR("720p HDR", ""),
    ExtremelyHigh_HDR("1080p HDR", ""),
    TwoK_HDR("2k HDR", ""),
    FourK_HDR("4k HDR", ""),
    EightK("8k", ""),
    ExtremelyHighPlus("1080p+", "");

    private final String audioquality;
    private final String resolution;

    @Override // java.lang.Enum
    public String toString() {
        return this.resolution;
    }

    public int getIndex() {
        return ordinal();
    }

    public static Resolution[] getAllResolutions() {
        try {
            return new Resolution[]{Undefine, L_Standard, Standard, High, H_High, SuperHigh, ExtremelyHigh, ExtremelyHighPlus, ExtremelyHigh_50F, ExtremelyHigh_60F, ExtremelyHigh_120F, HDR, TwoK, TwoK_50F, TwoK_60F, TwoK_120F, FourK, FourK_50F, FourK_60F, FourK_120F, L_Standard_HDR, Standard_HDR, High_HDR, H_High_HDR, SuperHigh_HDR, ExtremelyHigh_HDR, TwoK_HDR, FourK_HDR, EightK};
        } catch (Exception unused) {
            return new Resolution[0];
        }
    }

    static {
        Covode.recordClassIndex(652311);
    }

    public static Resolution valueOf(int i) {
        Resolution resolution = Undefine;
        if (i >= resolution.ordinal() && i <= FourK_HDR.ordinal()) {
            return values()[i];
        }
        return resolution;
    }

    public String toString(int i) {
        if (i == VideoRef.TYPE_AUDIO) {
            return this.audioquality;
        }
        if (i == VideoRef.TYPE_VIDEO) {
            return this.resolution;
        }
        return "";
    }

    public static String toString(Resolution resolution) {
        if (resolution == null || resolution == Undefine) {
            return "Undefine";
        }
        if (resolution == Standard) {
            return "Standard";
        }
        if (resolution == High) {
            return "High";
        }
        if (resolution == SuperHigh) {
            return "SuperHigh";
        }
        if (resolution == FourK) {
            return "FourK";
        }
        if (resolution == HDR) {
            return "HDR";
        }
        if (resolution == Auto) {
            return "Auto";
        }
        if (resolution == L_Standard) {
            return "L_Standard";
        }
        if (resolution == H_High) {
            return "H_High";
        }
        if (resolution == TwoK) {
            return "TwoK";
        }
        if (resolution == ExtremelyHigh_50F) {
            return "ExtremelyHigh_50F";
        }
        if (resolution == TwoK_50F) {
            return "TwoK_50F";
        }
        if (resolution == FourK_50F) {
            return "FourK_50F";
        }
        if (resolution == ExtremelyHigh_60F) {
            return "ExtremelyHigh_60F";
        }
        if (resolution == TwoK_60F) {
            return "TwoK_60F";
        }
        if (resolution == FourK_60F) {
            return "FourK_60F";
        }
        if (resolution == ExtremelyHigh_120F) {
            return "ExtremelyHigh_120F";
        }
        if (resolution == TwoK_120F) {
            return "TwoK_120F";
        }
        if (resolution == FourK_120F) {
            return "FourK_120F";
        }
        if (resolution == L_Standard_HDR) {
            return "L_Standard_HDR";
        }
        if (resolution == Standard_HDR) {
            return "Standard_HDR";
        }
        if (resolution == High_HDR) {
            return "High_HDR";
        }
        if (resolution == H_High_HDR) {
            return "H_High_HDR";
        }
        if (resolution == SuperHigh_HDR) {
            return "SuperHigh_HDR";
        }
        if (resolution == ExtremelyHigh_HDR) {
            return "ExtremelyHigh_HDR";
        }
        if (resolution == TwoK_HDR) {
            return "TwoK_HDR";
        }
        if (resolution == FourK_HDR) {
            return "FourK_HDR";
        }
        if (resolution == EightK) {
            return "EightK";
        }
        if (resolution != ExtremelyHighPlus) {
            return "Undefine";
        }
        return "1080p+";
    }

    public static Resolution forString(String str) {
        if (TextUtils.isEmpty(str)) {
            return Undefine;
        }
        if (str.equals("Undefine")) {
            return Undefine;
        }
        if (str.equals("Standard")) {
            return Standard;
        }
        if (str.equals("High")) {
            return High;
        }
        if (str.equals("SuperHigh")) {
            return SuperHigh;
        }
        if (str.equals("FourK")) {
            return FourK;
        }
        if (str.equals("HDR")) {
            return HDR;
        }
        if (str.equals("Auto")) {
            return Auto;
        }
        if (str.equals("L_Standard")) {
            return L_Standard;
        }
        if (str.equals("H_High")) {
            return H_High;
        }
        if (str.equals("TwoK")) {
            return TwoK;
        }
        if (str.equals("ExtremelyHigh_50F")) {
            return ExtremelyHigh_50F;
        }
        if (str.equals("TwoK_50F")) {
            return TwoK_50F;
        }
        if (str.equals("FourK_50F")) {
            return FourK_50F;
        }
        if (str.equals("ExtremelyHigh_60F")) {
            return ExtremelyHigh_60F;
        }
        if (str.equals("TwoK_60F")) {
            return TwoK_60F;
        }
        if (str.equals("FourK_60F")) {
            return FourK_60F;
        }
        if (str.equals("ExtremelyHigh_120F")) {
            return ExtremelyHigh_120F;
        }
        if (str.equals("TwoK_120F")) {
            return TwoK_120F;
        }
        if (str.equals("FourK_120F")) {
            return FourK_120F;
        }
        if (str.equals("L_Standard_HDR")) {
            return L_Standard_HDR;
        }
        if (str.equals("Standard_HDR")) {
            return Standard_HDR;
        }
        if (str.equals("High_HDR")) {
            return High_HDR;
        }
        if (str.equals("H_High_HDR")) {
            return H_High_HDR;
        }
        if (str.equals("SuperHigh_HDR")) {
            return SuperHigh_HDR;
        }
        if (str.equals("ExtremelyHigh_HDR")) {
            return ExtremelyHigh_HDR;
        }
        if (str.equals("TwoK_HDR")) {
            return TwoK_HDR;
        }
        if (str.equals("FourK_HDR")) {
            return FourK_HDR;
        }
        if (str.equals("EightK")) {
            return EightK;
        }
        if (str.equals("1080p+")) {
            return ExtremelyHighPlus;
        }
        return Undefine;
    }

    Resolution(String str, String str2) {
        this.resolution = str;
        this.audioquality = str2;
    }
}
