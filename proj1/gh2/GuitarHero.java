package gh2;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

/**
 * A client that uses the synthesizer package to replicate a plucked guitar string sound
 */
public class GuitarHero {
    public static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    public static final int noteCount = keyboard.length();

    public static void main(String[] args) {
        /* create two guitar strings, for concert A and C */
        GuitarString[] strings = new GuitarString[noteCount];
        for (int i = 0; i < noteCount; i++) {
            double frequency = 440 * Math.pow(2, (i - 24) / (double) 12);
            strings[i] = new GuitarString(frequency);
        }

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int keyPos = keyboard.indexOf(key);
                if (keyPos != -1) {
                    strings[keyPos].pluck();
                }
            }

            /* compute the superposition of samples */
            double sample = 0;
            for (int i = 0; i < strings.length; i++) {
                sample += strings[i].sample();
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (int i = 0; i < strings.length; i++) {
                strings[i].tic();
            }
        }
    }
}

