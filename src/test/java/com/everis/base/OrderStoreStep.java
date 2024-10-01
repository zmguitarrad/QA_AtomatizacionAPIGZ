package com.everis.base;

import com.everis.base.models.OrderStore;
import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class OrderStoreStep {

    private String URL_BASE= "https://petstore.swagger.io/v2";
    private int codigoRespuesta;
    private OrderStore respuestaOrder;

    public void crearOrden(int id, int petId, int quantity){

        OrderStore nuevaOrden = new OrderStore(id, petId, quantity);

        codigoRespuesta = given()
                .baseUri(URL_BASE)
                .contentType("application/json")
                .body(nuevaOrden)
                .when()
                .post("/store/order")
                .then()
                .statusCode(200)
                .extract()
                .statusCode();

        respuestaOrder = given()
                .baseUri(URL_BASE)
                .when()
                .get("/store/order/"+id)
                .as(OrderStore.class);

        System.out.println("ID Creado: " + respuestaOrder.getPetId());
        System.out.println("PetID Creado: " + respuestaOrder.getPetId());
        System.out.println("Quantity Creado: " + respuestaOrder.getQuantity());

    }


    public void validarCodigoRespuesta(int codigoEsperdo){
        if(codigoRespuesta != codigoEsperdo){
            throw new AssertionError("Código esperado: " +codigoEsperdo + "Código Obtenido: " +codigoRespuesta);
        }
    }

    public OrderStore obtenerRespuestaOrder(){
        return respuestaOrder;
    }

    public void consultarOrderStore(int id){
        respuestaOrder =given()
                .baseUri(URL_BASE)
                .when()
                .get("/store/order/"+id)
                .as(OrderStore.class);
    }
    private void listarOrderStore(OrderStore orderStore){
        System.out.println("ID Creado: " + orderStore.getPetId());
        System.out.println("PetID Creado: " + orderStore.getPetId());
        System.out.println("Quantity Creado: " + orderStore.getQuantity());

    }
    public void validarCodigoRespuesta1(int i){
        assertThat(lastResponse().statusCode(),is(i));
    }
    public OrderStore obtenerRespuestasdeOrderStore(){
        return respuestaOrder;
    }

}
