package com.company.core.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LastIndexOf {
    
    @Test
    @DisplayName("lastIndexOf() should return -1 when the element is not in the array")
    public void lastIndexOf_element_not_found() {
        //Arrange
        var source = new int[]{1, 2, 3, 2, 1};
        var expected = -1;
        
        //Act
        var result = ArrayHelpers.lastIndexOf(source, 7);
        
        //Assert
        Assertions.assertEquals(result, expected);
        
    }
    
    @Test
    @DisplayName("lastIndexOf() should return the index when the element is in the array")
    public void lastIndexOf_element_found() {
        //Arrange
        var source = new int[]{1, 2, 3, 2, 1};
        var expected = 4;
        
        //Act
        var result = ArrayHelpers.lastIndexOf(source, 1);
        
        //Assert
        Assertions.assertEquals(result, expected);
        
    }
    
    @Test
    @DisplayName("lastIndexOf() should return -1 when the array is empty")
    public void lastIndexOf_empty_array() {
        //Arrange
        var source = new int[]{};
        var expected = -1;
        
        //Act
        var result = ArrayHelpers.lastIndexOf(source, 1);
        
        //Assert
        Assertions.assertEquals(result, expected);
        
    }
    
}
