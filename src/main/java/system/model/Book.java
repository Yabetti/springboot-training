package system.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Book {

    /** ID ： Hibernateによる自動採番 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /** 書籍タイトル : 1文字以上、30文字以下 */
    @Size(min=1, max=30)
    private String title;

    /** 出版社名 : 1文字以上、10文字以下 */
    @Size(min=1, max=10)
    private String publisher;

    /** 価格 : 1文字以上、9文字以下 */
    @Pattern(regexp = "^[0-9]{1,9}$")
    private String price;

    /**
     * ISBN : 13文字以上、17文字以下
     * 	半角数字と-(ハイフン)のみ入力可能
     */
    @Size(min=1, max=30)
    private String isbn;

    /** デフォルトコンストラクタ */
    public Book() {
    }

    /** コンストラクタ */
    public Book(String title, String publisher, String price, String isbn) {
        super();
        this.title = title;
        this.publisher = publisher;
        this.price = price;
        this.isbn = isbn;
    }

    /** IDの取得 */
    public long getId() {
        return id;
    }

    /** IDの設定 */
    public void setId(long id) {
        this.id = id;
    }

    /** タイトルの取得 */
    public String getTitle() {
        return title;
    }

    /** タイトルの設定 */
    public void setTitle(String title) {
        this.title = title;
    }

    /** 出版社名の取得 */
    public String getPublisher() {
        return publisher;
    }

    /** 出版社名の設定 */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /** 価格の取得 */
    public String getPrice() {
        return price;
    }

    /** 価格の設定 */
    public void setPrice(String price) {
        this.price = price;
    }

    /** ISBNの取得 */
    public String getIsbn() {
        return isbn;
    }

    /** ISBNの設定 */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
