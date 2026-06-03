package com.tencent.tinker.lib.signature;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
abstract class ApkVerityBuilder {
    private static final byte[] DEFAULT_SALT;

    private ApkVerityBuilder() {
    }

    static {
        Covode.recordClassIndex(653799);
        DEFAULT_SALT = new byte[8];
    }

    private static class BufferedDigester implements DataDigester {
        private int mBytesDigestedSinceReset;
        private final byte[] mDigestBuffer;
        private final MessageDigest mMd;
        private final ByteBuffer mOutput;
        private final byte[] mSalt;

        static {
            Covode.recordClassIndex(653801);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fillUpLastOutputChunk() {
            int position = this.mOutput.position() % 4096;
            if (position == 0) {
                return;
            }
            this.mOutput.put(ByteBuffer.allocate(4096 - position));
        }

        public void assertEmptyBuffer() throws DigestException {
            if (this.mBytesDigestedSinceReset == 0) {
                return;
            }
            throw new IllegalStateException("Buffer is not empty: " + this.mBytesDigestedSinceReset);
        }

        @Override // com.tencent.tinker.lib.signature.DataDigester
        public void consume(ByteBuffer byteBuffer) throws DigestException {
            byteBuffer.position();
            int remaining = byteBuffer.remaining();
            while (remaining > 0) {
                int min = Math.min(remaining, 4096 - this.mBytesDigestedSinceReset);
                byteBuffer.limit(byteBuffer.position() + min);
                this.mMd.update(byteBuffer);
                remaining -= min;
                int i = this.mBytesDigestedSinceReset + min;
                this.mBytesDigestedSinceReset = i;
                if (i == 4096) {
                    MessageDigest messageDigest = this.mMd;
                    byte[] bArr = this.mDigestBuffer;
                    messageDigest.digest(bArr, 0, bArr.length);
                    this.mOutput.put(this.mDigestBuffer);
                    this.mMd.update(this.mSalt);
                    this.mBytesDigestedSinceReset = 0;
                }
            }
        }

        private BufferedDigester(byte[] bArr, ByteBuffer byteBuffer) throws NoSuchAlgorithmException {
            this.mDigestBuffer = new byte[32];
            this.mSalt = bArr;
            this.mOutput = byteBuffer.slice();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            this.mMd = messageDigest;
            messageDigest.update(bArr);
            this.mBytesDigestedSinceReset = 0;
        }
    }

    public static int toIntExact(long j) {
        int i = (int) j;
        if (i == j) {
            return i;
        }
        throw new ArithmeticException("integer overflow");
    }

    private static void assertSigningBlockAlignedAndHasFullPages(SignatureInfo signatureInfo) {
        long j = signatureInfo.apkSigningBlockOffset;
        if (j % ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF == 0) {
            if ((signatureInfo.centralDirOffset - j) % ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF == 0) {
                return;
            }
            throw new IllegalArgumentException("Size of APK Signing Block is not a multiple of 4096: " + (signatureInfo.centralDirOffset - signatureInfo.apkSigningBlockOffset));
        }
        throw new IllegalArgumentException("APK Signing Block does not start at the page  boundary: " + signatureInfo.apkSigningBlockOffset);
    }

    private static int[] calculateVerityLevelOffset(long j) {
        ArrayList arrayList = new ArrayList();
        do {
            j = divideRoundup(j, ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF) * 32;
            arrayList.add(Long.valueOf(divideRoundup(j, ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF) * ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF));
        } while (j > ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF);
        int[] iArr = new int[arrayList.size() + 1];
        int i = 0;
        iArr[0] = 0;
        while (i < arrayList.size()) {
            int i2 = i + 1;
            iArr[i2] = iArr[i] + toIntExact(((Long) arrayList.get((arrayList.size() - i) - 1)).longValue());
            i = i2;
        }
        return iArr;
    }

    static class ApkVerityResult {
        public final ByteBuffer fsverityData;
        public final byte[] rootHash;

        static {
            Covode.recordClassIndex(653800);
        }

        ApkVerityResult(ByteBuffer byteBuffer, byte[] bArr) {
            this.fsverityData = byteBuffer;
            this.rootHash = bArr;
        }
    }

    private static long divideRoundup(long j, long j2) {
        return ((j + j2) - 1) / j2;
    }

