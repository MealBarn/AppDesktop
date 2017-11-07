package ooad;

import javax.persistence.*;
import java.util.*;
import java.sql.*;

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
        //Scanner input = new Scanner (System.in);


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Food.odb");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();        

                    Food p = new Food();
                    em.persist(p);
                   
                    p.setName("ราดหน้าหมูหมัก");
                  
                    p.setType("a la carte");
                   
                    p.setRecipe("ส่วนผสม\n" +
"1.ก๋วยเตี๋ยวเส้นใหญ่ 1 กิโลกรัม\n" +
"2.ผักคะน้าต้นกลาง (นำไปปอกเปลือกและหั่นเฉียง)850 กรัม\n" +
"3.ซีอิ๊วดำ\n" +
"4.น้ำ 1.5 ลิตร\n" +
"5.พริกไทยขาวป่น\n" +
"6.เครื่องปรุงรสมี น้ำส้มพริกดอง(พริกชี้ฟ้าหั่นแว่นดองน้ำส้มสายชู) พริกป่น น้ำปลา และน้ำตาลทราย\n" +
" \n" +
"ส่วนผสมหมักหมู\n" +
"1.หมูส่วนสันนอกใกล้สันคอ (จะมีมันแทรกอยู่) 500 กรัม\n" +
"2.พริกไทป่น 2 ช้อนชา\n" +
"3.น้ำมันพืช 1 ช้อนโต๊ะ\n" +
"4.น้ำตาล 2 ช้อนโต๊ะ\n" +
"5.น้ำปลา 1 ช้อนโต๊ะ\n" +
"6.ซีอิ๊วขาว 2 ช้อนโต๊ะ (เด็กสมบูรณ์สูตรหนึ่ง)\n" +
"7.น้ำมันหอย 3 ช้อนโต๊ะ (ตราแม่ครัว)\n" +
"8.ซอสปรุงรส 2 ช้อนชา (ภูเขาทอง)\n" +
"9.แป้งมัน 1 ช้อนโต๊ะ\n" +
"10.ผงฟู ¼ ช้อนชา (แป้งใส่ Baking Soda)\n" +
"(ผงฟูปรับสูตรตามนี้ ที่ขึ้นอยู่กับวิธีหั่นหมู 2 แบบ คือ…1) หากหั่นชิ้นพอคำก็ใส่ 1/4 ช้อนชาตามสูตร..2) แต่หากหั่นชิ้นใหญ่หนา รีบใช้ก่อนให้เพิ่มเป็น 1/2 ช้อนชา…ถ้าหากหมักข้ามคืน หมูที่ได้จะนุ่มเด้งมากๆ เหมือนตามร้านดังๆเลย)\n" +
"** ข้อควรระวัง อย่ากลัวหมูไม่นิ่มแล้วเพิ่มผงฟู (baking Soda)…ไม่อย่างนั้นรสชาดจะเฝือนมากๆ…หากไม่นุ่มโดนใจให้ลองเอามาต้มหรือผัดสักนิดก่อน…ไม่พอก็ค่อยเพิ่มนะ\n" +
"\n" +
"ส่วนผสมน้ำราดหน้า (เข้มข้น)\n" +
"1.กระเทียมบุบสับหยาบ 2 ช้อนโต๊ะ\n" +
"2.เต้าเจี้ยว 3 ช้อนโต๊ะ\n" +
"3.น้ำตาล 3 ช้อนโต๊ะ + 1 ช้อนชา\n" +
"4.น้ำปลา 2 ช้อนโต๊ะ+ 1 ช้อนชา\n" +
"5.ซีอิ๊วขาว 5 ช้อนโต๊ะ\n" +
"6.น้ำมันหอย 4 ช้อนโต๊ะ\n" +
"7.ไข่ไก่ ตีพอแตก1 ฟอง\n" +
"8.แป้งมัน ½ ถ้วยตวง + น้ำเปล่า 1 ถ้วยตวง (ละลายและคนให้เข้ากันดี)\n" +
"9.น้ำเปล่า 1.5 ลิตร ( 8 ถ้วยตวง) (ต้มให้เดือด หรือร้อนจัด)\n" +
" \n" +
"วิธีทำราดหน้าหมูหมัก\n" +
"1.ทำหมูหมักโดยเคล้าเนื้อหมูกับเครื่องปรุงทั้งหมดนวดให้เครื่องปรุงซึมเข้าเนื้อ เสร็จแล้วใส่กล่องนำเข้าตู้เย็นหมักไว้อย่างน้อย 1 ชั่วโมง หรือถ้าแช่ข้ามคืนจะอร่อยมากขึ้น\n" +
"2.หั่นมาเตรียมผัก เริ่มด้วยนำคะน้ามาปลอกเปลือกและหั่นเฉียง แล้วนำไปลวกและช็อกผักคะน้าพอกรอบ พักไว้...วิธีลวกผักให้กรอบอร่อยมี 2 วิธีคือ\n" +
"1.ตั้งน้ำให้เดือด ใส่น้ำมันพืชลงไปเล็กน้อย ใส่ผักลงไปคนให้ทั่ว ตักขึ้นใส่แช่ในน้ำแข็ง หรือน้ำเย็นจัดสักพัก…ตักขึ้นพักไว้ในตระกร้า ให้สะเด็ดน้ำ\n" +
"2.วิธีลวกผักก็เหมือนที่เราลวกผักทั่วๆไปคือ เติมเกลือในน้ำและตั้งน้ำให้เดือดจัด ใส่ผักลงไปคนให้ทั่ว เพื่อรักษาสีผัก เมื่อลวกเสร็จแล้วตักขึ้นใส่แช่ในน้ำแข็งหรือน้ำเย็นจัดสักพัก เพื่อให้ผักหยุดสุก…ตักขึ้นพักไว้ในตระกร้า ให้สะเด็ดน้ำ \n" +
"3.ผัดเส้นใหญ่ที่ใช้เส้นใหญ่ 1 กิโล…ลอกเส้นใหญ่ไม่ให้จับตัวกันเป็นปึก…และเคล้าซีอิ๊วดำเล็กน้อยพอให้มีสีน้ำตาลนิดๆ จากนั้นตั้งกระทะให้ร้อนจัดมากๆ ใส่น้ำมันพืชลงไป (ร้อนจนเมื่อใส่น้ำมันลงไปแล้วควันขึ้นจะดีมาก)…นำเส้นใหญ่ลงไปผัด…ใช้ตะหลิวสองอันเกลี่ยเส้นในกระทะจนทั่วกันดี…จะเห็นเส้นเดือดปุดๆ…เมื่อระอุทั่วดีแล้ว…ปิดไฟ ตักใส่อ่างผสม\n" +
"4.ทำน้ำราดหน้า…ให้ทำตามขั้นตอนที่บอกไว้โดยละเอียดด้านล่างนี้นะครับ^^\n" +
"5.จัดเส้นใหญ่ผัดใส่จาน วางคะน้า ราดด้วยน้ำราดหน้าโรยพริกไทยป่น เสิร์ฟร้อนๆกับเครื่องปรุงรส\n" +
"\n" +
"วิธีทำน้ำราดหน้า \n" +
"1. เตรียมต้มน้ำ 1.5 ลิตรไว้ก่อน จากนั้นตั้งกระทะใส่น้ำมันพืช…เมื่อร้อนดีแล้วใส่กระเทียมลงไปไม่ต้องรอให้เหลืองตามด้วยเต้าเจี้ยวและเนื้อหมู ค่อยๆผัด ไม่ต้องลดไฟใช้ปานกลางค่อนไฟแรง…หากข้างกระทะมีสีน้ำตาลอ่อน ให้ใส่น้ำที่ต้มไว้ลงไปทีละ ¼ ถ้วย …ราดข้างๆกระทะ (เพื่อที่กระทะจะไม่ไหม้) ผัดจนหมูสุกประมาณ 30%\n" +
"2. ใส่น้ำร้อนที่เหลือลงไปทั้งหมด ใส่เห็ดที่ลวกแล้วตามลงไป…เติมเครื่องปรุงรส \n" +
"3. เมื่อเดือดให้ค่อยๆใส่แป้งมันที่ละลายไว้แล้วลงไป…คนแรงและเร็วเพื่อให้แป้งกระจายตัว ไม่เกาะกันเป็นก้อน (อย่าลืมคนแป้งมันที่ผสมไว้ในถ้วยให้ละลายดีก่อนเทลงกระทะนะคะ)\n" +
"4. รอให้เดือดอีกครั้งใช้มือที่ไม่ถนัดยกชามไข่ที่ตีไว้ให้สูงเหนือกระทะ…เทลงไปเป็นสายเล็กๆ…ใช้มือที่ถนัดจับตะหลิวคนในกระทะเป็นวงกลมเร็วๆทำจนไข่หมด…คนให้ข้นเหนียว…รอให้เดือดอีกครั้งปิดไฟ…ยกลงพร้อมเสิร์ฟ (หากใช้น้ำธรรมดาที่ไม่ใช่น้ำเดือดหรือน้ำร้อน…จะทำให้ต้องใช้เวลานานกว่าน้ำในกระทะจะเดือดอีกครั้งซึ่งจะทำให้หมูที่เราผัดไว้แล้วโดนเคี่ยวนานอาจจะกระด้างได้นะครับ)");
                    

   
        em.getTransaction().commit();
        
         em.close();
        emf.close();
         
    }
}   
