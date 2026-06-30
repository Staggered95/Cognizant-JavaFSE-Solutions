class Product {
  private int productId;
  private String productName;
  private String category;

  Product(int pid, String pname, String pcat) {
    productId = pid;
    productName = pname;
    category = pcat;
  }

  public int getId() {
    return productId;
  }

  public String getName() {
    return productName;
  }

  public String getCategory() {
    return category;
  }

  public String toString() {
    return productName;
  }
}

class EcommercePlatformSearchFunction {
  public static Product linearSearch(Product[] arr, int target) {
    for (Product p : arr) {
      if (p.getId() == target)
        return p;
    }
    return null;
  }

  public static Product binarySearch(Product[] arr, int target) {
    int n = arr.length;
    int left = 0;
    int right = n - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid].getId() == target) {
        return arr[mid];
      } else if (target > arr[mid].getId()) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return null;
  }

  public static void main(String[] args) {
    Product[] products = new Product[20];
    for (int i = 0; i < 20; i++) {
      String name = String.format("Product%d", i);
      String category = (i % 2 == 0) ? "One" : "Two";
      products[i] = new Product(i, name, category);
    }

    System.out.println("Linear Search for ID 15: " + linearSearch(products, 15));
    System.out.println("Binary Search for ID 15: " + binarySearch(products, 15));
  }
}
