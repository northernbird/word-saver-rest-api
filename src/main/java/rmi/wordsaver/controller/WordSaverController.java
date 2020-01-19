package rmi.wordsaver.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import rmi.wordsaver.controller.exception.ServiceException;
import rmi.wordsaver.model.Word;
import javax.validation.Valid;
    import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/words", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@ApiResponses({
        @ApiResponse(code = 500, message = "Internal server error. Please contact system administrator")
})
@Validated
public class WordSaverController {

    @GetMapping
    @ApiOperation(value = "read all registered words from service", notes = "サービスへ登録中の単語を取得します。")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Word.class, responseContainer = "List")
    })
    public ResponseEntity<List<Word>> readAll() {
        List<Word> list = new ArrayList<>();
        list.add(new Word());
        return  ResponseEntity.ok(list);
    }

    @PostMapping
    @ApiOperation(value = "create a new word", notes = "新しい単語をサービスへ追加します。")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Success"),
    })
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(final @Valid @RequestBody Word word) {
    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value = "update existing word", notes = "サービスへ登録済みの単語情報を修正します。")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 404, message = "The given word doesn't exist in service")
    })
    public ResponseEntity<Void> updateWord(@PathVariable @NotNull Long id, @Valid @RequestBody Word word) {
        if (id.equals("1")) {
            return ResponseEntity.notFound().build();
        } else if (id.equals("2")) {
            throw new ServiceException();
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "delete existing word", notes = "サービスへ登録済みの単語情報を削除します。")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 404, message = "The given word doesn't exist in service")
    })
    public ResponseEntity<Void> deleteWord(@PathVariable @NotNull Long id, @Valid @RequestBody Word word) {
        if (id.equals("1")) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
