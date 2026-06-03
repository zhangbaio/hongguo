package com.tencent.tinker.lib.pm;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IPluginPackageManager extends IInterface {

    public static class Default implements IPluginPackageManager {
        static {
            Covode.recordClassIndex(653774);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.tinker.lib.pm.IPluginPackageManager
        public ActivityInfo getActivityInfo(ComponentName componentName, int i) throws RemoteException {
            return null;
        }

        @Override // com.tencent.tinker.lib.pm.IPluginPackageManager
        public ProviderInfo getProviderInfo(ComponentName componentName, int i) throws RemoteException {
            return null;
        }

        @Override // com.tencent.tinker.lib.pm.IPluginPackageManager
        public List<ProviderInfo> getProviders(String str, int i) throws RemoteException {
            return null;
        }

        @Override // com.tencent.tinker.lib.pm.IPluginPackageManager
        public ActivityInfo getReceiverInfo(ComponentName componentName, int i) throws RemoteException {
            return null;
        }

        @Override // com.tencent.tinker.lib.pm.IPluginPackageManager
        public List<ReceiverInfo> getReceivers(String str, int i) throws RemoteException {
            return null;
        }

        @Override // com.tencent.tinker.lib.pm.IPluginPackageManager
        public ServiceInfo getServiceInfo(ComponentName componentName, int i) throws RemoteException {
            return null;
        }

        @Override // com.tencent.tinker.lib.pm.IPluginPackageManager
        public List<ResolveInfo> queryBroadcastReceivers(Intent intent, String str, int i) throws RemoteException {
            return null;
        }

        @Override // com.tencent.tinker.lib.pm.IPluginPackageManager
        public List<ResolveInfo> queryIntentActivities(Intent intent, String str, int i) throws RemoteException {
            return null;
        }

        @Override // com.tencent.tinker.lib.pm.IPluginPackageManager
        public List<ResolveInfo> queryIntentServices(Intent intent, String str, int i) throws RemoteException {
            return null;
        }

        @Override // com.tencent.tinker.lib.pm.IPluginPackageManager
        public ProviderInfo resolveContentProvider(String str, int i) throws RemoteException {
            return null;
        }

        @Override // com.tencent.tinker.lib.pm.IPluginPackageManager
        public ResolveInfo resolveIntent(Intent intent, String str, int i) throws RemoteException {
            return null;
        }

        @Override // com.tencent.tinker.lib.pm.IPluginPackageManager
        public ResolveInfo resolveService(Intent intent, String str, int i) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IPluginPackageManager {
        static {
            Covode.recordClassIndex(653775);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        private static class Proxy implements IPluginPackageManager {
            public static IPluginPackageManager sDefaultImpl;
            private IBinder mRemote;

            static {
                Covode.recordClassIndex(653776);
            }

            public String getInterfaceDescriptor() {
                return "com.tencent.tinker.lib.pm.IPluginPackageManager";
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.tencent.tinker.lib.pm.IPluginPackageManager
            public ActivityInfo getActivityInfo(ComponentName componentName, int i) throws RemoteException {
                ActivityInfo activityInfo;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.pm.IPluginPackageManager");
                    if (componentName != null) {
                        obtain.writeInt(1);
                        componentName.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getActivityInfo(componentName, i);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        activityInfo = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(obtain2);
                    } else {
                        activityInfo = null;
                    }
                    return activityInfo;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tinker.lib.pm.IPluginPackageManager
            public ProviderInfo getProviderInfo(ComponentName componentName, int i) throws RemoteException {
                ProviderInfo providerInfo;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.pm.IPluginPackageManager");
                    if (componentName != null) {
                        obtain.writeInt(1);
                        componentName.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getProviderInfo(componentName, i);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        providerInfo = (ProviderInfo) ProviderInfo.CREATOR.createFromParcel(obtain2);
                    } else {
                        providerInfo = null;
                    }
                    return providerInfo;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tinker.lib.pm.IPluginPackageManager
            public List<ProviderInfo> getProviders(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.pm.IPluginPackageManager");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getProviders(str, i);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(ProviderInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tinker.lib.pm.IPluginPackageManager
            public ActivityInfo getReceiverInfo(ComponentName componentName, int i) throws RemoteException {
                ActivityInfo activityInfo;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.pm.IPluginPackageManager");
                    if (componentName != null) {
                        obtain.writeInt(1);
                        componentName.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getReceiverInfo(componentName, i);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        activityInfo = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(obtain2);
                    } else {
                        activityInfo = null;
                    }
                    return activityInfo;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tinker.lib.pm.IPluginPackageManager
            public List<ReceiverInfo> getReceivers(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.pm.IPluginPackageManager");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getReceivers(str, i);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(ReceiverInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tinker.lib.pm.IPluginPackageManager
            public ServiceInfo getServiceInfo(ComponentName componentName, int i) throws RemoteException {
                ServiceInfo serviceInfo;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.pm.IPluginPackageManager");
                    if (componentName != null) {
                        obtain.writeInt(1);
                        componentName.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getServiceInfo(componentName, i);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        serviceInfo = (ServiceInfo) ServiceInfo.CREATOR.createFromParcel(obtain2);
                    } else {
                        serviceInfo = null;
                    }
                    return serviceInfo;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tinker.lib.pm.IPluginPackageManager
            public ProviderInfo resolveContentProvider(String str, int i) throws RemoteException {
                ProviderInfo providerInfo;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.pm.IPluginPackageManager");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().resolveContentProvider(str, i);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        providerInfo = (ProviderInfo) ProviderInfo.CREATOR.createFromParcel(obtain2);
                    } else {
                        providerInfo = null;
                    }
                    return providerInfo;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tinker.lib.pm.IPluginPackageManager
            public List<ResolveInfo> queryBroadcastReceivers(Intent intent, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.pm.IPluginPackageManager");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().queryBroadcastReceivers(intent, str, i);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(ResolveInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tinker.lib.pm.IPluginPackageManager
            public List<ResolveInfo> queryIntentActivities(Intent intent, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.pm.IPluginPackageManager");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().queryIntentActivities(intent, str, i);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(ResolveInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tinker.lib.pm.IPluginPackageManager
            public List<ResolveInfo> queryIntentServices(Intent intent, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.pm.IPluginPackageManager");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().queryIntentServices(intent, str, i);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(ResolveInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tinker.lib.pm.IPluginPackageManager
            public ResolveInfo resolveIntent(Intent intent, String str, int i) throws RemoteException {
                ResolveInfo resolveInfo;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.pm.IPluginPackageManager");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().resolveIntent(intent, str, i);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        resolveInfo = (ResolveInfo) ResolveInfo.CREATOR.createFromParcel(obtain2);
                    } else {
                        resolveInfo = null;
                    }
                    return resolveInfo;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tinker.lib.pm.IPluginPackageManager
            public ResolveInfo resolveService(Intent intent, String str, int i) throws RemoteException {
                ResolveInfo resolveInfo;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tinker.lib.pm.IPluginPackageManager");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().resolveService(intent, str, i);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        resolveInfo = (ResolveInfo) ResolveInfo.CREATOR.createFromParcel(obtain2);
                    } else {
                        resolveInfo = null;
                    }
                    return resolveInfo;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static IPluginPackageManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public Stub() {
            attachInterface(this, "com.tencent.tinker.lib.pm.IPluginPackageManager");
        }

        public static boolean setDefaultImpl(IPluginPackageManager iPluginPackageManager) {
            if (Proxy.sDefaultImpl == null && iPluginPackageManager != null) {
                Proxy.sDefaultImpl = iPluginPackageManager;
                return true;
            }
            return false;
        }

        public static IPluginPackageManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.tinker.lib.pm.IPluginPackageManager");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IPluginPackageManager)) {
                return (IPluginPackageManager) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                ComponentName componentName = null;
                Intent intent = null;
                Intent intent2 = null;
                Intent intent3 = null;
                Intent intent4 = null;
                Intent intent5 = null;
                ComponentName componentName2 = null;
                ComponentName componentName3 = null;
                ComponentName componentName4 = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.tencent.tinker.lib.pm.IPluginPackageManager");
                        if (parcel.readInt() != 0) {
                            componentName = (ComponentName) ComponentName.CREATOR.createFromParcel(parcel);
                        }
                        ActivityInfo activityInfo = getActivityInfo(componentName, parcel.readInt());
                        parcel2.writeNoException();
                        if (activityInfo != null) {
                            parcel2.writeInt(1);
                            activityInfo.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 2:
                        parcel.enforceInterface("com.tencent.tinker.lib.pm.IPluginPackageManager");
                        if (parcel.readInt() != 0) {
                            componentName4 = (ComponentName) ComponentName.CREATOR.createFromParcel(parcel);
                        }
                        ServiceInfo serviceInfo = getServiceInfo(componentName4, parcel.readInt());
                        parcel2.writeNoException();
                        if (serviceInfo != null) {
                            parcel2.writeInt(1);
                            serviceInfo.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 3:
                        parcel.enforceInterface("com.tencent.tinker.lib.pm.IPluginPackageManager");
                        if (parcel.readInt() != 0) {
                            componentName3 = (ComponentName) ComponentName.CREATOR.createFromParcel(parcel);
                        }
                        ActivityInfo receiverInfo = getReceiverInfo(componentName3, parcel.readInt());
                        parcel2.writeNoException();
                        if (receiverInfo != null) {
                            parcel2.writeInt(1);
                            receiverInfo.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 4:
                        parcel.enforceInterface("com.tencent.tinker.lib.pm.IPluginPackageManager");
                        if (parcel.readInt() != 0) {
                            componentName2 = (ComponentName) ComponentName.CREATOR.createFromParcel(parcel);
                        }
                        ProviderInfo providerInfo = getProviderInfo(componentName2, parcel.readInt());
                        parcel2.writeNoException();
                        if (providerInfo != null) {
                            parcel2.writeInt(1);
                            providerInfo.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 5:
                        parcel.enforceInterface("com.tencent.tinker.lib.pm.IPluginPackageManager");
                        if (parcel.readInt() != 0) {
                            intent5 = (Intent) Intent.CREATOR.createFromParcel(parcel);
                        }
                        ResolveInfo resolveIntent = resolveIntent(intent5, parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        if (resolveIntent != null) {
                            parcel2.writeInt(1);
                            resolveIntent.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                        parcel.enforceInterface("com.tencent.tinker.lib.pm.IPluginPackageManager");
                        if (parcel.readInt() != 0) {
                            intent4 = (Intent) Intent.CREATOR.createFromParcel(parcel);
                        }
                        ResolveInfo resolveService = resolveService(intent4, parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        if (resolveService != null) {
                            parcel2.writeInt(1);
                            resolveService.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 7:
                        parcel.enforceInterface("com.tencent.tinker.lib.pm.IPluginPackageManager");
                        ProviderInfo resolveContentProvider = resolveContentProvider(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        if (resolveContentProvider != null) {
                            parcel2.writeInt(1);
                            resolveContentProvider.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                        parcel.enforceInterface("com.tencent.tinker.lib.pm.IPluginPackageManager");
                        if (parcel.readInt() != 0) {
                            intent3 = (Intent) Intent.CREATOR.createFromParcel(parcel);
                        }
                        List<ResolveInfo> queryIntentActivities = queryIntentActivities(intent3, parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(queryIntentActivities);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.tencent.tinker.lib.pm.IPluginPackageManager");
                        if (parcel.readInt() != 0) {
                            intent2 = (Intent) Intent.CREATOR.createFromParcel(parcel);
                        }
                        List<ResolveInfo> queryIntentServices = queryIntentServices(intent2, parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(queryIntentServices);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.tencent.tinker.lib.pm.IPluginPackageManager");
                        if (parcel.readInt() != 0) {
                            intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                        }
                        List<ResolveInfo> queryBroadcastReceivers = queryBroadcastReceivers(intent, parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(queryBroadcastReceivers);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.tencent.tinker.lib.pm.IPluginPackageManager");
                        List<ReceiverInfo> receivers = getReceivers(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(receivers);
                        return true;
                    case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                        parcel.enforceInterface("com.tencent.tinker.lib.pm.IPluginPackageManager");
                        List<ProviderInfo> providers = getProviders(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(providers);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.tencent.tinker.lib.pm.IPluginPackageManager");
            return true;
        }
    }

    ActivityInfo getActivityInfo(ComponentName componentName, int i) throws RemoteException;

    ProviderInfo getProviderInfo(ComponentName componentName, int i) throws RemoteException;

    List<ProviderInfo> getProviders(String str, int i) throws RemoteException;

    ActivityInfo getReceiverInfo(ComponentName componentName, int i) throws RemoteException;

    List<ReceiverInfo> getReceivers(String str, int i) throws RemoteException;

    ServiceInfo getServiceInfo(ComponentName componentName, int i) throws RemoteException;

    List<ResolveInfo> queryBroadcastReceivers(Intent intent, String str, int i) throws RemoteException;

    List<ResolveInfo> queryIntentActivities(Intent intent, String str, int i) throws RemoteException;

    List<ResolveInfo> queryIntentServices(Intent intent, String str, int i) throws RemoteException;

    ProviderInfo resolveContentProvider(String str, int i) throws RemoteException;

    ResolveInfo resolveIntent(Intent intent, String str, int i) throws RemoteException;

    ResolveInfo resolveService(Intent intent, String str, int i) throws RemoteException;
}
