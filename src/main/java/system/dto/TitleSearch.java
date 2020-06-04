package system.dto;

import java.io.Serializable;

public class TitleSearch implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/** 検索キーワード(書籍タイトル) */
    private String bookTitle;

    /** コンストラクタ */
    public TitleSearch() {

    }

    /** 検索キーワードの取得 */
    public String getBookTitle() {
        return bookTitle;
    }

    /** 検索キーワードの設定 */
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

}
