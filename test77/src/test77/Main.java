/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test77;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//import org.apache.commons.codec.binary.Base64;
import java.util.Base64;
/**
 *
 * @author Panisa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//try {
         File file = new File("inputImage.jpg");	
         // Encode using basic encoder
//         String base64encodedString = Base64.getEncoder().encodeToString("TutorialsPoint?java8".getBytes("utf-8"));
//         System.out.println("Base64 Encoded String (Basic) :" + base64encodedString);
//		
//         // Decode
//         byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
//		
//         System.out.println("Original String: " + new String(base64decodedBytes, "utf-8"));
//         base64encodedString = Base64.getUrlEncoder().encodeToString("TutorialsPoint?java8".getBytes("utf-8"));
//         System.out.println("Base64 Encoded String (URL) :" + base64encodedString);
//		
//         StringBuilder stringBuilder = new StringBuilder();
//		
//         for (int i = 0; i < 10; ++i) {
//            stringBuilder.append(UUID.randomUUID().toString());
//         }
//		
//         byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
//         String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
//         System.out.println("Base64 Encoded String (MIME) :" + mimeEncodedString);

     
        File imageFileData = new File("inputImage.jpg");
         
        try {
            FileInputStream imageFile = new FileInputStream(imageFileData);
            byte imageData[] = new byte[(int) imageFileData.length()];
            imageFile.read(imageData);
             
            //Encoding Image Byte Array to Base64 Encoded Byte Array
//            byte[] base64EncodedByteArray = Base64.encodeBase64(imageData);
//           String inputimage = base64EncodedByteArray.toString();
//           System.out.print(inputimage);
           
           String base64encodedString = Base64.getUrlEncoder().encodeToString(imageData);
           System.out.println("Base64 Encoded String (Basic) :" + base64encodedString);
           byte[] base64decodedBytes = Base64.getUrlDecoder().decode(base64encodedString);
            //Decoding Base64 encoded Byte Array to Image Byte array
//            byte[] base64DecodedByteArray = Base64.decodeBase64(base64EncodedByteArray);
             
            FileOutputStream imageOutFile = new FileOutputStream("2.jpg");
            //imageOutFile.write(base64DecodedByteArray);
            imageOutFile.write(base64decodedBytes);
            imageFile.close();
            imageOutFile.close();
            System.out.println("    Image successfully encoded and decoded");
        }
        catch (FileNotFoundException e) {
            System.out.println("Image Not Found on that Location" + e);
        }
        catch (IOException ex) {
            System.out.println("Problem in Reading The Image" + ex);
        }
 
    }
}
   
    

    

