package com.tencent.tinker.lib;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IInstallCallback extends IInterface {

    public static class Default implements IInstallCallback {
        static {
            Covode.recordClassIndex(653688);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.tinker.lib.IInstallCallback
        public void onInstallResult(boolean z) throws RemoteException {
        }

        @Override // com.tencent.tinker.lib.IInstallCallback
        public void onReportDuration(int i, Bundle bundle) throws RemoteException {
        }

        @Override // com.tencent.tinker.lib.IInstallCallback
        public void onReportStatus(int i, int i2, Bundle bundle) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IInstallCallback {
        static {
            Covode.recordClassIndex(653689);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        private static class Proxy implements IInstallCallback {
            public static IInstallCallback sDefaultImpl;
            private IBinder mRemote;

            static {
                Covode.recordClassIndex(653690);
            }

            public String getInterfaceDescriptor() {
                return "com.tencent.tinker.lib.IInstallCallback";
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.tencent.tinker.lib.IInstallCallback
            public void onInstallResult(boolean z) throws RemoteException {
                int i;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.IInstallCallback");
                    if (z) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onInstallResult(z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tinker.lib.IInstallCallback
            public void onReportDuration(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.IInstallCallback");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onReportDuration(i, bundle);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tinker.lib.IInstallCallback
            public void onReportStatus(int i, int i2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.IInstallCallback");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onReportStatus(i, i2, bundle);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static IInstallCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public Stub() {
            attachInterface(this, "com.tencent.tinker.lib.IInstallCallback");
        }

        public static boolean setDefaultImpl(IInstallCallback iInstallCallback) {
            if (Proxy.sDefaultImpl == null && iInstallCallback != null) {
                Proxy.sDefaultImpl = iInstallCallback;
                return true;
            }
            return false;
        }

        public static IInstallCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.tinker.lib.IInstallCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IInstallCallback)) {
                return (IInstallCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            boolean z;
            if (i != 1) {
                Bundle bundle = null;
                if (i != 2) {
                    if (i != 3) {
                        if (i != 1598968902) {
                            return super.onTransact(i, parcel, parcel2, i2);
                        }
                        parcel2.writeString("com.tencent.tinker.lib.IInstallCallback");
                        return true;
                    }
                    parcel.enforceInterface("com.tencent.tinker.lib.IInstallCallback");
                    int readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    onReportDuration(readInt, bundle);
                    parcel2.writeNoException();
                    return true;
                }
                parcel.enforceInterface("com.tencent.tinker.lib.IInstallCallback");
                int readInt2 = parcel.readInt();
                int readInt3 = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                onReportStatus(readInt2, readInt3, bundle);
                parcel2.writeNoException();
                return true;
            }
            parcel.enforceInterface("com.tencent.tinker.lib.IInstallCallback");
            if (parcel.readInt() != 0) {
                z = true;
            } else {
                z = false;
            }
            onInstallResult(z);
            parcel2.writeNoException();
            return true;
        }
    }

    void onInstallResult(boolean z) throws RemoteException;

    void onReportDuration(int i, Bundle bundle) throws RemoteException;

    void onReportStatus(int i, int i2, Bundle bundle) throws RemoteException;
}
