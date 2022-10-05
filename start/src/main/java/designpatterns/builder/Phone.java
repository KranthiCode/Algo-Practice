package designpatterns.builder;

public class Phone {
  private String os;
  private int ram;
  private double memory;
  private String processor;
  private String manufacturer;
  private String yearOfMaking;

  public Phone(String os, int ram, double memory, String processor, String manufacturer, String yearOfMaking) {
    this.os = os;
    this.ram = ram;
    this.memory = memory;
    this.processor = processor;
    this.manufacturer = manufacturer;
    this.yearOfMaking = yearOfMaking;
  }

  @Override
  public String toString() {
    return "Phone [manufacturer=" + manufacturer + ", memory=" + memory + ", os=" + os + ", processor=" + processor
        + ", ram=" + ram + ", yearOfMaking=" + yearOfMaking + "]";
  }

}
