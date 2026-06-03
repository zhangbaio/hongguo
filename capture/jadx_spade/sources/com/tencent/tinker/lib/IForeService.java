package com.tencent.tinker.lib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IForeService extends IInterface {

    public static class Default implements IForeService {
        static {
            Covode.recordClassIndex(653684);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.tinker.lib.IForeService
        public void startme() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IForeService {
        static {
            Covode.recordClassIndex(653685);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        private static class Proxy implements IForeService {
            public static IForeService sDefaultImpl;
            private IBinder mRemote;

            static {
                Covode.recordClassIndex(653686);
            }

            public String getInterfaceDescriptor() {
                return "com.tencent.tinker.lib.IForeService";
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.tinker.lib.IForeService
            public void startme() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.IForeService");
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().startme();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }
        }

        public static IForeService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public Stub() {
            attachInterface(this, "com.tencent.tinker.lib.IForeService");
        }

        public static boolean setDefaultImpl(IForeService iForeService) {
            if (Proxy.sDefaultImpl == null && iForeService != null) {
                Proxy.sDefaultImpl = iForeService;
                return true;
            }
            return false;
        }

        public static IForeService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.tinker.lib.IForeService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IForeService)) {
                return (IForeService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.tencent.tinker.lib.IForeService");
                return true;
            }
            parcel.enforceInterface("com.tencent.tinker.lib.IForeService");
            startme();
            parcel2.writeNoException();
            return true;
        }
    }

    void startme() throws RemoteException;
}
