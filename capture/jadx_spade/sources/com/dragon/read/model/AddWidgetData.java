package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AddWidgetData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("guide_from")
    public String guideFrom;

    @SerializedName("widget_type")
    public String widgetType;

    static {
        Covode.recordClassIndex(612005);
        fieldTypeClassRef = FieldType.class;
    }
}
