package com.ttnet.org.chromium.base.library_loader;

import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.h;
import com.ttnet.org.chromium.base.n;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
abstract class Linker {
    private static Linker d;
    protected final Object a = new Object();
    boolean b = true;
    protected int c = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface PreferAddress {
    }

    @Retention(RetentionPolicy.SOURCE)
    protected @interface RelroSharingMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    protected @interface State {
    }

    static class LibInfo implements Parcelable {
        public static final Parcelable.Creator<LibInfo> CREATOR;
        public String mLibFilePath;
        public long mLoadAddress;
        public long mLoadSize;
        public int mRelroFd;
        public long mRelroSize;
        public long mRelroStart;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 1;
        }

        LibInfo() {
            this.mRelroFd = -1;
        }

        static {
            Covode.recordClassIndex(654345);
            CREATOR = new a();
        }

        public void close() {
            int i = this.mRelroFd;
            if (i >= 0) {
                n.a(ParcelFileDescriptor.adoptFd(i));
                this.mRelroFd = -1;
            }
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("libinfo", this);
            return bundle;
        }

        class a implements Parcelable.Creator<LibInfo> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public LibInfo[] newArray(int i) {
                return new LibInfo[i];
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public LibInfo createFromParcel(Parcel parcel) {
                return new LibInfo(parcel);
            }
        }

        public static LibInfo fromBundle(Bundle bundle) {
            bundle.setClassLoader(Linker.class.getClassLoader());
            return (LibInfo) bundle.getParcelable("libinfo");
        }

        LibInfo(Parcel parcel) {
            boolean z;
            this.mRelroFd = -1;
            this.mLibFilePath = parcel.readString();
            this.mLoadAddress = parcel.readLong();
            this.mLoadSize = parcel.readLong();
            this.mRelroStart = parcel.readLong();
            this.mRelroSize = parcel.readLong();
            if (parcel.readInt() != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
                if (parcelFileDescriptor != null) {
                    this.mRelroFd = parcelFileDescriptor.detachFd();
                    return;
                }
                return;
            }
            this.mRelroFd = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            parcel.writeString(this.mLibFilePath);
            parcel.writeLong(this.mLoadAddress);
            parcel.writeLong(this.mLoadSize);
            parcel.writeLong(this.mRelroStart);
            parcel.writeLong(this.mRelroSize);
            if (this.mRelroFd >= 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            int i3 = this.mRelroFd;
            if (i3 >= 0) {
                try {
                    ParcelFileDescriptor fromFd = ParcelFileDescriptor.fromFd(i3);
                    fromFd.writeToParcel(parcel, 0);
                    fromFd.close();
                } catch (IOException e) {
                    h.b("Linker", "Can't write LibInfo file descriptor to parcel", e);
                }
            }
        }
    }

    static {
        Covode.recordClassIndex(654344);
    }

    protected Linker() {
        d = this;
    }
}
