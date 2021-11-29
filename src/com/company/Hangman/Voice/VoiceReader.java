package com.company.Hangman.Voice;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class VoiceReader {
    public static void readingVoice(String result, String language) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {

        File yourFile = new File("src/com/company/Hangman/Voice/fail_English.mp3");
        AudioInputStream stream;
        AudioFormat format;
        DataLine.Info info;
        Clip clip;

        stream = AudioSystem.getAudioInputStream(yourFile);
        format = stream.getFormat();
        info = new DataLine.Info(Clip.class, format);
        clip = (Clip) AudioSystem.getLine(info);
        clip.open(stream);
        clip.start();
        Thread.sleep(5000);
    }
}

