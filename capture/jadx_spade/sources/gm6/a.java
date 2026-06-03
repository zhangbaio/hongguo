package gm6;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface a extends IInterface {

    /* renamed from: gm6.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0161a extends Binder implements a {
        static {
            Covode.recordClassIndex(656174);
        }

        /* renamed from: gm6.a$a$a, reason: collision with other inner class name */
        private static class C0162a implements a {
            public static a b;
            private IBinder a;

            static {
                Covode.recordClassIndex(656175);
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // gm6.a
            public String e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    if (!this.a.transact(1, obtain, obtain2, 0) && AbstractBinderC0161a.s0() != null) {
                        return AbstractBinderC0161a.s0().e();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            C0162a(IBinder iBinder) {
                this.a = iBinder;
            }
        }

        public static a s0() {
            return C0162a.b;
        }

        public static a W(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0162a(iBinder);
        }
    }

    String e() throws RemoteException;
}
