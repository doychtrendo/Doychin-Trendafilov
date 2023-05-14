package com.company.core.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Section {
    
    @Test
    @DisplayName("section() returns the correct part of the source string")
    public void section() {
        //Arrange
        var source = "xxCompanyxx";
        var expected = "Company";
        
        //Act
        var result = StringHelpers.section(source, 2, 8);
        
        //Assert
        Assertions.assertEquals(expected, result);
    }
    
}
