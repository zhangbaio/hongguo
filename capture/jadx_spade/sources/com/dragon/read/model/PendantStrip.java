package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PendantStrip implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("asset_gear_positions")
    public List<Integer> assetGearPositions;

    @SerializedName("show_asset_stage_migration")
    public boolean showAssetStageMigration;

    @SerializedName("show_asset_strip")
    public boolean showAssetStrip;

    static {
        Covode.recordClassIndex(612185);
        fieldTypeClassRef = FieldType.class;
    }
}
