package system.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import system.dto.TitleSearch;
import system.model.Book;
import system.service.BookService;

/**
 * 譖ｸ邀阪さ繝ｳ繝医Ο繝ｼ繝ｩ
 * @author yuta_kuroki
 *
 */
@Controller
@RequestMapping("/")
public class BookController {

    /**
     * 譖ｸ邀阪し繝ｼ繝薙せ(繧ｳ繝ｳ繝�繝翫ｈ繧翫し繝ｼ繝薙せ繧ｪ繝悶ず繧ｧ繧ｯ繝医ｒ蜿門ｾ�)
     */
    @Autowired
    BookService service;

    /**
     * 荳�隕ｧ逕ｻ髱｢縺ｫ繧｢繧ｯ繧ｻ繧ｹ縺励◆縺ｨ縺�
     * @param search 繧ｿ繧､繝医Ν讀懃ｴ｢逕ｨ縺ｮ繧ｭ繝ｼ繝ｯ繝ｼ繝�
     * @param model 逕ｻ髱｢縺ｫ陦ｨ遉ｺ縺吶ｋ縺溘ａ縺ｮ繝薙Η繝ｼ繝｢繝�繝ｫ
     * @return 逕ｻ髱｢
     */
    @GetMapping({"/", "/list"})
    public String listBooks(TitleSearch search, ModelMap model) {
        // 繧ｵ繝ｼ繝薙せ繧医ｊ縲∵嶌邀阪ｒ蜈ｨ莉ｶ蜿門ｾ励☆繧九��
        List<Book> books = service.findAllBooks();
        // 繧ｵ繝ｼ繝薙せ縺九ｉ蜿門ｾ励＠縺滓嶌邀阪Μ繧ｹ繝医ｒ逕ｻ髱｢縺ｫ險ｭ螳壹☆繧九��
        model.addAttribute("books", books);
        // 荳�隕ｧ逕ｻ髱｢繧定ｿ泌唆縺吶ｋ縲�
        return "list";
    }

    /**
     * 譁ｰ隕冗匳骭ｲ逕ｻ髱｢縺ｫ繧｢繧ｯ繧ｻ繧ｹ縺励◆譎�
     * @param model 逕ｻ髱｢縺ｫ陦ｨ遉ｺ縺吶ｋ縺溘ａ縺ｮ繝薙Η繝ｼ繝｢繝�繝ｫ
     * @return 逕ｻ髱｢
     */
    @GetMapping("/new")
    public String newBook(ModelMap model) {
        // 譖ｸ邀阪Δ繝�繝ｫ繧堤函謌舌☆繧九��
        Book book = new Book();
        // 逕ｻ髱｢縺ｫ譖ｸ邀阪Δ繝�繝ｫ繧定ｨｭ螳壹☆繧九��
        model.addAttribute("book", book);
        // 逋ｻ骭ｲ逕ｻ髱｢繧定ｿ泌唆縺吶ｋ縲�
        return "regist";
    }

    /**
     * 譁ｰ隕冗匳骭ｲ逕ｻ髱｢縺ｫ縺ｦ逋ｻ骭ｲ繝懊ち繝ｳ繧呈款荳九＠縺滓凾
     * @param book 逕ｻ髱｢縺ｫ蜈･蜉帙＆繧後◆譖ｸ邀阪ョ繝ｼ繧ｿ
     * @param result 蜈･蜉帶､懆ｨｼ繧定｡後▲縺溽ｵ先棡
     * @param model 逕ｻ髱｢縺ｫ陦ｨ遉ｺ縺吶ｋ縺溘ａ縺ｮ繝薙Η繝ｼ繝｢繝�繝ｫ
     * @return 逕ｻ髱｢
     */
    @PostMapping("/new")
    public String saveBook(@Valid Book book, BindingResult result, ModelMap model) {
        // 蜈･蜉帶､懆ｨｼ縺ｫ縺ｦ繧ｨ繝ｩ繝ｼ縺後≠繧句�ｴ蜷医�ｯ縲∫匳骭ｲ逕ｻ髱｢繧定ｿ斐☆縲�
        if (result.hasErrors()) {
            return "regist";
        }

        // (1) 繧ｵ繝ｼ繝薙せ縺ｮ譖ｸ邀咲匳骭ｲ繧貞他縺ｳ蜃ｺ縺励�√ョ繝ｼ繧ｿ繝吶�ｼ繧ｹ縺ｫ譖ｸ邀阪ｒ逋ｻ骭ｲ縺吶ｋ縲�
            service.saveBook(book);

        // 繝医ャ繝礼判髱｢縺ｫ驕ｷ遘ｻ(繝ｪ繝�繧､繝ｬ繧ｯ繝�)縺吶ｋ縲�
        return "redirect:/list";
    }

