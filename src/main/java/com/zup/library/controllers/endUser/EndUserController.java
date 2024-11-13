package com.zup.library.controllers.endUser;

import com.zup.library.controllers.endUser.dtos.EndUserRegisterDTO;
import com.zup.library.controllers.endUser.dtos.EndUserResponseDTO;
import com.zup.library.controllers.endUser.dtos.EndUserUpdateDTO;
import com.zup.library.service.interfaces.EndUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/endUser")
public class EndUserController {

    @Autowired
    private EndUserService endUserService;

    @GetMapping()
    public List<EndUserResponseDTO> showAuthors(){
        return endUserService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<?> saveAuthor(@RequestBody @Valid EndUserRegisterDTO registerDTO){
        try{
            endUserService.save(registerDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable Long id, @RequestBody @Valid EndUserUpdateDTO updateDTO){
        try{
            endUserService.update(id ,updateDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Long id){
        try{
            endUserService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
    }
}
