package com.company.core.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Copy {
    
    @Test
    @DisplayName("copy() copies enough elements from source array")
    public void copy_sourceArray_bigger() {
        //Arrange
        var source = new int[]{1, 2, 3, 4, 5};
        var destination = new int[4];
        var expected = new int[]{1, 2, 3, 4};
        
        //Act
        ArrayHelpers.copy(source, destination, 4);
        
        //Assert
        Assertions.assertArrayEquals(expected, destination);
    }
    
    
    @Test
    @DisplayName("copy() fills the empty positions with default values")
    public void copy_destinationArray_bigger() {
        //Arrange
        var source = new int[]{1, 2, 3};
        var destination = new int[6];
        var expected = new int[]{1, 2, 3, 0, 0, 0};
        
        //Act
        ArrayHelpers.copy(source, destination, 6);
        
        //Assert
        Assertions.assertArrayEquals(expected, destination);
    }
    
}
