package org.example;


import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class PrimeiroTeste {

    Calculadora calculadora;

    int numero1 = 10, numero2 = 5;

    @BeforeEach
    public void setUp(){
        calculadora = new Calculadora();
    }

    @Test
    @DisplayName("Deve somar 2 numeros")
    public void deveSomar2Numeros(){
        //cenário


        //execução
        int resultado = calculadora.somar(numero1, numero2);

        //verificações Junit
        //assertThat(resultado).isEqualTo(15);

        //verificações AssertJ
        Assertions.assertThat(resultado).isBetween(14,16); //esta entre
        Assertions.assertThat(resultado).isEqualTo(15); //se é igual
        Assertions.assertThat(resultado).isGreaterThan(10); //é maior que

    }

    @Test
    @DisplayName("Deve subtrair 2 numeros")
    public void deveSubtrair2Numeros(){
        //cenário

        //execução
        int resultado = calculadora.subtrair(numero1, numero2);

        //verificações Junit
        //Assert.assertEquals(5,resultado);

        //verificações AssertJ
        Assertions.assertThat(resultado).isBetween(3,6); //esta entre
        Assertions.assertThat(resultado).isEqualTo(5); //se é igual
        Assertions.assertThat(resultado).isGreaterThan(4); //é maior que

    }

    @Test
    @DisplayName("Deve multiplicar 2 numeros")
    public void deveMultiplicar2Numeros(){
        Calculadora  calculadora = new Calculadora();
        int numero1 = 10, numero2 = 5;

        //execução
        int resultado = calculadora.multiplicar(numero1, numero2);

        //verificações Junit
        //Assert.assertEquals(50,resultado);

        //verificações AssertJ
        Assertions.assertThat(resultado).isBetween(30,60); //esta entre
        Assertions.assertThat(resultado).isEqualTo(50); //se é igual
        Assertions.assertThat(resultado).isGreaterThan(40); //é maior que
    }

    @Test
    @DisplayName("Deve dividir 2 numeros")
    public void deveDividir2Numeros(){
        Calculadora  calculadora = new Calculadora();
        int numero1 = 10, numero2 = 5;

        //execução
        int resultado = calculadora.dividir(numero1, numero2);

        //verificações Junit
        //Assert.assertEquals(2,resultado);

        //verificações AssertJ
        Assertions.assertThat(resultado).isBetween(1,3); //esta entre
        Assertions.assertThat(resultado).isEqualTo(2); //se é igual
        Assertions.assertThat(resultado).isGreaterThan(1); //é maior que
    }

    @Test//(expected = RuntimeException.class)
    @DisplayName("Não deve somar numeros negativos")
    public void nãoDeveSomarNumerosNegativos(){
        //cenário
        Calculadora calculadora = new Calculadora();
        int numero1 = -10, numero2 = 5;

        //execução
        org.junit.jupiter.api.Assertions
                .assertThrows(RuntimeException.class, () -> calculadora.somar(numero1,numero2));


    }

    @Test//(expected = ArithmeticException.class)
    @DisplayName("Não deve dividir por zero")
    public void nãoDeveDividirPorZero(){
        //cenário
        Calculadora calculadora = new Calculadora();
        int numero1 = 10, numero2 = 0;

        //execução
        org.junit.jupiter.api.Assertions
                .assertThrows(ArithmeticException.class, () -> calculadora.dividir(numero1,numero2));

    }
}

class Calculadora{

    int somar(int num, int num2){
        if (num < 0 || num2 < 0){
            throw new RuntimeException("Não é permitido somar numeros negativos");
        }
        return num + num2;
    }

    int subtrair(int num, int num2){
        return num - num2;
    }

    int multiplicar(int num, int num2){
        return num * num2;
    }

    int dividir(int num, int num2){
        return num / num2;
    }
}