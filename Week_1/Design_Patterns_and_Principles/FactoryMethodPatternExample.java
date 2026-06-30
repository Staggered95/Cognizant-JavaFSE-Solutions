//godfather
interface Document {
  void open();
}

// consumer1
class WordDocument implements Document {
  public void open() {
    System.out.println("WordDocument opened");
  }
}

// consumer2
class PdfDocument implements Document {
  public void open() {
    System.out.println("PdfDocument opened");
  }
}

// consumer3
class ExcelDocument implements Document {
  public void open() {
    System.out.println("ExcelDocument");
  }
}

// factory-blueprint
abstract class DocumentFactory {
  public abstract Document createDocument();
}

// factory1
class WordDocumentFactory extends DocumentFactory {
  @Override
  public Document createDocument() {
    return new WordDocument();
  }
}

// factory2
class PdfDocumentFactory extends DocumentFactory {
  @Override
  public Document createDocument() {
    return new PdfDocument();
  }
}

// factory3
class ExcelDocumentFactory extends DocumentFactory {
  @Override
  public Document createDocument() {
    return new ExcelDocument();
  }
}

class FactoryMethodPatternExample {
  public static void main(String[] args) {
    // Open for extension but closed for modification
    DocumentFactory excelFactory = new ExcelDocumentFactory();
    Document excel = excelFactory.createDocument();
    excel.open();
  }
}
