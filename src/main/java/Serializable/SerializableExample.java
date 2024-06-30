package Serializable;
import java.io.*;

public class SerializableExample {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //if we don't want to serialize then we use transient keyword for the field in POJO which represents null value
        InstaAccount instaAccount=new InstaAccount();
        instaAccount.setUserName("Supreeth");
        instaAccount.setAccountType("Private");
        instaAccount.setBio("Present");
        instaAccount.setEmailId("sai@gmail.com");

        FileOutputStream fileOutputStream=new FileOutputStream("C:\\Users\\chait\\Downloads\\POST-Call\\POST-Call\\src\\main\\resources\\insta_account.txt");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(instaAccount);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream=new FileInputStream("C:\\Users\\chait\\Downloads\\POST-Call\\POST-Call\\src\\main\\resources\\insta_account.txt");
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);


        InstaAccount instaAccount1= (InstaAccount) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println("Deserialized Insta Account: ");
        System.out.println("username: "+instaAccount1.getUserName());
        System.out.println("Account type: "+instaAccount1.getAccountType());
        System.out.println("Bio: "+instaAccount1.getBio());
        System.out.println("Email : "+instaAccount1.getEmailId());


    }
}
