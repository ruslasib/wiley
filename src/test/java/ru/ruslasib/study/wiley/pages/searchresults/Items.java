package ru.ruslasib.study.wiley.pages.searchresults;

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

  public int size() {
    return items.size();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Items items1 = (Items) o;
    System.out.println("Expected:\t" + items + "\n" + "but was:\t" + items1);
    return Objects.equals(items, items1.items);
  }
}
