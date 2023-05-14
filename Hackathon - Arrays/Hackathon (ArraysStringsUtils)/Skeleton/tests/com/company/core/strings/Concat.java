package com.company.core.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Concat {
    
    @Test
    @DisplayName("concat() concatenates two strings")
    public void concat_concatenates() {
        //Arrange
        var word1 = "New";
        var word2 = " Company";
        var expected = "New Company";
        
        //Act
        var result = StringHelpers.concat(word1, word2);
        
        //Assert
        Assertions.assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("concat() returns only second string if first is empty")
    public void concat_empty() {
        //Arrange
        var word1 = "";
        var word2 = "Company";
        var expected = "Company";
        
        //Act
        var result = StringHelpers.concat(word1, word2);
        
        //Assert
        Assertions.assertEquals(expected, result);
    }
    
}
