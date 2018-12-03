package Model;

public class TestResults {
    private int studentResultID;
    private String questionsTaken;
    private String results;
    
	public TestResults() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestResults(int studentResultID, String questionsTaken, String results) {
		super();
		this.studentResultID = studentResultID;
		this.questionsTaken = questionsTaken;
		this.results = results;
	}

	public int getStudentResultID() {
		return studentResultID;
	}

	public void setStudentResultID(int studentResultID) {
		this.studentResultID = studentResultID;
	}

	public String getQuestionsTaken() {
		return questionsTaken;
	}

	public void setQuestionsTaken(String questionsTaken) {
		this.questionsTaken = questionsTaken;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}


	@Override
	public String toString() {
		return "TestResults [studentResultID=" + studentResultID + ", questionsTaken=" + questionsTaken + ", results="
				+ results + "]";
	}
    
    
}
