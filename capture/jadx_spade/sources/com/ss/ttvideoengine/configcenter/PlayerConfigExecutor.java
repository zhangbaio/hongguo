package com.ss.ttvideoengine.configcenter;

import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.utils.TTVideoEngineInternalLog;
import java.util.Arrays;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PlayerConfigExecutor {
    public static final PlayerConfigExecutor EMPTY;
    private boolean mEnableOptionArray;
    private MediaPlayer mMediaPlayer;

    public PlayerConfigExecutor() {
    }

    static {
        Covode.recordClassIndex(652413);
        EMPTY = new PlayerConfigExecutor();
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mMediaPlayer = mediaPlayer;
    }

    public PlayerConfigExecutor(boolean z) {
        this.mEnableOptionArray = z;
    }

    public void execute(ConfigItem configItem) {
        if (configItem != null && configItem.moduleType == 1) {
            execute(configItem.valueType, configItem.configKey, configItem.itemValue);
        }
    }

    public void execute(Map<Integer, ConfigItem> map, int i) {
        if (this.mEnableOptionArray) {
            executeUsingArray(map, i);
            return;
        }
        if (map != null && !map.isEmpty()) {
            for (ConfigItem configItem : map.values()) {
                if (configItem.moduleType == 1 && ((PlayerConfigItem) configItem).batchExecuteStage == i) {
                    execute(configItem.valueType, configItem.configKey, configItem.itemValue);
                }
            }
        }
    }

    private void executeUsingArray(Map<Integer, ConfigItem> map, int i) {
        if (map != null && !map.isEmpty()) {
            int[] iArr = new int[map.size()];
            int[] iArr2 = new int[map.size()];
            int i2 = 0;
            for (ConfigItem configItem : map.values()) {
                if (configItem.moduleType == 1 && ((PlayerConfigItem) configItem).batchExecuteStage == i) {
                    int i3 = configItem.valueType;
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 != 4) {
                                    TTVideoEngineInternalLog.e("PlayerConfigExecutor", "unknown value type");
                                } else {
                                    MediaPlayer mediaPlayer = this.mMediaPlayer;
                                    if (mediaPlayer != null) {
                                        mediaPlayer.setStringOption(configItem.configKey, (String) configItem.itemValue);
                                    }
                                }
                            } else {
                                MediaPlayer mediaPlayer2 = this.mMediaPlayer;
                                if (mediaPlayer2 != null) {
                                    mediaPlayer2.setFloatOption(configItem.configKey, ((Float) configItem.itemValue).floatValue());
                                }
                            }
                        } else {
                            MediaPlayer mediaPlayer3 = this.mMediaPlayer;
                            if (mediaPlayer3 != null) {
                                mediaPlayer3.setLongOption(configItem.configKey, ((Long) configItem.itemValue).longValue());
                            }
                        }
                    } else {
                        iArr[i2] = configItem.configKey;
                        iArr2[i2] = ((Integer) configItem.itemValue).intValue();
                        i2++;
                    }
                }
            }
            if (i2 > 0) {
                this.mMediaPlayer.setIntOptionArray(Arrays.copyOf(iArr, i2), Arrays.copyOf(iArr2, i2));
            }
        }
    }

    public void execute(int i, int i2, Object obj) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            return;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        TTVideoEngineInternalLog.e("PlayerConfigExecutor", "unknown value type");
                        return;
                    } else {
                        mediaPlayer.setStringOption(i2, (String) obj);
                        return;
                    }
                }
                mediaPlayer.setFloatOption(i2, ((Float) obj).floatValue());
                return;
            }
            mediaPlayer.setLongOption(i2, ((Long) obj).longValue());
            return;
        }
        mediaPlayer.setIntOption(i2, ((Integer) obj).intValue());
    }
}
