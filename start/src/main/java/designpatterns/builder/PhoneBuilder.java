package designpatterns.builder;

public class PhoneBuilder {
  private String os;
  private int ram;
  private double memory;
  private String processor;
  private String manufacturer;
  private String yearOfMaking;

  public PhoneBuilder setOs(String os) {
    this.os = os;
    return this;
  }

  public PhoneBuilder setRam(int ram) {
    this.ram = ram;
    return this;
  }

  public PhoneBuilder setMemory(double memory) {
    this.memory = memory;
    return this;
  }

  public PhoneBuilder setProcessor(String processor) {
    this.processor = processor;
    return this;
  }

  public PhoneBuilder setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
    return this;
  }

  public PhoneBuilder setYearOfMaking(String yearOfMaking) {
    this.yearOfMaking = yearOfMaking;
    return this;
  }

  public Phone getPhone() {
    return new Phone(this.os, this.ram, this.memory, this.processor, this.manufacturer, this.yearOfMaking);
  }

}
