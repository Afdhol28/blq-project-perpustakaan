package com.blq.demo.restcontroller.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blq.demo.dto.book.BookDTO;
import com.blq.demo.services.book.BookService;
import com.blq.demo.utils.Resp;



@RestController
@RequestMapping("/api/book")
public class BookRestController {

	@Autowired
	private BookService bookService;
	
	//get
	@GetMapping("/get")
	public Resp<List<BookDTO>> getAll(@RequestParam("keyword") String keyword) {
		// Mengemas Response API
		int code = 200;
		String message = "Sukses";
		List<BookDTO> data = bookService.getBook(keyword.trim());

		Resp<List<BookDTO>> response = new Resp<>();
		response.setCode(code);
		response.setMessage(message);
		response.setData(data);

		return response;
	}
	
	//insert
	@PostMapping("/insert")
	public Resp<Long> insert(
			@RequestParam("judul") String judul,
			@RequestParam("kode") String kode,
			@RequestParam("penerbit") String penerbit,
			@RequestParam("pengarang") String pengarang,
			@RequestParam("tahun") Long tahun) {
		try {
			// Mengemas Response API
			int code = 200;
			String message = "Buku berhasil ditambah!";
			bookService.addBook(judul, kode, penerbit, pengarang, tahun);
			
			Resp<Long> response = new Resp<>();
			response.setCode(code);
			response.setMessage(message);

			return response;
		} catch (Exception e) {
			String exceptionMessage = e.getMessage(); // "11-Blablabla"
			String[] split = exceptionMessage.split("-");

			int code = Integer.parseInt(split[0]);
			String message = split[1];

			Resp<Long> response = new Resp<>();
			response.setCode(code);
			response.setMessage(message);
			return response;
		}

	}
	
	@PutMapping("/update")
	public Resp<String> update(
			@RequestParam("id") Long id,
			@RequestParam("judul") String judul,
			@RequestParam("kode") String kode,
			@RequestParam("penerbit") String penerbit,
			@RequestParam("pengarang") String pengarang,
			@RequestParam("tahun") Long tahun) {
		
		try {
			// Mengemas Response API
			int code = 200;
			String message = "data berhasil diubah!";

			bookService.updateBook(id, judul, kode, penerbit, pengarang, tahun);
			
			Resp<String> response = new Resp<>();
			response.setCode(code);
			response.setMessage(message);

			return response;

		} catch (Exception e) {
			e.printStackTrace();
			String exceptionMessage = e.getMessage(); 
			String[] split = exceptionMessage.split("-");

			int code = Integer.parseInt(split[0]);
			String message = split[1];

			Resp<String> response = new Resp<>();
			response.setCode(code);
			response.setMessage(message);
			return response;
		}
		
	}
		@PutMapping("/delete")
		public Resp<String> delete(
				@RequestParam("id") Long id) {
			
			try {
				// Mengemas Response API
				int code = 200;
				String message = "user berhasil dihapus!";

				bookService.deleteBook(id);

				Resp<String> response = new Resp<>();
				response.setCode(code);
				response.setMessage(message);

				return response;

			} catch (Exception e) {
				e.printStackTrace();
				String exceptionMessage = e.getMessage(); 
				String[] split = exceptionMessage.split("-");

				int code = Integer.parseInt(split[0]);
				String message = split[1];

				Resp<String> response = new Resp<>();
				response.setCode(code);
				response.setMessage(message);
				return response;
			}
			
		}
		
	}