    /**
     * 隧ｳ邏ｰ逕ｻ髱｢縺ｫ繧｢繧ｯ繧ｻ繧ｹ縺励◆譎�
     * @param model 逕ｻ髱｢縺ｫ陦ｨ遉ｺ縺吶ｋ縺溘ａ縺ｮ繝薙Η繝ｼ繝｢繝�繝ｫ
     * @param id縲�逕ｻ髱｢縺ｫ陦ｨ遉ｺ縺吶ｋ譖ｸ邀巧D
     * @return 逕ｻ髱｢
     */
    @GetMapping("/detail-{id}-book")
    public String detailBook(ModelMap model, @PathVariable int id) {
        Book book = new Book();
        // (2) 繧ｵ繝ｼ繝薙せ繧医ｊ縲∫判髱｢縺九ｉ蜿門ｾ励＠縺滓嶌邀巧D縺ｧ譖ｸ邀阪ョ繝ｼ繧ｿ繧貞叙蠕励☆繧九��
            book= service.findById(id);
            
        // 逕ｻ髱｢縺ｫ蜿門ｾ励＠縺滓嶌邀阪ョ繝ｼ繧ｿ繧定ｨｭ螳壹☆繧九��
        model.addAttribute("book", book);
        // 隧ｳ邏ｰ逕ｻ髱｢繧定ｿ斐☆縲�
        return "detail";
    }

    /**
     * 邱ｨ髮�逕ｻ髱｢縺ｫ繧｢繧ｯ繧ｻ繧ｹ縺励◆譎�
     * @param model 逕ｻ髱｢縺ｫ陦ｨ遉ｺ縺吶ｋ縺溘ａ縺ｮ繝薙Η繝ｼ繝｢繝�繝ｫ
     * @param id縲�逕ｻ髱｢縺ｫ陦ｨ遉ｺ縺吶ｋ譖ｸ邀巧D
     * @return 逕ｻ髱｢
     */
    @GetMapping("/edit-{id}-book")
    public String editBook(ModelMap model, @PathVariable int id) {
        Book book = new Book();
        // (3) 繧ｵ繝ｼ繝薙せ繧医ｊ縲∫判髱｢縺九ｉ蜿門ｾ励＠縺滓嶌邀巧D縺ｧ譖ｸ邀阪ョ繝ｼ繧ｿ繧貞叙蠕励☆繧九��
            book = service.findById(id);
            
        // 逕ｻ髱｢縺ｫ蜿門ｾ励＠縺滓嶌邀阪ョ繝ｼ繧ｿ繧定ｨｭ螳壹☆繧九��
        model.addAttribute("book", book);
        // 邱ｨ髮�逕ｻ髱｢繧定ｿ斐☆縲�
        return "edit";
    }

