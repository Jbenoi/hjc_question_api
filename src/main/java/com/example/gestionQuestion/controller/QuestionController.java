package com.example.gestionQuestion.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import com.example.gestionQuestion.model.QuestionEntity;
import com.example.gestionQuestion.repository.QuestionRepository;
import com.example.gestionQuestion.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/hjc")
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;

    // Get All Questions
    @GetMapping("/questions")
    public List<QuestionEntity> getAllQuestions() {
        return questionRepository.findAll();
    }
    // Create a new Question
    @PostMapping("/questions")
    public QuestionEntity createQuestion(@Valid @RequestBody QuestionEntity questionEntity) {
        return questionRepository.save(questionEntity);
    }

    // Get a Single Question
    @GetMapping("/questions/{id}")
    public QuestionEntity getQuestionById(@PathVariable(value = "id") int id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question", "id", id));
    }

    // Update a Question
    @PutMapping("/questions/{id}}")
    public QuestionEntity updateQuestion(@PathVariable(value = "id") int id,
                           @Valid @RequestBody QuestionEntity questionEntity) {

    QuestionEntity question = questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("text", "id", id));

        question.setText(questionEntity.getText());
        question.setAnswer_a(questionEntity.getAnswer_a());
        question.setAnswer_b(questionEntity.getAnswer_a());
        question.setAnswer_c(questionEntity.getAnswer_c());
        question.setAnswer_d(questionEntity.getAnswer_d());
        question.setCorrect_answer(questionEntity.getCorrect_answer());
        question.setLimit(questionEntity.getLimit());
        question.setPoint(questionEntity.getPoint());
        question.setLimit(questionEntity.getLimit());

        QuestionEntity updatedQuestion = questionRepository.save(question);
        return updatedQuestion;
    }
    // Delete a Question
    @DeleteMapping("/questions/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable(value = "id") int id) {
        QuestionEntity questionEntity = questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("text", "id", id));

        questionRepository.delete(questionEntity);

        return ResponseEntity.ok().build();
    }

}
