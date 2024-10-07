package msp.test.learn.card;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Card {

    public static void main(String[] args) {
        callFun();
    }

    public static void callFun(){
        List<String> mrzList = constructMRZ();
        System.out.println(Arrays.toString(mrzList.toArray()));
    }

    public static List<String> constructMRZ() {
        MrzDto mrzDto = new MrzDto();

        mrzDto.setDob(LocalDateTime.of(1996, 8, 17, 0, 0));
        mrzDto.setGender("M");
        mrzDto.setFirstName("LUKA");
        mrzDto.setSurName("SINJANI");
        mrzDto.setExpiryDate(LocalDateTime.of(2034, 8, 17, 0, 0));
        mrzDto.setIssuingCountry("MWI");
        mrzDto.setDocumentNumber("0VYTJZGRD");
        mrzDto.setCardCode("I");

        return createMRZData(mrzDto);
    }

    public static List<String> createMRZData(MrzDto data) {
        System.out.println("MRZ : "+data);
        List<String> mrzList = new ArrayList<>();
        String firstLine =  creatLine1(data);
        System.out.println("First Line : "+firstLine);
        String secondLine = createLine2(data);
        String combinedLine = compineString(firstLine , secondLine);
        String thirdLine = createLine3(data);
        mrzList.add(combinedLine.substring(0,30));
        mrzList.add(combinedLine.substring(30,combinedLine.length()));
        mrzList.add(thirdLine);
        return mrzList;
    }

    private static String createLine3(MrzDto data) {
        StringBuilder builder = new StringBuilder();
        builder.append(data.getSurName()).append("<<").append(data.getFirstName());
        return increaseLineLength(builder.toString());
    }

    public static String creatLine1(MrzDto data){
        StringBuilder builder = new StringBuilder();
        builder.append(data.getCardCode())
                .append("<")
                .append(data.getIssuingCountry())
                .append(data.getDocumentNumber().length() == 9 ? data.getDocumentNumber() : "0"+data.getDocumentNumber())
                .append(checkDigit(data.getDocumentNumber()));
        return increaseLineLength(builder.toString());
    }

    public static String createLine2(MrzDto data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        StringBuilder builder = new StringBuilder();
        builder.append(data.getDob().format(formatter))
                .append(checkDigit(data.getDob().format(formatter)))
                .append(data.getGender())
                .append(data.getExpiryDate().format(formatter))
                .append(checkDigit(data.getExpiryDate().format(formatter)))
                .append(data.getIssuingCountry());

        return increaseLineLength(builder.toString());
    }

    public static String compineString(String firstLine, String secondLine){
        StringBuilder builder = new StringBuilder();
        builder.append(firstLine).append(secondLine);
        int num = checkDigit(builder.substring(0,builder.length()-1));
        System.out.println("Number : "+num);
        builder.setCharAt(builder.length() - 1 , Character.forDigit(num, 10));
        return builder.toString();
    }

    public static String increaseLineLength(String data){
        int targetLen = 30;
        int currentLen = data.length();

        if(currentLen >= targetLen){
            return data;
        }

        int paddingLen = targetLen - currentLen;

        StringBuilder builder = new StringBuilder(data);
        builder.append("<".repeat(paddingLen));

        return builder.toString();
    }


    private static int checkDigit(String data){
        System.out.println(" DATA : "+data + " Len L  : "+data.length());
        int[] weights = {7 , 3, 1};
        int index = 0;
        int total = 0;
        for (char c : data.toCharArray()) {
            int val = characterToInteger(c);
            int multipleWeight = weights[index];

            total += val * multipleWeight;

            index = ( index + 1 ) % weights.length;
        }
        System.out.println("Total weights: " + total%10);
        return total%10;
    }



    private static int characterToInteger(char c){
        if(Character.isDigit(c)){
            return c - '0';
        }else if(Character.isLetter(c)){
            return c - 'A' + 10;
        }else if(c == '<'){
            return  0 ;
        }
        else {
            throw new IllegalArgumentException("Illegal character: " + c);
        }
    }
}
