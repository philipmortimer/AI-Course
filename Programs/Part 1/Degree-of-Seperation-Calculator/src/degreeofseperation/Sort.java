/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package degreeofseperation;

/**
 *
 * @author mortimer
 */
public class Sort {
    /**
    * Sorts data using insertion sort
    * @param unsortedData a 2d string array of the unsorted data with each row representing one record and the nought element containing a String primary key (which is the field that will be used to sort)
    */
    public static void insertionSort(String[][]unsortedData){
        int indexToBeChecked=0;//loop variable that needs intialisation for method wide access
        String tempRecord[]=new String[unsortedData[0].length];//used as buffer storage of a record
        for(int indexOfElementToBeInserted=1;indexOfElementToBeInserted<unsortedData.length;indexOfElementToBeInserted++){
            for(int recordIndex=0;recordIndex<tempRecord.length;recordIndex++){//stores value of record to be "inserted"
                tempRecord[recordIndex]=unsortedData[indexOfElementToBeInserted][recordIndex];
            }
            for(indexToBeChecked=indexOfElementToBeInserted-1;indexToBeChecked>=0&&(tempRecord[0].compareTo(unsortedData[indexToBeChecked][0])<0);indexToBeChecked--){
                for(int recordIndex=0;recordIndex<tempRecord.length;recordIndex++){
                    unsortedData[indexToBeChecked+1][recordIndex]=unsortedData[indexToBeChecked][recordIndex];
                }
            }
            for(int recordIndex=0;recordIndex<tempRecord.length;recordIndex++){
                unsortedData[indexToBeChecked+1][recordIndex]=tempRecord[recordIndex];
            }
        }
    }
        /**
     * This function recursively splits all record down into sub arrays until each sub array only contains one record
     * these split arrays are merged back together using the merge function.
     * Therefore the data originally input into this function will be sorted (as arrays are passed by reference in java). The return value of this function is also the
     * sorted data.
     * @param data The data you want sorted. Assuming each row is one record and the first element in each row is a string that is the primary key.
     * @return The sorted data is returned with the data being sorted in ascending order (one row representing each record and the first element of each row containing the integer primary key).
     */
    public static String[][] mergeSort(String[][]data){
        if(data.length==1){
            return data;
        }
        int middle = data.length/2; //calculates the middle of the current data
        String[][]left=new String[middle][data[0].length];//stores the left half of the current data
        String[][]right = new String[data.length-middle][data[0].length];//stores the right half of the current data
        for(int yVal=0;yVal<data.length;yVal++){//fills up the left and right arrays so that the left array stores the left/ top half of the data array and the right array stores the remianing records
            if(yVal>=middle){
                for(int xVal=0;xVal<data[0].length;xVal++){
                    right[yVal-middle][xVal]=data[yVal][xVal];
                }
            }else{
                for(int xVal=0;xVal<data[0].length;xVal++){
                    left[yVal][xVal]=data[yVal][xVal];
                }
            }
        }
        return merge(mergeSort(left),mergeSort(right),data);//returns sorted data. calls the merge function on the data that has been recursively split into single elements
    }
    /**
     * 
     * @param left the left hand sub array of data
     * @param right the right hand sub array of data
     * @param dataToBeSorted the data to be sorted
     * @return returns the merged / sorted data 
     */
    private static String[][] merge(String[][]left,String[][]right,String dataToBeSorted[][]){
        int leftIndex=0;//stores index for left array
        int rightIndex=0;//stores index for right array
        int dataToBeStoredIndex=0;//stores the row index for the data to be sorted array
        while(leftIndex<left.length && rightIndex<right.length){//both righ and left arrays are already sorted. sorts one entire sub array and most of the other sub array
            if(left[leftIndex][0].compareTo(right[rightIndex][0])<0){
                for(int xVal=0;xVal<dataToBeSorted[0].length;xVal++){
                    dataToBeSorted[dataToBeStoredIndex][xVal]=left[leftIndex][xVal];
                }
                dataToBeStoredIndex++;
                leftIndex++;
            }else{
                for(int xVal=0;xVal<dataToBeSorted[0].length;xVal++){
                    dataToBeSorted[dataToBeStoredIndex][xVal]=right[rightIndex][xVal];
                }
                dataToBeStoredIndex++;
                rightIndex++;
            }
        }
        //as one of the sub arrays has been completely sorted, the remaining elements of the other array (which are already sorted) are appended onto the end of the array
        while(leftIndex<left.length){
            for(int xVal=0;xVal<dataToBeSorted[0].length;xVal++){
                dataToBeSorted[dataToBeStoredIndex][xVal]=left[leftIndex][xVal];
            }
            dataToBeStoredIndex++;
            leftIndex++;
        }
        while(rightIndex<right.length){
            for(int xVal=0;xVal<dataToBeSorted[0].length;xVal++){
                dataToBeSorted[dataToBeStoredIndex][xVal]=right[rightIndex][xVal];
            }
            dataToBeStoredIndex++;
            rightIndex++;
        }
        return dataToBeSorted;
    }
}
