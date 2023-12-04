package use_case.truefalseNew;

public class TrueFalseInputDataNew {

    final private String answer;

    final private String Qleft;

    final private String typeQuestion;
    final private Boolean isFirstDone;

    public TrueFalseInputDataNew(String answer, Boolean isFirstDone, String Qleft, String typeQuestion) {
        this.answer = answer;
        this.Qleft = Qleft;
        this.isFirstDone = isFirstDone;
        this.typeQuestion = typeQuestion;

    }

    String getAnswer() {
        return answer;
    }

    String getQleft(){ return Qleft;}

    Boolean getIsFirstDone(){ return isFirstDone;}

    String getTypeQuestion(){ return typeQuestion;}

}
