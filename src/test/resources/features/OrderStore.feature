
Feature: Gestión de ordenes de la tienda
  @CrearConsultarOrderStore

  Scenario Outline: Crear una nueva orden
    Given dado que estoy en la pagina
    When creo una orden con id<id>, petId<petId>, quantity<quantity>
    Then el código de estado de la respuesta debe ser <codigo>
    And la respuesta debe contener el id<id>, petId<petId>, quantity<quantity>
    Examples:
      |id|petId|quantity|codigo|
      |201|2   |3       |200   |
      |202|3   |1       |200   |
      |203|3   |1       |200   |
      |204|3   |1       |200   |

  Scenario Outline: Consultar ordenStore
    Given Dado que estoy en la pagina para consultar
    When Consultar el ordenStore con id<id>
    Then valido que el codigo sea <codigo>
    And La respuesta debe contener id<id>, petId<petId>, quantity<quantity>
    Examples:
      |id|petId|quantity|codigo|
      |201|2   |3       |200   |
      |202|3   |1       |200   |
      |203|3   |1       |200   |
      |204|3   |1       |200   |