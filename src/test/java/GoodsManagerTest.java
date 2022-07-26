import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GoodsManagerTest {
    GoodsRepository rep = new GoodsRepository();
    GoodsManager manager = new GoodsManager(rep);
    Product prod = new Product(10,"Tim",453);
    Book book1 = new Book(1, "Naruto", 1000, "Mark");
    Book book2 = new Book(2, "Naruto chronicles", 500, "Mark");
    Book book3 = new Book(3, "One-punch man", 800, "May");
    Book book4 = new Book(4, "Death note", 700, "Oleg");
    Smartphone smartphone1 = new Smartphone(5, "iPhone S", 6000, "Key");
    Smartphone smartphone2 = new Smartphone(6, "iPhone XL", 9000, "Ben");
    Smartphone smartphone3 = new Smartphone(7, "Super S", 3000, "Tom");

    @Test
    public void searchNaruto() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        Product[] actual = manager.searchBy("Naruto");
        Product[] expected = {book1, book2};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void zero() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        Product[] actual = manager.searchBy("boat");
        Product[] expected = {};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void man() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        Product[] actual = manager.searchBy("man");
        Product[] expected = {book3};
        assertArrayEquals(expected, actual);

    }
    @Test
    public void remove() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        rep.removeById(2);
        Product[] actual = manager.searchBy("Naruto");
        Product[] expected = {book1};
        assertArrayEquals(expected, actual);

    }
    @Test
    public void remove2() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        book1.setAuthor("Mark");
        book1.getAuthor();
        smartphone1.setManufacturer("Tup");
        smartphone1.getManufacturer();
        rep.removeById(4);
        Product[] actual = manager.searchBy("Naruto");
        Product[] expected = {book1, book2};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void iPhone() {
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        Product[] actual = manager.searchBy("iPhone");
        Product[] expected = {smartphone1, smartphone2};
        assertArrayEquals(expected, actual);

    }
    @Test
    public void zero1() {
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        Product[] actual = manager.searchBy("gamma");
        Product[] expected = {};
        assertArrayEquals(expected, actual);

    }
    @Test
    public void XL() {
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        Product[] actual = manager.searchBy("XL");
        Product[] expected = {smartphone2};
        assertArrayEquals(expected, actual);

    }
    @Test
    public void getId() {
        manager.add(prod);
        prod.setId(3);
        int expected = 3;
        int actual = prod.getId();
        assertEquals(expected , actual);

    }
    @Test
    public void getPrice() {
        manager.add(prod);
        prod.setPrice(300);
        int expected = 300;
        int actual = prod.getPrice();
        assertEquals(expected , actual);

    }
    @Test
    public void getName() {
        manager.add(prod);
        prod.setName("a");
        String expected = "a";
        String actual = prod.getName();
        assertEquals(expected , actual);

    }
    @Test
    public void notId() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        Assertions.assertThrows(NotFoundException.class, () ->{
            rep.removeById(11);
        });

    }

}
