package ru.ruslasib.study.wiley.pages.searchresults;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Items {

  private List<String> items;

  public Items(String[] items) {
    this.items = Arrays.asList(items);
  }

  public Items(List<String> items) {
    this.items = items;
  }

  public Items() {
    this.items = new ArrayList<String>();
  }

  public int size() {
    return items.size();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Items items1 = (Items) o;
    boolean isEqual = Objects.equals(items, items1.items);
    if (! isEqual) System.out.println("Expected:\t" + items + "\n" + "but was:\t" + items1.items);
    return isEqual;
  }
}
