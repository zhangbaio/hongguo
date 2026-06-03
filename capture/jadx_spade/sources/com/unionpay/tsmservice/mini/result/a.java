package com.unionpay.tsmservice.mini.result;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class a implements Parcelable.Creator {
    a() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final QueryVendorPayStatusResult createFromParcel(Parcel parcel) {
        return new QueryVendorPayStatusResult(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final QueryVendorPayStatusResult[] newArray(int i) {
        return new QueryVendorPayStatusResult[i];
    }
}
