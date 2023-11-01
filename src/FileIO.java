import java.io.*;
public class FileIO {
    private Product[] products;
    private ShopAssistant[] shopAssistants;
    public FileIO() throws IOException {
        createProducts();
        createShopAssistans();
    }
    private void createProducts() throws IOException {
        int lineCount = getLineCount("products.csv");
        BufferedReader inputStream = new BufferedReader(new FileReader("products.csv"));
        String line = inputStream.readLine();
        Product[] productArray = new Product[lineCount];
        int count = lineCount;
        while(line != null){
            String[] splitLine = line.split(";");
            int productId = Integer.parseInt(splitLine[0]);
            String productName = splitLine[1];
            splitLine[2] = splitLine[2].replace(",", ".");
            float productPrice = Float.parseFloat(splitLine[2]);
            Product newProduct = new Product(productId,productName,productPrice);
            productArray[lineCount - count] = newProduct;
            line = inputStream.readLine();
            count--;
        }
        inputStream.close();
        products = productArray;
    }
    private int getLineCount(String fileName) throws IOException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int lineCount = 0;
        while (reader.readLine() != null) lineCount++;
        reader.close();
        return lineCount;
    }
    private void createShopAssistans() throws IOException {
        int lineCount = getLineCount("shopAssistants.csv");
        BufferedReader inputStream = new BufferedReader(new FileReader("shopAssistants.csv"));
        String line = inputStream.readLine();
        ShopAssistant[] assistantArray = new ShopAssistant[lineCount];
        int count = lineCount;
        while(line != null) {
            String[] splitLine = line.split(";");
            int assistantId = Integer.parseInt(splitLine[0]);
            String assistantName = splitLine[1];
            String assistantSurname = splitLine[2];
            String assistantNumber = splitLine[3];
            ShopAssistant newAssistant = new ShopAssistant(assistantId,assistantName,assistantSurname,assistantNumber);
            assistantArray[lineCount - count] = newAssistant;
            line = inputStream.readLine();
            count--;
        }
        inputStream.close();
        shopAssistants = assistantArray;
    }
    public Product[] getProducts() {
        return products;
    }
    public ShopAssistant[] getShopAssistants() {
        return shopAssistants;
    }
}

