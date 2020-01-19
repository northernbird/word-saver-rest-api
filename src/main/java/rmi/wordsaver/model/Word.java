package rmi.wordsaver.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;


//@Entity
@ApiModel(description = "サービスで管理する単語情報", value = "Word")
public class Word {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
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
