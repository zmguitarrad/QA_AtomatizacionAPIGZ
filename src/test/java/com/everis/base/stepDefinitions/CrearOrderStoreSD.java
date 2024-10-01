package com.everis.base.stepDefinitions;

import com.everis.base.OrderStoreStep;
import com.everis.base.models.OrderStore;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
public class CrearOrderStoreSD {
    @Steps
    OrderStoreStep orderStoreStep;
    @Given("dado que estoy en la pagina")
    public void dadoQueEstoyEnLaPagina() {
    }

    @When("creo una orden con id{int}, petId{int}, quantity{int}")
    public void creoUnaOrdenConIdIdPetIdPetIdQuantityQuantity(int id, int petId, int quantity) {
        orderStoreStep.crearOrden(id,petId,quantity);
    }

    @Then("el código de estado de la respuesta debe ser {int}")
    public void elCódigoDeEstadoDeLaRespuestaDebeSerCodigo(int codigo) {
        orderStoreStep.validarCodigoRespuesta(codigo);
    }

    @And("la respuesta debe contener el id{int}, petId{int}, quantity{int}")
    public void laRespuestaDebeContenerElIdIdPetIdPetIdQuantityQuantity(int id, int petId, int quantity) {
        OrderStore orderStore = orderStoreStep.obtenerRespuestaOrder();
        assertNotNull(orderStore);
        assertEquals(id, orderStore.getId());
        assertEquals(petId, orderStore.getPetId());
        assertEquals(quantity, orderStore.getQuantity());

    }


    @Given("Dado que estoy en la pagina para consultar")
    public void dadoQueEstoyEnLaPaginaParaConsultar() {
    }

    @When("Consultar el ordenStore con id{int}")
    public void consultarElOrdenStoreConIdId(int id) {
        orderStoreStep.consultarOrderStore(id);
    }

    @Then("valido que el codigo sea {int}")
    public void validoQueElCodigoSeaCodigo(int codigo) {
        orderStoreStep.validarCodigoRespuesta1(codigo);
    }

    @And("La respuesta debe contener id(.*), petId(.*), quantity(.*)$")
    public void laRespuestaDebeContenerIdIdPetIdPetIdQuantityQuantity(int id, int PetId, int Quantity) {
        OrderStore orderStore=orderStoreStep.obtenerRespuestaOrder();
        assertEquals(id,orderStore.getId());
        assertEquals(PetId,orderStore.getPetId());
        assertEquals(Quantity,orderStore.getQuantity());
    }
}
