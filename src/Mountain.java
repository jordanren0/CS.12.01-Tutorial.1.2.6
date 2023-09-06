public class Mountain {
    /** @param array an array of positive integer values

     @param stop the last index to check
     Precondition: 0 <= stop < array.length
     @return true if for each j such that 0 <= j < stop, array[j] < array[j + 1] ;
     false otherwise
     */

    public static boolean isIncreasing(int[] array, int stop) {
        boolean increase = false;
        for(int i = 0; i < stop; i++){
            if(i < stop && array[i] < array[i+1])
                increase = true;
            else {
                increase = false;
                break;
            }
        }
        return increase;
    }
    /** @param array an array of positive integer values

     @param start the first index to check
     Precondition: 0 <= start < array.length - 1
     @return true if for each j such that start <= j < array.length - 1,
     array[j] > array[j + 1];
     false otherwise
     */

    public static boolean isDecreasing(int[] array, int start) {
        boolean decrease = false;
        for(int i = start; i < array.length-1; i++){
            if(array[i] > array[i+1])
                decrease = true;
            else {
                decrease = false;
                break;
            }
        }
        return decrease;
    }

    public static int getPeakIndex(int[] array) {
        int peak = -1;
        for(int i = 1; i < array.length-1; i++){
            if(array[i] > array[i-1] && array[i] > array[i+1]){
                peak = i;
                break;
            }
        }
        return peak;
    }

    public static boolean isMountain(int[] array) {
        int peak = getPeakIndex(array);
        boolean increase = false;
        boolean decrease = false;
        if(peak != -1){
            increase = isIncreasing(array, peak);
            decrease = isDecreasing(array, peak);
        }
        return peak != -1 && increase && decrease;
    }

}
