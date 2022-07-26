package exam;
import java.util.Scanner;
public class Question {
    static Scanner input = new Scanner(System.in);
    private String question;//
    private String[] choice =new String[4];//
    private String Real_correct_choice;//
    private String Evaluation_rank;//wait data base
    private static float  degree;//
    private char Answer='a' ;
    private float mark =0 ;//
    public Question ( String Real_correct_choice,float degree)
    {
        this.Real_correct_choice=Real_correct_choice;
        this.Evaluation_rank=Evaluation_rank;
        this.degree=degree;
    }

    public String getQuestion() {

        return question;
    }

    public void setQuestion() {
        System.out.println("please enter the question");
        String question = input.next();
        this.question = question;
    }

    public char getAnswer() {
        return Answer;
    }

    public void setAnswer() {
        char answer =input.next().charAt(0);
        Answer = answer;
    }

    public void getChoice() {
        //return choice;
        for (int i=0;i<4;i++) { System.out.println(choice[i]); }
    }

    public void setChoice() {
        for (int i=0;i<4;i++) {
            System.out.println("please enter the choices of question number" + (i + 1)+ " : ");
            choice[i]=input.next();
        }
    }
    public void marking ()
    {
        char [] answers =new char[]{'a', 'b', 'c', 'd'};
        int index=0 ;
        for (int i=0;i<4;i++)
        {
            if (Answer == answers[i] )
            { index = ((Character.getNumericValue(Answer))-1);
              break;
            }
        }
        if (Answer <'5' & Answer >'0')
        {
            index = Answer;
        }
        if (Real_correct_choice.equals(choice[index]))
        {
            mark=degree;
        }
    }
    public float get_degree ()
    {
        return degree;
    }
    public float getMark() {
        return mark;
    }
    public void ranking()
    {

        // from user taker degree of answer if this answer mark =5 >=(50/100)*number*user
    }
}