    private static void skip(ByteBuffer byteBuffer, int i) {
        byteBuffer.position(byteBuffer.position() + i);
    }

    private static void consumeByChunk(DataDigester dataDigester, DataSource dataSource, int i) throws IOException, DigestException {
        long size = dataSource.size();
        long j = 0;
        while (size > 0) {
            int min = (int) Math.min(size, i);
            dataSource.feedIntoDataDigester(dataDigester, j, min);
            long j2 = min;
            j += j2;
            size -= j2;
        }
    }

    private static ByteBuffer slice(ByteBuffer byteBuffer, int i, int i2) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position(0);
        duplicate.limit(i2);
        duplicate.position(i);
        return duplicate.slice();
    }

    static byte[] generateFsverityRootHash(RandomAccessFile randomAccessFile, ByteBuffer byteBuffer, SignatureInfo signatureInfo) throws NoSuchAlgorithmException, DigestException, IOException {
        ByteBuffer order = ByteBuffer.allocate(4096).order(ByteOrder.LITTLE_ENDIAN);
        ByteBuffer slice = slice(order, 0, 64);
        ByteBuffer slice2 = slice(order, 64, 4032);
        calculateFsveritySignatureInternal(randomAccessFile, signatureInfo, null, null, slice, slice2);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(slice);
        messageDigest.update(slice2);
        messageDigest.update(byteBuffer);
        return messageDigest.digest();
    }

    static ApkVerityResult generateApkVerity(RandomAccessFile randomAccessFile, SignatureInfo signatureInfo, ByteBufferFactory byteBufferFactory) throws IOException, SecurityException, NoSuchAlgorithmException, DigestException {
        int i = calculateVerityLevelOffset(randomAccessFile.length() - (signatureInfo.centralDirOffset - signatureInfo.apkSigningBlockOffset))[r0.length - 1];
        int i2 = i + 4096;
        ByteBuffer create = byteBufferFactory.create(i2);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        create.order(byteOrder);
        ByteBuffer slice = slice(create, 0, i);
        int i3 = i + 64;
        ByteBuffer slice2 = slice(create, i, i3);
        ByteBuffer slice3 = slice(create, i3, i2);
        byte[] bArr = new byte[32];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(byteOrder);
        calculateFsveritySignatureInternal(randomAccessFile, signatureInfo, slice, wrap, slice2, slice3);
        create.position(i3 + slice3.limit());
        create.putInt(slice3.limit() + 64 + 4);
        create.flip();
        return new ApkVerityResult(create, bArr);
    }

    private static ByteBuffer generateFsverityExtensions(ByteBuffer byteBuffer, long j, long j2, long j3) {
        byteBuffer.putInt(24);
        byteBuffer.putShort((short) 1);
        skip(byteBuffer, 2);
        byteBuffer.putLong(j);
        byteBuffer.putLong(j2);
        byteBuffer.putInt(20);
        byteBuffer.putShort((short) 2);
        skip(byteBuffer, 2);
        byteBuffer.putLong(j3 + 16);
        byteBuffer.putInt(toIntExact(j));
        skip(byteBuffer, 4);
        byteBuffer.flip();
        return byteBuffer;
    }

    private static void generateApkVerityDigestAtLeafLevel(RandomAccessFile randomAccessFile, SignatureInfo signatureInfo, byte[] bArr, ByteBuffer byteBuffer) throws IOException, NoSuchAlgorithmException, DigestException {
        BufferedDigester bufferedDigester = new BufferedDigester(bArr, byteBuffer);
        consumeByChunk(bufferedDigester, new MemoryMappedFileDataSource(randomAccessFile.getFD(), 0L, signatureInfo.apkSigningBlockOffset), 1048576);
        long j = signatureInfo.eocdOffset + 16;
        FileDescriptor fd = randomAccessFile.getFD();
        long j2 = signatureInfo.centralDirOffset;
        consumeByChunk(bufferedDigester, new MemoryMappedFileDataSource(fd, j2, j - j2), 1048576);
        ByteBuffer order = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
        order.putInt(toIntExact(signatureInfo.apkSigningBlockOffset));
        order.flip();
        bufferedDigester.consume(order);
        long j3 = j + 4;
        consumeByChunk(bufferedDigester, new MemoryMappedFileDataSource(randomAccessFile.getFD(), j3, randomAccessFile.length() - j3), 1048576);
        int length = (int) (randomAccessFile.length() % ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF);
        if (length != 0) {
            bufferedDigester.consume(ByteBuffer.allocate(4096 - length));
        }
        bufferedDigester.assertEmptyBuffer();
        bufferedDigester.fillUpLastOutputChunk();
    }

