package rmi.wordsaver.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.validation.constraints.NotEmpty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Entity(name = "words")
@ApiModel(description = "サービスで管理する単語情報", value = "Word")
@EntityListeners(AuditingEntityListener.class)
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "word identifier", example = "1")
    private Long id;
    @ApiModelProperty(value = "word", example = "離見の見")
    @NotEmpty(message = "Please provide a word")
    private String word;
    @ApiModelProperty(value = "description of word", example = "自分をはなれ観客の立場で自分の姿を見ること")
    @NotEmpty(message = "Please provide description")
    private String description;
    @ApiModelProperty(value = "language", example = "登録された単語の言語")
    @NotEmpty(message = "Please provide language")
    private String language;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    public Word() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

}
