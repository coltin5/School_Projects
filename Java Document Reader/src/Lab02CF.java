/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import csc241.*;
import java.util.*;
/**
 *
 * @author coltin
 */
public class Lab02CF {

   
    public static void main(String[] args) {
        
        StringBuilder msg = new StringBuilder( "" );
        
        Scanner scanner = new Scanner( System.in );
        
        String yn    = "Y";
        
        boolean cont = true;
        
        Data[] data;
        
    while( Character.toUpperCase( yn.charAt( 0 ) ) == 'Y' ){
           
      msg.delete( 0, msg.length()).append( "\nEnter the file you want to read - " );			
			
      System.out.print( msg );
      
      String fileName = scanner.next();   
      
      data = Data.createFromFile(fileName);
      
           
       if(data != null){
           
           msg.delete( 0, msg.length()).append( "\nPreparing to read ").append(fileName);
           System.out.println(msg);
           msg.delete(0, msg.length()).append("\n").append(fileName).append(" has ").append(data.length).append(" records.");
           System.out.println(msg);
       try{
         do{
             
           msg.delete( 0, msg.length()).append( "\nEnter the search SSN (no separators please) - ");
           System.out.print(msg);
           String ssn = scanner.next();
           Data dataKey = new Data();
           dataKey.setSsn(ssn);
           
           String formattedSsn = ssn.substring(0, 3) + '-' + ssn.substring(3, 5) + '-' + ssn.substring(5, 9);
           msg.delete( 0, msg.length()).append("\nSearching for SSN ").append(formattedSsn);
           System.out.println(msg);
           long lStartTime = System.currentTimeMillis();
           int linearDataTime = Data.dataSearch(dataKey, data, Data.LINEAR);
           
           
             
           
           if(linearDataTime < 0){
               msg.delete( 0, msg.length()).append("\nSSN ").append(formattedSsn).append(" was not found.");
               System.out.println(msg);
           }
           else{
             msg.delete( 0, msg.length()).append("\nThe key was found in record # ").append(linearDataTime);
             System.out.println(msg);
             msg.delete( 0, msg.length()).append("\nThe linear search required ").append(System.currentTimeMillis() - lStartTime).append(" ms to complete.");
             System.out.println(msg);
             msg.delete( 0, msg.length());
           
            
             
                long sortStartTime = System.currentTimeMillis();
                Arrays.sort(data, Comparator.comparing(Data::getSsn));
                msg.delete( 0, msg.length()).append("\nArray.sort required  ").append(System.currentTimeMillis() - sortStartTime).append(" ms to complete.");
                System.out.println(msg);
                
                long bStartTime = System.currentTimeMillis();
                int binarySearchTime = Data.dataSearch(dataKey, data, Data.BINARY);
                if (binarySearchTime < 0) {
                    msg.delete( 0, msg.length()).append("\nSSN ").append(formattedSsn).append(" was not found.");
                    System.out.println(msg);
                } else {
                msg.delete(0, msg.length()).append("\nAfter sorting the key was found at record # ").append(binarySearchTime);
                System.out.println(msg);
                msg.delete(0, msg.length()).append("\nThe binary search required ").append(System.currentTimeMillis() - bStartTime).append(" ms to complete.\n");
                msg.append(Data.toString(data[binarySearchTime]));
                System.out.println(msg);
                
}
}

        msg.delete(0, msg.length()).append("\nDo you wish to continue with another SSN (Y/N)? - ");
        System.out.print(msg);
        String conti = scanner.next();
        if(Character.toUpperCase(conti.charAt(0)) == 'Y') {
        cont = true;
        } else if (Character.toUpperCase(conti.charAt(0)) == 'N') {
        cont = false;
        }
       
        }while (cont);
        }
       catch(Exception s){
           System.out.println("\nInput is not a valid SSN!");
       }
       }else if(data == null){
        msg.delete(0, msg.length()).append("\n").append(fileName).append(" could not be found.");
        System.out.println(msg);
        msg.delete(0, msg.length()).append("\nDo you wish to continue (Y/N) - ");
        System.out.print(msg);
        String cont2 = scanner.next();

        if(Character.toUpperCase(cont2.charAt(0)) == 'N') {
        break;
        } else {
        msg.delete(0, msg.length()).append("\n");
        System.out.print(msg);
        continue;
        }
        }
        msg.delete(0, msg.length()).append("\nDo you wish to continue with another file (Y/N)? - ");
        System.out.print(msg);
        yn = scanner.next();
        System.out.print("\n");
             }
    }
            
        }
