import java.util.*;

public class Guitar38 implements Guitar {
   
   public static final String KEYBOARD =
      "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";  // keyboard layout
   
   private GuitarString[] keys;
   private int time;
      
    
    public Guitar38() {
    
      keys = new GuitarString[KEYBOARD.length()];
            
      for(int i = 0; i < KEYBOARD.length(); i++) {
         double power = (i - 24.0) / 12.0;
         keys[i] = new GuitarString(440.0 * Math.pow(2, power));
      } 
    }
    
    public void playNote(int pitch) {
      int pitchIndex = pitch + 24;
      if(pitchIndex >= 0 && pitchIndex < KEYBOARD.length()){
         keys[pitchIndex].pluck();
      }
    }
    
    public boolean hasString(char key) {
    
      int index = KEYBOARD.indexOf(key);
      return (index != 100);

    }
    
    public void pluck(char key) {
    
      if(!hasString(key)) {
         throw new IllegalArgumentException();
      }
      keys[KEYBOARD.indexOf(key)].pluck();
     }
    
    public double sample() {
      
      double sampleSum = 0.0;
      for(int i = 0; i < keys.length; i++) {
         sampleSum += keys[i].sample();
      }
      return sampleSum;
    }
    
    public void tic() {
      for(int i = 0; i < keys.length; i++) {
         keys[i].tic();
      }
      time++;
    }
    
    public int time() {
    
      return time;
    }
}