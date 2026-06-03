package com.tencent.tinker.lib.am;

import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.tinker.lib.am.IApplicationThread;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IPluginActivityManager extends IInterface {

    public static class Default implements IPluginActivityManager {
        static {
            Covode.recordClassIndex(653722);
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public void activityCreated(ActivityInfo activityInfo, ActivityInfo activityInfo2) throws RemoteException {
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public void activityDestroy(ActivityInfo activityInfo, ActivityInfo activityInfo2) throws RemoteException {
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public void applicationCreated(ApplicationInfo applicationInfo, String str, int i, IApplicationThread iApplicationThread) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public String getStubProcessName(String str) throws RemoteException {
            return null;
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public String getTargetProcessName(String str) throws RemoteException {
            return null;
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public ServiceInfo getTargetService(ServiceInfo serviceInfo) throws RemoteException {
            return null;
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public boolean isStubActivity(ActivityInfo activityInfo) throws RemoteException {
            return false;
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public boolean isStubProvider(ProviderInfo providerInfo) throws RemoteException {
            return false;
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public boolean isStubReceiver(ActivityInfo activityInfo) throws RemoteException {
            return false;
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public boolean isStubService(ServiceInfo serviceInfo) throws RemoteException {
            return false;
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public void receiverFinished(ActivityInfo activityInfo, ActivityInfo activityInfo2) throws RemoteException {
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public ActivityInfo selectStubActivity(ActivityInfo activityInfo) throws RemoteException {
            return null;
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public ProviderInfo selectStubProvider(ProviderInfo providerInfo) throws RemoteException {
            return null;
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public ActivityInfo selectStubReceiver(ActivityInfo activityInfo) throws RemoteException {
            return null;
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public ServiceInfo selectStubService(ServiceInfo serviceInfo) throws RemoteException {
            return null;
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public void serviceCreated(ServiceInfo serviceInfo, ServiceInfo serviceInfo2) throws RemoteException {
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public void serviceDestroy(ServiceInfo serviceInfo, ServiceInfo serviceInfo2) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IPluginActivityManager {
        static {
            Covode.recordClassIndex(653723);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        private static class Proxy implements IPluginActivityManager {
            public static IPluginActivityManager sDefaultImpl;
            private IBinder mRemote;

            static {
                Covode.recordClassIndex(653724);
            }

            public String getInterfaceDescriptor() {
                return "com.tencent.tinker.lib.am.IPluginActivityManager";
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.tencent.tinker.lib.am.IPluginActivityManager
            public String getStubProcessName(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.am.IPluginActivityManager");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(16, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getStubProcessName(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tinker.lib.am.IPluginActivityManager
            public String getTargetProcessName(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.am.IPluginActivityManager");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(15, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getTargetProcessName(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tinker.lib.am.IPluginActivityManager
            public ServiceInfo getTargetService(ServiceInfo serviceInfo) throws RemoteException {
                ServiceInfo serviceInfo2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.am.IPluginActivityManager");
                    if (serviceInfo != null) {
                        obtain.writeInt(1);
                        serviceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(17, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getTargetService(serviceInfo);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        serviceInfo2 = (ServiceInfo) ServiceInfo.CREATOR.createFromParcel(obtain2);
                    } else {
                        serviceInfo2 = null;
                    }
                    return serviceInfo2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tinker.lib.am.IPluginActivityManager
            public boolean isStubActivity(ActivityInfo activityInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.am.IPluginActivityManager");
                    boolean z = true;
                    if (activityInfo != null) {
                        obtain.writeInt(1);
                        activityInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isStubActivity(activityInfo);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tinker.lib.am.IPluginActivityManager
            public boolean isStubProvider(ProviderInfo providerInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.am.IPluginActivityManager");
                    boolean z = true;
                    if (providerInfo != null) {
                        obtain.writeInt(1);
                        providerInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isStubProvider(providerInfo);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tinker.lib.am.IPluginActivityManager
            public boolean isStubReceiver(ActivityInfo activityInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.am.IPluginActivityManager");
                    boolean z = true;
                    if (activityInfo != null) {
                        obtain.writeInt(1);
                        activityInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isStubReceiver(activityInfo);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tinker.lib.am.IPluginActivityManager
            public boolean isStubService(ServiceInfo serviceInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.am.IPluginActivityManager");
                    boolean z = true;
                    if (serviceInfo != null) {
                        obtain.writeInt(1);
                        serviceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isStubService(serviceInfo);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tinker.lib.am.IPluginActivityManager
            public ActivityInfo selectStubActivity(ActivityInfo activityInfo) throws RemoteException {
                ActivityInfo activityInfo2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.am.IPluginActivityManager");
                    if (activityInfo != null) {
                        obtain.writeInt(1);
                        activityInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().selectStubActivity(activityInfo);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        activityInfo2 = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(obtain2);
                    } else {
                        activityInfo2 = null;
                    }
                    return activityInfo2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tinker.lib.am.IPluginActivityManager
            public ProviderInfo selectStubProvider(ProviderInfo providerInfo) throws RemoteException {
                ProviderInfo providerInfo2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.am.IPluginActivityManager");
                    if (providerInfo != null) {
                        obtain.writeInt(1);
                        providerInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().selectStubProvider(providerInfo);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        providerInfo2 = (ProviderInfo) ProviderInfo.CREATOR.createFromParcel(obtain2);
                    } else {
                        providerInfo2 = null;
                    }
                    return providerInfo2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tinker.lib.am.IPluginActivityManager
            public ActivityInfo selectStubReceiver(ActivityInfo activityInfo) throws RemoteException {
                ActivityInfo activityInfo2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.am.IPluginActivityManager");
                    if (activityInfo != null) {
                        obtain.writeInt(1);
                        activityInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().selectStubReceiver(activityInfo);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        activityInfo2 = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(obtain2);
                    } else {
                        activityInfo2 = null;
                    }
                    return activityInfo2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tinker.lib.am.IPluginActivityManager
            public ServiceInfo selectStubService(ServiceInfo serviceInfo) throws RemoteException {
                ServiceInfo serviceInfo2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.am.IPluginActivityManager");
                    if (serviceInfo != null) {
                        obtain.writeInt(1);
                        serviceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().selectStubService(serviceInfo);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        serviceInfo2 = (ServiceInfo) ServiceInfo.CREATOR.createFromParcel(obtain2);
                    } else {
                        serviceInfo2 = null;
                    }
                    return serviceInfo2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tinker.lib.am.IPluginActivityManager
            public void activityCreated(ActivityInfo activityInfo, ActivityInfo activityInfo2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.am.IPluginActivityManager");
                    if (activityInfo != null) {
                        obtain.writeInt(1);
                        activityInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (activityInfo2 != null) {
                        obtain.writeInt(1);
                        activityInfo2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().activityCreated(activityInfo, activityInfo2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tinker.lib.am.IPluginActivityManager
            public void activityDestroy(ActivityInfo activityInfo, ActivityInfo activityInfo2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.am.IPluginActivityManager");
                    if (activityInfo != null) {
                        obtain.writeInt(1);
                        activityInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (activityInfo2 != null) {
                        obtain.writeInt(1);
                        activityInfo2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().activityDestroy(activityInfo, activityInfo2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tinker.lib.am.IPluginActivityManager
            public void receiverFinished(ActivityInfo activityInfo, ActivityInfo activityInfo2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.am.IPluginActivityManager");
                    if (activityInfo != null) {
                        obtain.writeInt(1);
                        activityInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (activityInfo2 != null) {
                        obtain.writeInt(1);
                        activityInfo2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().receiverFinished(activityInfo, activityInfo2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tinker.lib.am.IPluginActivityManager
            public void serviceCreated(ServiceInfo serviceInfo, ServiceInfo serviceInfo2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.am.IPluginActivityManager");
                    if (serviceInfo != null) {
                        obtain.writeInt(1);
                        serviceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (serviceInfo2 != null) {
                        obtain.writeInt(1);
                        serviceInfo2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().serviceCreated(serviceInfo, serviceInfo2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tinker.lib.am.IPluginActivityManager
            public void serviceDestroy(ServiceInfo serviceInfo, ServiceInfo serviceInfo2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.am.IPluginActivityManager");
                    if (serviceInfo != null) {
                        obtain.writeInt(1);
                        serviceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (serviceInfo2 != null) {
                        obtain.writeInt(1);
                        serviceInfo2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().serviceDestroy(serviceInfo, serviceInfo2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tinker.lib.am.IPluginActivityManager
            public void applicationCreated(ApplicationInfo applicationInfo, String str, int i, IApplicationThread iApplicationThread) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.am.IPluginActivityManager");
                    if (applicationInfo != null) {
                        obtain.writeInt(1);
                        applicationInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (iApplicationThread != null) {
                        iBinder = iApplicationThread.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().applicationCreated(applicationInfo, str, i, iApplicationThread);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static IPluginActivityManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public Stub() {
            attachInterface(this, "com.tencent.tinker.lib.am.IPluginActivityManager");
        }

        public static boolean setDefaultImpl(IPluginActivityManager iPluginActivityManager) {
            if (Proxy.sDefaultImpl == null && iPluginActivityManager != null) {
                Proxy.sDefaultImpl = iPluginActivityManager;
                return true;
            }
            return false;
        }

        public static IPluginActivityManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.tinker.lib.am.IPluginActivityManager");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IPluginActivityManager)) {
                return (IPluginActivityManager) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            ActivityInfo activityInfo;
            ActivityInfo activityInfo2;
            ServiceInfo serviceInfo;
            ServiceInfo serviceInfo2;
            ActivityInfo activityInfo3;
            if (i != 1598968902) {
                ActivityInfo activityInfo4 = null;
                ServiceInfo serviceInfo3 = null;
                ProviderInfo providerInfo = null;
                ActivityInfo activityInfo5 = null;
                ServiceInfo serviceInfo4 = null;
                ActivityInfo activityInfo6 = null;
                ActivityInfo activityInfo7 = null;
                ServiceInfo serviceInfo5 = null;
                ServiceInfo serviceInfo6 = null;
                ActivityInfo activityInfo8 = null;
                ActivityInfo activityInfo9 = null;
                ApplicationInfo applicationInfo = null;
                ProviderInfo providerInfo2 = null;
                ServiceInfo serviceInfo7 = null;
                ActivityInfo activityInfo10 = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.tencent.tinker.lib.am.IPluginActivityManager");
                        if (parcel.readInt() != 0) {
                            activityInfo4 = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(parcel);
                        }
                        ActivityInfo selectStubActivity = selectStubActivity(activityInfo4);
                        parcel2.writeNoException();
                        if (selectStubActivity != null) {
                            parcel2.writeInt(1);
                            selectStubActivity.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 2:
                        parcel.enforceInterface("com.tencent.tinker.lib.am.IPluginActivityManager");
                        if (parcel.readInt() != 0) {
                            activityInfo10 = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(parcel);
                        }
                        ActivityInfo selectStubReceiver = selectStubReceiver(activityInfo10);
                        parcel2.writeNoException();
                        if (selectStubReceiver != null) {
                            parcel2.writeInt(1);
                            selectStubReceiver.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 3:
                        parcel.enforceInterface("com.tencent.tinker.lib.am.IPluginActivityManager");
                        if (parcel.readInt() != 0) {
                            serviceInfo7 = (ServiceInfo) ServiceInfo.CREATOR.createFromParcel(parcel);
                        }
                        ServiceInfo selectStubService = selectStubService(serviceInfo7);
                        parcel2.writeNoException();
                        if (selectStubService != null) {
                            parcel2.writeInt(1);
                            selectStubService.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 4:
                        parcel.enforceInterface("com.tencent.tinker.lib.am.IPluginActivityManager");
                        if (parcel.readInt() != 0) {
                            providerInfo2 = (ProviderInfo) ProviderInfo.CREATOR.createFromParcel(parcel);
                        }
                        ProviderInfo selectStubProvider = selectStubProvider(providerInfo2);
                        parcel2.writeNoException();
                        if (selectStubProvider != null) {
                            parcel2.writeInt(1);
                            selectStubProvider.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 5:
                        parcel.enforceInterface("com.tencent.tinker.lib.am.IPluginActivityManager");
                        if (parcel.readInt() != 0) {
                            applicationInfo = (ApplicationInfo) ApplicationInfo.CREATOR.createFromParcel(parcel);
                        }
                        applicationCreated(applicationInfo, parcel.readString(), parcel.readInt(), IApplicationThread.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                        parcel.enforceInterface("com.tencent.tinker.lib.am.IPluginActivityManager");
                        if (parcel.readInt() != 0) {
                            activityInfo = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(parcel);
                        } else {
                            activityInfo = null;
                        }
                        if (parcel.readInt() != 0) {
                            activityInfo9 = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(parcel);
                        }
                        activityCreated(activityInfo, activityInfo9);
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.tencent.tinker.lib.am.IPluginActivityManager");
                        if (parcel.readInt() != 0) {
                            activityInfo2 = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(parcel);
                        } else {
                            activityInfo2 = null;
                        }
                        if (parcel.readInt() != 0) {
                            activityInfo8 = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(parcel);
                        }
                        activityDestroy(activityInfo2, activityInfo8);
                        parcel2.writeNoException();
                        return true;
                    case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                        parcel.enforceInterface("com.tencent.tinker.lib.am.IPluginActivityManager");
                        if (parcel.readInt() != 0) {
                            serviceInfo = (ServiceInfo) ServiceInfo.CREATOR.createFromParcel(parcel);
                        } else {
                            serviceInfo = null;
                        }
                        if (parcel.readInt() != 0) {
                            serviceInfo6 = (ServiceInfo) ServiceInfo.CREATOR.createFromParcel(parcel);
                        }
                        serviceCreated(serviceInfo, serviceInfo6);
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.tencent.tinker.lib.am.IPluginActivityManager");
                        if (parcel.readInt() != 0) {
                            serviceInfo2 = (ServiceInfo) ServiceInfo.CREATOR.createFromParcel(parcel);
                        } else {
                            serviceInfo2 = null;
                        }
                        if (parcel.readInt() != 0) {
                            serviceInfo5 = (ServiceInfo) ServiceInfo.CREATOR.createFromParcel(parcel);
                        }
                        serviceDestroy(serviceInfo2, serviceInfo5);
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.tencent.tinker.lib.am.IPluginActivityManager");
                        if (parcel.readInt() != 0) {
                            activityInfo3 = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(parcel);
                        } else {
                            activityInfo3 = null;
                        }
                        if (parcel.readInt() != 0) {
                            activityInfo7 = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(parcel);
                        }
                        receiverFinished(activityInfo3, activityInfo7);
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.tencent.tinker.lib.am.IPluginActivityManager");
                        if (parcel.readInt() != 0) {
                            activityInfo6 = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(parcel);
                        }
                        boolean isStubActivity = isStubActivity(activityInfo6);
                        parcel2.writeNoException();
                        parcel2.writeInt(isStubActivity ? 1 : 0);
                        return true;
                    case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                        parcel.enforceInterface("com.tencent.tinker.lib.am.IPluginActivityManager");
                        if (parcel.readInt() != 0) {
                            serviceInfo4 = (ServiceInfo) ServiceInfo.CREATOR.createFromParcel(parcel);
                        }
                        boolean isStubService = isStubService(serviceInfo4);
                        parcel2.writeNoException();
                        parcel2.writeInt(isStubService ? 1 : 0);
                        return true;
                    case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                        parcel.enforceInterface("com.tencent.tinker.lib.am.IPluginActivityManager");
                        if (parcel.readInt() != 0) {
                            activityInfo5 = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(parcel);
                        }
                        boolean isStubReceiver = isStubReceiver(activityInfo5);
                        parcel2.writeNoException();
                        parcel2.writeInt(isStubReceiver ? 1 : 0);
                        return true;
                    case 14:
                        parcel.enforceInterface("com.tencent.tinker.lib.am.IPluginActivityManager");
                        if (parcel.readInt() != 0) {
                            providerInfo = (ProviderInfo) ProviderInfo.CREATOR.createFromParcel(parcel);
                        }
                        boolean isStubProvider = isStubProvider(providerInfo);
                        parcel2.writeNoException();
                        parcel2.writeInt(isStubProvider ? 1 : 0);
                        return true;
                    case 15:
                        parcel.enforceInterface("com.tencent.tinker.lib.am.IPluginActivityManager");
                        String targetProcessName = getTargetProcessName(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(targetProcessName);
                        return true;
                    case 16:
                        parcel.enforceInterface("com.tencent.tinker.lib.am.IPluginActivityManager");
                        String stubProcessName = getStubProcessName(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(stubProcessName);
                        return true;
                    case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                        parcel.enforceInterface("com.tencent.tinker.lib.am.IPluginActivityManager");
                        if (parcel.readInt() != 0) {
                            serviceInfo3 = (ServiceInfo) ServiceInfo.CREATOR.createFromParcel(parcel);
                        }
                        ServiceInfo targetService = getTargetService(serviceInfo3);
                        parcel2.writeNoException();
                        if (targetService != null) {
                            parcel2.writeInt(1);
                            targetService.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.tencent.tinker.lib.am.IPluginActivityManager");
            return true;
        }
    }

    void activityCreated(ActivityInfo activityInfo, ActivityInfo activityInfo2) throws RemoteException;

    void activityDestroy(ActivityInfo activityInfo, ActivityInfo activityInfo2) throws RemoteException;

    void applicationCreated(ApplicationInfo applicationInfo, String str, int i, IApplicationThread iApplicationThread) throws RemoteException;

    String getStubProcessName(String str) throws RemoteException;

    String getTargetProcessName(String str) throws RemoteException;

    ServiceInfo getTargetService(ServiceInfo serviceInfo) throws RemoteException;

    boolean isStubActivity(ActivityInfo activityInfo) throws RemoteException;

    boolean isStubProvider(ProviderInfo providerInfo) throws RemoteException;

    boolean isStubReceiver(ActivityInfo activityInfo) throws RemoteException;

    boolean isStubService(ServiceInfo serviceInfo) throws RemoteException;

    void receiverFinished(ActivityInfo activityInfo, ActivityInfo activityInfo2) throws RemoteException;

    ActivityInfo selectStubActivity(ActivityInfo activityInfo) throws RemoteException;

    ProviderInfo selectStubProvider(ProviderInfo providerInfo) throws RemoteException;

    ActivityInfo selectStubReceiver(ActivityInfo activityInfo) throws RemoteException;

    ServiceInfo selectStubService(ServiceInfo serviceInfo) throws RemoteException;

    void serviceCreated(ServiceInfo serviceInfo, ServiceInfo serviceInfo2) throws RemoteException;

    void serviceDestroy(ServiceInfo serviceInfo, ServiceInfo serviceInfo2) throws RemoteException;
}
