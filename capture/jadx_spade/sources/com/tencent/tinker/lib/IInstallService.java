package com.tencent.tinker.lib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.IInstallCallback;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IInstallService extends IInterface {

    public static class Default implements IInstallService {
        static {
            Covode.recordClassIndex(653692);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.tinker.lib.IInstallService
        public void install(String str, int i, boolean z, IInstallCallback iInstallCallback) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IInstallService {
        static {
            Covode.recordClassIndex(653693);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        private static class Proxy implements IInstallService {
            public static IInstallService sDefaultImpl;
            private IBinder mRemote;

            static {
                Covode.recordClassIndex(653694);
            }

            public String getInterfaceDescriptor() {
                return "com.tencent.tinker.lib.IInstallService";
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.tencent.tinker.lib.IInstallService
            public void install(String str, int i, boolean z, IInstallCallback iInstallCallback) throws RemoteException {
                int i2;
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.IInstallService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    if (iInstallCallback != null) {
                        iBinder = iInstallCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().install(str, i, z, iInstallCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static IInstallService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public Stub() {
            attachInterface(this, "com.tencent.tinker.lib.IInstallService");
        }

        public static boolean setDefaultImpl(IInstallService iInstallService) {
            if (Proxy.sDefaultImpl == null && iInstallService != null) {
                Proxy.sDefaultImpl = iInstallService;
                return true;
            }
            return false;
        }

        public static IInstallService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.tinker.lib.IInstallService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IInstallService)) {
                return (IInstallService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            boolean z;
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.tencent.tinker.lib.IInstallService");
                return true;
            }
            parcel.enforceInterface("com.tencent.tinker.lib.IInstallService");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            if (parcel.readInt() != 0) {
                z = true;
            } else {
                z = false;
            }
            install(readString, readInt, z, IInstallCallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
    }

    void install(String str, int i, boolean z, IInstallCallback iInstallCallback) throws RemoteException;
}
