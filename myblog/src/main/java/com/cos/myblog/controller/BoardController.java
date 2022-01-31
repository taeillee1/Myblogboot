package com.cos.myblog.controller;

import com.cos.myblog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping({"","/"})
    public String index(Model model, @PageableDefault(size = 5,sort = "id", direction = Sort.Direction.DESC)
            Pageable pageable, @RequestParam(required = false,defaultValue = "") String searchText){
        model.addAttribute("boards",boardService.list(pageable,searchText));
        return "index";
    }

    @GetMapping("/board/saveForm")
    public String saveForm(){
        return "saveForm";
    }

    @GetMapping("/board/{id}")
    public String findById(@PathVariable int id,Model model){
        model.addAttribute("board",boardService.lookContent(id));
        return "detail";
    }

    @GetMapping("/board/{id}/updateForm")
    public String updateForm(@PathVariable int id, Model model){
        model.addAttribute("board", boardService.lookContent(id));
        return "updateForm";

    }
}
