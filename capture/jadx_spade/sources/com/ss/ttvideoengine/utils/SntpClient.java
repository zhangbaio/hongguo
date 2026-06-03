package com.ss.ttvideoengine.utils;

import android.os.SystemClock;
import com.bytedance.covode.number.Covode;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SntpClient {
    private long mNtpTime;
    private long mNtpTimeReference;
    private long mRoundTripTime;

    static {
        Covode.recordClassIndex(652757);
    }

    public long getNtpTime() {
        return this.mNtpTime;
    }

    public long getNtpTimeReference() {
        return this.mNtpTimeReference;
    }

    public long getRoundTripTime() {
        return this.mRoundTripTime;
    }

    private static class InvalidServerReplyException extends Exception {
        static {
            Covode.recordClassIndex(652758);
        }

        public InvalidServerReplyException(String str) {
            super(str);
        }
    }

    public boolean requestTime(String str, int i) {
        try {
            return requestTime(InetAddress.getByName(str), 123, i);
        } catch (Exception e) {
            TTVideoEngineLog.d(e);
            return false;
        }
    }

    private long read32(byte[] bArr, int i) {
        int i2 = bArr[i];
        int i3 = bArr[i + 1];
        int i4 = bArr[i + 2];
        int i5 = bArr[i + 3];
        if ((i2 & 128) == 128) {
            i2 = (i2 & 127) + 128;
        }
        if ((i3 & 128) == 128) {
            i3 = (i3 & 127) + 128;
        }
        if ((i4 & 128) == 128) {
            i4 = (i4 & 127) + 128;
        }
        if ((i5 & 128) == 128) {
            i5 = (i5 & 127) + 128;
        }
        return (i2 << 24) + (i3 << 16) + (i4 << 8) + i5;
    }

    private long readTimeStamp(byte[] bArr, int i) {
        long read32 = read32(bArr, i);
        long read322 = read32(bArr, i + 4);
        if (read32 == 0 && read322 == 0) {
            return 0L;
        }
        return ((read32 - 2208988800L) * 1000) + ((read322 * 1000) / 4294967296L);
    }

    private void writeTimeStamp(byte[] bArr, int i, long j) {
        if (j == 0) {
            Arrays.fill(bArr, i, i + 8, (byte) 0);
            return;
        }
        long j2 = j / 1000;
        long j3 = j - (j2 * 1000);
        long j4 = j2 + 2208988800L;
        int i2 = i + 1;
        bArr[i] = (byte) (j4 >> 24);
        int i3 = i2 + 1;
        bArr[i2] = (byte) (j4 >> 16);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (j4 >> 8);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (j4 >> 0);
        long j5 = (j3 * 4294967296L) / 1000;
        int i6 = i5 + 1;
        bArr[i5] = (byte) (j5 >> 24);
        int i7 = i6 + 1;
        bArr[i6] = (byte) (j5 >> 16);
        bArr[i7] = (byte) (j5 >> 8);
        bArr[i7 + 1] = (byte) (Math.random() * 255.0d);
    }

    public boolean requestTime(InetAddress inetAddress, int i, int i2) {
        DatagramSocket datagramSocket;
        DatagramSocket datagramSocket2 = null;
        try {
            try {
                datagramSocket = new DatagramSocket();
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            datagramSocket.setSoTimeout(i2);
            byte[] bArr = new byte[48];
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, inetAddress, i);
            bArr[0] = 27;
            long currentTimeMillis = System.currentTimeMillis();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            writeTimeStamp(bArr, 40, currentTimeMillis);
            datagramSocket.send(datagramPacket);
            datagramSocket.receive(new DatagramPacket(bArr, 48));
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            long j = elapsedRealtime2 - elapsedRealtime;
            long j2 = currentTimeMillis + j;
            byte b = bArr[0];
            int i3 = bArr[1] & 255;
            long readTimeStamp = readTimeStamp(bArr, 24);
            long readTimeStamp2 = readTimeStamp(bArr, 32);
            long readTimeStamp3 = readTimeStamp(bArr, 40);
            checkValidServerReply((byte) ((b >> 6) & 3), (byte) (b & 7), i3, readTimeStamp3);
            long j3 = j - (readTimeStamp3 - readTimeStamp2);
            long j4 = ((readTimeStamp2 - readTimeStamp) + (readTimeStamp3 - j2)) / 2;
            TTVideoEngineLog.d("SntpClient", "requestTime round trip: " + j3 + "ms, clock offset: " + j4 + "ms");
            this.mNtpTime = j2 + j4;
            this.mNtpTimeReference = elapsedRealtime2;
            this.mRoundTripTime = j3;
            datagramSocket.close();
            return true;
        } catch (Exception e2) {
            e = e2;
            datagramSocket2 = datagramSocket;
            TTVideoEngineLog.d(e);
            if (datagramSocket2 != null) {
                datagramSocket2.close();
                return false;
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            datagramSocket2 = datagramSocket;
            if (datagramSocket2 != null) {
                datagramSocket2.close();
            }
            throw th;
        }
    }

    private static void checkValidServerReply(byte b, byte b2, int i, long j) throws InvalidServerReplyException {
        if (b != 3) {
            if (b2 != 4 && b2 != 5) {
                throw new InvalidServerReplyException("untrusted mode: " + ((int) b2));
            }
            if (i != 0 && i <= 15) {
                if (j != 0) {
                    return;
                } else {
                    throw new InvalidServerReplyException("zero transmitTime");
                }
            } else {
                throw new InvalidServerReplyException("untrusted stratum: " + i);
            }
        }
        throw new InvalidServerReplyException("unsynchronized server");
    }
}
