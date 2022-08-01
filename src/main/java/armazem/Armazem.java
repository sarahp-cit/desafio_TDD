package armazem;

import ingredientes.Ingrediente;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TreeMap;

@SpringBootApplication
public class Armazem {

	private TreeMap<Ingrediente, Integer> estoque;

	public Armazem(){
		this.estoque= new TreeMap<>();
	}

	public void cadastrarIngredienteEmEstoque(Ingrediente ingrediente){
		if(estoque.containsKey(ingrediente))
			throw new IllegalArgumentException("Ingrediente já cadastrado");
		estoque.put(ingrediente, 0);
	}
	public void descadastrarIngredienteEmEstoque(Ingrediente ingrediente){
		if (!estoque.containsKey(ingrediente))
			throw new IllegalArgumentException("Ingrediente não encontrado");
		estoque.remove(ingrediente);
	}
	public void adicionarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidade){
		if (quantidade <= 0 || !estoque.containsKey(ingrediente))
			throw new IllegalArgumentException("Ingrediente não encontrado ou quantidade inválida");
		estoque.replace(ingrediente, quantidade);
	}
	public void reduzirQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidade){
		if (quantidade <= 0 || !estoque.containsKey(ingrediente))
			throw new IllegalArgumentException("Ingrediente não encontrado ou quantidade inválida");
		var antigaQuantidade = consultarQuantidadeDoIngredienteEmEstoque(ingrediente);
		if (antigaQuantidade < quantidade)
			throw new IllegalArgumentException("Ingrediente não encontrado ou quantidade inválida");
		var novaQuantidade = antigaQuantidade - quantidade;
		estoque.replace(ingrediente, novaQuantidade);
	}
	public Integer consultarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente){
		if (!estoque.containsKey(ingrediente))
			throw new IllegalArgumentException("Ingrediente não encontrado");
		return estoque.get(ingrediente);
	}
}
