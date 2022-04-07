/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241;

/**
 *
 * @author coltin
 */
import java.io.*  ;
import java.util.*;

public class Data implements Comparable<Data>
{
  private static final int FNMLN  = 20;
  private static final int LNMLN  = 30;
  private static final int SSNLN  =  9;
  private static final int MNMLN  =  1;
  private static final int ADDRLN = 40;
  private static final int CITLN  = 20;
  private static final int STLN  =   2;
  private static final int ZIPLN  =  9;
   
  private static final int DATALN = FNMLN + LNMLN + SSNLN + MNMLN + ADDRLN + CITLN + STLN + ZIPLN;
  
  public static final char LINEAR = 'L';
  public static final char BINARY = 'B';
  
  private String ssn  ;
  private String fName;
  private String lName;
  private String mName;
  private String addr ;
  private String city ;
  private String state;
  private String zip  ;
  
  public String getSsn(){
        return ssn;
    }
    public void setSsn(String ssn){
        this.ssn = ssn;
    }
    public String getfName(){
        return fName;
    }
    public void setFName(String fName){
        this.fName = fName;
    }
    public String getMName(){
        return mName;
    }
    public void setMName(String mName){
        this.mName = mName;
    }
    public String getLName(){
        return lName;
    }
    public void setLName(String lName){
        this.lName = lName;
    }
    public String getAddr(){
        return addr;
    }
    public void setAddr(String addr){
        this.addr = addr;
    }
    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }
    public String getState(){
        return state;
    }
    public void setState(String state){
        this.state = state;
    }
    public String getZip(){
        return zip;
    }
    public void setZip(String zip){
        this.zip = zip;
    }
    @Override
    public int compareTo(Data o) {
        return ssn.compareTo(o.getSsn());
    }

    public static Data[] createFromFile(final String fileName )
    {
        Data[] data = null;

        BufferedInputStream bis = null;
        DataInputStream     dis = null;
        FileInputStream     fis = null;

        try
        {
            File file = new File( fileName );
           
            dis = new DataInputStream( bis = new BufferedInputStream( fis = new FileInputStream( file ) ) );

            int nData = ( int ) ( file.length() ) / DATALN;   // Gives you the number of objects of type Data in the file.

            data = new Data[  nData ]; 

            byte[] dataBytes = new byte[ DATALN ];

            for( int i = 0, offset = 0 ; i < nData ; i++ )
            {
                dis.read( dataBytes, offset, DATALN );

                data[ i ] = new Data();

                data[ i ].setSsn( new String( dataBytes, offset, SSNLN ) );

                offset += SSNLN;

                data[ i ].setFName( new String( dataBytes, offset, FNMLN ) );

                offset += FNMLN;
                
                data[ i ].setMName( new String( dataBytes, offset, MNMLN ) );

                offset += MNMLN;

                data[ i ].setLName( new String( dataBytes, offset, LNMLN ) );

                offset += LNMLN;
                
                data[ i ].setAddr( new String( dataBytes, offset, ADDRLN ) );

                offset += ADDRLN;
                
                data[ i ].setCity( new String( dataBytes, offset, CITLN ) );

                offset += CITLN;
                
                data[ i ].setState( new String( dataBytes, offset, STLN ) );

                offset += STLN;
                
                data[ i ].setZip( new String( dataBytes, offset, ZIPLN ) );
                
                offset = 0;   // Reset for next iteration
            }
           
        }
        catch( Exception exc )
        {
            
        }
        finally
        {
            try
            {
                fis.close();
                bis.close();
                dis.close();
            }
            catch( Exception exc )
            {
            }
        }
       
        return data;
    }

  
    
    public static int dataSearch(final Data dataKey, final Data[] dataList, final char search) {
      
       int foundAt = -1;

       if (search == LINEAR) {
       for(int i = 0; i < dataList.length; i++) {
       if (dataList[i].getSsn().equals(dataKey.getSsn()))
       foundAt = i;
       }

       } else if (search == BINARY) {
        foundAt = Arrays.binarySearch(dataList, dataKey);
       }
       return foundAt;
       }
       public static StringBuilder toString(Data data) {
        StringBuilder sb = new StringBuilder();
        sb.append("\nSSN = ").append(data.getSsn());
        sb.append("\nfName = ").append(data.getfName());
        sb.append("\nmName = ").append(data.getMName());
        sb.append("\nlName = ").append(data.getLName());
        sb.append("\nAddr = ").append(data.getAddr());
        sb.append("\ncity = ").append(data.getCity());
        sb.append("\nstate = ").append(data.getState());
        sb.append("\nzip = ").append(data.getZip());

   return sb;
   }

 


   
}
