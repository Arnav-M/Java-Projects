// Arnav Mathur
// 3/3/2020
// Homework 7
// Section: BC
// TA: Khushi Chaudhari

/* Class QuestionNode is what QuestionTree uses to assign questions and yes or no answers to that
   question.
*/
public class QuestionNode {
   
   public String data;  
   public QuestionNode yes;  
   public QuestionNode no;
   
   // Constructs the tree with a question and no answers
   public QuestionNode(String data) {
      this(data, null, null);
   }
   
   // Constructs the tree with a question and two answers, one being yes the other being no.
   public QuestionNode(String data, QuestionNode yes, QuestionNode no) {
      this.data = data;
      this.yes = yes;
      this.no = no;
   }
}
