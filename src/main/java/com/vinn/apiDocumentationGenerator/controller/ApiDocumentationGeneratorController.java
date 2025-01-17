package com.vinn.apiDocumentationGenerator.controller;

import com.vinn.apiDocumentationGenerator.model.ApiDocumentationGeneratorDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Controller
@RequestMapping("/api-documentation-generator")
public class ApiDocumentationGeneratorController {

    @GetMapping({"/", "", "/create"})
    public String createForm(Model model) {
        model.addAttribute("apiDocumentationGeneratorDto", new ApiDocumentationGeneratorDto());
        return "index";
    }

    @PostMapping("/create")
    public RedirectView submitForm(@ModelAttribute ApiDocumentationGeneratorDto apiDocumentationGeneratorDto, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("apiDocumentation", apiDocumentationGeneratorDto);
        return new RedirectView("/api-documentation-generator/success", true);
    }

    @GetMapping("/success")
    public String successPage(Model model, HttpServletRequest request) {
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        if (inputFlashMap != null) {
            ApiDocumentationGeneratorDto apiDocumentation = (ApiDocumentationGeneratorDto) inputFlashMap.get("apiDocumentation");
            if (apiDocumentation != null) {
                model.addAttribute("apiDocumentation", apiDocumentation);
                return "success";
            }
        }
        return "redirect:/api-documentation-generator/create";
    }
}