package com.apollo2.atlaseditor;

import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import static org.monte.media.VideoFormatKeys.*;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;

import static org.monte.media.FormatKeys.*;
import java.io.File; 

public class ScreenRecorderUtil {
    private static ScreenRecorder screenRecorder;

    public static void startRecording(String outputFolder) throws Exception {
        File file = new File("./screenrecorder/");

        GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();

        screenRecorder = new ScreenRecorder(
                gc,
                null,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        DepthKey, 24, FrameRateKey, Rational.valueOf(15)),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
                        FrameRateKey, Rational.valueOf(30)),
                null,
                file
        );
        screenRecorder.start();
    }

    public static void stopRecording() throws Exception {
        if (screenRecorder != null) {
            screenRecorder.stop();
        }
    }
}
