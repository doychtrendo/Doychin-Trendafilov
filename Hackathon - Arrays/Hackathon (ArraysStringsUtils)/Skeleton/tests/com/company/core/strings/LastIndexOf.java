package com.company.core.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LastIndexOf {
    
    @Test
    @DisplayName("lastIndexOf() returns the index when the string contains the target character")
    public void lastIndexOf_exists() {
        //Arrange
        var word = "New Company";
        
        //Act
        var result = StringHelpers.lastIndexOf(word, 'n');
        
        //Assert
        Assertions.assertEquals(9, result);
    }
    
    @Test
    @DisplayName("lastIndexOf() returns -1 when the string doesn't contain the target character")
    public void lastIndexOf_doesnt_exist() {
        //Arrange
        var word = "Company";
        
        //Act
        var result = StringHelpers.lastIndexOf(word, 'w');
        
        //Assert
        Assertions.assertEquals(-1, result);
    }
    
    
    @Test
    @DisplayName("lastIndexOf() returns -1 when the string is empty")
    public void lastIndexOf_empty() {
        //Arrange
        var word = "";
        
        //Act
        var result = StringHelpers.lastIndexOf(word, 'w');
        
        //Assert
        Assertions.assertEquals(-1, result);
    }
    
}
