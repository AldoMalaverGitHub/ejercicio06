/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sunat.gob.pe.ejercicio06.controller.service;

import retrofit2.Call;
import retrofit2.http.POST;
import sunat.gob.pe.ejercicio06.controller.service.dto.AuthClientDto;
import sunat.gob.pe.ejercicio06.controller.service.dto.TokenDto;

/**
 *
 * @author Aldo Malaver
 */
public interface TokenInterface {
    
    @POST("authenticate-client")
    Call<TokenDto> loginClient(AuthClientDto authClientDto);
    
}
