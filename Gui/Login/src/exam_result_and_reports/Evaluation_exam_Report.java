package exam_result_and_reports;
import exam.Question;
public class Evaluation_exam_Report {
    private Statistical_graph histogram = new Statistical_graph();
    private  Question [] tough_questions;
    private String exam_id;
    public Evaluation_exam_Report(String exam_id)
    {
        this.exam_id=exam_id;
    }
}
