package ek6;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {
        static {
            Covode.recordClassIndex(655766);
        }

        /* renamed from: ek6.b$a$a, reason: collision with other inner class name */
        private static class C0150a implements b {
            public static b b;
            private IBinder a;

            static {
                Covode.recordClassIndex(655767);
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            C0150a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // ek6.b
            public void k1(String str, ek6.a aVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.security.xsof.IMiSafetyDetectServer");
                    obtain.writeString(str);
                    if (aVar != null) {
                        iBinder = aVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.a.transact(2, obtain, obtain2, 0) && a.s0() != null) {
                        a.s0().k1(str, aVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // ek6.b
            public void z0(String str, String str2, int i, ek6.a aVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.security.xsof.IMiSafetyDetectServer");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    if (aVar != null) {
                        iBinder = aVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.a.transact(1, obtain, obtain2, 0) && a.s0() != null) {
                        a.s0().z0(str, str2, i, aVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static b s0() {
            return C0150a.b;
        }

        public static b W(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.security.xsof.IMiSafetyDetectServer");
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new C0150a(iBinder);
        }
    }

    void k1(String str, ek6.a aVar) throws RemoteException;

    void z0(String str, String str2, int i, ek6.a aVar) throws RemoteException;
}
