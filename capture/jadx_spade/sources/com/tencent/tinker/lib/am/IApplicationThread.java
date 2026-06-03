package com.tencent.tinker.lib.am;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IApplicationThread extends IInterface {

    public static class Default implements IApplicationThread {
        static {
            Covode.recordClassIndex(653718);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IApplicationThread {
        static {
            Covode.recordClassIndex(653719);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        private static class Proxy implements IApplicationThread {
            public static IApplicationThread sDefaultImpl;
            private IBinder mRemote;

            static {
                Covode.recordClassIndex(653720);
            }

            public String getInterfaceDescriptor() {
                return "com.tencent.tinker.lib.am.IApplicationThread";
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }
        }

        public static IApplicationThread getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public Stub() {
            attachInterface(this, "com.tencent.tinker.lib.am.IApplicationThread");
        }

        public static boolean setDefaultImpl(IApplicationThread iApplicationThread) {
            if (Proxy.sDefaultImpl == null && iApplicationThread != null) {
                Proxy.sDefaultImpl = iApplicationThread;
                return true;
            }
            return false;
        }

        public static IApplicationThread asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.tinker.lib.am.IApplicationThread");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IApplicationThread)) {
                return (IApplicationThread) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString("com.tencent.tinker.lib.am.IApplicationThread");
            return true;
        }
    }
}
