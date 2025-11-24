package org.example.util;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class SoundUtil {
    private static MediaPlayer mediaPlayer;

    public static void initialize() {
        mediaPlayer=cargar("/sound/Bury_the_light.mp3");
    }

    //Obtiene el archivo y lo prepara para ser añadido desde el initialize
    private static MediaPlayer cargar(String ruta) {
        try {
            String url=SoundUtil.class.getResource(ruta).toExternalForm();
            MediaPlayer cancion = new MediaPlayer(new Media(url));
            cancion.setVolume(0.5);
            return cancion;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Reproduce la musica
    public static void playMedia() {
        reproducir(mediaPlayer);
    }

    private static void reproducir(MediaPlayer player) {
        if (player != null) {
            player.stop();
            player.seek(Duration.ZERO);
            player.play();
        }
    }
}
