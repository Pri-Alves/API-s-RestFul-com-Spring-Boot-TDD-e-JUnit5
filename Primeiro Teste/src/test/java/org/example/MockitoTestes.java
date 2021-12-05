package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class MockitoTestes {

    @Mock
    List<String> lista;

    @Test
    public void primeiroTesteMockito(){
        //List<String> lista = Mockito.mock(ArrayList.class); Alterado pelo @Mock e pelo RunWith

        Mockito.when(lista.size()).thenReturn(2);

        int size = lista.size();
        lista.add("");

        Assertions.assertThat(size).isEqualTo(2);

        Mockito.verify(lista).size(); //usado para verificar se o método foi invocado, muito utilizado em retornos void
        Mockito.verify(lista, Mockito.times(    1)).size(); //verificar quantas vezes o método foi invocado
        //Mockito.verify(lista, Mockito.never()).size(); //verificar se o método nunca foi chamado

        InOrder inOrder = Mockito.inOrder(lista); //verificar se os métodos estao sendo executados na ordem declarada abaixo
        inOrder.verify(lista).size();
        inOrder.verify(lista).add("");
    }
}
