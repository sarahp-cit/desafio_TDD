package armazem;

import ingredientes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ArmazemTests {

	private Armazem armazem;
	@BeforeEach
	void setup() {
		armazem = new Armazem();

		Ingrediente base = new Base(TipoBase.IORGUTE);
		armazem.cadastrarIngredienteEmEstoque(base);
		armazem.adicionarQuantidadeDoIngredienteEmEstoque(base, 2);

		Ingrediente fruta = new Fruta(TipoFruta.BANANA);
		armazem.cadastrarIngredienteEmEstoque(fruta);
		armazem.adicionarQuantidadeDoIngredienteEmEstoque(fruta, 2);

		Ingrediente topping = new Topping(TipoTopping.AVEIA);
		armazem.cadastrarIngredienteEmEstoque(topping);
		armazem.adicionarQuantidadeDoIngredienteEmEstoque(topping, 2);
	}
	@Test
	void cadastrarIngredienteEmEstoqueSucessoTest(){
		Ingrediente topping = new Topping(TipoTopping.MEL);
		armazem.cadastrarIngredienteEmEstoque(topping);

		assertEquals(0, armazem.consultarQuantidadeDoIngredienteEmEstoque(topping));
	}
	@Test
	void cadastrarIngredienteEmEstoqueFalhaTest(){
		Ingrediente topping = new Topping(TipoTopping.AVEIA);

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> armazem.cadastrarIngredienteEmEstoque(topping));
		assertEquals(exception.getMessage(), "Ingrediente já cadastrado");
	}
	@Test
	void descadastrarIngredienteEmEstoqueSucessoTest(){
		Ingrediente base = new Base(TipoBase.IORGUTE);
		armazem.descadastrarIngredienteEmEstoque(base);

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> armazem.consultarQuantidadeDoIngredienteEmEstoque(base));
		assertEquals(exception.getMessage(), "Ingrediente não encontrado");
	}
	@Test
	void descadastrarIngredienteEmEstoqueFalhaTest(){
		Ingrediente fruta = new Fruta(TipoFruta.MORANGO);

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> armazem.descadastrarIngredienteEmEstoque(fruta));
		assertEquals(exception.getMessage(), "Ingrediente não encontrado");
	}
	@Test
	void adicionarQuantidadeDoIngredienteEmEstoqueSucessoTest(){
		Ingrediente fruta = new Fruta(TipoFruta.BANANA);
		armazem.adicionarQuantidadeDoIngredienteEmEstoque(fruta, 5);

		assertEquals(5, armazem.consultarQuantidadeDoIngredienteEmEstoque(fruta));
	}
	@Test
	void adicionarQuantidadeDoIngredienteEmEstoqueFalhaQuantidadeTest(){
		Ingrediente fruta = new Fruta(TipoFruta.BANANA);

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> armazem.adicionarQuantidadeDoIngredienteEmEstoque(fruta, -1));
		assertEquals(exception.getMessage(), "Ingrediente não encontrado ou quantidade inválida");
	}
	@Test
	void adicionarQuantidadeDoIngredienteEmEstoqueFalhaIngredienteTest(){
		Ingrediente base = new Base(TipoBase.SORVETE);

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> armazem.adicionarQuantidadeDoIngredienteEmEstoque(base, 2));
		assertEquals(exception.getMessage(), "Ingrediente não encontrado ou quantidade inválida");
	}
	@Test
	void reduzirQuantidadeDoIngredienteEmEstoqueSucessoTest(){
		Ingrediente base = new Base(TipoBase.IORGUTE);
		armazem.reduzirQuantidadeDoIngredienteEmEstoque(base, 2);

		assertEquals(0, armazem.consultarQuantidadeDoIngredienteEmEstoque(base));
	}
	@Test
	void reduzirQuantidadeDoIngredienteEmEstoqueFalhaQuantidadeTest(){
		Ingrediente base = new Base(TipoBase.IORGUTE);

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> armazem.reduzirQuantidadeDoIngredienteEmEstoque(base, 3));
		assertEquals(exception.getMessage(), "Ingrediente não encontrado ou quantidade inválida");
	}
	@Test
	void reduzirQuantidadeDoIngredienteEmEstoqueFalhaQuantidadeNegativaTest(){
		Ingrediente base = new Base(TipoBase.IORGUTE);

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> armazem.reduzirQuantidadeDoIngredienteEmEstoque(base, -3));
		assertEquals(exception.getMessage(), "Ingrediente não encontrado ou quantidade inválida");
	}
	@Test
	void reduzirQuantidadeDoIngredienteEmEstoqueFalhaIngredienteTest(){
		Ingrediente base = new Base(TipoBase.SORVETE);

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> armazem.reduzirQuantidadeDoIngredienteEmEstoque(base, 1));
		assertEquals(exception.getMessage(), "Ingrediente não encontrado ou quantidade inválida");
	}
	@Test
	void consultarQuantidadeDoIngredienteEmEstoqueSucessoTest(){
		Ingrediente fruta = new Fruta(TipoFruta.BANANA);

		assertEquals(2, armazem.consultarQuantidadeDoIngredienteEmEstoque(fruta));
	}
	@Test
	void consultarQuantidadeDoIngredienteEmEstoqueFalhaTest(){
		Ingrediente base = new Base(TipoBase.SORVETE);

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> armazem.consultarQuantidadeDoIngredienteEmEstoque(base));
		assertEquals(exception.getMessage(), "Ingrediente não encontrado");
	}
}
