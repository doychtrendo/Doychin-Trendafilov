package com.company.core.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Capitalize {
    
    @Test
    @DisplayName("capitalize() returns capitalized string")
    public void capitalize_returns_capitalizedString() {
        //Arrange
        var source = "java";
        var expected = "Java";
        
        //Act
        var result = StringHelpers.capitalize(source);
        
        //Assert
        Assertions.assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("capitalize() doesn't change other characters")
    public void capitalize_1() {
        //Arrange
        var source = "jAva";
        var expected = "JAva";
        
        //Act
        var result = StringHelpers.capitalize(source);
        
        //Assert
        Assertions.assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("capitalize() returns empty string when passed an empty string")
    public void capitalize_returns_empty_when_stringEmpty() {
        //Arrange
        var source = "";
        var expected = "";
        
        //Act
        var result = StringHelpers.capitalize(source);
        
        //Assert
        Assertions.assertEquals(expected, result);
    }
    
}
