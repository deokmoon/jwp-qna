package qna.domain;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class Answers {
    @OneToMany(mappedBy = "question", cascade = CascadeType.PERSIST)
    private List<Answer> answers;

    protected Answers() {
        this.answers = new ArrayList<>();
    }

    public Answers(Answer answer) {
        this.answers = new ArrayList<>();
        this.answers.add(answer);
    }
    public Answers(List<Answer> answers) {
        this.answers = new ArrayList<>(answers);
    }

    public void addAnswer(Answer answer) {
        if (!this.answers.contains(answer)) {
            this.answers.add(answer);
        }
    }

    public void removeAnswer(Answer answer) {
        this.answers.remove(answer);
    }

    public int NumberOfAnswer() {
        return this.answers.size();
    }

    public boolean contains(Answer answer) {
        return this.answers.contains(answer);
    }
}
