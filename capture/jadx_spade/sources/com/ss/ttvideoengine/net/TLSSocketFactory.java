package com.ss.ttvideoengine.net;

import android.os.Build;
import com.bytedance.covode.number.Covode;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TLSSocketFactory extends SSLSocketFactory {
    private static final String[] TLS_ALL;
    private static final String[] TLS_POP_13;
    final SSLSocketFactory base;

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.base.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.base.getSupportedCipherSuites();
    }

    static {
        Covode.recordClassIndex(652586);
        TLS_ALL = new String[]{"TLSv1", "TLSv1.1", "TLSv1.2", "TLSv1.3"};
        TLS_POP_13 = new String[]{"TLSv1", "TLSv1.1", "TLSv1.2"};
    }

    public TLSSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.base = sSLSocketFactory;
    }

    private Socket patch(Socket socket) {
        if (socket instanceof SSLSocket) {
            if (Build.VERSION.SDK_INT >= 29) {
                ((SSLSocket) socket).setEnabledProtocols(TLS_ALL);
            } else {
                ((SSLSocket) socket).setEnabledProtocols(TLS_POP_13);
            }
        }
        return socket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        return patch(this.base.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return patch(this.base.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        return patch(this.base.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return patch(this.base.createSocket(inetAddress, i, inetAddress2, i2));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return patch(this.base.createSocket(socket, str, i, z));
    }
}
