package com.company.core.arrays;

@SuppressWarnings({"ManualArrayCopy", "ExplicitArrayFilling"})
public class ArrayHelpers {




//    /**
// *  Adds <code>element</code> to the end of the <code>source</code> array.
// *
// * @param source int[] - The array to add to
// * @param element int - The element to add
// * @return int[] - A new array, the original array with the element at the end
//     * @author Darina Pavlova
// */
    public static int[] add(int[] source, int element) {
        int[] arrayUpdated = new int[source.length + 1];

        for (int i = 0; i < source.length; i++) {

            arrayUpdated[i] = source[i];
        }
        arrayUpdated[arrayUpdated.length - 1] = element;
        return arrayUpdated;
    }


//    /**
//     * Add <code>element</code> at the start of <code>source</code>
//     *
//     * @param source int[] - The array to add
//     * @param element int - The element to add
//     * @return int[] - A new array, the original array with element at head position
//     *
//     *    @author Darina Pavlova
//     */

    public static int[] addFirst(int[] source, int element) {
            int[] arrayUpdated = new int[source.length + 1];
            for (int i = 0; i < source.length; i++) {
                arrayUpdated[i + 1] = source[i];
            }
            arrayUpdated[0] = element;
            return arrayUpdated;

    }


//    /**
//     * Adds all <code>elements</code> to the end of the <code>source</code> array
//     *
//     * @param source int[] - The array to add to
//     * @param elements int... - The elements to add
//     * @return int[] - A new array, the original array with all elements at the end
//     *
//     *  @author Darina Pavlova
//     */
    public static int[] addAll(int[] source, int... elements) {

                int[] arrayUpdated = new int[source.length + elements.length];
                for (int i = 0; i < source.length; i++) {
                    arrayUpdated[i] = source[i];
                }
                for (int i = 0; i < elements.length; i++) {
                    arrayUpdated[source.length + i] = elements[i];
                }

        return arrayUpdated;
            }




    /**
     * Checks if <code>source</code> contains <code>element</code>
     *
     * @param source int[] - The array to check in
     * @param element int - The elements to check for
     * @return int[] - boolean - true if source contains element, otherwise, false
     *
     * @author Doychin Trendafilov
     */
    public static boolean contains(int[] source, int element) {
        for (int num : source) {
            if (num == element) {
                return true;
            }
        }
        return false;
    }

    /**
     * Copies count elements from sourceArray into destinationArray
     *
     * @param source int[] - The array to copy from
     * @param destinationArray int[] - The array to copy to
     * @param count int - The number of elements to copy
     * @return void
     *
     * @author Doychin Trendafilov
     */
    public static void copy(int[] sourceArray, int[] destinationArray, int count) {
        for (int i = 0; i < count; i++) {
            if (i < sourceArray.length && i < destinationArray.length) {
                destinationArray[i] = sourceArray[i];
            } else {
                break;
            }
        }
    }

    /**
     * Copies elements from sourceArray, starting from sourceStartIndex into destinationArray, starting from destStartIndex, taking count elements.
     *
     * @param sourceArray int[] - The array to copy from
     * @param sourceStartIndex int[] - The starting index in sourceArray
     * @param destinationArray int[] - The array to copy to
     * @param destStartIndex int[] - The starting index in destinationArray
     * @param int - The number of elements to copy
     * @return void
     *
     * @author Doychin Trendafilov
     */
    public static void copyFrom(int[] sourceArray, int sourceStartIndex, int[] destinationArray, int destStartIndex, int count) {
        for (int i = 0; i < count; i++) {
            destinationArray[destStartIndex + i] = sourceArray[sourceStartIndex + i];
        }
    }

    /**
     * Fills source with element.
     *
     * @param source int[] - The array to fill
     * @param element int - The element to fill with
     * @return void
     *
     * @author Doychin Trendafilov
     */
    public static void fill(int[] source, int element) {
        for (int i = 0; i < source.length; i++)
        {
            source[i] = element;
        }
    }

    /**
     * Finds the first index of target within source.
     *
     * @param source int[] - The array to check in
     * @param element target int - The element to check for
     * @return int - The first index of target within source, otherwise, -1
     *
     * @author Doychin Trendafilov
     */
    public static int firstIndexOf(int[] source, int target) {
        for (int i = 0; i < source.length; i++) {
            if (source[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Inserts element at index index in source.
     *
     * @param source int[] - The array to insert in
     * @param index int - The index to insert at
     * @param element int - The element to insert
     * @return int[] - A new array with element in it
     *
     * @author Doychin Trendafilov
     */
    public static int[] insert(int[] source, int index, int element) {
        int[] result = new int[source.length + 1];

        for (int i = 0; i < index; i++) {
            result[i] = source[i];
        }

        result[index] = element;

        for (int i = index; i < source.length; i++) {
            result[i + 1] = source[i];
        }

        return result;
    }

    public static boolean isValidIndex(int[] source, int index) {
        return false;
    }

    public static int lastIndexOf(int[] source, int target) {
        return 0;
    }

    public static int[] removeAllOccurrences(int[] source, int element) {
        return new int[1];
    }



//    /**
//     * Reverses the elements of the <code>arrayToReverse</code>.
//     *
//     * @param arrayToReverse The int[] array to reverse
//     *
//     * @author Darina Pavlova
//     */
    public static void reverse(int[] arrayToReverse) {

            for (int i = 0; i < arrayToReverse.length / 2; i++) {
                int current = arrayToReverse[i];
                arrayToReverse[i] = arrayToReverse[arrayToReverse.length - 1 - i];
                arrayToReverse[arrayToReverse.length - 1 - i] = current;
            }
        }



    public static int[] section(int[] source, int startIndex, int endIndex) {
        return new int[1];
    }

}
