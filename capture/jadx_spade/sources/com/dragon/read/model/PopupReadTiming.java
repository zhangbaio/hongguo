package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PopupReadTiming implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("button_text")
    public String buttonText;
    public String desc;

    @SerializedName("is_open")
    public boolean isOpen;

    @SerializedName("pop_interval")
    public List<Integer> popInterval;
    public String title;

    @SerializedName("warn_switch_enable")
    public boolean warnSwitchEnable;

    static {
        Covode.recordClassIndex(612193);
        fieldTypeClassRef = FieldType.class;
    }
}
