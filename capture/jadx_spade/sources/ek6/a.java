package ek6;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface a extends IInterface {
    void onResult(String str, int i) throws RemoteException;

    /* renamed from: ek6.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0149a extends Binder implements a {
        static {
            Covode.recordClassIndex(655762);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public AbstractBinderC0149a() {
            attachInterface(this, "com.xiaomi.security.xsof.IMiSafetyDetectCallback");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.xiaomi.security.xsof.IMiSafetyDetectCallback");
                return true;
            }
            parcel.enforceInterface("com.xiaomi.security.xsof.IMiSafetyDetectCallback");
            onResult(parcel.readString(), parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }
}
