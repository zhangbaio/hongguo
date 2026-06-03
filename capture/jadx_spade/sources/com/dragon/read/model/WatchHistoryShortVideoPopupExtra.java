package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class WatchHistoryShortVideoPopupExtra implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("bonus_list")
    public List<WatchHistoryShortVideoBonus> bonusList;

    @SerializedName("current_index")
    public int currentIndex;

    @SerializedName("excitation_ad")
    public ExcitationAdData excitationAd;

    @SerializedName("last_day_double")
    public boolean lastDayDouble;

    @SerializedName("today_completed")
    public boolean todayCompleted;

    static {
        Covode.recordClassIndex(612299);
        fieldTypeClassRef = FieldType.class;
    }
}
