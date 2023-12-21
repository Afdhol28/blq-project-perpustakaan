package com.blq.demo.services.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blq.demo.dto.book.BookDTO;
import com.blq.demo.repositories.book.BookRepository;


@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	//get	
	public List<BookDTO> getBook(String keyword) {

		return bookRepository.getAllBook(keyword);
	}
	
	//add
	public void addBook(String judul, String kode, String penerbit, String pengarang, Long tahun) throws Exception {

		Boolean isIdExists = bookRepository.isKodeExist(kode);
		
		if (isIdExists==true) {
			throw new Exception("00-Kode sudah ada");
		}
			
		bookRepository.addBook(judul, kode, penerbit, pengarang, tahun);
	}
	
	//update
		public void updateBook(Long id,String judul, String kode, String penerbit, String pengarang, Long tahun) {
			
			bookRepository.updateBook(id, judul, kode, penerbit, pengarang, tahun);
		}
		
	//delete
		public void deleteBook(Long id) {
			
			bookRepository.deleteBook(id);
		}
}
