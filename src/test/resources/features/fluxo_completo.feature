Feature: Fluxo Completo de Compra

  Scenario: Comprar um monitor
    Given que o usuario esta na homepage
    When entra no menu de monitores
    And o usuario seleciona um dos monitores
    And o usuario adiciona o monitor ao carrinho
    And o usuario acessa a pagina do carrinho
    And clica em "place order" pra finalizar a compra
    And o usuario informa os dados "julia batista", "brasil", "porto alegre", "5454545456565656", "03", e "30"
    And o usuario completa a compra
    Then a compra deve ser bem sucedida
