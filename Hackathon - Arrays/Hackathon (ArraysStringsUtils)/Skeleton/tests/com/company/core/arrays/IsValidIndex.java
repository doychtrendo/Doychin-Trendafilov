package com.company.core.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IsValidIndex {
    
    @Test
    @DisplayName("isValidIndex() returns true if the index is valid")
    public void isValidIndex_returns_true() {
        //Arrange
        var source = new int[]{1, 2, 3, 4};
        
        //Act
        var result = ArrayHelpers.isValidIndex(source, 2);
        
        //Assert
        Assertions.assertTrue(result);
    }
    
    @Test
    @DisplayName("isValidIndex() returns false if the index is not valid")
    public void isValidIndex_returns_false() {
        //Arrange
        var source = new int[]{1, 2, 3, 4};
        
        //Act
        var result = ArrayHelpers.isValidIndex(source, 7);
        
        //Assert
        Assertions.assertFalse(result);
    }
    
    
    @Test
    @DisplayName("isValidIndex() returns false if given an empty array")
    public void isValidIndex_empty() {
        //Arrange
        var source = new int[]{};
        
        //Act
        var result = ArrayHelpers.isValidIndex(source, 0);
        
        //Assert
        Assertions.assertFalse(result);
    }
    
}
