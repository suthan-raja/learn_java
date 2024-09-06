package msp.test.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class LearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnApplication.class, args);
		String b = new String("Hi").intern();
//		String c = new String("navin");
//		String a = "Hii";
		String c = "Hi";
//		System.out.println("1st One : "+b==a);
		System.out.println("2nd One : "+c==b);
		System.out.println(c==b);
		System.out.println(Arrays.toString(args));

		String []  newS = {"Sathish Bot"};

		main(newS , "kabi");
		String a = "Hi";
		String d = new String("Hi").intern();
		System.out.println(a==d);


	}

	public static void main(String[] args , String kabi) {
//		SpringApplication.run(LearnApplication.class, args);
		String b = new String("Hi").intern();
//		String c = new String("navin");
//		String a = "Hii";
		String c = "Hi";
//		System.out.println("1st One : "+b==a);
		System.out.println("2nd One : "+c==b);
		System.out.println(c==b);
		System.out.println(Arrays.toString(args));
		System.out.println(kabi);

		String a = "Hi";
		String d = new String("Hi").intern();
		System.out.println(a==d);


	}

}
