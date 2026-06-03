package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class MixTaskAwardNode implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int amount;

    @SerializedName("collect_status")
    public int collectStatus;

    @SerializedName("collected_amount")
    public int collectedAmount;

    @SerializedName("have_reader_floating_layer_popup")
    public boolean haveReaderFloatingLayerPopup;
    public String type;

    static {
        Covode.recordClassIndex(612156);
        fieldTypeClassRef = FieldType.class;
    }
}
