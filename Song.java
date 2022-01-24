// Arnav Mathur
// 4/1/2020
// CSE 142 A
// TA: Ana Jojic
// Assignment #1
// This program prints a song.

public class Song {
   public static void main(String[] args) {
      verse1();
      System.out.println();
      verse2();
      System.out.println();
      verse3();
      System.out.println();
      verse4();
      System.out.println();
      verse5();
      System.out.println();
      verse6();
      System.out.println();
      verse7();
   }
   
   //prints out verse 1
   public static void verse1() {
      System.out.println("There was an old woman who swallowed a fly.");
      flyPlusDie();
   }
   
   // prints out verse 2
   public static void verse2() {
      System.out.println("There was an old woman who swallowed a spider,");
      System.out.println("That wriggled and iggled and jiggled inside her.");
      spiderPlusFly();
   }
   
   // prints out verse 3
   public static void verse3() {
      System.out.println("There was an old woman who swallowed a bird,");
      System.out.println("How absurd to swallow a bird.");
      birdPlusSpider();   
   }
   
   // prints out verse 4
   public static void verse4() {
      System.out.println("There was an old woman who swallowed a cat,");
      System.out.println("Imagine that to swallow a cat.");
      catPlusBird(); 
   }
   
   // prints out verse 5
   public static void verse5() {
      System.out.println("There was an old woman who swallowed a dog,");
      System.out.println("What a hog to swallow a dog.");
      dogPlusCat();
   }
   
   // prints out our custom verse 6
   public static void verse6() {
      System.out.println("There was an old woman who swallowed a rabbit");
      System.out.println("What a habit to swallow a rabbit");
      rabbitPlusDog();
   }
   
   // prints out verse 7
   public static void verse7() {
      System.out.println("There was an old woman who swallowed a horse,");
      System.out.println("She died of course.");
   }
   
   // prints out a recurring phrase
   public static void flyPlusDie() {
      System.out.println("I don't know why she swallowed that fly,");
      System.out.println("Perhaps she'll die.");
   }
   
   // prints out a recurring phrase
   public static void spiderPlusFly() {
      System.out.println("She swallowed the spider to catch the fly,");
      flyPlusDie();
   }
   
   // prints out a recurring phrase
   public static void birdPlusSpider() {
      System.out.println("She swallowed the bird to catch the spider,");
      spiderPlusFly();
   }
   
   // prints out a recurring phrase
   public static void catPlusBird() {
       System.out.println("She swallowed the cat to catch the bird,");
       birdPlusSpider();
   }
   
   // prints out a recurring phrase
   public static void dogPlusCat() {
      System.out.println("She swallowed the dog to catch the cat,");
      catPlusBird();
   }
   
   // prints out a recurring phrase
   public static void rabbitPlusDog() {
      System.out.println("She swallowed the rabbit to catch the dog");
      dogPlusCat();
   }
}