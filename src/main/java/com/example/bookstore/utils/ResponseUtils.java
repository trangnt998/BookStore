package com.example.bookstore.utils;

import com.example.bookstore.dto.MetadataDTO;
import com.example.bookstore.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;

public class ResponseUtils {
    public static final String CODE_OK = "200";
    public static final String MESSAGE_OK = "OK";


    public static ResponseDTO buildResponse(String code, String message, Object data){
        MetadataDTO meta = new MetadataDTO(code, message);
        return new ResponseDTO(meta, data);
    }

    public static ResponseDTO response_OK(Object data){
        return buildResponse(CODE_OK, MESSAGE_OK, data);
    }

    public static ResponseDTO buildError(MetadataDTO metaData) {
        return new ResponseDTO(metaData, null);
    }

    public static ResponseDTO buildError(String code, String message) {
        return new ResponseDTO(new MetadataDTO(code, message), null);
    }

    public static ResponseEntity<ResponseDTO> response(ResponseDTO responseDTO) {
        return ResponseEntity.ok().body(responseDTO);
    }

}
