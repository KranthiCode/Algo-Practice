package designpatterns.builder;

public class Test {
  public static void main(String[] args) {
    Phone mySamsungPhone = new PhoneBuilder().setOs("ANdroid").setManufacturer("Samsung").setProcessor("MediaTek")
        .setRam(8).setMemory(128).setYearOfMaking("2011").getPhone();

    System.out.println(mySamsungPhone);
  }
}
