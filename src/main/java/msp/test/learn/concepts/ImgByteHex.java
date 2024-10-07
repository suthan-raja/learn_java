package msp.test.learn.concepts;

import org.apache.tomcat.util.buf.HexUtils;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImgByteHex {

    String imgPath = "D:\\img\\new.jpg";

    public BufferedImage readImage(String filePath) {
        File file = new File(filePath);
        try {
            long s = Files.size(file.toPath());
            System.out.println("SIZE : "+s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            return ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] convertToByteArray(BufferedImage image, String format) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, format, baos);
        baos.flush();
        byte[] imageBytes = baos.toByteArray();
        System.out.println("NEW : " + imageBytes.length);
        baos.close();
        return imageBytes;
    }

    public void printImageByteArraySize(BufferedImage image, String format) throws IOException {
        byte[] imageBytes = convertToByteArray(image, format);
        System.out.println("Byte Array Length: " + imageBytes.length);
    }

    public byte[] img() {
        System.out.println(imgPath);
        File file = new File(imgPath);

        BufferedImage image = null;
        byte[] bytes;
        try {
            bytes =  Files.readAllBytes(file.toPath());
            System.out.println("ORIGINAL BYTES : "+bytes.length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return bytes;

    }

    public byte[] hexToByteArray(String hex) {
        int hexLength = hex.length();
        byte[] data = new byte[hexLength / 2];
        for (int i = 0; i < hexLength; i += 2) {
            data[i / 2] = (byte) (((Character.digit(hex.charAt(i), 16) << 4)) + Character.digit(hex.charAt(i + 1), 16));
        }

        return data;
    }

    public String byteArrayToHex(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }

    public static final String asHexString(byte buf[]) {
        StringBuffer strbuf = new StringBuffer(buf.length * 2);
        int i;
        for (i = 0; i < buf.length; i++) {
            if (((int) buf[i] & 0xff) < 0x10) {
                strbuf.append("0");
            }
            strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
        }
        return strbuf.toString();
    }
    public static List<String> splitByteArray(byte[] bytes, int len) {
//    public static Map<String , String> splitByteArray(byte[] bytes, int len) {
        System.out.println("Length : " + len);
        List<String> list = new ArrayList<String>();
//        List<String , String> val = new HashMap<>();
        int totalLength = (int) Math.ceil((double) bytes.length / len);
        for (int i = 0; i < totalLength; i++) {
            int start = i * len;
            int end = Math.min(bytes.length, start + len);
//            byte[] subBytes = Arrays.copyOfRange(bytes, start, end);
//            System.out.println("start : " + HexUtils.toHexString((char) start).toUpperCase());

            String hexVal = HexUtils.toHexString((char) start).toUpperCase();

            byte[] subBytes = new byte[end - start];
//            System.out.println("SUB LENGTH : "+ HexUtils.toHexString((char) subBytes.length));
            System.arraycopy(bytes, start, subBytes, 0, end - start);
//            System.out.println("split : " + HexUtils.toHexString(subBytes).toUpperCase());
            String splitVal = HexUtils.toHexString(subBytes).toUpperCase();
            String sizeOfHex = HexUtils.toHexString((char) (splitVal.length() / 2)).toUpperCase();

            String frontCmt = "00D6" + hexVal.substring(0,2)  + hexVal.substring(2)+ sizeOfHex.substring(2) + splitVal;
//            System.out.println("Front : "+frontCmt);

            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < frontCmt.length() ; j+=2) {
                if(j > 0){
                    builder.append(" ");
                }
                builder.append(frontCmt.substring(j , Math.min( j+2 , frontCmt.length() )));
            }

            System.out.println(builder.toString());

//            System.out.println("Size : "+ hexVal + " -- > " + sizeOfHex);
//            list.add(DatatypeConverter.printHexBinary(subBytes));
//
//            val.put(HexUtils.toHexString((char) end), HexUtils.toHexString(subBytes));
        }


        return list;
//        return val;
    }
}
