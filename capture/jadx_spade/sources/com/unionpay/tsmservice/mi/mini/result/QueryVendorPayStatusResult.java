package com.unionpay.tsmservice.mi.mini.result;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.covode.number.Covode;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class QueryVendorPayStatusResult extends BaseResult {
    public static final Parcelable.Creator CREATOR;
    private Bundle mStatus;

    static {
        Covode.recordClassIndex(654904);
        CREATOR = new a();
    }

    public QueryVendorPayStatusResult() {
    }

    public QueryVendorPayStatusResult(Parcel parcel) {
        this.mStatus = parcel.readBundle();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getQueryVendorPayStatusResult() {
        return this.mStatus;
    }

    @Override // com.unionpay.tsmservice.mi.mini.result.BaseResult
    public void initWithJSONObject(JSONObject jSONObject) {
    }

    public void setQueryVendorPayStatusResult(Bundle bundle) {
        this.mStatus = bundle;
    }

    @Override // com.unionpay.tsmservice.mi.mini.result.BaseResult
    public JSONObject toJSONObject() {
        return new JSONObject();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.mStatus);
    }
}
