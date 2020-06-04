package system.common;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import system.model.Book;
import system.repository.BookRepository;

@Component
@ConditionalOnProperty(prefix = "extension.test.generator", name = "enabled", matchIfMissing = false)
public class TestDataGenerator {

    @Autowired
    private BookRepository repo;

    private static final int SIZE = 7;

    @PostConstruct
    @Transactional
    public void initialize() {
        for (int i=0; i<SIZE; i++) {
            Book b = new Book("テスト_" + i, "テスト", String.valueOf(i * 1000), "978-4-7981-4247-0");
            repo.insert(b);
        }
    }
}
