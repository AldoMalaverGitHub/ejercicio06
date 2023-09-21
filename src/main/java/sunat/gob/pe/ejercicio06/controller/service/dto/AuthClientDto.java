/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sunat.gob.pe.ejercicio06.controller.service.dto;

/**
 *
 * @author Aldo Malaver
 */
public class AuthClientDto {
   
    //DTO --> Data Transfer Object
    private String param;
    
    private String value;
    
    private String documentType;
    
    private String documentNumber;

    public AuthClientDto() {
    }

    public AuthClientDto(String param, String value, String documentType, String documentNumber) {
        this.param = param;
        this.value = value;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
    }
    
    

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }
    
    
        
}
