package com.tencent.tinker.lib.am;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class BinderParcel implements Parcelable {
    public static final Parcelable.Creator<BinderParcel> CREATOR;
    private final IBinder mBinder;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    IBinder getBinder() {
        return this.mBinder;
    }

    static {
        Covode.recordClassIndex(653715);
        CREATOR = new Parcelable.Creator<BinderParcel>() { // from class: com.tencent.tinker.lib.am.BinderParcel.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public BinderParcel[] newArray(int i) {
                return new BinderParcel[i];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public BinderParcel createFromParcel(Parcel parcel) {
                return new BinderParcel(parcel);
            }
        };
    }

    BinderParcel(IBinder iBinder) {
        this.mBinder = iBinder;
    }

    BinderParcel(Parcel parcel) {
        this.mBinder = parcel.readStrongBinder();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.mBinder);
    }
}
