/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sunat.gob.pe.ejercicio06.controller.service;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 *
 * @author Aldo Malaver
 */
public interface ClienteInterface {
    
    @GET("valor")
    Call<String> devolverValor();
    
}
