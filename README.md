# Desafio TDD

```
O desafio é desevolver um armazém  usando TDD
```

<h3>Criar uma classe Armazém que irá armazenar os Ingredientes e a quantidade de Ingrediente</h3>
<ul>
    <li>A classe deve ter um atributo private TreeMap&lt;Ingrediente, Integer&gt; chamado estoque</li>
</ul>

<h3>Criar um TDD para os seguintes métodos dessa classe:</h3>
<ul>
    <li> public void cadastrarIngrediente(Ingrediente ingrediente) que cadastra no estoque um ingrediente com quantidade 0 ou retorna um IllegalArgumentException caso o ingrediente já esteja cadastrado
    </li>
    <li>public void descadastrarIngrediente(Ingrediente ingrediente) que descadastra no estoque um ingrediente, ou retorna IllegalArgumentException caso o ingrediente não exista no estoque
</li>
  <li>public void adicionarQuantidade(Ingrediente ingrediente, Integer quantidade) adiciona uma determinada quantidade de um determinado ingrediente no estoque. Podendo retornar IllegaLArgumentException caso o ingrediente não exista no estoque ou caso a quantidade informada seja menor ou igual a zero
</li>
<li>public void reduzirQuantidade(Ingrediente ingrediente, Integer quantidade) reduz a quantidade de um determinado ingrediente no estoque. Podendo retornar IllegalArgumentException caso o ingrediente não exista, caso a quantidade seja menor ou igual ao zero ou caso não exista quantidade suficiente no estoque para ser removida</li>
    <li>public Integer consultarIngrediente(Ingrediente ingrediente) busca a quantidade de um determinado ingrediente no estoque. Podendo retornar IllegalArgumentException caso não exista o ingrediente</li>

</ul>