    /**
     * 邱ｨ髮�逕ｻ髱｢縺ｫ縺ｦ邱ｨ髮�繝懊ち繝ｳ繧呈款荳九＠縺滓凾
     * @param book 逕ｻ髱｢縺ｫ蜈･蜉帙＆繧後◆譖ｸ邀阪ョ繝ｼ繧ｿ
     * @param result 蜈･蜉帶､懆ｨｼ繧定｡後▲縺溽ｵ先棡
     * @param model 逕ｻ髱｢縺ｫ陦ｨ遉ｺ縺吶ｋ縺溘ａ縺ｮ繝薙Η繝ｼ繝｢繝�繝ｫ
     * @param id 逕ｻ髱｢縺ｫ陦ｨ遉ｺ縺吶ｋ譖ｸ邀巧D
     * @return 逕ｻ髱｢
     */
    @PostMapping("/edit-{id}-book")
    public String updateBook(@Valid Book book, BindingResult result, ModelMap model, @PathVariable int id) {
        // 蜈･蜉帶､懆ｨｼ縺ｫ縺ｦ繧ｨ繝ｩ繝ｼ縺後≠繧句�ｴ蜷医�ｯ縲∫ｷｨ髮�逕ｻ髱｢繧定ｿ斐☆縲�
        if(result.hasErrors()) {
            return "edit";
        }

        // (4) 繧ｵ繝ｼ繝薙せ繧医ｊ縲∝�･蜉帙＆繧後◆蜀�螳ｹ縺ｧ譖ｸ邀阪ョ繝ｼ繧ｿ繧呈峩譁ｰ縺吶ｋ縲�
              service.updateBook(book);

        // 繝医ャ繝礼判髱｢縺ｫ驕ｷ遘ｻ(繝ｪ繝�繧､繝ｬ繧ｯ繝�)縺吶ｋ縲�
        return "redirect:/list";
    }

    /**
     * 譖ｸ邀肴ュ蝣ｱ繧貞炎髯､縺吶ｋ
     * @param id 蜑企勁蟇ｾ雎｡縺ｮ譖ｸ邀巧D(逕ｻ髱｢縺九ｉ蜿門ｾ�)
     * @return 逕ｻ髱｢
     */
    @GetMapping("/delete-{id}-book")
    public String deleteBook(@PathVariable int id) {
        // (5) 繧ｵ繝ｼ繝薙せ繧医ｊ縲∫判髱｢縺九ｉ蜿門ｾ励＠縺滓嶌邀巧D縺ｧ譖ｸ邀阪ョ繝ｼ繧ｿ繧貞叙蠕励☆繧九��

        // (6) 蜿門ｾ励＠縺滓嶌邀阪ョ繝ｼ繧ｿ繧偵し繝ｼ繝薙せ繧医ｊ蜑企勁縺吶ｋ縲�

        // 繝医ャ繝礼判髱｢縺ｫ驕ｷ遘ｻ(繝ｪ繝�繧､繝ｬ繧ｯ繝�)縺吶ｋ縲�
        return "redirect:/list";
    }

    /**
     * 譖ｸ邀阪�ｮ繧ｿ繧､繝医Ν繧堤畑縺�縺ｦ譖ｸ邀肴ュ蝣ｱ繧呈､懃ｴ｢縺吶ｋ
     * @param search 繧ｿ繧､繝医Ν讀懃ｴ｢逕ｨ縺ｮ繧ｭ繝ｼ繝ｯ繝ｼ繝�(逕ｻ髱｢縺九ｉ蜿門ｾ�)
     * @param model 逕ｻ髱｢縺ｫ陦ｨ遉ｺ縺吶ｋ縺溘ａ縺ｮ繝薙Η繝ｼ繝｢繝�繝ｫ
     * @return 逕ｻ髱｢
     */
    @GetMapping("/search")
    public String searchBook(TitleSearch search, ModelMap model) {
        List<Book> books = new ArrayList<Book>();
        // (7) 繧ｵ繝ｼ繝薙せ繧医ｊ縲∫判髱｢縺九ｉ蜿門ｾ励＠縺溘く繝ｼ繝ｯ繝ｼ繝峨〒繧ｿ繧､繝医Ν繧呈､懃ｴ｢縺吶ｋ縲�

        // 蜿門ｾ励＠縺滓嶌邀堺ｸ�隕ｧ繧堤判髱｢縺ｫ險ｭ螳壹☆繧九��
        model.addAttribute("books", books);
        // 繝医ャ繝礼判髱｢繧定ｿ斐☆縲�
        return "list";
    }

}
