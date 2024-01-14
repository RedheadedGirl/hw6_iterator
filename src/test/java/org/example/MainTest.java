package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private static Stream<Arguments> provideGoodArrays() {
        return Stream.of(
                Arguments.of(new Main.Cat[]{new Main.Cat(), new Main.Cat()}, 2),
                Arguments.of(new String[]{"hello", "hi", "hey"}, 3),
                Arguments.of(new Integer[]{3,4,5,8,9}, 5)
        );
    }

    private static Stream<Arguments> provideBadArrays() {
        return Stream.of(
                Arguments.of((Object) new Main.Cat[]{}),
                Arguments.of((Object) new String[]{}),
                Arguments.of((Object) new Integer[]{})
        );
    }

    @ParameterizedTest
    @MethodSource("provideGoodArrays")
    void givenArray_whenIterateNotEmpty_thenOk(Object[] array, int size) {
        List<Object> objects = assertDoesNotThrow(() -> Main.iterate(array));
        assertEquals(size, objects.size());
    }


    @ParameterizedTest
    @MethodSource("provideBadArrays")
    void givenArray_whenIterateEmpty_thenThrowException(Object[] array) {
        EmptyListException emptyListException = assertThrows(EmptyListException.class, () -> Main.iterate(array));
        assertEquals("Список оказался пустым!", emptyListException.getMessage());
    }


}