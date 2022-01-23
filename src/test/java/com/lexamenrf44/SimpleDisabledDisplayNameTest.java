package com.lexamenrf44;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@Disabled
public class SimpleDisabledDisplayNameTest {

    @Test
    @DisplayName("Тестирование 3 > 2")
    public void test() {
        Assertions.assertTrue(3 > 2);

    }


}