    private static ByteBuffer generateFsverityHeader(ByteBuffer byteBuffer, long j, int i, byte[] bArr) {
        if (bArr.length == 8) {
            byteBuffer.put("TrueBrew".getBytes());
            byteBuffer.put((byte) 1);
            byteBuffer.put((byte) 0);
            byteBuffer.put((byte) 12);
            byteBuffer.put((byte) 7);
            byteBuffer.putShort((short) 1);
            byteBuffer.putShort((short) 1);
            byteBuffer.putInt(0);
            byteBuffer.putInt(0);
            byteBuffer.putLong(j);
            byteBuffer.put((byte) 2);
            byteBuffer.put((byte) 0);
            byteBuffer.put(bArr);
            skip(byteBuffer, 22);
            byteBuffer.flip();
            return byteBuffer;
        }
        throw new IllegalArgumentException("salt is not 8 bytes long");
    }

    private static byte[] generateApkVerityTree(RandomAccessFile randomAccessFile, SignatureInfo signatureInfo, byte[] bArr, int[] iArr, ByteBuffer byteBuffer) throws IOException, NoSuchAlgorithmException, DigestException {
        generateApkVerityDigestAtLeafLevel(randomAccessFile, signatureInfo, bArr, slice(byteBuffer, iArr[iArr.length - 2], iArr[iArr.length - 1]));
        int length = iArr.length - 3;
        while (true) {
            if (length >= 0) {
                int i = length + 1;
                ByteBuffer slice = slice(byteBuffer, iArr[i], iArr[length + 2]);
                ByteBuffer slice2 = slice(byteBuffer, iArr[length], iArr[i]);
                ByteBufferDataSource byteBufferDataSource = new ByteBufferDataSource(slice);
                BufferedDigester bufferedDigester = new BufferedDigester(bArr, slice2);
                consumeByChunk(bufferedDigester, byteBufferDataSource, 4096);
                bufferedDigester.assertEmptyBuffer();
                bufferedDigester.fillUpLastOutputChunk();
                length--;
            } else {
                byte[] bArr2 = new byte[32];
                BufferedDigester bufferedDigester2 = new BufferedDigester(bArr, ByteBuffer.wrap(bArr2));
                bufferedDigester2.consume(slice(byteBuffer, 0, 4096));
                bufferedDigester2.assertEmptyBuffer();
                return bArr2;
            }
        }
    }

    private static void calculateFsveritySignatureInternal(RandomAccessFile randomAccessFile, SignatureInfo signatureInfo, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, ByteBuffer byteBuffer4) throws IOException, NoSuchAlgorithmException, DigestException {
        assertSigningBlockAlignedAndHasFullPages(signatureInfo);
        long j = signatureInfo.centralDirOffset - signatureInfo.apkSigningBlockOffset;
        int[] calculateVerityLevelOffset = calculateVerityLevelOffset(randomAccessFile.length() - j);
        if (byteBuffer != null) {
            byte[] generateApkVerityTree = generateApkVerityTree(randomAccessFile, signatureInfo, DEFAULT_SALT, calculateVerityLevelOffset, byteBuffer);
            if (byteBuffer2 != null) {
                byteBuffer2.put(generateApkVerityTree);
                byteBuffer2.flip();
            }
        }
        if (byteBuffer3 != null) {
            byteBuffer3.order(ByteOrder.LITTLE_ENDIAN);
            generateFsverityHeader(byteBuffer3, randomAccessFile.length(), calculateVerityLevelOffset.length - 1, DEFAULT_SALT);
        }
        if (byteBuffer4 != null) {
            byteBuffer4.order(ByteOrder.LITTLE_ENDIAN);
            generateFsverityExtensions(byteBuffer4, signatureInfo.apkSigningBlockOffset, j, signatureInfo.eocdOffset);
        }
    }
}
