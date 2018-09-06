public class QuizCard{

	private String Question;
	private String Answer;

	public QuizCard(String question, String answer){
		this.Question = question;
		this.Answer = answer;
	}

	public String getQuestion(){
		return Question;
	}

	public String getAnswer(){
		return Answer;
	}

}