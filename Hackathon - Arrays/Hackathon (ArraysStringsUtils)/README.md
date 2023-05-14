# Hackathon

## Description

Your task is to implement helper methods that work with Strings and Arrays. Most of the methods are already present in the standard Java library, but the idea is that you practice creating such methods.

## Getting Started

Each member should add their method implementations to ***`ArrayHelpers.java`*** and ***`StringHelpers.java`*** in Skeleton. 

## Requirements

- You can create new (`private`) methods, but ***do not*** modify the existing ones.
- Each member _**must**_ implement at least three methods.
- Each member _**must**_ be able to explain how their code works. 
- Each member _**must**_ be able to explain how the entire project works and why it was implemented that way.
- Each method _**must**_ have documentation that is similar to how Oracle documents Java methods. For example: [Integer.compare()](https://docs.oracle.com/javase/7/docs/api/java/lang/Integer.html#compare(int,%20int))
  - There should be 4 sections - **Description**, **Parameters**, **Returns** and **Author**.
    - *Description* - A short summary of what the method is supposed to do.
    - *Parameters* - The name and type of the method's arguments. 
    - *Returns* - The type of the returned value, if applicable; otherwise use `void`.
    - *Author* - Who implemented the method.

### Documentation Example

```java
    /**
    * Concatenates <code>string1</code> to the end of <code>string2</code>.
    *
    * @param string1 The left part of the new string
    * @param string2 The right part of the new string
    * @return A string that represents the concatenation of string1 followed by string2's characters.
    *
    * @author Nadya Atanasova
    */
    public static String concat(String string1, String string2) {
        return string1 + string2;
    }
```

## Constraints
- Do not use any of the build-in methods from `System.java`, `String.java`, `Arrays.java` or `StringBuilder.java`.
  - E.g. to implement the `contains` method you are not allowed to use the `contains` method in the `String` class.
  - You can use String's `.toCharArray()` and `.charAt(int index)` methods.

## Hints
- Reusing code is great. If you see an opportunity, do it!
- You will find some tests in the project that you can use to check your code. To run the tests right-click the tests directory in IntelliJ and select `Run 'All Tests'`

## Resources
- [Introduction to JavaDoc](https://www.baeldung.com/javadoc)

Good luck!
