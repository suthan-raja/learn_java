package msp.test.learn;

import msp.test.learn.concepts.ImgByteHex;
import msp.test.learn.concepts.SmartCardConnection;
import org.apache.tomcat.util.buf.HexUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.bind.DatatypeConverter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class LearnApplication {

    public static void main(String[] args) {
//        SpringApplication.run(LearnApplication.class, args);


        ImgByteHex imgByteHex = new ImgByteHex();
        byte[] byteArray = imgByteHex.img();
        System.out.println("Byte Length : " + byteArray.length);

        String hexFormat = DatatypeConverter.printHexBinary(byteArray);
        System.out.println("Hex Length: " + hexFormat.length() / 2);
        int len = HexUtils.toHexString(byteArray).length();
        System.out.println(len);
        imgByteHex.splitByteArray(byteArray , 255);


        SmartCardConnection smartCardConnection = new SmartCardConnection();
        smartCardConnection.checkCardReader();



    }
}
