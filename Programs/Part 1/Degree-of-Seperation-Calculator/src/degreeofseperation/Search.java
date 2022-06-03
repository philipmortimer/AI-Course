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
public class Search {
    /**
     * Performs a binary search on the one d array. Assumes it is sorted lexographically. 
     * @param data The data sorted lexographically
     * @param itemToFind the data item to be found
     * @return true is returned if the record is in the array, otherwise false is returned
     */
    public static boolean isRecordInArray(String[]data,String itemToFind){
        if(data.length==1){
            if(data[0].equals(itemToFind)){
                return true;
            }else{
                return false;
            }
        }
        if(data.length==0){
            return false;
        }
        String record="";
        int first = 0;
        int last = data.length-1;
        int mid;
        int comparison;
        String primaryKeyBuffer;
        do{
            mid = (first+last)/2;
            primaryKeyBuffer=data[mid];
            //if pk precedes itemToFind less than 0 
            comparison = primaryKeyBuffer.compareTo(itemToFind);
            if(comparison==0){
                return true;
            }else if(comparison>0){
                last = mid-1;
            }else{
                first = mid + 1;
            }
        }while(last>=first);
        return false;
    }
    /**
     * Performs a binary search on the 2d array inputted. It searches for the itemToFind. It assumes this is a primary key at the nought element
     * of every row. It uses binary search and the java String method .compareTo(). Hence the data must be sorted by the primary key
     * with data of a small lexographic value at the top (i.e. sorted in ascending order).
     * @param data The data to be searched through.
     * @param itemToFind The item to find
     * @return the field containing the item to find. If no item is found, this will be a null array of width equal to the width of a record.
     */
    public static String[]searchForRecordWithPrimaryKeyAtNoughtElement(String[][]data,String itemToFind){
        if(data.length==0){
            return new String[1];
        }
        String record[]= new String[data[0].length];
        if(data.length==0){
            return record;
        }
        int first = 0;
        int last = data.length-1;
        int mid;
        int comparison;
        String primaryKeyBuffer;
        do{
            mid = (first+last)/2;
            primaryKeyBuffer=data[mid][0];
            //if pk precedes itemToFind less than 0 
            comparison = primaryKeyBuffer.compareTo(itemToFind);
            if(comparison==0){
                for(int element=0;element<record.length;element++){
                    record[element]=data[mid][element];
                }
                break;
            }else if(comparison>0){
                last = mid-1;
            }else{
                first = mid + 1;
            }
        }while(last>=first);
        return record;
    }
      public static int searchForRecordWithPrimaryKeyAtNoughtElementReturnElement(String[][]data,String itemToFind){
        if(data.length==0){
            return -1;
        }
        String record[]= new String[data[0].length];
        if(data.length==0){
            return -1;
        }
        int first = 0;
        int last = data.length-1;
        int mid=-1;
        int comparison;
        String primaryKeyBuffer;
        do{
            mid = (first+last)/2;
            primaryKeyBuffer=data[mid][0];
            //if pk precedes itemToFind less than 0 
            comparison = primaryKeyBuffer.compareTo(itemToFind);
            if(comparison==0){
                for(int element=0;element<record.length;element++){
                    record[element]=data[mid][element];
                }
                break;
            }else if(comparison>0){
                last = mid-1;
            }else{
                first = mid + 1;
            }
        }while(last>=first);
   
        return mid;
    }
}
