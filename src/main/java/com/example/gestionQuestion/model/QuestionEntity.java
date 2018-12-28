package com.example.gestionQuestion.model;
import com.google.common.base.MoreObjects;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class QuestionEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "text")
    private String text;

    @Column(name = "answer_a")
    private String answer_a;

    @Column(name = "answer_b")
    private String answer_b;

    @Column(name = "answer_c")
    private String answer_c;

    @Column(name = "answer_d")
    private String answer_d;

    @Column(name = "correct_answer")
    private String correct_answer;

    @Column(name = "limit")
    private int limit;

    @Column(name = "point")
    private int point;

    @Column(name = "active")
    private int active;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAnswer_a() {
        return answer_a;
    }

    public void setAnswer_a(String answer_a) {
        this.answer_a = answer_a;
    }

    public String getAnswer_b() {
        return answer_b;
    }

    public void setAnswer_b(String answer_b) {
        this.answer_b = answer_b;
    }

    public String getAnswer_c() {
        return answer_c;
    }

    public void setAnswer_c(String answer_c) {
        this.answer_c = answer_c;
    }

    public String getAnswer_d() {
        return answer_d;
    }

    public void setAnswer_d(String answer_d) {
        this.answer_d = answer_d;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    //@Column(name = "QUEST_REPONSE")
    //private List<String> reponse;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        QuestionEntity question = (QuestionEntity) o;

        return new EqualsBuilder()
                .append(id, question.id)
                .append(text, question.text)
                .append(answer_a,question.answer_a )
                .append(answer_b,question.answer_b)
                .append(answer_c,question.answer_c)
                .append(answer_d,question.answer_d)
                .append(correct_answer,question.correct_answer)
                .append(limit,question.limit)
                .append(point,question.point)
                .append(active,question.active)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(text)
                .append(answer_a)
                .append(answer_b)
                .append(answer_c)
                .append(answer_d)
                .append(correct_answer)
                .append(limit)
                .append(point)
                .append(active)
                .toHashCode();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("text", text)
                .add("answer_a", answer_a)
                .add("answer_b", answer_b)
                .add("answer_c",answer_c)
                .add("answer_d",answer_d)
                .add("correct_answer",correct_answer)
                .add("limit",limit)
                .add("point",point)
                .add("active",active)
                .toString();
    }
}
