package com.example.RPG.exceptions;

import com.example.RPG.model.ClassePerso;
import com.example.RPG.model.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RegraDeNegocioException.class)
    public ResponseEntity<Map<String, Object>> handleRegraDeNegocioException(RegraDeNegocioException ex) {
        Map<String, Object> erro = new HashMap<>();
        erro.put("timestamp", LocalDateTime.now());
        erro.put("status", HttpStatus.BAD_REQUEST.value());
        erro.put("error", "Bad Request");
        erro.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(NaoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> handleNaoEncontradoException(NaoEncontradoException ex) {
        Map<String, Object> erro = new HashMap<>();
        erro.put("timestamp", LocalDateTime.now());
        erro.put("status", HttpStatus.NOT_FOUND.value());
        erro.put("error", "Not Found");
        erro.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler({IllegalArgumentException.class, HttpMessageConversionException.class})
    public ResponseEntity<Map<String, Object>> handleEnumConversionError(Exception ex) {
        Map<String, Object> erro = new HashMap<>();
        erro.put("timestamp", LocalDateTime.now());
        erro.put("status", HttpStatus.BAD_REQUEST.value());
        erro.put("error", "Bad Request");

        String mensagem = "";
        if (ex.getMessage() != null) {
            if (ex.getMessage().contains("ClassePerso")) {
                mensagem = "Valor inválido para o campo 'classePerso'. Valores aceitos: " +
                        Arrays.toString(ClassePerso.values());
            } else if (ex.getMessage().contains("Item")) {
                mensagem = "Valor inválido para o campo 'tipoDoItem'. Valores aceitos: " +
                        Arrays.toString(Item.values());
            }
        }

        erro.put("message", mensagem);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }


}


