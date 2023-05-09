package com.brandonodom.bigtechcompanies.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brandonodom.bigtechcompanies.models.Company;
import com.brandonodom.bigtechcompanies.services.CompanyService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/companys")
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	
	// ----- ALL BOOKS -----
			@GetMapping("")
			public String allCompanys(Model model, HttpSession session) {
				
				if (session.getAttribute("userId") == null) {
					return "redirect:/";
				}
				model.addAttribute("companys", companyService.allCompanys());
				companyService.allCompanys().forEach(System.out::println);
				return "allCompanys.jsp";
			}

			// ----- ONE BOOK -----
			@GetMapping("/{id}")
			public String showCompany(@PathVariable("id") Long id, Model model, HttpSession session) {
				if (session.getAttribute("userId") == null) {
					return "redirect:/";
				}
				model.addAttribute("companys", companyService.findCompany(id));
				return "showCompany.jsp";
			}

			// ----- NEW BOOK -----
			@GetMapping("/new")
			public String renderNewCompany(@ModelAttribute("newCompany") Company newCompany, HttpSession session) {
				if (session.getAttribute("userId") == null) {
					return "redirect:/";
				}
				return "newCompany.jsp";
			}
			
			@PostMapping("/new")
			public String processNewCompany(
					@Valid @ModelAttribute("newCompany") Company newCompany,
					BindingResult result,
					HttpSession session
					) {
				if (session.getAttribute("userId") == null) {
					return "redirect:/";
				}

				if (result.hasErrors()) {
					return "newCompany.jsp";
				}

				companyService.createCompany(newCompany);
				return "redirect:/companys";
			}
			
			// ----- EDIT BOOK -----
			@GetMapping("/{id}/edit")
			public String renderEditCompany(
					@PathVariable("id") Long id,
					Model model,
					HttpSession session
					) {
				Long userId = (Long) session.getAttribute("userId");
				if (userId == null) {
					return "redirect:/";
				}
				
				Company oneCompany = companyService.findCompany(id);
				
				if (!userId.equals(oneCompany.getUser().getId())) {
					return "redirect:/companys/" + oneCompany.getId();
				}

				model.addAttribute("oneCompany", oneCompany);
				return "editCompany.jsp";
			}
			
			@PutMapping("/{id}/edit")
			public String processEditCompany(
					@Valid @ModelAttribute("oneCompany") Company oneCompany,
					BindingResult result
					
					) {
				
//				Long userId = (Long) session.getAttribute("userId");
//				
//				if (userId == null ) {
//					return "redirect:/";
//				}
//				if (!userId.equals(oneCompany.getUser().getId())) {
//					return "redirect:/companys/" + oneCompany.getId();
//				}
//				
				if (result.hasErrors()) {
					System.out.println(result);
					return "editCompany.jsp";
				}
				
				else {

					 companyService.updateCompany(oneCompany);
					return "redirect:/companys";
				}
				
			}
			
			
			// ----- DELETE BOOK -----
			@DeleteMapping("/{id}")
			public String deleteCompany(@PathVariable("id") Long id, HttpSession session) {
				Long userId = (Long) session.getAttribute("userId");
				if (userId == null) {
					return "redirect:/";
				}
				
				Company oneCompany = companyService.findCompany(id);
				
				if (!userId.equals(oneCompany.getUser().getId())) {
					return "redirect:/companys/" + oneCompany.getId();
				}

				companyService.removeCompany(id);
				return "redirect:/companys";
			}

}
