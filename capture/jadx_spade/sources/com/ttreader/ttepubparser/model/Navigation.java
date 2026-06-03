package com.ttreader.ttepubparser.model;

import com.bytedance.covode.number.Covode;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class Navigation {
    public ArrayList<Navigation> mChildren = new ArrayList<>();
    public String mId;
    public String mLabel;
    public Navigation mParent;
    public String mRef;

    static {
        Covode.recordClassIndex(654702);
    }

    public void AddChild(Navigation navigation) {
        navigation.mParent = this;
        this.mChildren.add(navigation);
    }

    private static String ReadStringFromStream(DataInputStream dataInputStream) throws IOException {
        int readInt = dataInputStream.readInt();
        byte[] bArr = new byte[readInt];
        dataInputStream.read(bArr, 0, readInt);
        return new String(bArr, StandardCharsets.UTF_8);
    }

    public static Navigation ReadStream(DataInputStream dataInputStream) {
        Navigation navigation = new Navigation();
        try {
            navigation.mLabel = ReadStringFromStream(dataInputStream);
            navigation.mRef = ReadStringFromStream(dataInputStream);
            navigation.mId = ReadStringFromStream(dataInputStream);
            int readInt = dataInputStream.readInt();
            for (int i = 0; i < readInt; i++) {
                navigation.AddChild(ReadStream(dataInputStream));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return navigation;
    }
}
