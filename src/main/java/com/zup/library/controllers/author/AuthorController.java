package com.zup.library.controllers.author;

import com.zup.library.controllers.author.dtos.AuthorRegisterDTO;
import com.zup.library.controllers.author.dtos.AuthorResponseDTO;
import com.zup.library.controllers.author.dtos.AuthorUpdateDTO;
import com.zup.library.service.interfaces.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping()
    public List<AuthorResponseDTO> showAuthors(){
        return authorService.getAllAuthor();
    }

    @PostMapping
    public ResponseEntity<?> saveAuthor(@RequestBody @Valid AuthorRegisterDTO registerDTO){
        try{
            authorService.save(registerDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable Long id, @RequestBody @Valid AuthorUpdateDTO updateDTO){
        try{
            authorService.update(id ,updateDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Long id){
        try{
            authorService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
    }
}
