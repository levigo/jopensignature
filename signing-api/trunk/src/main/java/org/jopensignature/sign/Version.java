package org.jopensignature.sign;

/**
 * Represents a version. The {@link Version} is a vendor specific structure which shall implement
 * {@link Comparable#compareTo(Object)} and {@link #toString()}.
 */
public abstract class Version implements Comparable<Version> {

  @Override
  public abstract String toString();
}
