package designpatterns.singleton;

import java.io.Serializable;

public final class Singleton implements Serializable, Cloneable {
  // if we want to implement lazy initialization then this filed should be
  // private static volatile(Java > 1.4 only) and we should also check for
  // double locking in the getInstance method.
  // double locking:
  // public static Singleton getInstance() {
  // if (instance == null) {
  // synchronized (Singleton .class) {
  // if (instance == null) {
  // instance = new Singleton();
  // }
  // }
  // }
  // return instance;
  // }
  // The above one is very verbose and hard to read only works > 1.4v
  private static final Singleton INSTANCE = new Singleton();

  private Singleton() {
    if (INSTANCE != null) {
      try {
        throw new InstantiationException("Can not instantiate the object");
      } catch (InstantiationException e) {
        e.printStackTrace();
      }
    }
  }

  public static Singleton getInstance() {
    return INSTANCE;
  }

  // For over coming cloning
  @Override
  protected Object clone() throws CloneNotSupportedException {
    return INSTANCE;
  }

  // for over coming serialization
  protected Object readResolve() {
    return this;
  }

}
